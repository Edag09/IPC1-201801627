package Ventanas;

import ListaCircular.ListaCircularDoble;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CircularDobleV extends JFrame{
    private JLabel val;
    private JTextField txtVal;
    private Container lienzo;
    private JTextArea GraphSimple;
    private JButton add,eliminar;
    ListaCircularDoble listaCD;
    
    public CircularDobleV(ListaCircularDoble listaCD){
        this.setTitle("Lista Ciercular Doble");
        this.setBounds(350, 100, 450, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.listaCD = listaCD;
        
        
        val = new JLabel("Valor");
        val.setBounds(50, 20, 50, 25);
        val.setFont(new Font("Cavolini", Font.PLAIN, 16));
        
        txtVal = new JTextField();
        txtVal.setBounds(50, 50, 100, 25);
        
        add = new JButton("Agregar");
        add.setBounds(300, 50, 110, 30);
        add.setFont(new Font("Retrow Mentho", Font.PLAIN, 15));
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        ActionListener agregar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (txtVal.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Completar Campos");
                    }else{
                    int valor = Integer.parseInt(txtVal.getText());
                    listaCD.insertarDC(valor, Color.RED);
                    GraphSimple.setText(listaCD.GraphvizCD());
                    JOptionPane.showMessageDialog(null, "Agregado");
                    txtVal.setText("");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa los datos correctos");
                }
            }
        };
        add.addActionListener(agregar);
        
        eliminar = new JButton("Eliminar");
        eliminar.setBounds(300, 150, 110, 30);
        eliminar.setFont(new Font("Retrow Mentho", Font.PLAIN, 15));
        eliminar.setForeground(Color.WHITE);
        eliminar.setBackground(Color.BLACK);
        ActionListener delete = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int valor = Integer.parseInt(txtVal.getText());
                    listaCD.eliminar(valor);
                    GraphSimple.setText(listaCD.GraphvizCD());
                    JOptionPane.showMessageDialog(null, "Eliminado");
                    txtVal.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa los datos correctos");
                }
            }
        };
        eliminar.addActionListener(delete);
        
        GraphSimple = new JTextArea();
        GraphSimple.setBounds(50, 90, 225, 375);
        GraphSimple.setEditable(false);
        
        GraphSimple.setText(listaCD.GraphvizCD());
        
        lienzo = this.getContentPane();
        lienzo.add(val);
        lienzo.add(txtVal);
        lienzo.add(add);
        lienzo.add(GraphSimple);
        lienzo.add(eliminar);
    }
}
