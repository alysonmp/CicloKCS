/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo1.View;

import Ciclo1.Control.ControlPrincipal;
import Ciclo1.Control.Conversao.ControlConverte;
import Ciclo1.Control.Start;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author alysonmp
 */
public class ViewPrincipal extends JFrame{

    private JLabel lbleffLT = new JLabel("effLt: ");
    

    private JTextField txteffLt = new JTextField("0.1");
    
    //BUTTON
    private JButton btnCalcular = new JButton("Calcular");
            
    //Panel
    private JPanel painelEntrada = new JPanel(new GridBagLayout());
    private JPanel painelSaida = new JPanel(new GridBagLayout());
    private JPanel painelDados = new JPanel(new GridBagLayout());
    
    private ViewDadosOperacionais dadosOp;
    private ViewFonteCalor fonteCalor;
    private ViewTrocadores trocadores;
    
    private JTabbedPane tabbedPanel = new JTabbedPane();
    
    private JFrame frameEspera;
    
    private int comp = 1;
    private int FON = 1;
    
    private ControlConverte controlConverte;
    
    public ViewPrincipal(ControlPrincipal ctrPrincipal) {
        controlConverte = new ControlConverte();
        
        this.setLayout(new FlowLayout());
        
        fonteCalor = new ViewFonteCalor(ctrPrincipal);
        tabbedPanel.addTab("Fonte de Calor", fonteCalor);
        
        dadosOp = new ViewDadosOperacionais(ctrPrincipal);
        tabbedPanel.add("Dados Operacionais", dadosOp);
        
        trocadores = new ViewTrocadores();
        tabbedPanel.add("Trocadores de Calor", trocadores);
        
        GridBagConstraints g = new GridBagConstraints();
        
        //PAINEL MAIOR
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 3;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelDados.add(tabbedPanel,g);
        
        g.gridx = 2;
        g.gridy = 1;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelDados.add(btnCalcular,g);
     
        this.add(painelDados);
        
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Thread t1 = new Thread(new Runnable() {
                @Override
                    public void run() {
                        Start start = new Start(ctrPrincipal.getSession(), ctrPrincipal);
                    }
                });
                t1.start();
                
                new Thread(new Runnable() {
                    @Override
                    public void run() {    
                        try {
                            ctrPrincipal.getViewPrincipal().setEnabled(false);
                            ViewEspera painelEspera = new ViewEspera(ctrPrincipal);

                            frameEspera = new JFrame();
                            frameEspera.setUndecorated(true);
                            frameEspera.add(painelEspera.getPanelEspera());
                            frameEspera.setAlwaysOnTop(true);
                            frameEspera.setBounds((ctrPrincipal.getViewPrincipal().getWidth()/2)-100, (ctrPrincipal.getViewPrincipal().getHeight()/2)-50, 200, 100);
                            frameEspera.setResizable(false);
                            frameEspera.setVisible(true);
                            frameEspera.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frameEspera.revalidate();
                            frameEspera.repaint();

                            t1.join();
                            
                            frameEspera.dispose();
                            ctrPrincipal.getViewPrincipal().setEnabled(true);
                        }catch(InterruptedException ex){
                            
                        }
                    }
                }).start();
            }
        });
    }

    public JLabel getLbleffLT() {
        return lbleffLT;
    }

    public JTextField getTxteffLt() {
        return txteffLt;
    }

    public JPanel getPainelEntrada() {
        return painelEntrada;
    }

    public JPanel getPainelSaida() {
        return painelSaida;
    }

    public JPanel getPainelDados() {
        return painelDados;
    }

    public int getComp() {
        return comp;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }

	public int getFON() {
		return FON;
	}

	public void setFON(int fON) {
		FON = fON;
	}

	public ViewDadosOperacionais getDadosOp() {
		return dadosOp;
	}

	public void setDadosOp(ViewDadosOperacionais dadosOp) {
		this.dadosOp = dadosOp;
	}

	public ViewFonteCalor getFonteCalor() {
		return fonteCalor;
	}

	public void setFonteCalor(ViewFonteCalor fonteCalor) {
		this.fonteCalor = fonteCalor;
	}

	public ViewTrocadores getTrocadores() {
		return trocadores;
	}

	public void setTrocadores(ViewTrocadores trocadores) {
		this.trocadores = trocadores;
	}
}
