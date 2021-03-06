package akcije;

import java.awt.EventQueue;
import java.nio.file.*; 

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import jpl.Atom;
import jpl.Query;
import jpl.Term;
import jpl.Variable;
import model.PacijentDescriptor;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;

import java.awt.List;
import javax.swing.JList;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.border.LineBorder;

import cbr.CbrApplication;

import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class NKarton {
	
	private static NKarton instanca = null;
	
	private JFrame frmKartonPacijenta;
	private JTextField imeTF;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField lekarskaDijagnozaTF;

	/**
	 * Launch the application.
	 */
	
	public static NKarton getInstance() {
		if(instanca == null) {
			instanca = new NKarton();	
			instanca.initialize();
		}
		return instanca;
	}
	
	
	
	
	/**
	 * Create the application.
	 */
	
	
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frmKartonPacijenta = new JFrame();
		frmKartonPacijenta.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmKartonPacijenta.setIconImage(Toolkit.getDefaultToolkit().getImage("lib/caduceus (1).png"));
		frmKartonPacijenta.setTitle("Karton pacijenta");
		frmKartonPacijenta.setBounds(100, 100, 1035, 725);
		frmKartonPacijenta.setLocationRelativeTo(null);
		frmKartonPacijenta.setVisible(true);
		frmKartonPacijenta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblIme = new JLabel("Ime i prezime:");
		lblIme.setBounds(24, 16, 107, 19);
		lblIme.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		imeTF = new JTextField();
		imeTF.setBounds(143, 13, 381, 25);
		imeTF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		imeTF.setColumns(10);
		
		JLabel lblAnamneza = new JLabel("Anamneza:");
		lblAnamneza.setBounds(339, 45, 100, 19);
		lblAnamneza.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblPrimenjenaDijagnostikaProcedura = new JLabel("Primenjena dijagnosti\u010Dka procedura:");
		lblPrimenjenaDijagnostikaProcedura.setBounds(669, 45, 290, 19);
		lblPrimenjenaDijagnostikaProcedura.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		panel.setBounds(339, 81, 303, 168);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(669, 81, 303, 168);
		
		JButton btnOdrediDijagnozu = new JButton("Odredi dijagnozu RB");
		btnOdrediDijagnozu.setBounds(24, 260, 198, 31);
		btnOdrediDijagnozu.setForeground(new Color(255, 102, 0));
		
		btnOdrediDijagnozu.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblDijagnoza = new JLabel("Dijagnoza RB:");
		lblDijagnoza.setBounds(24, 302, 123, 19);
		lblDijagnoza.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JRadioButton rdbtnUltrazvukDonjihEkstremiteta = new JRadioButton("Ultrazvuk donjih ekstremiteta");
		rdbtnUltrazvukDonjihEkstremiteta.setBounds(24, 81, 217, 27);
		rdbtnUltrazvukDonjihEkstremiteta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup_2.add(rdbtnUltrazvukDonjihEkstremiteta);
		rdbtnUltrazvukDonjihEkstremiteta.setActionCommand("donjiekst");
		
		JRadioButton rdbtnUltrazvukStitasteZlezde = new JRadioButton("Ultrazvuk \u0161titaste \u017Elezde");
		rdbtnUltrazvukStitasteZlezde.setBounds(24, 113, 185, 27);
		rdbtnUltrazvukStitasteZlezde.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup_2.add(rdbtnUltrazvukStitasteZlezde);
		rdbtnUltrazvukStitasteZlezde.setActionCommand("stitz");
		
		JRadioButton rdbtnUltrazvukAbdomena = new JRadioButton("Ultrazvuk abdomena");
		rdbtnUltrazvukAbdomena.setBounds(24, 145, 163, 27);
		rdbtnUltrazvukAbdomena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup_2.add(rdbtnUltrazvukAbdomena);
		rdbtnUltrazvukAbdomena.setActionCommand("abd");
		
		JLabel lblVrstaPregleda = new JLabel("Vrsta pregleda:");
		lblVrstaPregleda.setBounds(24, 45, 115, 19);
		lblVrstaPregleda.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JRadioButton rdbtnUltrazvukBubrega = new JRadioButton("Ultrazvuk bubrega");
		rdbtnUltrazvukBubrega.setBounds(24, 177, 147, 27);
		rdbtnUltrazvukBubrega.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup_2.add(rdbtnUltrazvukBubrega);
		rdbtnUltrazvukBubrega.setActionCommand("bubreg");
		
		JRadioButton rdbtnUltrazvukDojki = new JRadioButton("Ultrazvuk dojki");
		rdbtnUltrazvukDojki.setBounds(24, 209, 123, 27);
		rdbtnUltrazvukDojki.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup_2.add(rdbtnUltrazvukDojki);
		rdbtnUltrazvukDojki.setActionCommand("dojka");
		
		JTextArea textAreaDI = new JTextArea();
		
		List listaA = new List();		
		listaA.setBounds(339, 83, 290, 160);
		frmKartonPacijenta.getContentPane().add(listaA);
		listaA.setMultipleMode(true);
		
		
		List listaDP = new List();
		listaDP.setBounds(669, 83, 290, 160);
		frmKartonPacijenta.getContentPane().add(listaDP);
		listaDP.setMultipleMode(true);
		
		
		
		
		rdbtnUltrazvukDonjihEkstremiteta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listaDP.removeAll();
				listaA.removeAll();
				
					listaA.add("noga_svrbi");
					listaA.add("modra_noga");
					listaA.add("otecena_noga");
					listaA.add("osecaj_zatezanja_na_nozi");
					listaA.add("hladna_noga");
					listaA.add("topla_noga");
					listaA.add("bleda_noga");
					listaA.add("bol_u_nozi");
					listaA.add("povisena_telesna_tempetatura");
				
				    listaDP.add("nekompresibilna_vena");
				    listaDP.add("protok_krvi_kroz_venu_se_ne_registruje");
				    listaDP.add("protok_krvi_kroz_venu_se_registruje");
				    listaDP.add("prosirene_spoljasnje_vene");
				    listaDP.add("arterijski_protok_se_registruje");
				    listaDP.add("arterijski_protok_se_ne_registruje");
				  
			}
		});
		
		rdbtnUltrazvukStitasteZlezde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listaDP.removeAll();
				listaA.removeAll();
				
				
					listaA.add("genetski_faktor");
					listaA.add("povisena_telesna_tempetatura");
					listaA.add("bol_u_vratu_u_regiji_stitaste_zlezde");
					listaA.add("preznojavanje");
					listaA.add("drhtanje");
					listaA.add("opadanje_kose");
					listaA.add("povisen_krvni_pritisak");
					listaA.add("dekoncentracija");
					
					listaA.add("zamor");
					listaA.add("pospanost");
					listaA.add("podbulost");
					listaA.add("pojacano_gojenje");
					listaA.add("nemogucnost_skidanja_kila");
					listaA.add("izostanak_ciklusa");
				 
				    listaDP.add("stitasta_zlezda_deformisane_konture");
				    listaDP.add("stitasta_zlezda_uvecana");
				    listaDP.add("signal_krvnih_sudova_pojacan");
				    listaDP.add("stitasta_zlezda_smanjena");
				    listaDP.add("signal_krvnih_sudova_smanjen");
				   
			}
		});
		
		
		
		
		rdbtnUltrazvukAbdomena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listaDP.removeAll();
				listaA.removeAll();
				
					listaA.add("mucnina");
					listaA.add("gadjenje");
					listaA.add("nadimanje");
					listaA.add("neredovna_ishrana");
					listaA.add("povracanje");
					listaA.add("gojaznost");
					listaA.add("bol_ispod_desnog_rebarnog_luka");
					listaA.add("povracanje_preradjene_krvi");
					listaA.add("mrsavost");
					listaA.add("crna_stolica");
					
					listaDP.add("bela_ovalna_struktura_unutar_zucne_kese");
				    listaDP.add("zid_zucne_kese_raslojen_i_zadebljan");
				    listaDP.add("prosiren_zeludac_i_12pal_crevo");
				    listaDP.add("postoje_limfni_cvorovi_u_okolini_12pal_creva");
				    listaDP.add("postoji_slobodna_tecnost_u_okolini_12pal_creva");
			}
		});
		
		
		rdbtnUltrazvukBubrega.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listaDP.removeAll();
				listaA.removeAll();
				
				
				listaA.add("bolno_mokrenje_krvi");
				listaA.add("ostar_bol_u_bubreznoj_lozi");
				listaA.add("povisena_telesna_temperatura");
				
				listaA.add("bezbolno_mokrenje_krvi");
				listaA.add("tup_bol_u_bubreznoj_lozi");
				
				listaDP.add("bubreg_je_uvecan");
				listaDP.add("vidljiva_bela_ovalna_struktura_u_sabirnom_sistemu_bubrega");
				
				listaDP.add("bubreg_deformisane_konture");
				listaDP.add("bubreg_deformisane_konture");
				listaDP.add("na_bubregu_primetne_izrasline_u_vidu_cvorova");
				listaDP.add("primetne_izrasline_u_vidu_cvorova_na_sabirnom_sistemu");
				listaDP.add("cvorovi_su_ekspanzivni_i_heterogeni");
				
				listaDP.add("krvni_sudovi_na_rubu_cvora");
				listaDP.add("nema_kalcifikacija_u_cvoru");
				listaDP.add("nema_masne_komponente_u_cvoru");
				
				listaDP.add("krvni_sudovi_u_centru_cvora");
				listaDP.add("ima_kalcifikacija_u_cvoru");
				listaDP.add("ima_masne_komponente_u_cvoru");
				
				listaDP.add("cvor_u_bubregu");
				listaDP.add("cvor_u_bubregu_i_delom_van_bubrega");
				listaDP.add("limfni_cvorovi_u_neposrednoj_okolini");
				listaDP.add("udaljene_metastaze");
			}
		});
		
		
		
		rdbtnUltrazvukDojki.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listaDP.removeAll();
				listaA.removeAll();
				
				listaA.add("bolan_cvor_na_dojci");
				listaA.add("cvor_je_elastican");
				listaA.add("bezbolan_cvor_na_dojci");
				listaA.add("krv_na_bradavici_dojke");
				listaA.add("cvor_je_pokretan");
				listaA.add("cvor_je_fiksiran");
				listaA.add("uvucena_bradavica_na_dojci");
				listaA.add("jamica_na_dojci_ispod_koje_je_tvrdo");
				listaA.add("genetski_faktor");
				
				listaDP.add("vidljiva_ovalna_homogena_ostro_ogranicena_zona");
			    listaDP.add("signal_krvnih_sudova_nepostojeci_ili_po_rubu");
			    listaDP.add("iza_cvora_pojacan_ultrazvucni_talas");
			    
			    listaDP.add("vidljiva_zvezdasta_nehomogena_neostro_ogranicena_zona");
			    listaDP.add("signal_krvnih_sudova_u_centru_cvora");
			    listaDP.add("iza_cvora_slabiji_ultrazvucni_talas");
			    
			    listaDP.add("prisutni_patoloski_limfni_cvorovi_u_pazuhu");
			    listaDP.add("udaljene_metastaze");
			    listaDP.add("cvor_od_10_do_20mm");
			    listaDP.add("cvor_veci_od_20mm");
			}
		});
		 
	    
	    
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 303, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 168, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		
		List listDijagnoza = new List();
		

		btnOdrediDijagnozu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("konkretanPregled.pl");
	    	    FileWriter fr;
				try {
					fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
		    	    PrintWriter pr = new PrintWriter(br);
		    	    String anamneza="";
		    	    for (int i=0; i<listaA.getSelectedItems().length; i++)
		    	    	anamneza+=listaA.getSelectedItems()[i]+",";
		    	    
		    	    anamneza=anamneza.substring(0, anamneza.length() - 1);
		    	    //System.out.println(anamneza);
		    	    String imeRazmak=imeTF.getText().replace(" ", "_");
		    	    pr.println("anamneza("+imeRazmak+",["+anamneza+"]).");
		    	    
		    	    String dijagnostickaProcedura="";
		    	    for (int i=0; i<listaDP.getSelectedItems().length; i++)
		    	    	dijagnostickaProcedura+=listaDP.getSelectedItems()[i]+",";
		    	    
		    	    dijagnostickaProcedura=dijagnostickaProcedura.substring(0, dijagnostickaProcedura.length() - 1);
		    	    //System.out.println(dijagnostickaProcedura);
		    	    pr.println("pregled("+imeRazmak+",["+dijagnostickaProcedura+"]).");
		    	    
		    	    pr.close();
		    	    br.close();
		    	    fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				Query q1 =
					    new Query(
					        "consult",
					        new Term[] {new Atom("bazaBolesti.pl")}
					    );
					System.out.println( "consult " + (q1.query() ? "succeeded" : "failed"));
			
					Query q2 =
						    new Query(
						        "consult",
						        new Term[] {new Atom("dijagnoza.pl")}
						    );	
					System.out.println( "consult " + (q2.query() ? "succeeded" : "failed"));

					Query q3 =
						    new Query(
						        "consult",
						        new Term[] {new Atom("konkretanPregled.pl")}
						    );
					
					System.out.println( "consult " + (q3.query() ? "succeeded" : "failed"));

				Variable Dijagnoza = new Variable("Dijagnoza");
				String imeRazmak=imeTF.getText().replace(" ", "_");
				Term arg[] = {new Atom(imeRazmak), Dijagnoza };
				Query    q = new Query("dijagnoza", arg);
				
				String dijagnoza="";
				listDijagnoza.removeAll();
				while (q.hasMoreElements()){
					Term bound_to_dijagnoza = (Term) ((Hashtable) q.nextElement()).get("Dijagnoza");
					System.out.println(bound_to_dijagnoza);
					dijagnoza=bound_to_dijagnoza.toString();
					listDijagnoza.add(dijagnoza);
					
				}
				
				try {
					Files.deleteIfExists(Paths.get("konkretanPregled.pl"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		
		});
		
		JTextArea textAreaPrPregled = new JTextArea();
		
		listDijagnoza.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Query q1 =
					    new Query(
					        "consult",
					        new Term[] {new Atom("bazaBolesti.pl")}
					    );
					System.out.println( "consult " + (q1.query() ? "succeeded" : "failed"));
			
				
				Query q2 =
					    new Query(
					        "consult",
					        new Term[] {new Atom("dijagnoza.pl")}
					    );	
				System.out.println( "konsultovao dijagnoza.pl");
				
				Query q3 =
					    new Query(
					        "consult",
					        new Term[] {new Atom("konkretanPregled.pl")}
					    );
				
				System.out.println( "konsultovao konkretanpregled.pl");
				
				

				System.out.println( listDijagnoza.getSelectedItem().toString());
				
				String imeRazmak=imeTF.getText().replace(" ", "_");
				Variable DaljaIspitivanja = new Variable("DaljaIspitivanja");
				Term arg[] = {new Atom(imeRazmak),new Atom(listDijagnoza.getSelectedItem().toString()), DaljaIspitivanja };
				Query    q = new Query("dalja_ispitivanja_zakljucak", arg);
				
				
				String daljispt="";
				while (q.hasMoreElements()){
					Term bound_to_dalja_ispitivanja = (Term) ((Hashtable) q.nextElement()).get("DaljaIspitivanja");
					System.out.println(bound_to_dalja_ispitivanja);
					daljispt=bound_to_dalja_ispitivanja.toString()+"\n";
					textAreaDI.setText(daljispt);
					
					 }		
				
				Variable PreventivniPregledi = new Variable("PreventivniPregledi");
				Term args[] = {new Atom(imeRazmak),new Atom(listDijagnoza.getSelectedItem().toString()), PreventivniPregledi };
				Query qpp = new Query("preventivni_pregled_zakljucak", args);
			
				String prevpreg="";	
				while (qpp.hasMoreElements()){
					Term bound_to_pp = (Term) ((Hashtable) qpp.nextElement()).get("PreventivniPregledi");
					System.out.println(bound_to_pp);
					prevpreg+=bound_to_pp.toString()+"\n";
					textAreaPrPregled.setText(prevpreg);
					
					 }		
			}
		});
		
		JLabel lblDaljaIspitivanja = new JLabel("Dalja ispitivanja RB:");
		lblDaljaIspitivanja.setBounds(24, 396, 155, 19);
		lblDaljaIspitivanja.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDaljaIspitivanja.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(24, 323, 265, 65);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(25, 422, 265, 65);
		panel_3.setBorder(new LineBorder(Color.GRAY));
		
		JLabel lblPrevPr = new JLabel("Preventivni - kontrolni pregledi RB:");
		lblPrevPr.setBounds(24, 493, 271, 19);
		lblPrevPr.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panelPrPregled = new JPanel();
		panelPrPregled.setBorder(new LineBorder(new Color(128, 128, 128)));
		panelPrPregled.setBounds(24, 518, 265, 65);
		
		JButton btnOdrediDijagnozuCb = new JButton("Odredi dijagnozu CB");
		btnOdrediDijagnozuCb.setBounds(339, 260, 198, 31);
		btnOdrediDijagnozuCb.setForeground(new Color(255, 102, 0));
		btnOdrediDijagnozuCb.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 303, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 168, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelPrPregled = new GroupLayout(panelPrPregled);
		gl_panelPrPregled.setHorizontalGroup(
			gl_panelPrPregled.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
		);
		gl_panelPrPregled.setVerticalGroup(
			gl_panelPrPregled.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrPregled.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		
		scrollPane.setViewportView(textAreaPrPregled);
		panelPrPregled.setLayout(gl_panelPrPregled);
		
		
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(textAreaDI, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(textAreaDI, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
		);
		panel_3.setLayout(gl_panel_3);
		
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(listDijagnoza, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(listDijagnoza, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		frmKartonPacijenta.getContentPane().setLayout(null);
		frmKartonPacijenta.getContentPane().add(rdbtnUltrazvukDojki);
		frmKartonPacijenta.getContentPane().add(rdbtnUltrazvukBubrega);
		frmKartonPacijenta.getContentPane().add(lblVrstaPregleda);
		frmKartonPacijenta.getContentPane().add(rdbtnUltrazvukDonjihEkstremiteta);
		frmKartonPacijenta.getContentPane().add(rdbtnUltrazvukStitasteZlezde);
		frmKartonPacijenta.getContentPane().add(rdbtnUltrazvukAbdomena);
		frmKartonPacijenta.getContentPane().add(lblIme);
		frmKartonPacijenta.getContentPane().add(imeTF);
		frmKartonPacijenta.getContentPane().add(lblPrevPr);
		frmKartonPacijenta.getContentPane().add(panelPrPregled);
		frmKartonPacijenta.getContentPane().add(panel_2);
		frmKartonPacijenta.getContentPane().add(panel);
		frmKartonPacijenta.getContentPane().add(lblAnamneza);
		frmKartonPacijenta.getContentPane().add(lblDijagnoza);
		frmKartonPacijenta.getContentPane().add(btnOdrediDijagnozu);
		frmKartonPacijenta.getContentPane().add(btnOdrediDijagnozuCb);
		frmKartonPacijenta.getContentPane().add(panel_3);
		frmKartonPacijenta.getContentPane().add(lblDaljaIspitivanja);
		frmKartonPacijenta.getContentPane().add(lblPrimenjenaDijagnostikaProcedura);
		frmKartonPacijenta.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Dijagnoza CB:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(339, 298, 134, 27);
		frmKartonPacijenta.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dalja ispitivanja CB:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(339, 396, 155, 19);
		frmKartonPacijenta.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Preventivni - kontrolni pregledi CB:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(339, 491, 271, 19);
		frmKartonPacijenta.getContentPane().add(lblNewLabel_2);
		
		JButton btnCuvanje = new JButton("U\u010Denje CB");
		btnCuvanje.setForeground(new Color(255, 0, 0));
		btnCuvanje.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCuvanje.setBounds(339, 596, 134, 31);
		frmKartonPacijenta.getContentPane().add(btnCuvanje);
		
		lekarskaDijagnozaTF = new JTextField();
		lekarskaDijagnozaTF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lekarskaDijagnozaTF.setBounds(669, 323, 265, 65);
		frmKartonPacijenta.getContentPane().add(lekarskaDijagnozaTF);
		lekarskaDijagnozaTF.setColumns(10);
		
		JLabel lblKonanaDijagnoza = new JLabel("Kona\u010Dna dijagnoza:");
		lblKonanaDijagnoza.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKonanaDijagnoza.setBounds(669, 302, 203, 16);
		frmKartonPacijenta.getContentPane().add(lblKonanaDijagnoza);
		
		JButton btnIstorija = new JButton("\u010Cuvanje istorije");
		btnIstorija.setForeground(new Color(255, 0, 0));
		btnIstorija.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIstorija.setBounds(669, 396, 169, 30);
		frmKartonPacijenta.getContentPane().add(btnIstorija);
		
		List listDCB = new List();
		listDCB.setBounds(339, 325, 265, 65);
		frmKartonPacijenta.getContentPane().add(listDCB);
		
		List listDICB = new List();
		listDICB.setBounds(339, 422, 265, 65);
		frmKartonPacijenta.getContentPane().add(listDICB);
		
		List listPrPCB = new List();
		listPrPCB.setBounds(339, 516, 265, 65);
		frmKartonPacijenta.getContentPane().add(listPrPCB);
		
		JButton btnIB = new JButton("Istorija bolesti ");
		btnIB.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIB.setForeground(Color.RED);
		btnIB.setBounds(669, 487, 169, 30);
		frmKartonPacijenta.getContentPane().add(btnIB);
		
		btnIB.addActionListener(new IstorijaBolestiAction());
		
		
		
		btnOdrediDijagnozuCb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			//*******************KOPIRAN MAIN*******************************
				StandardCBRApplication recommender = new CbrApplication();
				try {
					recommender.configure();

					recommender.preCycle();

					CBRQuery query = new CBRQuery();
					
					ArrayList<String> simptomi= new ArrayList<>();
					for (int i=0;i<listaA.getSelectedItems().length;i++) {
						simptomi.add(listaA.getSelectedItems()[i]);
					}
					
					/*
					simptomi.add("otecena_noga");
					simptomi.add("noga_svrbi");
					simptomi.add("modra_noga");
					*/
					
					ArrayList<String> dijagnostickaProcedura= new ArrayList<>();
					for (int i=0;i<listaDP.getSelectedItems().length;i++) {
						dijagnostickaProcedura.add(listaDP.getSelectedItems()[i]);
					}
					
					PacijentDescriptor pacijent = new PacijentDescriptor();
					
					pacijent.setSimptomi(simptomi);
					pacijent.setDijagnostickaProcedura(dijagnostickaProcedura);
					
					
					query.setDescription( pacijent );
					recommender.cycle(query);

					recommender.postCycle();
					
					CbrApplication cbr=(CbrApplication)recommender;
					
					listDCB.removeAll();
					listDICB.removeAll();
					listPrPCB.removeAll();
					
					for (String d : cbr.getDijagnoza()) {
						listDCB.add(d);
					}
					
					for (String di : cbr.getDaljaIspitivanja()) {
						listDICB.add(di);
					}
					
					for (String pp : cbr.getPreventivniPregledi()) {
						listPrPCB.add(pp);
					}		
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			//*******************KOPIRAN MAIN*******************************
				
			}
		});
		
		btnCuvanje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String simptomi="";
				for (int i=0;i<listaA.getSelectedItems().length;i++) {
					simptomi+=listaA.getSelectedItems()[i]+",";
				}
				
				
				simptomi=simptomi.substring(0, simptomi.length() - 1);
				
							
				String dp="";
				for (int i=0;i<listaDP.getSelectedItems().length;i++) {
					dp+=listaDP.getSelectedItems()[i]+",";
				}
				dp=dp.substring(0, dp.length() - 1);
				
				
				String dijagnoza=listDCB.getSelectedItem().split("-")[0].substring(2);				
				String daljaispitivanje=listDICB.getSelectedItem().substring(2);
				String preventivnipregledi=listPrPCB.getSelectedItem().substring(2);
				
				String upisUcenje=simptomi+";"+dp+";"+dijagnoza+";"+daljaispitivanje+";"+preventivnipregledi;
				
				System.out.println(dijagnoza);
				
				File file = new File("bazaBolesti.csv");
	    	    FileWriter fr;
				try {
					fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
		    	    PrintWriter pr = new PrintWriter(br);
		    	    
		    	    pr.println(upisUcenje);
		    	    pr.close();
		    	    br.close();
		    	    fr.close();

				} catch (Exception e1) {
					e1.printStackTrace();

				}
			}	
		});
		
		btnIstorija.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String simptomi="";
				for (int i=0;i<listaA.getSelectedItems().length;i++) {
					simptomi+=listaA.getSelectedItems()[i]+",";
				}
				
				
				simptomi=simptomi.substring(0, simptomi.length() - 1);
				
							
				String dp="";
				for (int i=0;i<listaDP.getSelectedItems().length;i++) {
					dp+=listaDP.getSelectedItems()[i]+",";
				}
				dp=dp.substring(0, dp.length() - 1);
				
				
				
				File istorija = new File("istorija/"+imeTF.getText());
	    	    FileWriter fr1;
				try {
					fr1 = new FileWriter(istorija, true);
					BufferedWriter br = new BufferedWriter(fr1);
		    	    PrintWriter pr = new PrintWriter(br);
		    	    
		    	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
		    	    LocalDateTime now = LocalDateTime.now();  
		    	    //System.out.println();  
		    	    
		    	    pr.println(simptomi+";"+dp+";"+lekarskaDijagnozaTF.getText()+";"+dtf.format(now));
		    	    pr.close();
		    	    br.close();
		    	    fr1.close();

				} catch (Exception e1) {
					e1.printStackTrace();
				}	
			}
			
		});
		
		
		
		frmKartonPacijenta.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        instanca=null;
		    }
		});
		
		
	}

	public JTextField getImeTF() {
		return imeTF;
	}

	public void setImeTF(JTextField imeTF) {
		this.imeTF = imeTF;
	}
	
	
}
