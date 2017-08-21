/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo1.Control;

import Ciclo1.Control.Conversao.ControlConverte;
import Ciclo1.Dao.ControlConexao;
import Ciclo1.Model.Ciclo1.ModelFluidos;
import Ciclo1.Model.ModelCVA;
import Ciclo1.Model.ModelCVB;
import Ciclo1.Model.ModelConsExeMatA;
import Ciclo1.Model.ModelConsExeMatB;
import Ciclo1.Model.ModelConstantesMat;
import Ciclo1.Model.ModelCriticasKCSMat_K1;
import Ciclo1.Model.ModelCriticasKCSMat_PM;
import Ciclo1.Model.ModelCriticasKCSMat_Pc;
import Ciclo1.Model.ModelCriticasKCSMat_Tc;
import Ciclo1.Model.ModelCriticasKCSMat_w;
import Ciclo1.Model.ModelDRT70;
import Ciclo1.Model.ModelDRT80;
import Ciclo1.Model.ModelEqro;
import Ciclo1.Model.ModelEqrs;
import Ciclo1.Model.ModelLinear;
import Ciclo1.Model.ModelQfpsoKCSMat;
import Ciclo1.Util.HibernateUtil;
import Ciclo1.View.ViewPrincipal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author alysonmp
 */
public class ControlPrincipal {
    private ViewPrincipal viewPrincipal;
    private Session session;
    private ControlConexao conexao;
    
    private ControlConverte controlConverte = new ControlConverte(); 
    
    @SuppressWarnings("empty-statement")
    public ControlPrincipal(){
        conexao = new ControlConexao();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        this.session = sf.openSession();
        
        Criteria cr = this.session.createCriteria(ModelFluidos.class);
        List results = cr.list();
        if(results.isEmpty()){
            Transaction tx = session.beginTransaction();

            session.save(new ModelFluidos(1, "Agua"));
            session.save(new ModelFluidos(2, "Toluene (C7H8)"));
            session.save(new ModelFluidos(3, "Ethylbenzene (C8H10)"));
            session.save(new ModelFluidos(4, "Propylbenzene (C9H12)"));
            session.save(new ModelFluidos(5, "Dimetylbenzene(C8H10)"));
            session.save(new ModelFluidos(6, "Octamethyltrisiloxane (MDM)"));
            session.save(new ModelFluidos(7, "Decamethyltetrasiloxane (MD2M)"));
            session.save(new ModelFluidos(8, "Dodecamethylpentasiloxane (MD3M)"));
            session.save(new ModelFluidos(9, "Dodecamethylcyclohexasiloxane (D6)"));
            session.save(new ModelFluidos(10, "Isobutano"));
            session.save(new ModelFluidos(11, "Isopentano"));
            session.save(new ModelFluidos(12, "n-Butano"));
            session.save(new ModelFluidos(13, "n-Pentano"));
            session.save(new ModelFluidos(14, "R-134a (1,1,1,2-Tetrafluoroethane)"));
            session.save(new ModelFluidos(15, "R-290 (PROPANE)"));
            session.save(new ModelFluidos(16, "R-142b (1,1-Difluoro-1-chloroethane)"));
            session.save(new ModelFluidos(17, "R-1270 (1-Propene)"));
            session.save(new ModelFluidos(18, "R-40  (Clorometano)"));
            session.save(new ModelFluidos(19, "Hexamethyldisiloxane, (MM)"));
            session.save(new ModelFluidos(20, "Tetradecamethylhexasiloxane (MD4M)"));
            session.save(new ModelFluidos(21, "Octamethylcyclotetrasiloxane (D4)"));
            session.save(new ModelFluidos(22, "Decamethylcyclopentasiloxane (D5)"));
            session.save(new ModelFluidos(23, "Trichlorofluoromethane (R11)"));
            session.save(new ModelFluidos(24, "Dichlorodifluoromethane (R12)"));
            session.save(new ModelFluidos(25, "1,3-Dichloro-1,1,2,2,3,3-hexafluoropropane (R216ca)"));
            session.save(new ModelFluidos(26, "1,2-Dichlorotetrafluoroethane (R114)"));
            session.save(new ModelFluidos(27, "1,1-Dichloro-1-fluoroethane (R141b)"));
            session.save(new ModelFluidos(28, "1,1-Difluoroethane (R152a)"));
            session.save(new ModelFluidos(29, "1-Chloro-1,1-difluoroethane (R142b)"));
            session.save(new ModelFluidos(30, "n-Hexane"));
            session.save(new ModelFluidos(31, "n-Heptane"));
            session.save(new ModelFluidos(32, "n-octane"));
            session.save(new ModelFluidos(33, "Chlorodifluoromethane (R22)"));

            tx.commit();
        }
        
        cr = this.session.createCriteria(ModelConstantesMat.class);
        results = cr.list();
        if(results.isEmpty()){
            Transaction tx = session.beginTransaction();
            
            double[][] valoresC1 = {{90.483, -4669.7, -11.607, 0.017194, 1.0}};
            session.save(new ModelConstantesMat("C1", valoresC1));
            
            double[][] valoresC2 = {{73.649, -7258.2, -7.3037, 4.1653E-6, 2.0}};
            session.save(new ModelConstantesMat("C2", valoresC2));

            double[][] valoresCC = {{33.60134, -0.002145, -3.999E-6, 4.752E-8, -3.533E-11, 0.0, 0.0}, 
                                    {33.573, -0.012581, 8.8906E-5, -7.1783E-8, 1.8569E-11, 0.0, 0.0}};
            session.save(new ModelConstantesMat("CC", valoresCC));
            
            tx.commit();
        }
        
        
        cr = this.session.createCriteria(ModelLinear.class);
        results = cr.list();
        if(results.isEmpty()){
            Transaction tx = session.beginTransaction();

            session.save(new ModelLinear(new double[]{142.2, -0.01509422,-8.3348292E-8,-2.3243455E-13,6.5603658E-17,-3.4487625E-20,2.0808293E-23,-5.8664246E-27,9.1463375E-31,-7.446578E-35,2.4885769E-39}));
            session.save(new ModelLinear(new double[]{143.90002, -0.014493643, -4.6103987E-8, 1.3981357E-12, 2.3993308E-16, -9.8949381E-21, 1.6261678E-24, 0.0, 0.0, 0.0, 0.0}));
            session.save(new ModelLinear(new double[]{145.2, -5.6111011E-4, -0.094364859, 1.0896055E-7,2.3103997E-5, -7.4868329E-12, -2.5130974E-9, 1.9128073E-16, 1.2643961E-13, -7.5492826E-22, -2.4248126E-18}));
            session.save(new ModelLinear(new double[]{135.20007, -0.01007358, 1.2520524E-7, 2.5722111E-12, 4.3171784E-17, -3.9207826E-20, 1.2906424E-24, 0.0, 0.0, 0.0, 0.0}));
            session.save(new ModelLinear(new double[]{159.7099, -0.0061700647, 5.3500968E-8, -3.4218675E-11, 9.9938341E-15, -1.6897954E-18, 1.6983127E-22, -9.9200576E-27, 3.0981733E-31, -3.9847803E-36, 0.0}));
            session.save(new ModelLinear(new double[]{-4501439.8, 384.02683, 3.2531763E10, -0.020762985, -1.3089914E14, 6.9584129E-7, 2.0965934E17, -1.3226177E-11, 9.2327351E19, 1.0920871E-16, 0.0}));
            
            tx.commit();
        }
        
        cr = this.session.createCriteria(ModelQfpsoKCSMat.class);
        results = cr.list();
        if(results.isEmpty()){
            Transaction tx = session.beginTransaction();
            
            session.save(new ModelQfpsoKCSMat(new double[]{-5.0989335E-5, 66.250549, -0.024244439, 1.4359252E-5, -3.1287299E-9, 2.7938016E-10, 3.1938551E-11, -8.6058944E-13, 1.0138024E-14, -5.7854786E-17, 1.3108388E-19, 0.0}));
            session.save(new ModelQfpsoKCSMat(new double[]{-7.6520373E-5, 68.996718, -0.015276822, 4.4519632E-5, 3.2384275E-7, -9.5543181E-9, 3.1876871E-10, -5.3692223E-12, 5.1514164E-14, -2.6095697E-16, 5.4962813E-19, 0.0}));
            session.save(new ModelQfpsoKCSMat(new double[]{7.875352E-5, -0.04698885, 77.569376, 7.5518527E-4, -3.6218838, -4.6157586E-6, 0.05773998, 8.645757E-9, -3.5076036E-4, 3.2457331E-12, 6.9448062E-7, 0.0}));
            session.save(new ModelQfpsoKCSMat(new double[]{-0.0025970942, 99.279743, 0.12007259, 8.0406572E-4, -1.1669656E-5, 4.9266436E-7, -1.169747E-8, 1.6715254E-10, -1.5243562E-12, 7.6811009E-15, -1.5862785E-17, 0.0}));
            session.save(new ModelQfpsoKCSMat(new double[]{1.5353958, 162.37375, 0.11646613, -0.0086520143, 1.3170876E-4, 5.772981E-6, -3.037534E-7, 6.0681698E-9, -6.2711257E-11, 3.3117369E-13, -7.0587574E-16, 0.0}));
  
            tx.commit();
        }
        
        cr = this.session.createCriteria(ModelCriticasKCSMat_K1.class);
        results = cr.list();
        
        if(results.isEmpty()){
            Transaction tx = session.beginTransaction();
            
            double[] valores = {-0.06635, 0.03849, 0.03994, 0.02715, 0.01277, 0.12634,0.03079,0.16431,0.09627,0.03781,0.0284,0.02222,0.03521,-0.0103,0.19724,0.00689,-0.24609,0.0304,-0.0528,0.0346,0.1568,0.0388,0.02574,0.02752,0.10833,0.02818,0.05949,-0.1459,0.00689,0.06998,0.07222,0.07233,0.02623};
            for(int i = 0; i < valores.length; i++){
                this.session.save(new ModelCriticasKCSMat_K1(valores[i]));
            }
            
            double[] valores2 = {18.0, 92.14, 106.17, 120.19, 106.17, 236.53, 310.69, 384.94, 444.92, 58.12, 72.15, 58.12, 72.15, 102.0, 44.1, 100.5, 42.08, 50.49, 162.37752, 458.99328, 296.61576, 370.7697,137.36,120.91,220.92,170.91,116.94,66.05,100.49,86.18,100.2,114.2,86.47};
            for(int i = 0; i < valores2.length; i++){
                this.session.save(new ModelCriticasKCSMat_PM(valores2[i]));
            }
            
            double[] valores3 = {22089.75,4106.0,3606.0,3200.0,3511.0,1415.0,1227.0,945.0,961.0,3648.0,3381.0,4023.0,3529.0,4059.0,4242.0,4120.0,4664.0,6700.0,1939.39,877.47,1332.0,1160.46,4408.0,4124.0,2570.0,3300.0,4340.0,4444.0,4121.0,3032.0,2737.0,2497.0,4975.0};
            for(int i = 0; i < valores3.length; i++){
                this.session.save(new ModelCriticasKCSMat_Pc(valores3[i]));
            }
            
            double[] valores4 = {647.286,591.8,617.2,638.32,616.23,564.09,599.4,628.36,645.78,408.05,460.43,419.53,464.78,374.21,369.82,410.25,365.59,416.25,518.75,653.2,586.5,619.15,471.11,385.12,449.05,418.55,478.85,386.41,410.25,507.85,540.15,568.55,369.2};
            for(int i = 0; i < valores4.length; i++){
                this.session.save(new ModelCriticasKCSMat_Tc(valores4[i]));
            }
            
            double[] valores5 = {0.3438,0.26323,0.3027,0.34513,0.32141,0.5297,0.668,0.7218,0.7361,0.1848,0.22802,0.19409,0.23329,0.3261,0.268,0.2816,0.21974,0.153,0.419,0.785,0.589,0.6658,0.191,0.176,0.3286,0.2533,0.2211,0.2557,0.236,0.3007,0.3498,0.4018,0.215};
            for(int i = 0; i < valores5.length; i++){
                this.session.save(new ModelCriticasKCSMat_w(valores5[i]));
            }
            
            tx.commit();
        }
        
        cr = this.session.createCriteria(ModelConsExeMatA.class);
        results = cr.list();
        
        if(results.isEmpty()){
            Transaction tx = session.beginTransaction();
            this.session.save(new ModelConsExeMatA(new double[]{10.57, 1.05, 2.06, -3936.0}));
             
            this.session.save(new ModelConsExeMatA(new double[] {7.3, 1.23, 0.0, -2286.0}));
            
            this.session.save(new ModelConsExeMatA(new double[] {11.4, 0.94, 1.84, -3992.0}));
            
            this.session.save(new ModelConsExeMatA(new double[] {7.16, 0.5, 0.4, -2313.0}));
            
            this.session.save(new ModelConsExeMatA(new double[] {6.83, 0.45, 0.12, -2127.0}));
            
            this.session.save(new ModelConsExeMatA(new double[] {6.79, 0.49, 0.11, -2105.0}));
            
            this.session.save(new ModelConsExeMatA(new double[] {7.3, 1.23, 0.0, -5379.0}));
            
            this.session.save(new ModelConsExeMatA(new double[] {7.03, 0.46, 0.14, -2184.0}));
            
            double[] valoresB = {20140.0, 11710.0, 303500.0, 3970.0, 720.0, 275430.0, 238490.0, 89040.0};
            
            for(int i = 0; i < valoresB.length; i++){
                this.session.save(new ModelConsExeMatB(valoresB[i]));
            }
            
            tx.commit();
        }
        
        
        cr = this.session.createCriteria(ModelCVA.class);
        results = cr.list();
        Transaction tx = session.beginTransaction();
        
        if(results.isEmpty()){
            String csvFile = "/Ciclo1/Csv/Cva.csv";
            InputStream is = getClass().getResourceAsStream(csvFile);
            BufferedReader br = null;
            String line = "";
            String csvSplitBy = ";";
           
            double[] valoresV = new double[2];
            try{
                cr = this.session.createCriteria(ModelCVA.class);
                results = cr.list();
                br = new BufferedReader(new InputStreamReader(is));
                while((line = br.readLine()) != null){
                    String[] table_c = line.split(csvSplitBy);
                    for(int i = 0; i < table_c.length; i++){
                        valoresV[i] = Double.parseDouble(table_c[i]);
                    }
                    this.session.save(new ModelCVA(valoresV));
                }

            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            
            csvFile = "/Ciclo1/Csv/Cvb.csv";
            is = getClass().getResourceAsStream(csvFile);

            br = null;
            line = "";
            csvSplitBy = ";";
           
            valoresV = new double[2];
            try{
                cr = this.session.createCriteria(ModelCVB.class);
                results = cr.list();
                br = new BufferedReader(new InputStreamReader(is));
                while((line = br.readLine()) != null){
                    String[] table_c = line.split(csvSplitBy);
                    for(int i = 0; i < table_c.length; i++){
                        valoresV[i] = Double.parseDouble(table_c[i]);
                    }
                    this.session.save(new ModelCVB(valoresV));
                }

            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        tx.commit();
        
        cr = this.session.createCriteria(ModelDRT70.class);
        results = cr.list();
        tx = session.beginTransaction();
        
        if(results.isEmpty()){
            String csvFile = "/Ciclo1/Csv/drt70.csv";
            InputStream is = getClass().getResourceAsStream(csvFile);

            BufferedReader br = null;
            String line = "";
            String csvSplitBy = ";";
           
            try{
                cr = this.session.createCriteria(ModelDRT70.class);
                results = cr.list();
                br = new BufferedReader(new InputStreamReader(is));
                while((line = br.readLine()) != null){
                    double[] valoresV = new double[5];
                    String[] table_c = line.split(csvSplitBy);
                    for(int i = 0; i < table_c.length; i++){
                        valoresV[i] = Double.parseDouble(table_c[i]);
                    }
                    this.session.save(new ModelDRT70(valoresV));
                }

            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            
            csvFile = "/Ciclo1/Csv/drt80.csv";
            is = getClass().getResourceAsStream(csvFile);
            
            br = null;
            line = "";
            csvSplitBy = ";";
           
            try{
                cr = this.session.createCriteria(ModelDRT80.class);
                results = cr.list();
                br = new BufferedReader(new InputStreamReader(is));
                while((line = br.readLine()) != null){
                    double[] valoresV = new double[4];
                    String[] table_c = line.split(csvSplitBy);
                    for(int i = 0; i < table_c.length; i++){
                        valoresV[i] = Double.parseDouble(table_c[i]);
                    }
                    this.session.save(new ModelDRT80(valoresV));
                }

            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            
            csvFile = "/Ciclo1/Csv/eqro.csv";
            is = getClass().getResourceAsStream(csvFile);

            br = null;
            line = "";
            csvSplitBy = ";";
           
            try{
                cr = this.session.createCriteria(ModelEqro.class);
                results = cr.list();
                br = new BufferedReader(new InputStreamReader(is));
                while((line = br.readLine()) != null){
                    double[] valoresV = new double[3];
                    String[] table_c = line.split(csvSplitBy);
                    for(int i = 0; i < table_c.length; i++){
                        valoresV[i] = Double.parseDouble(table_c[i]);
                    }
                    this.session.save(new ModelEqro(valoresV));
                }

            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            
            csvFile = "/Ciclo1/Csv/eqrs.csv";
            is = getClass().getResourceAsStream(csvFile);

            br = null;
            line = "";
            csvSplitBy = ";";
           
            try{
                cr = this.session.createCriteria(ModelEqrs.class);
                results = cr.list();
                br = new BufferedReader(new InputStreamReader(is));
                while((line = br.readLine()) != null){
                    double[] valoresV = new double[3];
                    String[] table_c = line.split(csvSplitBy);
                    for(int i = 0; i < table_c.length; i++){
                        valoresV[i] = Double.parseDouble(table_c[i]);
                    }
                    this.session.save(new ModelEqrs(valoresV));
                }

            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            tx.commit();
        }
        
        viewPrincipal = new ViewPrincipal(this);
        viewPrincipal.setResizable(false);
        viewPrincipal.pack();
        viewPrincipal.setTitle("KCS");
        viewPrincipal.setVisible(true);
        viewPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewPrincipal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                try {
                    conexao.getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(ControlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }
        });
    }
 
    public ViewPrincipal getViewPrincipal() {
        return viewPrincipal;
    }

    public void setViewPrincipal(ViewPrincipal viewPrincipal) {
        this.viewPrincipal = viewPrincipal;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

	public ControlConverte getControlConverte() {
		return controlConverte;
	}

	public void setControlConverte(ControlConverte controlConverte) {
		this.controlConverte = controlConverte;
	}
}


