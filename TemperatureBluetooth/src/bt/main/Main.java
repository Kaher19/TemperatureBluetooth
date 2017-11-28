/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.main;

import bt.UI.BluetoothUI;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 *
 * @author Kirbey García
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new BluetoothUI();
        JFreeChart Grafica;
        JFrame representarGrafica = new JFrame();
        
        final XYSeries serie = new XYSeries("Temperature");
        final XYSeries average = new XYSeries("Average");
        final XYSeriesCollection collection = new XYSeriesCollection();
        
        Grafica = ChartFactory.createXYLineChart("Temperature per second", "Second", "Temperature",
        collection, PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel graficPanel = new ChartPanel(Grafica);
        
        //representarGrafica.setLocationRelativeTo(null);
        representarGrafica.setTitle("Temperature Vs. Time");
        representarGrafica.setSize(800, 600);
        representarGrafica.setVisible(true);
        representarGrafica.getContentPane().add(graficPanel);
        representarGrafica.pack();
        representarGrafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        serie.add(0, 0);
        average.add(0, 0);
        collection.addSeries(serie);
        collection.addSeries(average);
        
        int seconds = 0 ;
        int temperatura = 5;
        int temperaturas = 0;
        int averageT = 0;
        
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
             try{Thread.sleep(1000);
             }catch(InterruptedException e){
             }
        }
}
 
