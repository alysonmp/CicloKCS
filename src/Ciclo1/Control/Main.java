/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo1.Control;

import Ciclo1.View.ViewInicio;



/**
 *
 * @author alysonmp
 */
public class Main {
       
    public static void main(String[] args){
        
        ViewInicio vi = new ViewInicio();
        ControlPrincipal principal = new ControlPrincipal();
        vi.getViewInicio().dispose();
    }
}
