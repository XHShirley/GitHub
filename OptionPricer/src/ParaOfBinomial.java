/**
 * 
 */

/**
 * @author Shirley Yang
 *
 */
public class ParaOfBinomial extends Parameter {

	private int numIntervals;
	private int totalPara;
	
	public ParaOfBinomial(double sNaught,double strikePrice,double riskFreeRate,double volatility,double term,int numIntervals){
		super(sNaught,strikePrice,riskFreeRate,volatility,term);
		this.numIntervals=numIntervals;
		this.totalPara = super.getTotalPara()+1;
	}
	
	public void setNumIntervals(int numIntervals){
		this.numIntervals=numIntervals;
	}
	
	public int getNumIntervals(){
		return this.numIntervals;
	}
	
	public int getTotalPara(){
		return this.totalPara;
	}
}
