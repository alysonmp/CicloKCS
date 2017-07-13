/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo1.Control.Bomba;

import Ciclo1.Model.Ciclo1.ModelBomba;
import Ciclo1.Model.Ciclo1.ModelMassa;
import Ciclo1.View.Bomba.ViewBombaPanelKCS;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 *
 * @author alysonmp
 */
public class ControlBombaPanelKCS {
    private ViewBombaPanelKCS viewBomba;
    private Session session;
    
    public ControlBombaPanelKCS(Session session){
        this.session = session;
        viewBomba = new ViewBombaPanelKCS(this);
    }

    public ViewBombaPanelKCS getViewBomba() {
        return viewBomba;
    }

    public void setViewBomba(ViewBombaPanelKCS viewBomba) {
        this.viewBomba = viewBomba;
    }
}
