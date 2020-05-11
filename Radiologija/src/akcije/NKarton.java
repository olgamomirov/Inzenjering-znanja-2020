package akcije;

import java.awt.EventQueue;

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
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import java.awt.Panel;
import javax.swing.JScrollPane;

public class NKarton {

	private JFrame frmKartonPacijenta;
	private JTextField imeTF;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NKarton window = new NKarton();
					window.frmKartonPacijenta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NKarton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKartonPacijenta = new JFrame();
		frmKartonPacijenta.setIconImage(Toolkit.getDefaultToolkit().getImage("lib/caduceus (1).png"));
		frmKartonPacijenta.setTitle("Karton pacijenta");
		frmKartonPacijenta.setBounds(100, 100, 682, 664);
		frmKartonPacijenta.setLocationRelativeTo(null);
		frmKartonPacijenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblIme = new JLabel("Ime i prezime:");
		lblIme.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		imeTF = new JTextField();
		imeTF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		imeTF.setColumns(10);
		
		JLabel lblAnamneza = new JLabel("Anamneza:");
		lblAnamneza.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblPrimenjenaDijagnostikaProcedura = new JLabel("Primenjena dijagnosti\u010Dka procedura:");
		lblPrimenjenaDijagnostikaProcedura.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JButton btnOdrediDijagnozu = new JButton("Odredi dijagnozu");
		btnOdrediDijagnozu.setForeground(new Color(255, 102, 0));
		
		btnOdrediDijagnozu.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblDijagnoza = new JLabel("Dijagnoza:");
		lblDijagnoza.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JRadioButton rdbtnUltrazvukDonjihEkstremiteta = new JRadioButton("Ultrazvuk donjih ekstremiteta");
		rdbtnUltrazvukDonjihEkstremiteta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup_2.add(rdbtnUltrazvukDonjihEkstremiteta);
		rdbtnUltrazvukDonjihEkstremiteta.setActionCommand("donjiekst");
		
		JRadioButton rdbtnUltrazvukStitasteZlezde = new JRadioButton("Ultrazvuk \u0161titaste \u017Elezde");
		rdbtnUltrazvukStitasteZlezde.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup_2.add(rdbtnUltrazvukStitasteZlezde);
		rdbtnUltrazvukStitasteZlezde.setActionCommand("stitz");
		
		JRadioButton rdbtnUltrazvukAbdomena = new JRadioButton("Ultrazvuk abdomena");
		rdbtnUltrazvukAbdomena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup_2.add(rdbtnUltrazvukAbdomena);
		rdbtnUltrazvukAbdomena.setActionCommand("abd");
		
		JLabel lblVrstaPregleda = new JLabel("Vrsta pregleda:");
		lblVrstaPregleda.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JRadioButton rdbtnUltrazvukBubrega = new JRadioButton("Ultrazvuk bubrega");
		rdbtnUltrazvukBubrega.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup_2.add(rdbtnUltrazvukBubrega);
		rdbtnUltrazvukBubrega.setActionCommand("bubreg");
		
		JRadioButton rdbtnUltrazvukDojki = new JRadioButton("Ultrazvuk dojki");
		rdbtnUltrazvukDojki.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup_2.add(rdbtnUltrazvukDojki);
		rdbtnUltrazvukDojki.setActionCommand("dojka");
		
		
		List listaDP = new List();
		listaDP.setMultipleMode(true);
		
		List listaA = new List();
		listaA.setMultipleMode(true);
		
		JTextArea textAreaDI = new JTextArea();
		
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
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(listaDP, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(listaDP, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addContainerGap())
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
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(listaA, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(listaA, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JLabel lblDaljaIspitivanja = new JLabel("Dalja ispitivanja:");
		lblDaljaIspitivanja.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDaljaIspitivanja.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.GRAY));
		
		JLabel lblPrevPr = new JLabel("Preventivni - kontrolni pregledi:");
		lblPrevPr.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panelPrPregled = new JPanel();
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frmKartonPacijenta.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOdrediDijagnozu)
						.addComponent(rdbtnUltrazvukDojki)
						.addComponent(rdbtnUltrazvukBubrega)
						.addComponent(lblVrstaPregleda)
						.addComponent(rdbtnUltrazvukDonjihEkstremiteta)
						.addComponent(rdbtnUltrazvukStitasteZlezde)
						.addComponent(rdbtnUltrazvukAbdomena)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblIme)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(imeTF, 381, 381, 381))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
								.addComponent(lblAnamneza)
								.addComponent(lblDijagnoza))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDaljaIspitivanja)
								.addComponent(lblPrimenjenaDijagnostikaProcedura, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)))
						.addComponent(lblPrevPr)
						.addComponent(panelPrPregled, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIme)
								.addComponent(imeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(7)
							.addComponent(lblVrstaPregleda)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnUltrazvukDonjihEkstremiteta))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(93)
							.addComponent(rdbtnUltrazvukStitasteZlezde)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnUltrazvukAbdomena)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnUltrazvukBubrega)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnUltrazvukDojki)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAnamneza)
						.addComponent(lblPrimenjenaDijagnostikaProcedura))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOdrediDijagnozu)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDijagnoza)
						.addComponent(lblDaljaIspitivanja))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 66, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPrevPr)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelPrPregled, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelPrPregled = new GroupLayout(panelPrPregled);
		gl_panelPrPregled.setHorizontalGroup(
			gl_panelPrPregled.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrPregled.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelPrPregled.setVerticalGroup(
			gl_panelPrPregled.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrPregled.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		
		scrollPane.setViewportView(textAreaPrPregled);
		panelPrPregled.setLayout(gl_panelPrPregled);
		
		
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addComponent(textAreaDI, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(textAreaDI, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
		);
		panel_3.setLayout(gl_panel_3);
		
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addComponent(listDijagnoza, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addComponent(listDijagnoza, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		frmKartonPacijenta.getContentPane().setLayout(groupLayout);
	}
}
