
package org.pris2.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebaPolinomios {
	
	private PruebaPolinomios(){		
	}

	public static void main(String[] args) {
		
		List<Monomio> coefisVariao = new ArrayList<>();
		coefisVariao.add(new Monomio(1.0, 2, 'x'));
		coefisVariao.add(new Monomio(3.0, 3, 'x'));
		coefisVariao.add(new Monomio(5.0, 4, 'x'));
		coefisVariao.add(new Monomio(2.0, 2, 'x'));
		coefisVariao.add(new Monomio(6.0, 3, 'x'));
		coefisVariao.add(new Monomio(4.0, 7, 'x'));
		Polinomio p1 = new Polinomio(coefisVariao);
		
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, "Polinomio 1:");
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, p1.toString());
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, "Polinomio 1 simplificado: ");
		p1.juntarComunes2((ArrayList<Monomio>) coefisVariao);
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, " ");
		
		List<Monomio> coefisVariao2 = new ArrayList<>();
		coefisVariao2.add(new Monomio(1.0, 2, 'x'));
		coefisVariao2.add(new Monomio(3.0, 3, 'x'));
		coefisVariao2.add(new Monomio(5.0, 4, 'x'));
		coefisVariao2.add(new Monomio(2.0, 2, 'x'));
		coefisVariao2.add(new Monomio(6.0, 3, 'x'));
		coefisVariao2.add(new Monomio(4.0, 7, 'x'));
		Polinomio p3 = new Polinomio(coefisVariao);
		
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, "Polinomio 2: ");
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, p1.toString());
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, "Polinomio 2 simplificado: ");
		p3.juntarComunes2((ArrayList<Monomio>) coefisVariao2); 
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, " ");
		
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, "Suma:");
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, "(" + p3.toString() + ") + (" + p1 + ") = ");
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, Polinomio.sumar(p3,p1).toString());
		
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, "Multiplicación:");
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, "(" + p3.toString() + ") * (" + p1 + ") = ");
		Logger.getLogger(PruebaPolinomios.class.getName()).log(Level.INFO, p3.mult(p1).toString());
		
	}

}