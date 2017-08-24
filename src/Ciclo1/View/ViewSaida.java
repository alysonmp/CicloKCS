package Ciclo1.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Ciclo1.Control.ControlPrincipal;

public class ViewSaida extends JFrame{

	//LABELS
	JLabel lblWt = new JLabel("<html>W<sub>t</sub></html>");
	JLabel lblWn = new JLabel("<html>W<sub>n</sub></html>");
	JLabel lblWb = new JLabel("<html>W<sub>b</sub></html>");
	JLabel lblQcon = new JLabel("<html>Q<sub>con</sub></html>");
	JLabel lblAevp = new JLabel("<html>A<sub>evp</sub></html>");
	JLabel lblAcon = new JLabel("<html>A<sub>con</sub></html>");
	private JLabel lblEc = new JLabel("Ec: ");
    private JLabel lblQLHR = new JLabel("<html>Q<sub>LHR</sub></html>");
    private JLabel lblQHHR = new JLabel("<html>Q<sub>HHR</sub></html>");
    private JLabel lblALHR = new JLabel("<html>A<sub>LHR</sub></html>");
    private JLabel lblAHHR = new JLabel("<html>A<sub>HHR</sub></html>");
    private JLabel lblAT = new JLabel("AT: ");
    
    //FIELDS
    private JLabel txtEc = new JLabel("0 %");
    private JLabel txtQcon = new JLabel("0 kJ/s");
    private JLabel txtQLHR = new JLabel("0 kJ/s");
    private JLabel txtQHHR = new JLabel("0 kJ/s");
    private JLabel txtWt = new JLabel("0 kW");
    private JLabel txtWn = new JLabel("0 kW");
    private JLabel txtWb = new JLabel("0 kW");
    private JLabel txtAcon = new JLabel("0  m²");
    private JLabel txtAevp = new JLabel("0  m²");
    private JLabel txtALHR = new JLabel("0  m²");
    private JLabel txtAHHR = new JLabel("0  m²");
    private JLabel txtAT = new JLabel("0  m²");
	
	JPanel painelSaida = new JPanel();
	
	public ViewSaida(ControlPrincipal ctrlPrincipal) {
	
		painelSaida.setLayout(new GridBagLayout());
		painelSaida.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.lightGray), "Saída", 1, 2, new Font("Times New Roman", 1, 12), Color.darkGray));
		
		GridBagConstraints g = new GridBagConstraints();
		
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
		
		this.add(painelSaida);
	    this.setBounds(200, 200, 300, 250);
	    this.setTitle("Dados de Saída");
	    this.setVisible(true);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    
    public JLabel getLblEc() {
        return lblEc;
    }

    public JLabel getLblQcon() {
        return lblQcon;
    }

    public JLabel getLblQLHR() {
        return lblQLHR;
    }
}
