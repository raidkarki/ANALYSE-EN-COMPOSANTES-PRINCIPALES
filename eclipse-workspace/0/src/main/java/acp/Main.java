package acp;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Main  {
	public static double[][] getTableData (JTable table) {
		
		
		
		Object[][] tableData = new Object[15][3];
	    for (int i = 0 ; i < 15 ; i++) 
	    	for (int j = 0 ; j <3 ; j++) 
	    		tableData[i][j] =  table.getValueAt(i,j);
	            
	    
	    String[][] tabl = new String[15][3];
	    for (int i = 0 ; i < 15 ; i++) 
	    	for (int j = 0 ; j < 3 ; j++)
	            tabl[i][j] =  tableData[i][j].toString();
	    
	    
	    
	    double[][] table1 = new double[15][3];
	    for (int i = 0 ; i < 15 ; i++) 
	    	for (int j = 0 ; j < 3 ; j++)
	            table1[i][j] =  Double.valueOf(tabl[i][j]).doubleValue();
	    
	    
	    System.out.printf("la table des donnes brute\n");
	    for (int i = 0 ; i < 15 ; i++) {
	    	
	    		System.out.printf("%f  %f  %f\n",table1[i][0],table1[i][1],table1[i][2]);
	           }
	    
	    
	    return table1;
	}
	public static void main(String[] args) {
		Object[][] m1 = {{5.1f, 3.5f, 1.4f}, {4.9f, 3, 1.4f}, {4.7f, 3.2f, 1.3f}, {4.6f, 3.1f, 1.5f}, {5, 3.6f, 1.4f}, {7, 3.2f, 4.7f}, {6.4f, 3.2f, 4.5f}, {6.9f, 3.1f, 4.9f}, {5.5f, 2.3f, 4}, {6.5f, 2.8f, 4.6f}, {6.3f, 3.3f, 6}, {5.8f, 2.7f, 5.1f}, {7.1f, 3, 5.9f}, {6.3f, 2.9f, 5.6f}, {6.5f, 3, 5.8f}};
		
		
		
		
		
		String[] va={"x1","x2","x3"};

		
		
		
		DefaultTableModel model = new javax.swing.table.DefaultTableModel(m1,va);
		
		
		
		
		
		
		
        
        JTable mat =new JTable(model);
       
      
     
        
        JButton centree=new JButton("Centree");
        JButton cnorme=new JButton("C_Norme");
        JButton individu=new JButton("Individus");
        JButton corelation=new JButton("Correlation");
        
        
        
        
       
        //panel lifih les botons
        JPanel panelB=new JPanel();
        panelB.setLayout(new BoxLayout(panelB, BoxLayout.X_AXIS));
   
        panelB.add(centree);
        panelB.add(cnorme);
        panelB.add(individu);
        panelB.add(corelation);
        
        
      //panel lifih les Tables
        JPanel panelT=new JPanel();
        panelT.setLayout(new BoxLayout(panelT, BoxLayout.PAGE_AXIS));
        panelT.add(new JScrollPane(mat));
        
        
        
        //panel lifih panel table wel panel ta les botons
        JPanel panelG=new JPanel();
        panelG.setLayout(new BoxLayout(panelG, BoxLayout.PAGE_AXIS));   
        panelG.add(panelT);
        panelG.add(panelB);
        panelG.setSize(200,200);
        
        
        double[][] ob=getTableData(mat);
        Representation3d content=new Representation3d(ob);
      
        
        
        
        
        
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(panelG);    
        panel.add(content);
       
        
        JFrame frame=new JFrame("ANALYSE EN COMPOSANTES PRINCIPALES");
        frame.add(panel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        
     centree.addActionListener(new ActionListener(){
	        @SuppressWarnings("removal")
			public void actionPerformed(ActionEvent e){
	        	
	        	double[][] ob=getTableData(mat);
	        	
	        	 
	         
	        	
	        	
	        	double[][] centre=new Calculcentre(ob).centre;
	        	Object[][] centreO = new Object[15][3];
	        	for(int i=0;i<15;i++) {
	        		for(int k=0;k<3;k++) {
	        			centreO[i][k] = new Double (centre[i][k]);}
	        		
	        	}
	        	  JTable mat2 =new JTable(centreO,va);
	              mat2.setEnabled(false);
	            
	              if(panelT.getComponentCount()>1) {
	              panelT.remove(panelT.getComponent(1));
	              }
	              panelT.add(new JScrollPane(mat2));
	              
	              
	              
	              
	              
	        	Representation3d content=new Representation3d(ob,"centree");
	        	
                panel.remove(panel.getComponent(1));
                panel.add(content);
               
                panel.updateUI();
        
	
        }    
        
     });
     cnorme.addActionListener(new ActionListener(){
	        @SuppressWarnings("removal")
			public void actionPerformed(ActionEvent e){
	        	
	        	double[][] ob=getTableData(mat);
	        	
	        	
	        	
	        	double[][] centre=new Calculcentreenorme(ob).m1;
	        	Object[][] centreO = new Object[15][3];
	        	for(int i=0;i<15;i++) {
	        		for(int k=0;k<3;k++) {
	        			centreO[i][k] = new Double (centre[i][k]);}
	        		
	        	}
	        	  JTable mat2 =new JTable(centreO,va);
	              mat2.setEnabled(false);
	            
	              if(panelT.getComponentCount()>1) {
	              panelT.remove(panelT.getComponent(1));
	              }
	              panelT.add(new JScrollPane(mat2));
	        	Representation3d content=new Representation3d(ob,"normee");
	        	panel.remove(panel.getComponent(1));
                panel.add(content);
                panel.updateUI();
     
	
     }    
     
  });
     individu.addActionListener(new ActionListener(){
	        @SuppressWarnings("removal")
			public void actionPerformed(ActionEvent e){
	        	double[][] ob=getTableData(mat);
	        	double[][] centre=new Calculindividus().getindividu(ob);
	        	Object[][] centreO = new Object[15][3];
	        	for(int i=0;i<15;i++) {
	        		for(int k=0;k<3;k++) {
	        			centreO[i][k] = new Double (centre[i][k]);}
	        		
	        	}
	        	  JTable mat2 =new JTable(centreO,va);
	              mat2.setEnabled(false);
	            
	              if(panelT.getComponentCount()>1) {
	              panelT.remove(panelT.getComponent(1));
	              }
	              panelT.add(new JScrollPane(mat2));
	        	Representation2d content=new Representation2d(ob);
	        	panel.remove(panel.getComponent(1));
             panel.add(content);
             panel.updateUI();
  
	
  }    
  
});
     corelation.addActionListener(new ActionListener(){
	        @SuppressWarnings("removal")
			public void actionPerformed(ActionEvent e){
	        	double[][] ob=getTableData(mat);
	        	double[][] centre=new Calculindividus().getcoordones(ob);
	        	Object[][] centreO = new Object[3][3];
	        	for(int i=0;i<3;i++) {
	        		for(int k=0;k<3;k++) {
	        			centreO[i][k] = new Double (centre[i][k]);}
	        		
	        	}
	        	  JTable mat2 =new JTable(centreO,va);
	              mat2.setEnabled(false);
	            
	              if(panelT.getComponentCount()>1) {
	              panelT.remove(panelT.getComponent(1));
	              }
	              panelT.add(new JScrollPane(mat2));
	        	Representation2d content=new Representation2d(ob,"");
	        	panel.remove(panel.getComponent(1));
          panel.add(content);
          panel.updateUI();

	
}    

});
	
}}