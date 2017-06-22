package es.ua.dlsi.im3.core.score.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import es.ua.dlsi.im3.IM3Exception;
import es.ua.dlsi.im3.adt.StackMap;
import es.ua.dlsi.im3.core.score.ScoreSong;
import es.ua.dlsi.im3.io.ImportException;

public abstract class XMLSAXImporter {

	private static final String NULL_STRING = "null";
	private DefaultHandler handler;
	private SAXParser saxParser;
	protected StringBuilder currentStringBuilder;
	protected ScoreSong song;
	protected ArrayList<String> elementStack; // implemented as a list to be able to check the previous contents
	protected StackMap<String, String> expectedContentForElement;
	private String lastElement;
	private ArrayList<IXMLSAXImporterExtension> extensions;
	
	public XMLSAXImporter() {
		super();
		extensions = new ArrayList<>();
	}

	public void registerExtension(IXMLSAXImporterExtension extension) {
		extensions.add(extension);
	}
	
	protected void initSAX() throws ParserConfigurationException, SAXException {
		elementStack = new ArrayList<>();
		expectedContentForElement = new StackMap<>();
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		saxParser = factory.newSAXParser();
	
		handler = new DefaultHandler() {
	
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				/*System.out.println("Start:" + qName);
				for (int i = 0; i < attributes.getLength(); i++) {
					System.out.println("\t" + attributes.getQName(i) + "=" + attributes.getValue(i));
				}*/
				try {
					lastElement = qName;
					HashMap<String, String> attributesMap = getAttributes(qName, attributes);
					handleOpenElement(qName, attributesMap);
					for (IXMLSAXImporterExtension extension: extensions) {
						extension.handleOpenElement(qName, attributesMap);
					}
					currentStringBuilder = null; 
				} catch (ImportException e) {
					throw new SAXException(e);
				}
			}
	
			public void endElement(String uri, String localName, String qName) throws SAXException {
				//System.out.println("End:" + qName);
				try {
					handleCloseElement(qName);
					for (IXMLSAXImporterExtension extension: extensions) {
						extension.handleCloseElement(qName);
					}
					
				} catch (ImportException e) {
					throw new SAXException(e);
				}
			}
			
			public void characters(char ch[], int start, int length) throws SAXException {
				if (currentStringBuilder == null) {
					currentStringBuilder = new StringBuilder();					
				}
				for (int i = 0; i < length; i++) {
					currentStringBuilder.append(ch[i + start]);
				}
			}
		};				
	}

	public ScoreSong importStream(InputStream is) throws ImportException {
		try {
			initSAX();
			init();
			saxParser.parse(is, handler);
		} catch (ParserConfigurationException | SAXException | IOException | IM3Exception e) {
			throw new ImportException(e);
		}
	
		return song;
	}

	protected abstract void init() throws ParserConfigurationException, SAXException, IM3Exception;

	public ScoreSong importFileToScoreSong(File file) throws ImportException {
		try {
			initSAX();
			init();
			saxParser.parse(file, handler);
			postProcess();
		} catch (IM3Exception | ParserConfigurationException | SAXException | IOException e) {
			throw new ImportException(e);
		}
	
		return song;
	}

	protected void postProcess() throws ImportException, IM3Exception {
	}

	public HashMap<String, String> getAttributes(String element, Attributes saxAttributes) {
		HashMap<String, String> result = new HashMap<>();
		for (int i = 0; i < saxAttributes.getLength(); i++) {
			result.put(saxAttributes.getQName(i), saxAttributes.getValue(i));
		}
		return result;
	}

	protected String getAttribute(HashMap<String, String> attributes, String key) throws ImportException {
		String result = attributes.get(key);
		if (result == null) {
			throw new ImportException("Attribute '" + key + "' not found among " + attributes + " in " + this.lastElement);
		}
		return result;
	}

	protected String getOptionalAttribute(HashMap<String, String> attributes, String key) throws ImportException {
		String result = attributes.get(key);
		return result;
	}

	protected boolean parseYesOrNo(String elementOrAttribute, String value) throws ImportException {
			if (value == null) {
				throw new ImportException("Cannot parse a null value for element or attribute '" + elementOrAttribute);
			}
			if (value.equals("yes")) {
				return true;
			} else if (value.equals("no")) {
				return false;
			} else {
				throw new ImportException("Expected 'yes' or 'no' and found '" + value + "' for element or attribute '" + elementOrAttribute);
			}
	}

	public void handleCloseElement(String element) throws ImportException {
		String closingElement = elementStack.remove(elementStack.size()-1);		
		if (!closingElement.equals(element)) {
			throw new ImportException("Expected " + closingElement + " and found " + element);
		}
		if (currentStringBuilder != null) {
			String content = currentStringBuilder.toString().trim();
			if (!content.isEmpty() && !(content.equals(NULL_STRING))) {
				handleElementContent(closingElement, content);
				for (IXMLSAXImporterExtension extension: extensions) {
					extension.handleElementContent(closingElement, content);
				}				
			}
		}
		try {
			handleElementClose(closingElement);
		} catch (IM3Exception e) {
			throw new ImportException(e);
		}
	}

	protected abstract void handleElementClose(String closingElement) throws ImportException, IM3Exception;

	public void handleOpenElement(String element, HashMap<String, String> attributesMap) throws ImportException {
		//System.out.println("Element:  " + element);
		elementStack.add(element);
		doHandleOpenElement(element, attributesMap);
	}

	protected abstract void doHandleOpenElement(String element, HashMap<String,String> attributesMap) throws ImportException;

	protected abstract void handleElementContent(String currentElement, String content) throws ImportException;
	

	protected void showUnimplemented(String element) {
		Logger.getLogger(XMLSAXImporter.class.getName()).log(Level.INFO, "Unimplemented element {0}", element);		
	}

	protected String getElementContentFor(String expectedElement) throws ImportException {
		Entry<String, String> entry = expectedContentForElement.pop();
		if (!expectedElement.equals(entry.getKey())) {
			throw new ImportException("Expected element " + expectedElement + " and found " + entry.getKey());
		}
		return entry.getValue();
	}
	
	protected String getParentElement() {
		if (elementStack.size() < 1) {
			return null;
		} else {
			return elementStack.get(elementStack.size()-1);
		}
	}

}