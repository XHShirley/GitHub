/**
 * 
 */

/**
 * @version 1.0
 * @author Shirley Yang 
 * 1/3/2014
 *
 */
public class ParaOfSimulation extends Parameter {
	
	/** Price an Asian (arithmetic average price) option using simulation. 
	 @param sNaught - The stock price at time 0
	 @param strike - the option's strike price
	 @param volatility - the underlying stock price volatility
	 @param riskFreeRate - the current risk-free interest rate (money market rate)
	 @param term - the term of the option, expressed in years
	 @param side - true for call options, false for put options
	 @param numTimeIntervals - break the time to maturity [0, T] into this many intervals
	 @param numTrials - the number of simulation trials
	 @return the estimated price of the option
	 */
	
	private int numTimeIntervals;
	private int numTrials;
	private int totalPara;
	
	public ParaOfSimulation(double sNaught,double strikePrice,double riskFreeRate,double volatility,double term,int numTimeIntervals,int numTrials) {
		super(sNaught,strikePrice,riskFreeRate,volatility,term);
		this.numTimeIntervals=numTimeIntervals;
		this.numTrials=numTrials;
		this.totalPara = super.getTotalPara()+2;
	}
	
	public void setNumIntervals(int numTimeIntervals){
		this.numTimeIntervals=numTimeIntervals;
	}
	
	public int getNumTimeIntervals(){
		return this.numTimeIntervals;
	}
	
	public void setNumTrials(int numTrials){
		this.numTrials=numTrials;
	}
	
	public int getNumTrials(){
		return this.numTrials;
	}
	
	public int getTotalPara(){
		return this.totalPara;
	}
	



}
