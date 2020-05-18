package model;

import java.util.ArrayList;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class PacijentDescriptor implements CaseComponent{
	
	private ArrayList<String>simptomi;
	private ArrayList<String> dijagnostickaProcedura;
	private String dijagnoza;
	private String daljaIspitivanja;
	private String preventivniPregledi;
		

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


	public ArrayList<String> getSimptomi() {
		return simptomi;
	}


	public void setSimptomi(ArrayList<String> simptomi) {
		this.simptomi = simptomi;
	}


	public String getDijagnoza() {
		return dijagnoza;
	}


	public void setDijagnoza(String dijagnoza) {
		this.dijagnoza = dijagnoza;
	}


	



	@Override
	public String toString() {
		return "PacijentDescriptor [simptomi=" + simptomi + ", dijagnostickaProcedura=" + dijagnostickaProcedura
				+ ", dijagnoza=" + dijagnoza + ", daljaIspitivanja=" + daljaIspitivanja + ", preventivniPregledi="
				+ preventivniPregledi + "]";
	}


	public ArrayList<String> getDijagnostickaProcedura() {
		return dijagnostickaProcedura;
	}


	public void setDijagnostickaProcedura(ArrayList<String> dijagnostickaProcedura) {
		this.dijagnostickaProcedura = dijagnostickaProcedura;
	}


	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id",this.getClass());
	}

}
