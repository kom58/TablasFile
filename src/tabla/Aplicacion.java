package tabla;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import lib.Comprobar;


public class Aplicacion {

    private JPanel panPrincipal;
    private JTextArea tarTabla;
    private JTextField tflNumero;
    private JButton btnGuardar;
    private JButton btnSalir;
    private JButton btnLeer;

    public Aplicacion() {
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                guardaTabla();
            }
        });
        btnLeer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                leeTabla();
            }
        });
    }

    public void guardaTabla(){

        Comprobar cp = new Comprobar();
        if (cp.esEntero(tflNumero.getText())) {

            int n = Integer.parseInt(tflNumero.getText());
            String tab = "";

            try {
                FileWriter f = new FileWriter("tabla.txt");
                for (int i = 1; i <= 10; i++) {
                    //f.write(" " + n + " x " + i + " = " + n * i + "\n");
                    tab = tab + " " + n + " x " + i + " = " + n * i + "\n";
                }
                f.write(tab);

                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void leeTabla(){

        String tt = "";

        try {
            FileReader f = new FileReader("tabla.txt");
            int c;
            c = f.read();
            //while ( (c = f.read()) != -1)	// Forma resumida habitual del while para recorrer ficheros
            while (c != -1) {
                if (c != -1) {
                    tt = tt + ((char)c);
                }
                c = f.read();
            }
            f.close();
        }
        catch (IOException e) { e.printStackTrace(); }

        tarTabla.setText(tt);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tablas");
        frame.setContentPane(new Aplicacion().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(400,350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
