package acp;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

@SuppressWarnings("serial")
public class Representation2d extends ChartPanel {

	
public Representation2d(double[][] m1) {
	
	super(createscraterplot(m1));
	
    
}
public Representation2d(double[][] m1,String re) {
	
	super(createscraterplot2(m1));
	
    
}

public static  JFreeChart createscraterplot(double [][] mat) {
	double[][] mt=new Calculindividus().getindividu(mat);
	XYSeries serie1 = new XYSeries("individu");
	for (int i = 0; i < 15; i++) {
        serie1.add(mt[i][0], mt[i][1]);
    }
	XYDataset PFG = new XYSeriesCollection(serie1);
	 JFreeChart chart1 = ChartFactory.createScatterPlot("Plan factoriel 1-2", "X", "Y", PFG);
	 return chart1;
}





public static  JFreeChart createscraterplot2(double [][] mat) {
	double[][] lastmat=new Calculindividus().getcoordones(mat);
	XYSeries serie2 = new XYSeries("coordonee");
    
    for (int i = 0; i < 3; i++) {
        serie2.add(lastmat[i][0], lastmat[i][1]);
    }
    XYDataset CCL = new XYSeriesCollection(serie2);
    JFreeChart chart2 = ChartFactory.createScatterPlot("Circle de coeficeant lineaire ", "X", "Y", CCL);
    XYPlot plot = (XYPlot) chart2.getPlot();
    
    ValueAxis axis = plot.getDomainAxis();
    axis.setLowerBound(-1);
    axis.setUpperBound(1);
    NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
    yAxis.setLowerBound(-1);
    yAxis.setUpperBound(1);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    double range = 1.0f;
    
   
    double outRad = range ;
    Ellipse2D outercircle = new Ellipse2D.Double(- outRad,  - outRad, outRad * 2.0f, outRad * 2.0f);
    
    
    
    plot.addAnnotation(new XYShapeAnnotation(outercircle, new BasicStroke(1.0f), Color.BLUE));
    
    
    
    return chart2;
}

}
