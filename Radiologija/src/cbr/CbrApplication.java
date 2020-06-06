package cbr;

import java.util.ArrayList;
import java.util.Collection;

import connector.CsvConnector;
import model.PacijentDescriptor;
import similarity.MySimilarity;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Threshold;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

public class CbrApplication implements StandardCBRApplication {
	private String dijagnoza="";
	private String daljaIspitivanja="";
	private String preventivniPregledi="";
	
	public String getPreventivniPregledi() {
		return preventivniPregledi;
	}

	public void setPreventivniPregledi(String preventivniPregledi) {
		this.preventivniPregledi = preventivniPregledi;
	}

	public String getDaljaIspitivanja() {
		return daljaIspitivanja;
	}

	public void setDaljaIspitivanja(String daljaIspitivanja) {
		this.daljaIspitivanja = daljaIspitivanja;
	}

	public String getDijagnoza() {
		return dijagnoza;
	}

	public void setDijagnoza(String dijagnoza) {
		this.dijagnoza = dijagnoza;
	}

	Connector _connector;  /** Connector object */
	CBRCaseBase _caseBase;  /** CaseBase object */

	NNConfig simConfig;  /** KNN configuration */
	
	public void configure() throws ExecutionException {
		_connector =  new CsvConnector();
		
		_caseBase = new LinealCaseBase();  // Create a Lineal case base for in-memory organization
		
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average
		
		Collection<CBRCase> eval=_caseBase.getCases();
				
		
		simConfig.addMapping(new Attribute("simptomi", PacijentDescriptor.class), new MySimilarity());
		simConfig.addMapping(new Attribute("dijagnostickaProcedura", PacijentDescriptor.class), new MySimilarity());
		//simConfig.addMapping(new Attribute("daljaIspitivanja", PacijentDescriptor.class), new Equal());
		

		// Equal - returns 1 if both individuals are equal, otherwise returns 0
		// Interval - returns the similarity of two number inside an interval: sim(x,y) = 1-(|x-y|/interval)
		// Threshold - returns 1 if the difference between two numbers is less than a threshold, 0 in the other case
		// EqualsStringIgnoreCase - returns 1 if both String are the same despite case letters, 0 in the other case
		// MaxString - returns a similarity value depending of the biggest substring that belong to both strings
		// EnumDistance - returns the similarity of two enum values as the their distance: sim(x,y) = |ord(x) - ord(y)|
		// EnumCyclicDistance - computes the similarity between two enum values as their cyclic distance
		// Table - uses a table to obtain the similarity between two values. Allowed values are Strings or Enums. The table is read from a text file.
		// TableSimilarity(List<String> values).setSimilarity(value1,value2,similarity) 
	}

	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 5);
		System.out.println("Retrieved cases:");
		int i=0;
		for (RetrievalResult nse : eval) {
			i=i+1;
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
			PacijentDescriptor p=(PacijentDescriptor) nse.get_case().getDescription();
			//System.out.println("verovatnoca je: "+nse.getEval()+"  za dijagnozu: "+ p.getDijagnoza());
			String dijagproc=i+") "+p.getDijagnoza()+"->"+nse.getEval();
			dijagnoza+=dijagproc+"\n";
			daljaIspitivanja+=i+") "+p.getDaljaIspitivanja()+"\n";
			preventivniPregledi+=i+") "+p.getPreventivniPregledi()+"\n";
		}
		
		
		
	}

	public void postCycle() throws ExecutionException {
		
	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		for (CBRCase c: cases)
			System.out.println(c.getDescription());
		return _caseBase;
	}

	public static void main(String[] args) {
		
		StandardCBRApplication recommender = new CbrApplication();
		try {
			recommender.configure();

			recommender.preCycle();

			CBRQuery query = new CBRQuery();
			
			ArrayList<String> simptomi= new ArrayList<>();
			simptomi.add("otecena_noga");
			simptomi.add("noga_svrbi");
			simptomi.add("modra_noga");
			
			PacijentDescriptor pacijent = new PacijentDescriptor();
			
			pacijent.setSimptomi(simptomi);
			//pacijent.setDijagnostickaProcedura("protok_krvi_kroz_venu_se_ne_registruje");
			
			
			query.setDescription( pacijent );
			recommender.cycle(query);

			recommender.postCycle();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}