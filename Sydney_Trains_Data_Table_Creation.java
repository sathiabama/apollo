/*
 * Input:  sample infringements issued offences on Sydney Trains service 

 * Expected Output:  table, bar chart, gauge 
 * Language Used: Java(JFrame)
 * Developed by: Sathia,HCL Technologies,India
 * Developed on: 22-Nov-2018
 * Developed for: CBA  
 */

package sydney_Trains_Data_Table_Creation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;    
import javax.swing.table.DefaultTableCellRenderer;

public class Sydney_Trains_Data_Table_Creation extends JFrame{ 
	
	private static final long serialVersionUID = 1L;

		JFrame f; 
	 
	 	String pNo_Grand_TotalValue;
	 
	 	Sydney_Trains_Data_Table_Creation(){  
	    	
	    f=new JFrame(); 
	    
	    int[] pNo_Total_2013 = { 72362,69705,25172,652,330,371,108,91};	 
	    
	    int pNoResult_2013=totalSum(pNo_Total_2013);
	    
	    String pNo_TotalValue_2013=intToStrConversion(pNoResult_2013);	
	    
	    int[] fValue_Total_2013= {8136122,13038900,6652750,121359,35000,87500,17860,22150};	    
	       
	    int fValueResult_2013=totalSum(fValue_Total_2013);	   
	       
	    String fValue_TotalValue_2013=NumberFormat.getNumberInstance(Locale.US).format(fValueResult_2013);	 
	    
	    int[] pNo_Total_2014= { 91891,69705,32189,781,617,450,167,123};
	    
	    int pNoResult_2014=totalSum(pNo_Total_2014);	
	    
	    String pNo_TotalValue_2014=intToStrConversion(pNoResult_2014);	
	   
	    int[] fValue_Total_2014 = { 9297100, 13038900, 7131850, 212132,61700, 100250, 29150, 25171};
	    
	    int fValueResult_2014=totalSum(fValue_Total_2014);	    
	    
	    String fValue_TotalValue_2014=NumberFormat.getNumberInstance(Locale.US).format(fValueResult_2014);
	    
	    int pNo_Grand_Total= pNoResult_2013+pNoResult_2014;
	    
	    pNo_Grand_TotalValue=intToStrConversion(pNo_Grand_Total);
	    
	    int fValue_Grand_Total= fValueResult_2013+fValueResult_2014;
	    
	    String fValue_Grand_TotalValue=NumberFormat.getNumberInstance(Locale.US).format(fValue_Grand_Total);	      
	   
	    String data[][]={ {"2013","Parking offence ","72362","8,136,122"}, 
	    		
	    		{"","Fare Evasion/False Information","69705","13,038,900"},
	    		
	    		{"","Compliance/Safety/Anti-social/Offensive behaviour ","25172","6,652,750"},
	    		
	    		{"","Vehicle offence","652","121,359"},
	    		
	    		{"","Feet on seat","330","35,000"},
	    		
	    		{"","Smoking offence","371","87,500"},
	    		
	    		{"","Littering offence ","108 ","17,860"},
	    		
	    		{"","Animal Offence","91","22,150"},
	    		
	    		{"2013 Total","",pNo_TotalValue_2013,fValue_TotalValue_2013},
	    		
	    		{"2014","Parking offence ","91891","9,297,100"}, 
	    		
	    		{"","Fare Evasion/False Information","69705","13,038,900"},
	    		
	    		{"","Compliance/Safety/Anti-social/Offensive behaviour ","32189","7,131,850"},
	    		
	    		{"","Vehicle offence","781","212,132"},
	    		
	    		{"","Feet on seat","617","61,700"},
	    		
	    		{"","Smoking offence","450","100,250"},
	    		
	    		{"","Littering offence ","167 ","29,150"},
	    		
	    		{"","Animal Offence","123","25171"},
	    		
	    		{"2014 Total","",pNo_TotalValue_2014,fValue_TotalValue_2014},
	    		
	    		{"Grand Total","",pNo_Grand_TotalValue,fValue_Grand_TotalValue}
	    };    
	    
	    String column[]={"Year","Offence Category","Number of PNs","Face Values"};      
	     
	    JTable jt=new JTable(data,column);  
	    
	    jt.setBounds(80,90,700,800);
	    
	    jt.setGridColor(Color.WHITE);
	    
	    jt.setBackground(Color.LIGHT_GRAY);
	    
	    jt.setDefaultRenderer(Object.class, new LastRowBold());
	    
	    JScrollPane sp=new JScrollPane(jt);
	    
	    f.add(sp);
	    
	    f.setSize(800,900);
	    
	    f.setVisible(true);  	
} 
	    
	    static int totalSum(int[] paramData)
	    {
	    	int sum=0;
	    	for(int i=0;i<paramData.length;i++)
	    	{
	    		sum+=paramData[i];	    		
	    	}
	    	return sum;
	    }
	       
	     static String intToStrConversion(int intValueToStrConversion)
	    {
	    	 String pn_Total_Str = null;
	    	try
	    	{
	    		if(intValueToStrConversion > 0)
	    			   pn_Total_Str=String.valueOf(intValueToStrConversion);
	    			
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	return pn_Total_Str;
	    }
 
	    
public static void main(String[] args) {    
    new Sydney_Trains_Data_Table_Creation();    
}    
}

class LastRowBold extends DefaultTableCellRenderer {	
	  
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, 
	   Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		   
	     JLabel parent = (JLabel) super.getTableCellRendererComponent(table, 
	      value, isSelected, hasFocus, row, column);
	     
	     if(row == table.getRowCount()-1 || row == table.getRowCount()-2 || row == table.getRowCount()-11) parent.setFont(
	       parent.getFont().deriveFont(Font.BOLD));
	     
	     return parent;
	   } 
} 
