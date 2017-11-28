/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.UI;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
        JFrame graphWindow = new JFrame();
        JPanel graphArea = new JPanel();
        ImageIcon image = new ImageIcon("Logo_Kaher.png");
        Image imagenExterna = image.getImage();
        
        final XYSeries serie = new XYSeries("Temperature");
        final XYSeries average = new XYSeries("Average");
        final XYSeriesCollection collection = new XYSeriesCollection();
        
        Grafica = ChartFactory.createXYLineChart("Temperature per second", "Second", "Temperature",
        collection, PlotOrientation.VERTICAL, true, true, true);
        
        ChartPanel graficPanel = new ChartPanel(Grafica);
        
        graficPanel.setSize(200, 200);
        graficPanel.setAlignmentX(ChartPanel.RIGHT_ALIGNMENT);
        graficPanel.setAlignmentY(ChartPanel.TOP_ALIGNMENT);
        
        graphArea.setSize(400, 400);
        graphArea.add(graficPanel);
        graphArea.setToolTipText("Grafica de la temperatura");
        
        graphWindow.setIconImage(imagenExterna);
        graphWindow.setTitle("Temperature Vs. Time");
        graphWindow.setSize(800, 600);
        graphWindow.setVisible(true);
        graphWindow.add(graphArea);
        graphWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        serie.add(0, 0);
        average.add(0, 0);
        collection.addSeries(serie);
        collection.addSeries(average);
        
        int seconds = 0 ;
        int temperatura;
        int temperaturas = 0;
        int averageT;
        
        while (seconds>=0){
            temperatura=seconds^2*temperaturas;
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
