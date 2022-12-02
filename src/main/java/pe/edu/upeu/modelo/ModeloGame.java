/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.modelo;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.upeu.dao.ResultadoDaoI;

import pe.edu.upeu.gui.MainJuego;





public class ModeloGame {

    MainJuego Gp;
    ResultadoDaoI cDao;
    DefaultTableModel modelo;
    private String turno;
    private boolean end;
    private boolean empate;
    public JLabel Xj1;
    public JLabel Oj2;
    private String[][] tablero;
    private int cantJugadas;
    private int victoriasJ1;
    private int victoriasJ2;

    
    
    
    
    public ModeloGame() {

        turno = "X";
        end = false;
        empate = false;
        tablero = new String[3][3];
        cantJugadas = 0;
        victoriasJ1 = 0;
        victoriasJ2 = 0;

    }

    
    
    
    
    public void marcarBtn(int i, int j, JButton[][] MatrizButton, javax.swing.JButton bt) {
        if (!end) {
            if (tablero[i][j] == null) {
                tablero[i][j] = turno;
                MatrizButton[i][j].setText(turno);
                cantJugadas++;
                verificarEstado();
                if (!end) {
                    if (turno.equals("X")) {
                        turno = "O";
                        bt.setForeground(Color.red);
                        bt.setFont(new Font("Ink Free", Font.BOLD, 56));
                    } else {
                        turno = "X";
                        bt.setForeground(Color.blue);
                        bt.setFont(new Font("Ink Free", Font.BOLD, 56));
                    }
                } else {
                    terminarJuego();
                }
            }
        }
    }

    
    
    
    private void verificarEstado() {
        verificarFilas();
        if (!end) {
            verificarColumnas();
            if (!end) {
                verificarDiagonalP();
                if (!end) {
                    verificarDiagonalS();
                    if (cantJugadas == 9) {
                        empate = true;
                        end = true;
                    }
                }
            }
        }
    }

    
    
    
    private void verificarFilas() {
        for (int i = 0; i < 3 && !end; i++) {
            boolean win = true;
            for (int j = 0; j < 3 && win; j++) {
                if (tablero[i][j] == null || !tablero[i][j].equals(turno)) {
                    win = false;
                }
            }
            if (win) {
                end = true;
            }
        }
    }

    
    
    
    private void verificarColumnas() {
        for (int j = 0; j < 3 && !end; j++) {
            boolean win = true;
            for (int i = 0; i < 3 && win; i++) {
                if (tablero[i][j] == null || !tablero[i][j].equals(turno)) {
                    win = false;
                }
            }
            if (win) {
                end = true;
            }
        }
    }

  
    
    
    private void verificarDiagonalP() {

        boolean win = true;
        for (int i = 0; i < 3 && win; i++) {
            if (tablero[i][i] == null || !tablero[i][i].equals(turno)) {
                win = false;
            }
        }
        if (win) {
            end = true;
        }

    }

    
    
    
    private void verificarDiagonalS() {

        boolean win = true;
        int j = 2;
        for (int i = 0; i < 3 && win; i++, j--) {
            if (tablero[i][j] == null || !tablero[i][j].equals(turno)) {
                win = false;
            }
        }
        if (win) {
            end = true;
        }

    }

  
    
    
    private void terminarJuego() {

        if (empate) {
            victoriasJ1 = 0;
            victoriasJ2 = 0;
            JOptionPane.showMessageDialog(null, "Empate");
            Gp.ListarResultado();
        } else {
            if (turno.equals("X")) {
                victoriasJ1++;
                Xj1.setText(String.valueOf(victoriasJ1));
                JOptionPane.showMessageDialog(null, "Victoria de jugador 1");
                Gp.ListarResultado();

                //clasegu
            } else {
                victoriasJ2++;
                Oj2.setText(String.valueOf(victoriasJ2));
                JOptionPane.showMessageDialog(null, "Victoria del jugador 2");
                Gp.ListarResultado();
                //clase
            }
        }
    }

 
    
    
    public void setPlayer(JLabel j1, JLabel j2) {
        Xj1 = j1;
        Oj2 = j2;
    }

  
    
    
    public void resetJP(JButton[][] MatrizButton) {
        turno = "X";
        end = false;
        empate = false;
        cantJugadas = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = null;
                MatrizButton[i][j].setText("");

            }

        }
    }

}
