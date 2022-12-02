/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.gui;


import pe.edu.upeu.modelo.ModeloGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;


public class GameGui {

    private MainJuego ventana;
    private ModeloGame modelo;
    private JButton[][] MatrizButton;

    public GameGui(MainJuego ventana, ModeloGame modelo) {
        this.ventana = ventana;
        this.modelo = modelo;
        MatrizButton = this.ventana.getMatrizButton();
        agregarListeners();
        crearPlayer();
    }

    private void agregarListeners() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                agregarEventoMouse(i, j);
            }
        }
        JButton Anular=ventana.getAnular();
        Anular.addActionListener(new ActionListener() {
            
            
            @Override
            public void actionPerformed(ActionEvent e){
                modelo.resetJP(MatrizButton);
                      
        }
     });
    }

    private void agregarEventoMouse(int i, int j) {
        JButton ABtn = MatrizButton[i][j];
        ABtn.addMouseListener(new MouseAdapter() {
            
            
            @Override
            public void mouseClicked(MouseEvent e){
                modelo.marcarBtn(i,j,MatrizButton,ABtn);
        }
     });
    
    }
     private void crearPlayer() {
        JLabel j1 =ventana.getVitoriasJ1();
        JLabel j2 =ventana.getVitoriasJ2();
        modelo.setPlayer(j1,j2);
    }


}
