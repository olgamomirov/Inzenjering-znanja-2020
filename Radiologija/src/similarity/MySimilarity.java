package similarity;

import java.util.ArrayList;
import java.util.List;

import ucm.gaia.jcolibri.exception.NoApplicableSimilarityFunctionException;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;

public class MySimilarity implements LocalSimilarityFunction{
	
	@Override
	public double compute(Object arg0, Object arg1) throws NoApplicableSimilarityFunctionException {
		double i=0;
		ArrayList<String> s0=(ArrayList<String>) arg0;
		ArrayList<String> s1=(ArrayList<String>) arg1;
		System.out.println("s0 simptomi: "+s0);
		System.out.println("s1 simptomi: "+s1);
		
		for(String s:s1) {
			if(s0.contains(s))
				i++;
		}
		
		if(s0.size()>s1.size()) {
			System.out.println("i je: "+i +"  a racun:  "+i/s0.size());
			return i/s0.size();
		}else {
			System.out.println("i je: "+i +"  a racun:  "+i/s1.size());
			return i/s1.size();
			
		}
		
		
	}

	@Override
	public boolean isApplicable(Object arg0, Object arg1) {
		if (arg0 instanceof String && arg1 instanceof String)
			return true;
		return false;
	}

}
