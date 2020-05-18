package connector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import model.PacijentDescriptor;

import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;

public class CsvConnector implements Connector {
	
	@Override
	public Collection<CBRCase> retrieveAllCases() {
		LinkedList<CBRCase> cases = new LinkedList<CBRCase>();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(FileIO.openFile("de.csv")));
			if (br == null)
				throw new Exception("Error opening file");

			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#") || (line.length() == 0))
					continue;
				String[] values = line.split(";");

				CBRCase cbrCase = new CBRCase();
				
				String[] simptomi=values[0].split(",");
				ArrayList<String> listaSimptoma=new ArrayList<>();
				for (String s : simptomi) {
					listaSimptoma.add(s);
				}
				
				
				String[] dijagnostickaProcedura=values[1].split(",");
				ArrayList<String> dijagnostickaProceduraLista=new ArrayList<>();
				for(String dp:dijagnostickaProcedura) {
					dijagnostickaProceduraLista.add(dp);
					
				}
				

				PacijentDescriptor pacijent= new PacijentDescriptor();
				
				pacijent.setSimptomi(listaSimptoma);
				//pacijent.setDijagnostickaProcedura(values[1]);
				pacijent.setDijagnostickaProcedura(dijagnostickaProceduraLista);
				pacijent.setDijagnoza(values[2]);
				pacijent.setDaljaIspitivanja(values[3]);
				pacijent.setPreventivniPregledi(values[4]);
				
				
				cbrCase.setDescription(pacijent);
				cases.add(cbrCase);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cases;
	}

	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
		return null;
	}

	@Override
	public void storeCases(Collection<CBRCase> arg0) {
	}
	
	@Override
	public void close() {
	}

	@Override
	public void deleteCases(Collection<CBRCase> arg0) {
	}

	@Override
	public void initFromXMLfile(URL arg0) throws InitializingException {
	}

}