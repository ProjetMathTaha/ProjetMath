package UI;

import java.awt.Color;
import java.awt.Component; 
import java.awt.FlowLayout; 
import java.awt.GridLayout; 
 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection; 
 
public class Vue extends JPanel { 
 
  public Vue() { 
    JPanel don = new JPanel(); 
    don.setLayout(new GridLayout(3,1)); 
     
    don.add(new JLabel("A :")); 
    JTextField donA = new JTextField(); 
    don.add(donA); 
    don.add(new JLabel("B :")); 
    JTextField donB = new JTextField(); 
    don.add(donB); 
    don.add(new JLabel("X :")); 
    JTextField donX = new JTextField(); 
    don.add(donX); 
 
    this.add(don); 
    
    // Create dataset
    XYDataset dataset = createDataset();

    // Create chart
    JFreeChart chart = ChartFactory.createScatterPlot(
        "Boys VS Girls weight comparison chart", 
        "X-Axis", "Y-Axis", dataset);

  //Changes background color
    XYPlot plot = (XYPlot)chart.getPlot();
    plot.setBackgroundPaint(new Color(255,228,196));
    
    ChartPanel panel = new ChartPanel(chart);
    
    
    this.add(panel);
  } 

  private XYDataset createDataset() {
	    XYSeriesCollection dataset = new XYSeriesCollection();

	    //Boys (Age,weight) series
	    XYSeries series1 = new XYSeries("Boys");
	    series1.add(1, 72.9);
	    series1.add(2, 81.6);
	    series1.add(3, 88.9);
	    series1.add(4, 96);
	    series1.add(5, 102.1);
	    series1.add(6, 108.5);
	    series1.add(7, 113.9);
	    series1.add(8, 119.3);
	    series1.add(9, 123.8);
	    series1.add(10, 124.4);

	    dataset.addSeries(series1);
	    
	   //Girls (Age,weight) series
	    XYSeries series2 = new XYSeries("Girls");
	    series2.add(1, 72.5);
	    series2.add(2, 80.1);
	    series2.add(3, 87.2);
	    series2.add(4, 94.5);
	    series2.add(5, 101.4);
	    series2.add(6, 107.4);
	    series2.add(7, 112.8);
	    series2.add(8, 118.2);
	    series2.add(9, 122.9);
	    series2.add(10, 123.4);

	    dataset.addSeries(series2);

	    return dataset;
	  }

  
  
}