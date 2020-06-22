package akcije;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class IstorijaAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFileChooser fc = new JFileChooser(System.getProperty("user.dir").toString()+"\\istorija");
		fc.showOpenDialog(fc);
		try {
			File f=fc.getSelectedFile();
			NKarton noviKarton= new NKarton();
			noviKarton.getImeTF().setText(f.getName());
			System.out.println(System.getProperty("user.dir"));
		}catch (Exception e1) {
			System.out.println("nema fajla");
		}
		
		
		
	}

}
