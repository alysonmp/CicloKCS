package Ciclo1.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewTrocadores extends JPanel {

    //RegeneradorLT Label
    JLabel labelRegLTEff = new JLabel("<html>&isin;</html>");

    //RegeneradorLT Field
    JTextField fieldRegLTEff = new JTextField("0", 11);

    //RegeneradorHT Label
    JLabel labelRegHTEff = new JLabel("SUBT ");

    //RegeneradorHT Field
    JTextField fieldRegHTSubt = new JTextField("0", 11);

    JPanel painelRegeneradorLT;
    JPanel painelRegeneradorHT;

    public ViewTrocadores() {
        painelRegeneradorLT = new JPanel(new GridBagLayout());
        painelRegeneradorHT = new JPanel(new GridBagLayout());

        painelRegeneradorLT.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.lightGray), "Regenerador LT", 1, 2, new Font("Times New Roman", 1, 12), Color.darkGray));
        painelRegeneradorHT.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.lightGray), "Regenerador HT", 1, 2, new Font("Times New Roman", 1, 12), Color.darkGray));

        this.setLayout(new GridBagLayout());

        GridBagConstraints g = new GridBagConstraints();

        //RegeneradorLT
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
        g.gridy = 2;
        painelRegeneradorHT.add(labelRegHTEff, g);
        font = new Font("Arial", 0, 12);
        labelRegHTEff.setFont(font);

        g.gridx = 1;
        g.gridy = 2;
        painelRegeneradorHT.add(fieldRegHTSubt, g);

        //PAINEIS
        g.gridx = 0;
        g.gridy = 0;
        this.add(painelRegeneradorLT, g);

        g.gridx = 1;
        g.gridy = 0;
        this.add(painelRegeneradorHT, g);
    }

    public JTextField getFieldRegLTEff() {
        return fieldRegLTEff;
    }

    public void setFieldRegLTEff(JTextField fieldRegLTEff) {
        this.fieldRegLTEff = fieldRegLTEff;
    }

    public JTextField getFieldRegHTSubt() {
        return fieldRegHTSubt;
    }

    public void setFieldRegHTSubt(JTextField fieldRegHTSubt) {
        this.fieldRegHTSubt = fieldRegHTSubt;
    }
}
