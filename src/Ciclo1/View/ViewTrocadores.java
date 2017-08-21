package Ciclo1.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewTrocadores extends JPanel{

	//Evaporador Label
	JLabel labelEvapCore = new JLabel("Core");
	JLabel labelEvapK = new JLabel("K");
	
	//Evaporador Field
	JTextField fieldEvapCore = new JTextField("13",10);
	JTextField fieldEvapK = new JTextField("16",10);
	
	//Condensador Label
	JLabel labelCondCore = new JLabel("Core");
	JLabel labelCondK = new JLabel("K");
	
	//Condensador Field
	JTextField fieldCondCore = new JTextField("13",10);
	JTextField fieldCondK = new JTextField("16",10);
	
	//RegeneradorLT Label
	JLabel labelRegLTCore = new JLabel("Core");
	JLabel labelRegLTK = new JLabel("K");
	JLabel labelRegLTEff = new JLabel("<html>&isin;</html>");
	
	//RegeneradorLT Field
	JTextField fieldRegLTCore = new JTextField("13",10);
	JTextField fieldRegLTK = new JTextField("16",10);
	JTextField fieldRegLTEff = new JTextField("0",10);
	
	//RegeneradorHT Label
	JLabel labelRegHTCore = new JLabel("Core");
	JLabel labelRegHTK = new JLabel("K");
	JLabel labelRegHTEff = new JLabel("SUBT");
	
	//RegeneradorHT Field
	JTextField fieldRegHTCore = new JTextField("13",10);
	JTextField fieldRegHTK = new JTextField("16",10);
	JTextField fieldRegHTSubt = new JTextField("0",10);
	
	JPanel painelEvaporador;
	JPanel painelRegeneradorLT;
	JPanel painelRegeneradorHT;
	JPanel painelCondensador;
	
	public ViewTrocadores() {
		
		painelEvaporador = new JPanel(new GridBagLayout());
		painelRegeneradorLT = new JPanel(new GridBagLayout());
		painelRegeneradorHT = new JPanel(new GridBagLayout());
		painelCondensador = new JPanel(new GridBagLayout());
		
		painelEvaporador.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.lightGray), "Evaporador", 1, 2, new Font("Times New Roman", 1, 12), Color.darkGray));
		painelRegeneradorLT.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.lightGray), "Regenerador LT", 1, 2, new Font("Times New Roman", 1, 12), Color.darkGray));
		painelRegeneradorHT.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.lightGray), "Regenerador HT", 1, 2, new Font("Times New Roman", 1, 12), Color.darkGray));
		painelCondensador.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.lightGray), "Condensador", 1, 2, new Font("Times New Roman", 1, 12), Color.darkGray));
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints g = new GridBagConstraints();
		
		//Evaporador
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.fill = GridBagConstraints.HORIZONTAL;
		painelEvaporador.add(labelEvapCore, g);
		
		g.gridx = 1;
		g.gridy = 0;
		painelEvaporador.add(fieldEvapCore, g);
		
		g.gridx = 0;
		g.gridy = 1;
		painelEvaporador.add(labelEvapK, g);
		
		g.gridx = 1;
		g.gridy = 1;
		painelEvaporador.add(fieldEvapK, g);
		
		//RegeneradorLT
		g.gridx = 0;
		g.gridy = 0;
		g.fill = GridBagConstraints.HORIZONTAL;
		painelRegeneradorLT.add(labelRegLTCore, g);
		
		g.gridx = 1;
		g.gridy = 0;
		painelRegeneradorLT.add(fieldRegLTCore, g);
		
		g.gridx = 0;
		g.gridy = 1;
		painelRegeneradorLT.add(labelRegLTK, g);
		
		g.gridx = 1;
		g.gridy = 1;
		painelRegeneradorLT.add(fieldRegLTK, g);
		
		g.gridx = 0;
		g.gridy = 2;
		painelRegeneradorLT.add(labelRegLTEff, g);
		Font font = new Font("Arial", Font.BOLD, 18);
		labelRegLTEff.setFont(font);
		
		g.gridx = 1;
		g.gridy = 2;
		painelRegeneradorLT.add(fieldRegLTEff, g);
		
		//RegeneradorHT
		g.gridx = 0;
		g.gridy = 0;
		g.fill = GridBagConstraints.HORIZONTAL;
		painelRegeneradorHT.add(labelRegHTCore, g);
		
		g.gridx = 1;
		g.gridy = 0;
		painelRegeneradorHT.add(fieldRegHTCore, g);
		
		g.gridx = 0;
		g.gridy = 1;
		painelRegeneradorHT.add(labelRegHTK, g);
		
		g.gridx = 1;
		g.gridy = 1;
		painelRegeneradorHT.add(fieldRegHTK, g);
		
		g.gridx = 0;
		g.gridy = 2;
		painelRegeneradorHT.add(labelRegHTEff, g);
		font = new Font("Arial", 0, 12);
		labelRegHTEff.setFont(font);
		
		g.gridx = 1;
		g.gridy = 2;
		painelRegeneradorHT.add(fieldRegHTSubt, g);
		
		//Condensador
		g.gridx = 0;
		g.gridy = 0;
		g.fill = GridBagConstraints.HORIZONTAL;
		painelCondensador.add(labelCondCore, g);
		
		g.gridx = 1;
		g.gridy = 0;
		painelCondensador.add(fieldCondCore, g);
		
		g.gridx = 0;
		g.gridy = 1;
		painelCondensador.add(labelCondK, g);
		
		g.gridx = 1;
		g.gridy = 1;
		painelCondensador.add(fieldCondK, g);
		
		
		//PAINEIS
		g.gridx = 0;
		g.gridy = 0;
		this.add(painelEvaporador, g);
		
		g.gridx = 0;
		g.gridy = 1;
		this.add(painelRegeneradorLT, g);
		
		g.gridx = 1;
		g.gridy = 1;
		this.add(painelRegeneradorHT, g); 
		
		g.gridx = 1;
		g.gridy = 0;
		this.add(painelCondensador, g);
	}

	public JTextField getFieldEvapCore() {
		return fieldEvapCore;
	}

	public void setFieldEvapCore(JTextField fieldEvapCore) {
		this.fieldEvapCore = fieldEvapCore;
	}

	public JTextField getFieldEvapK() {
		return fieldEvapK;
	}

	public void setFieldEvapK(JTextField fieldEvapK) {
		this.fieldEvapK = fieldEvapK;
	}

	public JTextField getFieldCondCore() {
		return fieldCondCore;
	}

	public void setFieldCondCore(JTextField fieldCondCore) {
		this.fieldCondCore = fieldCondCore;
	}

	public JTextField getFieldCondK() {
		return fieldCondK;
	}

	public void setFieldCondK(JTextField fieldCondK) {
		this.fieldCondK = fieldCondK;
	}

	public JTextField getFieldRegLTCore() {
		return fieldRegLTCore;
	}

	public void setFieldRegLTCore(JTextField fieldRegLTCore) {
		this.fieldRegLTCore = fieldRegLTCore;
	}

	public JTextField getFieldRegLTK() {
		return fieldRegLTK;
	}

	public void setFieldRegLTK(JTextField fieldRegLTK) {
		this.fieldRegLTK = fieldRegLTK;
	}

	public JTextField getFieldRegLTEff() {
		return fieldRegLTEff;
	}

	public void setFieldRegLTEff(JTextField fieldRegLTEff) {
		this.fieldRegLTEff = fieldRegLTEff;
	}

	public JTextField getFieldRegHTCore() {
		return fieldRegHTCore;
	}

	public void setFieldRegHTCore(JTextField fieldRegHTCore) {
		this.fieldRegHTCore = fieldRegHTCore;
	}

	public JTextField getFieldRegHTK() {
		return fieldRegHTK;
	}

	public void setFieldRegHTK(JTextField fieldRegHTK) {
		this.fieldRegHTK = fieldRegHTK;
	}

	public JTextField getFieldRegHTSubt() {
		return fieldRegHTSubt;
	}

	public void setFieldRegHTSubt(JTextField fieldRegHTSubt) {
		this.fieldRegHTSubt = fieldRegHTSubt;
	}
}
