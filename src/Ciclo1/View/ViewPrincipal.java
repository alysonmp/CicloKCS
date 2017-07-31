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
import javax.swing.JTextField;

/**
 *
 * @author alysonmp
 */
public class ViewPrincipal extends JFrame{

    //Labels
    //ENTRADA
    private JLabel lblT1 = new JLabel("T1: ");
    private JLabel lblP1 = new JLabel("P1: ");
    private JLabel lblPP = new JLabel("PP: ");
    private JLabel lblSUBT = new JLabel("SUBT: ");
    private JLabel lblTf = new JLabel("Tf: ");
    private JLabel lblPf = new JLabel("Pf: ");
    private JLabel lblMf = new JLabel("Mf: ");
    private JLabel lblTres = new JLabel("Tres: ");
    private JLabel lblcompressor = new JLabel("Compressor: ");
    private JLabel lbleffLT = new JLabel("effLt: ");
    private JLabel lblzi = new JLabel("zi: ");
    private JLabel lblVE = new JLabel("VE: ");
    
    //SAIDA
    private JLabel lblEc = new JLabel("Ec: ");
    private JLabel lblQcon = new JLabel("Qcon: ");
    private JLabel lblQLHR = new JLabel("QLHR: ");
    private JLabel lblQHHR = new JLabel("QHHR: ");
    private JLabel lblWt = new JLabel("Wt: ");
    private JLabel lblWn = new JLabel("Wn: ");
    private JLabel lblWb = new JLabel("Wb: ");
    private JLabel lblAcon = new JLabel("Acon: ");
    private JLabel lblAevp = new JLabel("Aevp: ");
    private JLabel lblALHR = new JLabel("ALHR: ");
    private JLabel lblAHHR = new JLabel("AHHR: ");
    private JLabel lblAT = new JLabel("AT: ");
    
    //TextFields
    //ENTRADA
    private JTextField txtT1 = new JTextField("20",10);
    private JTextField txtP1 = new JTextField("20");
    private JTextField txtPP = new JTextField("2");
    private JTextField txtSUBT = new JTextField("0");
    private JTextField txtTf = new JTextField("415.15");
    private JTextField txtPf = new JTextField("415.15");
    private JTextField txtMf = new JTextField("415.15");
    private JTextField txtTres = new JTextField("298.15");
    private JTextField txteffLt = new JTextField("0.1");
    private JTextField txtzi = new JTextField("0.8");
    private JTextField txtVE = new JTextField("0.5");
    
    //SAIDA
    private JLabel txtEc = new JLabel("0%");
    private JLabel txtQcon = new JLabel("0");
    private JLabel txtQLHR = new JLabel("0");
    private JLabel txtQHHR = new JLabel("0");
    private JLabel txtWt = new JLabel("0");
    private JLabel txtWn = new JLabel("0");
    private JLabel txtWb = new JLabel("0");
    private JLabel txtAcon = new JLabel("0");
    private JLabel txtAevp = new JLabel("0");
    private JLabel txtALHR = new JLabel("0");
    private JLabel txtAHHR = new JLabel("0");
    private JLabel txtAT = new JLabel("0");
    
    //COMBOBOX
    private String[] pressoes = {"kPa", "atm", "bar"};
    private String[] temps = {"K", "°C", "°F"};
    private String[] fluidos = {"Água", "Ar", "Compressor 1", "Compressor 2", "Compressor 3", "Compressor 4", "Compressor 5", "Gases"};
    
    private JComboBox cmbCompressor = new JComboBox(fluidos);
    private JComboBox<String> comboT1 = new JComboBox<>(temps);
    private JComboBox<String> comboP1 = new JComboBox<>(pressoes);
    private JComboBox<String> comboTf = new JComboBox<>(temps);
    private JComboBox<String> comboPf = new JComboBox<>(pressoes);
    
    //BUTTON
    private JButton btnCalcular = new JButton("Calcular");
            
    //Panel
    private JPanel painelEntrada = new JPanel(new GridBagLayout());
    private JPanel painelSaida = new JPanel(new GridBagLayout());
    private JPanel painelDados = new JPanel(new GridBagLayout());
    
    private JFrame frameEspera;
    
    private int comp = 0;
    
    private ControlConverte controlConverte;
    
    public ViewPrincipal(ControlPrincipal ctrPrincipal) {
        controlConverte = new ControlConverte();
        
        this.setLayout(new FlowLayout());
        
        painelEntrada.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.lightGray), "Entrada", 1, 2, new Font("Times New Roman", 1, 12), Color.darkGray));
        painelSaida.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.lightGray), "Saída", 1, 2, new Font("Times New Roman", 1, 12), Color.darkGray));

        GridBagConstraints g = new GridBagConstraints();
       
        //PANEL ENTRADA
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 1;
        //g.insets = new Insets(4, 0, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(lblcompressor,g);
        
        g.gridx = 1;
        g.gridy = 0;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(cmbCompressor,g);
        
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(lblT1,g);

        g.gridx = 1;
        g.gridy = 1;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(txtT1,g);
        
        g.gridx = 3;
        g.gridy = 1;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(comboT1,g);
        
        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(lblP1,g);

        g.gridx = 1;
        g.gridy = 2;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(txtP1,g);
        
        g.gridx = 3;
        g.gridy = 2;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(comboP1,g);
        
        g.gridx = 0;
        g.gridy = 3;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(lblPP,g);
        
        g.gridx = 1;
        g.gridy = 3;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(txtPP,g);
        
        g.gridx = 0;
        g.gridy = 4;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(lblSUBT,g);
                
        g.gridx = 1;
        g.gridy = 4;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(txtSUBT,g);
        
        g.gridx = 0;
        g.gridy = 5;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(lblTf,g);
        
        g.gridx = 1;
        g.gridy = 5;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(txtTf,g);
        
        g.gridx = 3;
        g.gridy = 5;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(comboTf,g);
        
        g.gridx = 0;
        g.gridy = 6;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(lblPf,g);
        
        g.gridx = 1;
        g.gridy = 6;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(txtPf,g);
        
        g.gridx = 3;
        g.gridy = 6;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(comboPf,g);
        
        g.gridx = 0;
        g.gridy = 7;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(lblMf,g);
        
        g.gridx = 1;
        g.gridy = 7;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(txtMf,g);
        
        g.gridx = 0;
        g.gridy = 8;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(lblTres,g);
        
        g.gridx = 1;
        g.gridy = 8;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(txtTres,g);

        g.gridx = 0;
        g.gridy = 9;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(lbleffLT,g);
        
        g.gridx = 1;
        g.gridy = 9;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(txteffLt,g);
        
        g.gridx = 0;
        g.gridy = 10;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(lblzi,g);
        
        g.gridx = 1;
        g.gridy = 10;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(txtzi,g);
        
        g.gridx = 0;
        g.gridy = 11;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(lblVE,g);
        
        g.gridx = 1;
        g.gridy = 11;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelEntrada.add(txtVE,g);
       
        //PAINEL SAIDA
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 1;
        g.weightx = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(lblEc,g);
        
        g.gridx = 1;
        g.gridy = 0;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(txtEc,g);
        
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(lblQcon,g);
        
        g.gridx = 1;
        g.gridy = 1;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(txtQcon,g);
        
        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(lblQLHR,g);
        
        g.gridx = 1;
        g.gridy = 2;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(txtQLHR,g);
        
        g.gridx = 0;
        g.gridy = 3;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(lblQHHR,g);
        
        g.gridx = 1;
        g.gridy = 3;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(txtQHHR,g);
        
        g.gridx = 0;
        g.gridy = 4;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(lblWt,g);
        
        g.gridx = 1;
        g.gridy = 4;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(txtWt,g);
        
        g.gridx = 0;
        g.gridy = 5;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(lblWn,g);
        
        g.gridx = 1;
        g.gridy = 5;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(txtWn,g);
        
        g.gridx = 0;
        g.gridy = 6;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(lblWb,g);
        
        g.gridx = 1;
        g.gridy = 6;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(txtWb,g);
        
        g.gridx = 0;
        g.gridy = 7;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(lblAcon,g);
        
        g.gridx = 1;
        g.gridy = 7;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(txtAcon,g);
        
        g.gridx = 0;
        g.gridy = 8;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(lblAevp,g);
        
        g.gridx = 1;
        g.gridy = 8;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(txtAevp,g);
        
        g.gridx = 0;
        g.gridy = 9;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(lblALHR,g);
        
        g.gridx = 1;
        g.gridy = 9;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(txtALHR,g);
        
        g.gridx = 0;
        g.gridy = 10;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(lblAHHR,g);
        
        g.gridx = 1;
        g.gridy = 10;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(txtAHHR,g);
        
        g.gridx = 0;
        g.gridy = 11;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(lblAT,g);
        
        g.gridx = 1;
        g.gridy = 11;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelSaida.add(txtAT,g);
        
        //PAINEL MAIOR
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 3;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelDados.add(painelEntrada,g);
        
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 3;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelDados.add(painelSaida,g);
        
        g.gridx = 2;
        g.gridy = 2;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        painelDados.add(btnCalcular,g);
     
        this.add(painelDados);
        
        cmbCompressor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int FON = cmbCompressor.getSelectedIndex()+1;
                switch(FON){
                    case 3:
                        comp = 1;
                        txtMf.setText(55.54+"");
                        txtTf.setText(415.15+"");
                        txtPf.setText(1144.4+"");
                        break;
                    case 4:
                        comp = 2;
                        txtMf.setText(55.54+"");
                        txtTf.setText(417.15+"");
                        txtPf.setText(3133.8+"");
                        break;
                    case 5: 
                        comp = 3;
                        txtMf.setText(55.54+"");
                        txtTf.setText(418.15+"");
                        txtPf.setText(8825.6+"");
                        break;
                    case 6:
                        comp = 4;
                        txtMf.setText(55.54+"");
                        txtTf.setText(408.15+"");
                        txtPf.setText(25109+"");
                        break;
                    case 7: 
                        comp = 5;
                        txtMf.setText(61.78+"");
                        txtTf.setText(431.15+"");
                        txtPf.setText(8196.1+"");
                        break;
                    default:
                        comp = 0;
                        break;
                }
            }
        });
        
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
        
        comboT1.addItemListener(new ItemListener() {
            
            String[] tipo = new String[2];
            int tip = 0;
            
            @Override
            public void itemStateChanged(ItemEvent ie) {
                
                tipo[tip] = ie.getItem().toString();
                tip++;
                if(tip == 2){
                    String valor = txtT1.getText();
                    if(!valor.isEmpty()){
                        txtT1.setText(String.valueOf(controlConverte.converte(tipo[0],tipo[1],Double.parseDouble(valor))));
                    } 
                    tip = 0;
                }
            }
        });
        
        comboP1.addItemListener(new ItemListener() {
            
            String[] tipo = new String[2];
            int tip = 0;
            
            @Override
            public void itemStateChanged(ItemEvent ie) {
                
                tipo[tip] = ie.getItem().toString();
                tip++;
                if(tip == 2){
                    String valor = txtP1.getText();
                    if(!valor.isEmpty()){
                        txtP1.setText(String.valueOf(controlConverte.converte(tipo[0],tipo[1],Double.parseDouble(valor))));
                    } 
                    tip = 0;
                }
            }
        });
        
        comboTf.addItemListener(new ItemListener() {
            
            String[] tipo = new String[2];
            int tip = 0;
            
            @Override
            public void itemStateChanged(ItemEvent ie) {
                
                tipo[tip] = ie.getItem().toString();
                tip++;
                if(tip == 2){
                    String valor = txtTf.getText();
                    if(!valor.isEmpty()){
                        txtTf.setText(String.valueOf(controlConverte.converte(tipo[0],tipo[1],Double.parseDouble(valor))));
                    } 
                    tip = 0;
                }
            }
        });
        
        comboPf.addItemListener(new ItemListener() {
            
            String[] tipo = new String[2];
            int tip = 0;
            
            @Override
            public void itemStateChanged(ItemEvent ie) {
                
                tipo[tip] = ie.getItem().toString();
                tip++;
                if(tip == 2){
                    String valor = txtPf.getText();
                    if(!valor.isEmpty()){
                        txtPf.setText(String.valueOf(controlConverte.converte(tipo[0],tipo[1],Double.parseDouble(valor))));
                    } 
                    tip = 0;
                }
            }
        });
    }

    public JLabel getLblP1() {
        return lblP1;
    }

    public JLabel getLblPP() {
        return lblPP;
    }

    public JLabel getLblSUBT() {
        return lblSUBT;
    }

    public JLabel getLblTf() {
        return lblTf;
    }

    public JLabel getLblTres() {
        return lblTres;
    }

    public JLabel getLblcompressor() {
        return lblcompressor;
    }

    public JLabel getLbleffLT() {
        return lbleffLT;
    }

    public JLabel getLblzi() {
        return lblzi;
    }

    public JLabel getLblVE() {
        return lblVE;
    }

    public JLabel getLblEc() {
        return lblEc;
    }

    public JLabel getLblQcon() {
        return lblQcon;
    }

    public JLabel getLblQLHR() {
        return lblQLHR;
    }

    public JTextField getTxtP1() {
        return txtP1;
    }

    public JTextField getTxtPP() {
        return txtPP;
    }

    public JTextField getTxtSUBT() {
        return txtSUBT;
    }

    public JTextField getTxtTf() {
        return txtTf;
    }

    public JTextField getTxtTres() {
        return txtTres;
    }

    public JTextField getTxteffLt() {
        return txteffLt;
    }

    public JTextField getTxtzi() {
        return txtzi;
    }

    public JTextField getTxtVE() {
        return txtVE;
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

    public JLabel getLblQHHR() {
        return lblQHHR;
    }

    public void setLblQHHR(JLabel lblQHHR) {
        this.lblQHHR = lblQHHR;
    }

    public JLabel getLblWt() {
        return lblWt;
    }

    public void setLblWt(JLabel lblWt) {
        this.lblWt = lblWt;
    }

    public JLabel getLblWn() {
        return lblWn;
    }

    public void setLblWn(JLabel lblWn) {
        this.lblWn = lblWn;
    }

    public JLabel getLblWb() {
        return lblWb;
    }

    public void setLblWb(JLabel lblWb) {
        this.lblWb = lblWb;
    }

    public JLabel getLblAcon() {
        return lblAcon;
    }

    public void setLblAcon(JLabel lblAcon) {
        this.lblAcon = lblAcon;
    }

    public int getComp() {
        return comp;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }

    public JTextField getTxtPf() {
        return txtPf;
    }

    public void setTxtPf(JTextField txtPf) {
        this.txtPf = txtPf;
    }

    public JTextField getTxtMf() {
        return txtMf;
    }

    public void setTxtMf(JTextField txtMf) {
        this.txtMf = txtMf;
    }

    public JTextField getTxtT1() {
        return txtT1;
    }

    public void setTxtT1(JTextField txtT1) {
        this.txtT1 = txtT1;
    }

    public JLabel getTxtEc() {
        return txtEc;
    }

    public void setTxtEc(JLabel txtEc) {
        this.txtEc = txtEc;
    }

    public JLabel getTxtQcon() {
        return txtQcon;
    }

    public void setTxtQcon(JLabel txtQcon) {
        this.txtQcon = txtQcon;
    }

    public JLabel getTxtQLHR() {
        return txtQLHR;
    }

    public void setTxtQLHR(JLabel txtQLHR) {
        this.txtQLHR = txtQLHR;
    }

    public JLabel getTxtQHHR() {
        return txtQHHR;
    }

    public void setTxtQHHR(JLabel txtQHHR) {
        this.txtQHHR = txtQHHR;
    }

    public JLabel getTxtWt() {
        return txtWt;
    }

    public void setTxtWt(JLabel txtWt) {
        this.txtWt = txtWt;
    }

    public JLabel getTxtWn() {
        return txtWn;
    }

    public void setTxtWn(JLabel txtWn) {
        this.txtWn = txtWn;
    }

    public JLabel getTxtWb() {
        return txtWb;
    }

    public void setTxtWb(JLabel txtWb) {
        this.txtWb = txtWb;
    }

    public JLabel getTxtAcon() {
        return txtAcon;
    }

    public void setTxtAcon(JLabel txtAcon) {
        this.txtAcon = txtAcon;
    }

    public JLabel getTxtAevp() {
        return txtAevp;
    }

    public void setTxtAevp(JLabel txtAevp) {
        this.txtAevp = txtAevp;
    }

    public JLabel getTxtALHR() {
        return txtALHR;
    }

    public void setTxtALHR(JLabel txtALHR) {
        this.txtALHR = txtALHR;
    }

    public JLabel getTxtAHHR() {
        return txtAHHR;
    }

    public void setTxtAHHR(JLabel txtAHHR) {
        this.txtAHHR = txtAHHR;
    }

    public JLabel getTxtAT() {
        return txtAT;
    }

    public void setTxtAT(JLabel txtAT) {
        this.txtAT = txtAT;
    }
    
    
}
