package Programas;

import Clases.DatosDesordenados;
import Clases.DatosOrdenados;
import javax.swing.JOptionPane;

public class ProyectoOrdenación {

    public static void main(String[] args) {
        DatosDesordenados m;
        //DatosOrdenados datosOrd;
        int n, s; 
        long t, t1, t2;
        
        n = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos datos son?"));
        s = Integer.parseInt(JOptionPane.showInputDialog("¿Cuál es el valor máximo?"));
        
        m = new DatosDesordenados(s, n);
        m.generarValores();
        System.out.println("" + m);
        
        t1 = System.nanoTime();   // start
           
            System.out.println("\n" + "Ordenamiento Burbuja");    
            DatosOrdenados mob = m.bubbleSort();
            DatosOrdenados mob2 = m.bubbleSort2();
            t2 = System.nanoTime();   // stop
            t= t2 - t1;
            System.out.println("n= "+ n + "t= " + t  + " ns. Burbuja = " + mob);
            System.out.println("Descendente:" + mob2 + "\n" + "\n");
            t1 = System.nanoTime();   // start
            
            
            System.out.println("Ordenamiento InsertSort");  
            DatosOrdenados moi = m.insertSort();
            DatosOrdenados moi2 = m.insertSort2();
            t2 = System.nanoTime();   // stop
            t = t2 - t1;
            System.out.println("n= "+ n + "t= " + t +  " ns. Inserción" + moi);
            System.out.println("Descendente:" + moi2 + "\n" + "\n");
            
            
            System.out.println("Ordenamiento ShellSort");  
            DatosOrdenados mos = m.ShellSort();
            DatosOrdenados mos2 = m.ShellSort2();
            t2 = System.nanoTime();   // stop
            t = t2 - t1;
            System.out.println("n= "+ n + "t= "+ t +  " ns. ShellSort" + mos);     
            System.out.println("Descendente:" + mos2 + "\n" + "\n");
    }
}
