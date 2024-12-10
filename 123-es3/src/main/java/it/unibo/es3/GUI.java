package it.unibo.es3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class GUI extends JFrame {
    
    private final Map<JButton, Pair<Integer, Integer>> buttons = new HashMap<>();
    private final Logics logics;
    
    public GUI(int width) {
        this.logics = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        
        JPanel panel = new JPanel(new GridLayout(width,width));
        this.getContentPane().add(panel);

        this.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '>') {
                    GUI.this.update(logics.hit());
                    if (logics.toQuit()){
                        System.exit(1);
                    } 
                }
            }
        });
                
        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
            	final JButton jb = new JButton(" ");
                this.buttons.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }
        this.update(logics.init());
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setVisible(true);
    }
    
    private void update(Collection<Pair<Integer, Integer>> set) {
        buttons.forEach((button, position) -> {
            if (set.contains(position)) {
                button.setText("*");
            }
        });
    }
    
}