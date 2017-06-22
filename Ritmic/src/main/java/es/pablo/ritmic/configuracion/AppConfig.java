package es.pablo.ritmic.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import es.pablo.ritmic.converter.CursoToUserTOConverter;
//import es.pablo.ritmic.converter.FicheroToFicheroTOConverter;
import es.pablo.ritmic.converter.RoleToUserProfileConverter;
import es.pablo.ritmic.converter.TipoActividadToTipoActividadTOConverter;
import es.pablo.ritmic.converter.TipoFicheroToTipoFicheroTOConverter;
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "es.pablo.ritmic")

public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	RoleToUserProfileConverter roleToUserProfileConverter;
	
	@Autowired
	CursoToUserTOConverter cursoToUserTOConverter;
	
	@Autowired
	TipoActividadToTipoActividadTOConverter tipoActividadTOConverter;
	
	@Autowired
	TipoFicheroToTipoFicheroTOConverter tipoFicheroToFicheroTOConverter;
     
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
     
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
    
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
	 
    /**
     * Conversores de tipos
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
    	
        registry.addConverter(roleToUserProfileConverter);
        registry.addConverter(cursoToUserTOConverter);
        registry.addConverter(tipoActividadTOConverter);
        registry.addConverter(tipoFicheroToFicheroTOConverter);
    }
}