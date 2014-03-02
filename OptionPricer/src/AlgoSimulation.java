/**
 * 
 */

/**
 * @author Shirley Yang
 *
 */

import java.util.Random;
import java.lang.Math;

public class AlgoSimulation extends Algorithm implements Side {
	
	ParaOfSimulation paraSim;
	Boolean side;

	/**
	 * 
	 */
	public AlgoSimulation(Parameter para) {
		if(para instanceof ParaOfSimulation)
			this.paraSim=(ParaOfSimulation)para;
		this.side=true;
	}
	
	private double calculate(){

			int i, trialCount;
			double deltaT = this.paraSim.getTerm()/(double)this.paraSim.getNumTimeIntervals();
			double trialRunningSum, trialAverage, trialPayoff;
			double simulationRunningSum, simulationAveragePayoff;
			double s;
			Random rand = new Random();
			simulationRunningSum = 0.0;
			for (trialCount = 1; trialCount <= this.paraSim.getNumTrials(); trialCount++) {
				s = this.paraSim.getSNaught();
				trialRunningSum = 0.0;
				double nns = 0;
				for (i = 0; i < this.paraSim.getNumTimeIntervals(); i++) {
					nns = rand.nextGaussian();
					s = s*Math.exp((this.paraSim.getRiskFreeRate()-this.paraSim.getVolatility()*this.paraSim.getVolatility()/2)*deltaT + 
						this.paraSim.getVolatility()*nns*Math.sqrt(deltaT));
					trialRunningSum += s;

				}
				trialAverage = trialRunningSum/this.paraSim.getNumTimeIntervals();
				if (side == true)	// call option
					trialPayoff = Math.max(trialAverage - this.paraSim.getStrikePrice(), 0.0);
				else				// put option
					trialPayoff = Math.max(this.paraSim.getStrikePrice() - trialAverage,  0.0);
				simulationRunningSum += trialPayoff;			
			}
			simulationAveragePayoff = simulationRunningSum / this.paraSim.getNumTrials();
			double valueOfOption;
			valueOfOption = simulationAveragePayoff * Math.exp(-this.paraSim.getRiskFreeRate()*this.paraSim.getTerm());
			return valueOfOption;
		
	}

	@Override
	public double put() {
		this.side=false;
		return calculate();
	}

	@Override
	public double call() {
		this.side=true;
		return calculate();
	}

}
