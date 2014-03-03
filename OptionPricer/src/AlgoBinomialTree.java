/**
 * 
 */

/**
 * @author Shirley Yang
 *
 */
public class AlgoBinomialTree extends Algorithm {
	
	ParaOfBinomial paraOfB;
	double deltaT;
	boolean side;
	
	
	public AlgoBinomialTree(Parameter para){
		super();
		if(para instanceof ParaOfBinomial)
			this.paraOfB = (ParaOfBinomial)para;
		this.deltaT = paraOfB.getTerm() / paraOfB.getNumIntervals();
	}
	
		
	// An inner class used by the binomial tree valuation method
	private class Price
	{
		public double stockPrice;
		public double optionPrice;
	}


	/** Price an American or European option using a binomial tree. 
	 *@return the estimated price of the option
	 */
	private double calculate() {
		// the additional parameter here (int paraOfB.getNumIntervals()) will be created in the GUI
		// TODO Auto-generated method stub			
		int i;
		int j;
		double up = 1.0 + paraOfB.getRiskFreeRate() * deltaT + (paraOfB.getVolatility() * Math.sqrt(deltaT));
		double down = 1.0 + paraOfB.getRiskFreeRate() * deltaT - (paraOfB.getVolatility() * Math.sqrt(deltaT));
		double upProb = 0.5;
		double downProb = 0.5;
		// End Hrusa
		double binomValue;
		Price[][] binomialTree;

		binomialTree = new Price[paraOfB.getNumIntervals()+ 1][];
		for (i = 0; i <= paraOfB.getNumIntervals(); i++)
		{
			binomialTree[i] = new Price[i + 1];
		}
		// Fill the stockPrice component of the binomialTree
		for (i = 0; i <= paraOfB.getNumIntervals(); i++)
		{
			for (j = 0; j <= i; j++)
			{
				binomialTree[i][j] = new Price();
				binomialTree[i][j].stockPrice = paraOfB.getSNaught() * Math.pow(up, j) * Math.pow(down, i - j);
			}
		}
		// Fill the optionPrices at the terminal nodes
		for (j = 0; j <= paraOfB.getNumIntervals(); j++)
		{
			binomialTree[paraOfB.getNumIntervals()][j].optionPrice = Math.max(paraOfB.getStrikePrice() - binomialTree[paraOfB.getNumIntervals()][j].stockPrice, 0.0);
		}
		// Now work backwards, filling optionPrices in the rest of the tree
		double discount = Math.exp(-paraOfB.getRiskFreeRate() * deltaT);
		for (i = paraOfB.getNumIntervals() - 1; i >= 0; i--)
		{
			for (j = 0; j <= i; j++)
			{
				if(side==false)  // put option
					binomialTree[i][j].optionPrice = Math.max(paraOfB.getStrikePrice() - binomialTree[i][j].stockPrice, discount * (upProb * binomialTree[i + 1][j + 1].optionPrice + downProb * binomialTree[i + 1][j].optionPrice));
				else  // call option
					binomialTree[i][j].optionPrice = Math.max(binomialTree[i][j].stockPrice - paraOfB.getStrikePrice(), discount * (upProb * binomialTree[i + 1][j + 1].optionPrice + downProb * binomialTree[i + 1][j].optionPrice));
			}
		}

		// Report the result, then clean up
		binomValue = binomialTree[0][0].optionPrice;
		for (int k = 0; k <= paraOfB.getNumIntervals(); k++)
		{
			binomialTree[k] = null;
		}
		binomialTree = null;
		return binomValue;

	}
	
//	@Override
//	public double put() {
//		this.side=false;
//		return calculate();
//	}
//
//	@Override
//	public double call() {
//		this.side=true;
//		return calculate();
//	}
}

