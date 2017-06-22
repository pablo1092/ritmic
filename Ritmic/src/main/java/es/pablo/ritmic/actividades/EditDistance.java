package es.pablo.ritmic.actividades;

import java.util.ArrayList;
import java.util.List;

import es.ua.dlsi.im3.IM3Exception;

public class EditDistance {
	protected double z = 0;
	private EditScript editScript;
	private List<Long> from;
	private List<Long> to;
	double weightInsert;
	double weightDelete;
	
	public EditDistance() {
		super();
	}
	/**
	 * Minimum between 3 values
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	static public double min3(double x, double y, double z){
		  return  x<y? (x<z?x:z) : (y<z?y:z);
	}
	/**
	 * Maximum between 3 values
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	static public double max3(double x, double y, double z){
		  return  x>y? (x>z?x:z) : (y>z?y:z);
	}
	
	/**
	 * 
	 * @param from
	 * @param to
	 * @return Normalizado entre 0 y 1
	 * @throws IM2Exception
	 */
	public double computeDistance(List<Long> from, List<Long> to) throws IM3Exception {
		double res=0;
		double [][] m = new double[from.size()+1][to.size()+1];
		int i,j;
		
		this.from = from;
		this.to = to;
		
		if (from.size() == 0 && to.size() == 0) {
			return 0;
		}
		
		m[0][0] = z;
		
		double sumA = 0, sumB = 0;
		for (i=0; i<from.size(); i++) {
				sumA += from.get(i);
		}
		for (i=0; i<to.size(); i++) {
			sumB += to.get(i);
		}
		
		weightDelete = sumA / (double) from.size();
		weightInsert = sumB / (double) to.size();
		
		for (i=1; i<=from.size(); i++)
			m[i][0]=m[i-1][0] + deleteCost(from.get(i-1)); // pesoBorrado

		for (j=1; j<=to.size(); j++)
			m[0][j]=m[0][j-1] +insertCost(to.get(j-1)); // pesoInsercion

		for (i=1; i<=from.size(); i++) {
			for (j=1; j<=to.size(); j++)
			{
				double sust = distance(from.get(i-1), to.get(j-1));
				m[i][j] = min3(m[i-1][j-1] + sust, m[i][j-1] + insertCost(to.get(j-1)), m[i-1][j] +deleteCost(from.get(i-1)));
			}		
		}
				
		res = m[from.size()][to.size()]/(double)(from.get(from.size()-1) + to.get(to.size()-1));
		
		// backtrace
		//if (this.traceEditScript) 
		{
			editScript = new EditScript();
			int ii=m.length-1;
			int jj=m[ii].length-1;
			while (ii>0 || jj>0) {
				//System.out.println(">"+ii + "<\t>" + jj + "<");
				EditOperation eo;
				if (ii>0 && jj>0 && m[ii-1][jj-1] <= m[ii-1][jj] && m[ii-1][jj-1] <= m[ii][jj-1]) {
					// sust
					eo = new EditOperation(ii-1, jj-1, m[ii][jj]-m[ii-1][jj-1]);
					ii=ii-1;
					jj=jj-1;
				} else if (jj>0 && ii==0 || jj>0 && m[ii][jj-1] <= m[ii-1][j-1] && m[ii][jj-1] <= m[ii-1][jj]) {
					// ins
					eo = new EditOperation(EditOperation.EMPTY, jj-1, m[ii][jj] - m[ii][jj-1]);
					jj=jj-1;
				} else {
					// del
					eo = new EditOperation(ii-1, EditOperation.EMPTY, m[ii][jj] - m[ii-1][jj]);
					ii=ii-1;
				}
				this.editScript.addEditOperation(eo);
			}
		}

		System.out.println("Dist: "+ res);
		return res;
	}
	

	private double distance(Long a, Long b) {
		return Math.abs(a-b);
	}
	private double insertCost(Long type) {
		return weightInsert;
	}
	private double deleteCost(Long type) {
		return weightDelete;
	}
	public void printEditString() {
		System.out.println("Accumulated cost: " + editScript.getAccumulatedCost());
		
		ArrayList<EditOperation> scr = editScript.getScript();
		for (int i=scr.size()-1; i>=0; i--) {
			EditOperation eo = scr.get(i);				
			Long from = eo.getFrom()!=EditOperation.EMPTY?  this.from.get(eo.getFrom()):null;
			Long to = eo.getTo()!=EditOperation.EMPTY ? this.to.get(eo.getTo()):null;
			System.out.print(from!=null?from.toString():"-");
			System.out.print("\t");
			System.out.print(to!=null?to.toString():"-");
			System.out.print("\t");
			System.out.println(eo.getCost());			
	}
	}
}
