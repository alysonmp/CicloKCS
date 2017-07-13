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
import org.hibernate.Session;

/**
 *
 * @author alysonmp
 */
public class Start {
    
    double P1, PP, SUBT, Tf, Tres, effLT, zi, VE, P2, Pf, DT1, T1, ec;
    Session session;
    
    int compressor;
    
    public Start(Session session){
        this.session = session;
        
        P1 = 20;
        PP = 2;
        SUBT = 0;
        Tf = 415.15;
        Tres = 298.15;
        compressor = 1;
        effLT = 0.1;
        zi = 0.8;
        VE = 0.5;
        
        P2 = P1;
        Pf = 4000/100; //%bar

        ControlParametros parametros = new ControlParametros(P1, Tf, Pf, zi, Tres, this.session);
        
        DT1=(parametros.getTorvA()-parametros.getTbolA())-1;
        T1=parametros.getTbolA()+(DT1*VE);

        if(Tf-5<T1){
            //jdjdjdjdj*kdkdkd;
        }

        double Beff = parametros.getBeff();
        double Pcon = parametros.getPcon();
        double Tcon = parametros.getTcon();
        double Pref = parametros.getPref();
        double Tref = parametros.getTref();
        
        ControlBomba bomba = new ControlBomba(Beff, P1, Pcon, Tcon, Pref, Tref, zi, session);
        
        ControlSeparador separador = new ControlSeparador(P1, T1, zi, Pref, Tref, session);
        
        double H2 = separador.getH2();
        double Teff = parametros.getTeff();
        double T2 = separador.getT2();
        double y2 = separador.getYi();
        
        ControlTurbina turbina = new ControlTurbina(H2, Teff, P2, T2, Pcon, Pref, Tref, y2, session);
        
        double x3 = separador.getX();
        
        ControlValvula valvula = new ControlValvula(SUBT, P1, x3, Pcon, Pref, Tref, session);
        
        double TbolB = parametros.getTbolB();
        double TorvB = parametros.getTorvB();
        double T6 = valvula.getT6();
        double T4 = turbina.getT4();
        double VF1 = separador.getVF();
        double H4 = turbina.getH4();
        double H6 = valvula.getH6();
        
        ControlMisturador misturador = new ControlMisturador(TbolB, TorvB, T6, zi, T4, Pcon, VF1, H4, H6, Pref, Tref, session);
        
        double TbolA = parametros.getTbolA();
        double TorvA = parametros.getTorvA();
        double H7 = misturador.getH7();
        double H10 = bomba.getH10();
        double T7 = misturador.getH7();
        double T10 = bomba.getT10();
        
        ControlRegeneradorLT regeneradorLT = new ControlRegeneradorLT(TbolA, TorvA, TbolB, TorvB, P1, H7, H10, T7, T10, Pcon, Pref, Tref, zi, effLT, session);
        
        double H3 = separador.getH3();
        double H5 = valvula.getH5();
        double H11 = regeneradorLT.getH11();
        double T3 = separador.getH3();
        double T5 = valvula.getH5();
        double T11 = regeneradorLT.getH11();
        
        ControlRegeneradorHT regeneradorHT = new ControlRegeneradorHT(TbolA, TorvA, VF1, H3, H5, H11, T3, T5, T11, P1, Pref, Tref, zi, session);
        
        double T8 = regeneradorLT.getT8();
        double P8 = regeneradorLT.getP8();
        double H8 = regeneradorLT.getH8();
        
        ControlCondensador condensador = new ControlCondensador(TbolB, T8, P8, H8, Pref, Tref, zi, session);
        
        double T12 = regeneradorHT.getT12();
        double H12 = regeneradorHT.getH12();
        double H1 = separador.getH1();
        
        ControlEvaporador evaporador = new ControlEvaporador(TbolA, T12, H12, Tf, P1, zi, Pref, Tref, H1, PP, compressor, session);
        
        double m = evaporador.getM();
        double H9 = condensador.getH9();
        
        ControlBalanco balanco = new ControlBalanco(VF1, m, H2, H4, H7, H8, H9, H10, H12, H11);
        
        double QLHR = balanco.getQLHR();
        double QHHR = balanco.getQHHR();
        double Qcon = balanco.getQcon();
        double Qsen = evaporador.getQsen();
        double Qlat = evaporador.getQlat();
        double Tfout = evaporador.getTfout();
        double T9 = condensador.getT9();
        
        ControlAreas areas = new ControlAreas(QLHR, QHHR, Qcon, Qsen, Qlat, PP, Tf, Tfout, T1, T12, TbolA, T9, T8, T11, T7, T10, T3, T5);
        
        double Wn = balanco.getWn();
        double QTf = evaporador.getQTf();
        
        ec=Wn/QTf;
    }
}
