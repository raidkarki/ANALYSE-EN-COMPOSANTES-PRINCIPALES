package acp;

import java.awt.BorderLayout;
import java.awt.Color;



import javax.swing.JPanel;


import org.jfree.chart3d.Chart3D;
import org.jfree.chart3d.Chart3DFactory;
import org.jfree.chart3d.Chart3DPanel;


import org.jfree.chart3d.data.xyz.XYZSeries;
import org.jfree.chart3d.data.xyz.XYZSeriesCollection;
import org.jfree.chart3d.graphics3d.swing.DisplayPanel3D;






@SuppressWarnings("serial")
public class Representation3d extends JPanel{
	
	 /**
	 * 
	 */
	
	
	
	public Representation3d(double [][] ma,String re) {
		
		   super(new BorderLayout());
		    
		    if(re=="centree") {
		    	 double[][] matra=new Calculcentre(ma).centre;
		    add(createScatterChart(matra,re));
		    }
		    else if(re=="normee") {
		    	double[][] matra=new Calculcentre(ma).centre;
		    	double[][] matraa=new Calculcentreenorme(matra).m1;
			    add(createScatterChart(matraa,re));
		    }
		      
		}

    public Representation3d(double [][] ma) {
	
   super(new BorderLayout());
    
    
    add(createScatterChart(ma,""));  
}

public static DisplayPanel3D createScatterChart(double [][] ma,String re) {
    
    //content.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
    XYZSeries<String> series = new XYZSeries<>("S1");
    for (int i = 0; i < 15; i++) {
        series.add(ma[i][0], ma[i][1],ma[i][2]);
    }
    XYZSeriesCollection<String> dataset = new XYZSeriesCollection<>();
    dataset.add(series);
    Chart3D chart = Chart3DFactory.createScatterChart("Representation 3D", "", dataset, "X","Y", "Z");
    		
 //XYZPlot plot= (XYZPlot) chart.getPlot();
    
 //ValueAxis3D axis= plot.getXAxis();
 //axis.setRange(0, 8);
 //ValueAxis3D axis1= plot.getYAxis();
 //axis1.setRange(0, 4);
 //ValueAxis3D axis2= plot.getZAxis();
 //axis2.setRange(0, 8);
    if(re=="normee")
    chart.setChartBoxColor(Color.ORANGE);
    else if(re=="centree")
    	 chart.setChartBoxColor(Color.GREEN);
    else 
    	chart.setChartBoxColor(Color.PINK);
   
   
    
    Chart3DPanel chartPanel = new Chart3DPanel(chart);
   
    
    DisplayPanel3D content=new DisplayPanel3D(chartPanel);
    return content;
}









}
