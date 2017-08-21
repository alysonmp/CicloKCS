package Ciclo1.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Ciclo1.Control.ControlPrincipal;

public class ViewDadosOperacionais extends JPanel{
	
	//LABELS
	private JLabel lblT1 = new JLabel("<html>T<sub>1 </sub></html>");
    private JLabel lblP1 = new JLabel("<html>P<sub>1 </sub></html>");
    private JLabel lblPP = new JLabel("<html>P<sub>P </sub></html>");
    private JLabel lblzi = new JLabel("<html>z<sub>i </sub></html>");
    private JLabel lblTcon = new JLabel("<html>T<sub>con </sub></html>");
    private JLabel lblTeff = new JLabel("<html>&eta;<sub>T</sub></html>");
    private JLabel lblBeff = new JLabel("<html>&eta;<sub>B</sub></html>");
	
    //FIELDS
    private JTextField txtT1 = new JTextField("20",10);
    private JTextField txtP1 = new JTextField("20");
    private JTextField txtPP = new JTextField("2");
    private JTextField txtTcon = new JTextField("298.15");
    private JTextField txtzi = new JTextField("0.8");
    private JTextField txtBeff = new JTextField("0.8");
    private JTextField txtTeff = new JTextField("0.8");
    
    //COMBOS
    private String[] pressoes = {"bar", "kPa", "atm"};
    private String[] temps = {"K", "°C", "°F"};
    
    private JComboBox<String> comboT1 = new JComboBox<>(temps);
    private JComboBox<String> comboP1 = new JComboBox<>(pressoes);
    
    public ViewDadosOperacionais(ControlPrincipal ctrlPrincipal) {
    	
    		this.setLayout(new GridBagLayout());
    		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.lightGray), "Entrada", 1, 2, new Font("Times New Roman", 1, 12), Color.darkGray));
    	
    		GridBagConstraints g = new GridBagConstraints();
    	
    		g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(lblT1,g);

        g.gridx = 1;
        g.gridy = 0;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(txtT1,g);
        
        g.gridx = 3;
        g.gridy = 0;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(comboT1,g);
        
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(lblP1,g);

        g.gridx = 1;
        g.gridy = 1;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(txtP1,g);
        
        g.gridx = 3;
        g.gridy = 1;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(comboP1,g);
        
        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(lblPP,g);
        
        g.gridx = 1;
        g.gridy = 2;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(txtPP,g);
        
        g.gridx = 0;
        g.gridy = 4;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(lblTcon,g);
        
        g.gridx = 1;
        g.gridy = 4;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(txtTcon,g);
        
        g.gridx = 0;
        g.gridy = 5;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(lblzi,g);
        
        g.gridx = 1;
        g.gridy = 5;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(txtzi,g);
        
        g.gridx = 0;
        g.gridy = 6;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(lblBeff,g);
        
        g.gridx = 1;
        g.gridy = 6;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(txtBeff,g);
        
        g.gridx = 0;
        g.gridy = 7;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(lblTeff,g);
        
        g.gridx = 1;
        g.gridy = 7;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        this.add(txtTeff,g);
        
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
                        txtT1.setText(String.valueOf(ctrlPrincipal.getControlConverte().converte(tipo[0],tipo[1],Double.parseDouble(valor))));
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
                        txtP1.setText(String.valueOf(ctrlPrincipal.getControlConverte().converte(tipo[0],tipo[1],Double.parseDouble(valor))));
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
    
    public JLabel getLblTcon() {
        return lblTcon;
    }
    
    public JLabel getLblzi() {
        return lblzi;
    }
    
    public JTextField getTxtP1() {
        return txtP1;
    }

    public JTextField getTxtPP() {
        return txtPP;
    }
    
    public JTextField getTxtTcon() {
        return txtTcon;
    }
    
    public JTextField getTxtzi() {
        return txtzi;
    }
    
    public JTextField getTxtT1() {
        return txtT1;
    }

    public void setTxtT1(JTextField txtT1) {
        this.txtT1 = txtT1;
    }
    
    public JComboBox<String> getComboT1() {
        return comboT1;
    }

    public void setComboT1(JComboBox<String> comboT1) {
        this.comboT1 = comboT1;
    }

    public JComboBox<String> getComboP1() {
        return comboP1;
    }

    public void setComboP1(JComboBox<String> comboP1) {
        this.comboP1 = comboP1;
    }

	public JTextField getTxtBeff() {
		return txtBeff;
	}

	public void setTxtBeff(JTextField txtBeff) {
		this.txtBeff = txtBeff;
	}

	public JTextField getTxtTeff() {
		return txtTeff;
	}

	public void setTxtTeff(JTextField txtTeff) {
		this.txtTeff = txtTeff;
	}

	public void setTxtP1(JTextField txtP1) {
		this.txtP1 = txtP1;
	}

	public void setTxtPP(JTextField txtPP) {
		this.txtPP = txtPP;
	}
	
	public void setTxtTcon(JTextField txtTcon) {
		this.txtTcon = txtTcon;
	}

	public void setTxtzi(JTextField txtzi) {
		this.txtzi = txtzi;
	}
}
