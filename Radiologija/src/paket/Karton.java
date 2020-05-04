package paket;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import akcije.NoviKartonAction;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Karton {

	private JFrame frmRadiolokiElektronskiKarton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Karton window = new Karton();
					window.frmRadiolokiElektronskiKarton.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Karton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRadiolokiElektronskiKarton = new JFrame();
		frmRadiolokiElektronskiKarton.setIconImage(Toolkit.getDefaultToolkit().getImage("lib/caduceus (1).png"));
		frmRadiolokiElektronskiKarton.setTitle("Radiolo\u0161ki elektronski karton");
		frmRadiolokiElektronskiKarton.setBounds(100, 100, 534, 300);
		frmRadiolokiElektronskiKarton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRadiolokiElektronskiKarton.setLocationRelativeTo(null);
		frmRadiolokiElektronskiKarton.getContentPane().setLayout(null);
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}    
		SwingUtilities.updateComponentTreeUI(frmRadiolokiElektronskiKarton);    
		
		JButton btnNoviKarton = new JButton("Novi Karton");
		btnNoviKarton.setIcon(new ImageIcon("lib/icons8-health-book-100.png"));
		btnNoviKarton.setSelectedIcon(new ImageIcon("lib/icons8-health-book-100.png"));
		btnNoviKarton.addActionListener(new NoviKartonAction());
		
		btnNoviKarton.setBounds(12, 52, 211, 130);
		frmRadiolokiElektronskiKarton.getContentPane().add(btnNoviKarton);
		
		JButton btnKartoni = new JButton("Kartoni");
		btnKartoni.setSelectedIcon(new ImageIcon("lib/icons8-health-book-100 (1).png"));
		btnKartoni.setIcon(new ImageIcon("lib/icons8-health-book-100 (1).png"));
		btnKartoni.setBounds(293, 52, 211, 130);
		frmRadiolokiElektronskiKarton.getContentPane().add(btnKartoni);
	}
}
