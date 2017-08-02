/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo1.View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author leonardo
 */
public class ViewInicio {

    private JFrame viewInicio;
    private JPanel painelInicio;
    
    public ViewInicio() {
        viewInicio = new JFrame();
        painelInicio = new JPanel();
        
        JLabel l = new JLabel("\n\nAguarde...");
        l.setFont(new Font("TimesRoman",Font.BOLD,50));
        
        
        painelInicio.add(l);
        painelInicio.setBorder(BorderFactory.createLineBorder(Color.black));
        
        viewInicio.add(painelInicio);
        
        
        viewInicio.setUndecorated(true);
        viewInicio.setSize(400,200);
        viewInicio.setLocationRelativeTo(null);
        viewInicio.setResizable(false);
        viewInicio.setVisible(true);
        
    }

    public JFrame getViewInicio() {
        return viewInicio;
    }
 
}
