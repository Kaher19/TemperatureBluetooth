/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.UI;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Kirbey
 */
public class BluetoothUI {
    public void bluetoothUI(){
        JFreeChart Grafica;
        JFrame representarGrafica = new JFrame();
        
        final XYSeries serie = new XYSeries("Temperature");
        final XYSeries average = new XYSeries("Average");
        final XYSeriesCollection collection = new XYSeriesCollection();
        
        Grafica = ChartFactory.createXYLineChart("Temperature per second", "Second", "Temperature",
        collection, PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel graficPanel = new ChartPanel(Grafica);
        
        graficPanel.setMouseWheelEnabled(true);
        graficPanel.setMouseZoomable(true);
        
        representarGrafica.setLocation(150,150);
        representarGrafica.setTitle("Temperature Vs. Time");
        representarGrafica.setSize(1280, 720);
        representarGrafica.setVisible(true);
        representarGrafica.getContentPane().add(graficPanel);
        representarGrafica.pack();
        representarGrafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        serie.add(0, 0);
        average.add(0, 0);
        collection.addSeries(serie);
        collection.addSeries(average);
        
        int seconds = 0 ;
        int temperatura;
        int temperaturas = 0;
        int averageT;
        
        while (seconds>=0){
            temperatura=seconds^2;
            temperaturas = temperaturas + temperatura;
            seconds++;
            averageT=temperaturas/seconds;
            
            //jLabel1.setText("Segundo " +seconds);
            //jLabel2.setText("Temperatura " +temperatura);
            
            serie.add(seconds, temperatura);
            average.add(seconds, averageT);
            delaySegundo(); 
            }
    }
    
    private static void delaySegundo(){      
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
        }          
    }
}
