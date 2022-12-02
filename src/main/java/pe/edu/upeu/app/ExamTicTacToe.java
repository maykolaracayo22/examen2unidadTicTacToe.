/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package pe.edu.upeu.app;


import pe.edu.upeu.gui.GameGui;

import pe.edu.upeu.gui.MainJuego;
import pe.edu.upeu.modelo.ModeloGame;






public class ExamTicTacToe {

    public static void main(String[] args) {
        ModeloGame modelo = new ModeloGame();
        MainJuego ventana = new MainJuego();
        GameGui juego = new GameGui(ventana, modelo);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

    }

}
