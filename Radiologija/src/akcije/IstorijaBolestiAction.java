package akcije;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.ManageReferralControl;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class IstorijaBolestiAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		NKarton noviKarton = NKarton.getInstance();
		
		
		
		File file = new File(System.getProperty("user.dir").toString()+"\\istorija\\"+noviKarton.getImeTF().getText());
	    FileReader fr;
		
	    JFrame istorijaBolesti  = new JFrame("Istorija bolesti");
	    istorijaBolesti.setIconImage(Toolkit.getDefaultToolkit().getImage("lib/caduceus (1).png"));
	    istorijaBolesti.setVisible(true);
	    istorijaBolesti.setSize(500, 300); 
	    istorijaBolesti.setLocationRelativeTo(null);
	    
	   
	    String [] columnNames= {"Dijagnoza", "Datum"};
	    TableModel table_model=new DefaultTableModel(columnNames,0);
	    JTable table = new JTable(table_model);
	      
	    JScrollPane scrollpane = new JScrollPane(table);
	      
	    istorijaBolesti.add(scrollpane);
	    
	    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
	    table.setRowSorter(sorter);

	    List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
	    sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
	    sorter.setSortKeys(sortKeys);
	    
	    
	    
	    try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
    	    String line="";
			while((line=br.readLine())!=null) {
				String dijagnoza=line.split(";")[2];
				String datum=line.split(";")[3];
				((DefaultTableModel) table_model).addRow(new Object[]{dijagnoza,datum});
				System.out.println(dijagnoza+"  "+datum);
			}
    	    
    	    br.close();
    	    fr.close();

		} catch (Exception e1) {
			e1.printStackTrace();

		}
	}

}
