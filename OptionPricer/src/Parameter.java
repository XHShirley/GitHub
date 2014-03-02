/**
 * 
 */

/**
 * @version 1.0
 * @author Shirley Yang
 *1/3/2014
 */
public class Parameter {
	// Basic values of a stock option; A client can change 
	// these by using the "set" methods declared below
	private double sNaught;
	private double strikePrice;
	private double riskFreeRate;
	private double volatility;
	private double term;
	private int totalPara;
	
	public Parameter(double sNaught,double strikePrice,double riskFreeRate,double volatility,double term){
		this.sNaught=sNaught;
		this.strikePrice=strikePrice;
		this.riskFreeRate=riskFreeRate;
		this.volatility=volatility;
		this.term=term;
		this.totalPara=5;
	}
	
	public void setSNaught(double sNaught){
		this.sNaught=sNaught;
	}
	
	public double getSNaught(){
		return this.sNaught;
	}
	
	public void setStrikePrice(double strikePrice){
		this.strikePrice=strikePrice;
	}
	
	public double getStrikePrice(){
		return this.strikePrice;
	}
	
	public void setRiskFreeRate(double riskFreeRate){
		this.riskFreeRate=riskFreeRate;
	}
	
	public double getRiskFreeRate(){
		return this.riskFreeRate;
	}
	
	public void setVolatility(double volatility){
		this.volatility=volatility;
	}
	
	public double getVolatility(){
		return this.volatility;
	}
	
	public void setTerm(double term){
		this.term=term;
	}
	
	public double getTerm(){
		return this.term;
	}
	
	public int getTotalPara(){
		return this.totalPara;
	}
	
	

}
