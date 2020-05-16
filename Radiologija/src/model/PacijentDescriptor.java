package model;

import java.util.ArrayList;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class PacijentDescriptor implements CaseComponent{
	
	private ArrayList<String>simptomi;
	private String dijagnostickaProcedura;
	private String dijagnoza;
	
	


	

	public ArrayList<String> getSimptomi() {
		return simptomi;
	}


	public void setSimptomi(ArrayList<String> simptomi) {
		this.simptomi = simptomi;
	}


	public String getDijagnostickaProcedura() {
		return dijagnostickaProcedura;
	}


	public void setDijagnostickaProcedura(String dijagnostickaProcedura) {
		this.dijagnostickaProcedura = dijagnostickaProcedura;
	}


	public String getDijagnoza() {
		return dijagnoza;
	}


	public void setDijagnoza(String dijagnoza) {
		this.dijagnoza = dijagnoza;
	}


	

	@Override
	public String toString() {
		return "PacijentDescriptor [simptomi=" + simptomi + ", dijagnostickaProcedura="
				+ dijagnostickaProcedura + ", dijagnoza=" + dijagnoza + "]";
	}


	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id",this.getClass());
	}

}
