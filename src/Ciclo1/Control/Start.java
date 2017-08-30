/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo1.Control;

import Ciclo1.Control.Ciclo1.ControlAreas;
import Ciclo1.Control.Ciclo1.ControlBalanco;
import Ciclo1.Control.Ciclo1.ControlBomba;
import Ciclo1.Control.Ciclo1.ControlCondensador;
import Ciclo1.Control.Ciclo1.ControlEvaporador;
import Ciclo1.Control.Ciclo1.ControlMisturador;
import Ciclo1.Control.Ciclo1.ControlParametros;
import Ciclo1.Control.Ciclo1.ControlRegeneradorHT;
import Ciclo1.Control.Ciclo1.ControlRegeneradorLT;
import Ciclo1.Control.Ciclo1.ControlSeparador;
import Ciclo1.Control.Ciclo1.ControlTurbina;
import Ciclo1.Control.Ciclo1.ControlValvula;
import Ciclo1.Control.Conversao.ControlConverte;
import Ciclo1.View.ViewSaida;

import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author alysonmp
 */
public class Start {
    
    Session session;
    
    public Start(Session session,ControlPrincipal ctrPrincipal){
        ControlConverte converte = new ControlConverte();
        this.session = session;
        
        double P1;
        if(!ctrPrincipal.getViewPrincipal().getDadosOp().getComboP1().getSelectedItem().toString().equals("bar")){
            P1 = converte.converte(ctrPrincipal.getViewPrincipal().getDadosOp().getComboP1().getSelectedItem().toString(), "bar", Double.parseDouble(ctrPrincipal.getViewPrincipal().getDadosOp().getTxtP1().getText()));
        }else{
            P1 = Double.parseDouble(ctrPrincipal.getViewPrincipal().getDadosOp().getTxtP1().getText());
        }
        
        double T1;
        if(!ctrPrincipal.getViewPrincipal().getDadosOp().getComboT1().getSelectedItem().toString().equals("K")){
            T1 = converte.converte(ctrPrincipal.getViewPrincipal().getDadosOp().getComboT1().getSelectedItem().toString(), "K", Double.parseDouble(ctrPrincipal.getViewPrincipal().getDadosOp().getTxtT1().getText()));
        }else{
            T1 = Double.parseDouble(ctrPrincipal.getViewPrincipal().getDadosOp().getTxtT1().getText());
        }
        
        double PP = Double.parseDouble(ctrPrincipal.getViewPrincipal().getDadosOp().getTxtPP().getText());
        double SUBT = Double.parseDouble(ctrPrincipal.getViewPrincipal().getTrocadores().getFieldRegHTSubt().getText());
        
        double Tf;
        if(!ctrPrincipal.getViewPrincipal().getFonteCalor().getComboTf().getSelectedItem().toString().equals("K")){
            Tf = converte.converte(ctrPrincipal.getViewPrincipal().getFonteCalor().getComboTf().getSelectedItem().toString(), "kPa", Double.parseDouble(ctrPrincipal.getViewPrincipal().getFonteCalor().getTxtTf().getText()));
        }else{
            Tf = Double.parseDouble(ctrPrincipal.getViewPrincipal().getFonteCalor().getTxtTf().getText());
        }
        
        double Pf;
        if(!ctrPrincipal.getViewPrincipal().getFonteCalor().getComboPf().getSelectedItem().toString().equals("K")){
            Pf = converte.converte(ctrPrincipal.getViewPrincipal().getFonteCalor().getComboPf().getSelectedItem().toString(), "kPa", Double.parseDouble(ctrPrincipal.getViewPrincipal().getFonteCalor().getTxtPf().getText()));
        }else{
            Pf = Double.parseDouble(ctrPrincipal.getViewPrincipal().getFonteCalor().getTxtPf().getText());
        }
        
        double Mf = Double.parseDouble(ctrPrincipal.getViewPrincipal().getFonteCalor().getTxtMf().getText());
        double Tcon = Double.parseDouble(ctrPrincipal.getViewPrincipal().getDadosOp().getTxtTcon().getText());
        int compressor = ctrPrincipal.getViewPrincipal().getComp();
        double effLT = Double.parseDouble(ctrPrincipal.getViewPrincipal().getTrocadores().getFieldRegLTEff().getText());
        double zi = Double.parseDouble(ctrPrincipal.getViewPrincipal().getDadosOp().getTxtzi().getText());
        
        double Beff = Double.parseDouble(ctrPrincipal.getViewPrincipal().getDadosOp().getTxtBeff().getText());
        double Teff = Double.parseDouble(ctrPrincipal.getViewPrincipal().getDadosOp().getTxtTeff().getText());
        
        double P2 = P1;
        //Pf = 4000/100; //%bar

        ControlParametros parametros = new ControlParametros(P1, Tf, Pf, zi, Tcon, this.session, ctrPrincipal);
        if(!parametros.getMensagem().equals("")){
            JOptionPane.showMessageDialog(null, parametros.getMensagem(),"Error",0);
            return;
        }
        
        double DT1=(parametros.getTorvA()-parametros.getTbolA())-1;
        
        double Tmin = parametros.getTbolA() + 0.3*DT1;
        double Tmax = parametros.getTbolA() + 0.7*DT1;
        
        if(T1 < Tmin || T1 > Tmax){
            JOptionPane.showMessageDialog(null, "T1 está abaixo da temperatura de bolha (Tbol = "+Tmin+") ou acima da temperatura de orvalho (Torv = "+Tmax+").","Error",0);
            return;
        }

        if(Tf-5<T1){
            JOptionPane.showMessageDialog(null,"Temperatura de vaporização superior à temperatura da fonte de calor.","Error",0);
            return;
        }

        double Pcon = parametros.getPcon();
        double Pref = parametros.getPref();
        double Tref = parametros.getTref();
        
        //ControlBomba bomba = new ControlBomba(0.8, 20, 11.8076, 313.15, 50, 273.15, 0.8, session);
        ControlBomba bomba = new ControlBomba(Beff, P1, Pcon, Tcon, Pref, Tref, zi, session);
        if(!bomba.getMensagem().equals("")){
            JOptionPane.showMessageDialog(null,bomba.getMensagem(),"Error",0);
            return;
        }
        
        //ControlSeparador separador = new ControlSeparador(P1, 378.3645, zi, Pref, Tref, session);
        ControlSeparador separador = new ControlSeparador(P1, T1, zi, Pref, Tref, session);
        
        double H2 = separador.getH2();
        double T2 = separador.getT2();
        double y2 = separador.getYi();
        
        ControlTurbina turbina = new ControlTurbina(H2, Teff, P2, T2, Pcon, Pref, Tref, y2, session);
        if(!turbina.getMensagem().equals("")){
            JOptionPane.showMessageDialog(null,turbina.getMensagem(),"Error",0);
            return;
        }
        
        double x3 = separador.getX();
        
        ControlValvula valvula = new ControlValvula(SUBT, P1, x3, Pcon, Pref, Tref, session);
        
        double TbolB = parametros.getTbolB();
        double TorvB = parametros.getTorvB();
        double T6 = valvula.getT6();
        double T4 = turbina.getT4();
        double VF1 = separador.getVF();
        double H4 = turbina.getH4();
        double H6 = valvula.getH6();
        //double T4 = 0;
        //double H4 = 0;
        //ControlMisturador misturador = new ControlMisturador(313.15, 409.57, T6, zi, 355.0946, Pcon, VF1, 24279, H6, Pref, Tref, session);
        ControlMisturador misturador = new ControlMisturador(TbolB, TorvB, T6, zi, T4, Pcon, VF1, H4, H6, Pref, Tref, session);
        
        double TbolA = parametros.getTbolA();
        double TorvA = parametros.getTorvA();
        double H7 = misturador.getH7();
        double H10 = bomba.getH10();
        double T7 = misturador.getT7();
        double T10 = bomba.getT10();
        
        //ControlRegeneradorLT regeneradorLT = new ControlRegeneradorLT(333.6505, 424.0785, 313.1576, 409.5770, P1, H7, H10, 354.7027, T10, Pcon, Pref, Tref, zi, effLT, session);
        ControlRegeneradorLT regeneradorLT = new ControlRegeneradorLT(TbolA, TorvA, TbolB, TorvB, P1, H7, H10, T7, T10, Pcon, Pref, Tref, zi, effLT, session);
        if(!regeneradorLT.getMensagem().equals("")){
            JOptionPane.showMessageDialog(null,regeneradorLT.getMensagem(),"Error",0);
            return;
        }
              
        double H3 = separador.getH3();
        double H5 = valvula.getH5();
        double H11 = regeneradorLT.getH11();
        double T3 = separador.getT3();
        double T5 = valvula.getT5();
        double T11 = regeneradorLT.getT11();
        //double H11 = 0;
        //double T11 = 0;
        
        //ControlRegeneradorHT regeneradorHT = new ControlRegeneradorHT(333.6505, 424.0785, 0.7156, 5132.1, 3168.9, 1459, 378.3645, 353.5914, 317.4796, P1, Pref, Tref, zi, session);
        ControlRegeneradorHT regeneradorHT = new ControlRegeneradorHT(TbolA, TorvA, VF1, H3, H5, H11, T3, T5, T11, P1, Pref, Tref, zi, session);
        if(!regeneradorHT.getMensagem().equals("")){
            JOptionPane.showMessageDialog(null,regeneradorHT.getMensagem(),"Error",0);
            return;
        }
        
        double T8 = regeneradorLT.getT8();
        double P8 = regeneradorLT.getP8();
        double H8 = regeneradorLT.getH8();
        //double T8 = 0;
        //double P8 = 0;
        //double H8 = 0;
        
        //ControlCondensador condensador = new ControlCondensador(313.1576, 350.6612, 11.8076, 17960, Pref, Tref, zi, session);
        ControlCondensador condensador = new ControlCondensador(TbolB, T8, P8, H8, Pref, Tref, zi, session);
        
        double T12 = regeneradorHT.getT12();
        double H12 = regeneradorHT.getH12();
        double H1 = separador.getH1();
        
        //ControlEvaporador evaporador = new ControlEvaporador(333.6505, T12, H12, Tf, P1, zi, Pref, Tref, H1, PP, compressor, session);
        ControlEvaporador evaporador = new ControlEvaporador(TbolA, T12, H12, Tf, P1, zi, Pref, Tref, H1, PP, compressor, session);
        if(!evaporador.getMensagem().equals("")){
            JOptionPane.showMessageDialog(null,evaporador.getMensagem(),"Error",0);
            return;
        }
        
        double m = evaporador.getM();
        double H9 = condensador.getH9();
        
        //ControlBalanco balanco = new ControlBalanco(VF1, m, H2, 24279, H7, 17960, H9, H10, H12, 1459);
        ControlBalanco balanco = new ControlBalanco(VF1, m, H2, H4, H7, H8, H9, H10, H12, H11);
        double QLHR = balanco.getQLHR();
        double QHHR = balanco.getQHHR();
        double Qcon = balanco.getQcon();
        double Qsen = evaporador.getQsen();
        double Qlat = evaporador.getQlat();
        double Tfout = evaporador.getTfout();
        double T9 = condensador.getT9();
        double Wt = balanco.getWt();
        double Wn = balanco.getWn();
        double Wb = balanco.getWb();
        
        //ControlAreas areas = new ControlAreas(QLHR, QHHR, Qcon, Qsen, Qlat, PP, Tf, Tfout, 378.3645, T12, 333.6505, T9, 350.6612, 317.4796, 354.7027, T10, 378.3645, 353.5914);
        ControlAreas areas = new ControlAreas(QLHR, QHHR, Qcon, Qsen, Qlat, PP, Tf, Tfout, T1, T12, TbolA, T9, T8, T11, T7, T10, T3, T5);
        double QTf = evaporador.getQTf();
        double Acon = areas.getAcon();
        double Aevp = areas.getAevp();
        double ALHR = areas.getALHR();
        double AHHR = areas.getAHHR();
        double AT = areas.getAT();
        
        double ec=(Wn/QTf)*100;
        
        ViewSaida saida = new ViewSaida(ctrPrincipal);
        
        saida.getTxtEc().setText(round(ec,3)+"%");
        saida.getTxtQcon().setText(round(Qcon,3)+" kJ/s");
        saida.getTxtQLHR().setText(round(QLHR,3)+" kJ/s");
        saida.getTxtQHHR().setText(round(QHHR,3)+" kJ/s");
        saida.getTxtWt().setText(round(Wt,3)+" kW");
        saida.getTxtWn().setText(round(Wn,3)+" kW");
        saida.getTxtWb().setText(round(Wb,3)+" kW");
        saida.getTxtAcon().setText(round(Acon,3)+" m²");
        saida.getTxtAevp().setText(round(Aevp,3)+" m²");
        saida.getTxtALHR().setText(round(ALHR,3)+" m²");
        saida.getTxtAHHR().setText(round(AHHR,3)+" m²");
        saida.getTxtAT().setText(round(AT,3)+" m²");
    }
    
    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
