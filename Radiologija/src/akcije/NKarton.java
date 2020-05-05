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
		frmKartonPacijenta.setBounds(100, 100, 644, 836);
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
		
		JLabel lblNewLabel_1 = new JLabel("Pol:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JTextArea dijagnozaTA = new JTextArea();
		

		JRadioButton rdbtnNewRadioButton = new JRadioButton("M");
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JRadioButton radioButton = new JRadioButton("\u017D");
		buttonGroup_1.add(radioButton);
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
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
		
		
	    /*
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
	    */
	    
	    
	    
	    
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addComponent(listaDP, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(listaDP, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		
		
		
		
		
		
		
		/*
		listaA.add("bolan_cvor_na_dojci");
		listaA.add("cvor_je_elastican");
		listaA.add("bezbolan_cvor_na_dojci");
		listaA.add("krv_na_bradavici_dojke");
		listaA.add("cvor_je_pokretan");
		listaA.add("cvor_je_fiksiran");
		listaA.add("uvucena_bradavica_na_dojci");
		listaA.add("jamica_na_dojci_ispod_koje_je_tvrdo");
		*/

		btnOdrediDijagnozu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dijagnozaTA.setText("");
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
		    	    pr.println("anamneza("+imeTF.getText()+",["+anamneza+"]).");
		    	    
		    	    String dijagnostickaProcedura="";
		    	    for (int i=0; i<listaDP.getSelectedItems().length; i++)
		    	    	dijagnostickaProcedura+=listaDP.getSelectedItems()[i]+",";
		    	    
		    	    dijagnostickaProcedura=dijagnostickaProcedura.substring(0, dijagnostickaProcedura.length() - 1);
		    	    //System.out.println(dijagnostickaProcedura);
		    	    pr.println("pregled("+imeTF.getText()+",["+dijagnostickaProcedura+"]).");
		    	    
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
				Term arg[] = {new Atom(imeTF.getText()), Dijagnoza };
				Query    q = new Query("dijagnoza", arg);
				
				String dijagnoza="";
				while (q.hasMoreElements()){
					Term bound_to_dijagnoza = (Term) ((Hashtable) q.nextElement()).get("Dijagnoza");
					System.out.println(bound_to_dijagnoza);
					dijagnoza=bound_to_dijagnoza.toString()+"\n";
					dijagnozaTA.append(dijagnoza);
					
					 }
			
				
			
			}
		});
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addComponent(listaA, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(listaA, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		
		GroupLayout groupLayout = new GroupLayout(frmKartonPacijenta.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblVrstaPregleda)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(rdbtnUltrazvukDojki)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnUltrazvukBubrega)
									.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(rdbtnUltrazvukAbdomena)
										.addContainerGap())
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(rdbtnUltrazvukStitasteZlezde)
											.addContainerGap())
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(rdbtnUltrazvukDonjihEkstremiteta)
												.addContainerGap())
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblIme)
														.addComponent(lblAnamneza)
														.addComponent(btnOdrediDijagnozu)
														.addComponent(lblDijagnoza)
														.addComponent(lblPrimenjenaDijagnostikaProcedura, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(imeTF, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
													.addGap(7)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
															.addComponent(radioButton)
															.addGap(4)
															.addComponent(rdbtnNewRadioButton))
														.addComponent(lblNewLabel_1))
													.addGap(95))
												.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(dijagnozaTA, Alignment.LEADING)
														.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
													.addContainerGap())))))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIme)
						.addComponent(lblNewLabel_1))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(imeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(radioButton)
							.addComponent(rdbtnNewRadioButton)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblVrstaPregleda)
					.addGap(11)
					.addComponent(rdbtnUltrazvukDonjihEkstremiteta)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnUltrazvukStitasteZlezde)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnUltrazvukAbdomena)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnUltrazvukBubrega)
					.addGap(6)
					.addComponent(rdbtnUltrazvukDojki)
					.addGap(18)
					.addComponent(lblAnamneza)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPrimenjenaDijagnostikaProcedura)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOdrediDijagnozu)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDijagnoza)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dijagnozaTA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frmKartonPacijenta.getContentPane().setLayout(groupLayout);
	}
}
