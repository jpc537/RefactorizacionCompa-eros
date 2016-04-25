package org.pris2.ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio3 {
	int xizq = 0;
	int xder = 0;
	double precision = 0.0;
	double xr = 0.0;
	double funcionDer = 0.0;
	double funcionIzq = 0.0;
	double funcionRaiz = 0.0;
	private static final String LOG = "Ejercicio 3";

	public Ejercicio3(int izq, int der, double pre, double xr, double fd, double fi, double fraiz) {
		this.xizq = izq;
		this.xder = der;
		this.precision = pre;
		this.xr = xr;
		this.funcionDer = fd;
		this.funcionIzq = fi;
		this.funcionRaiz = fraiz;
	}

	public Ejercicio3() {
		xizq = 0;
		xder = 0;
		precision = 0.0;
		xr = 0.0;
		funcionDer = 0.0;
		funcionIzq = 0.0;
		funcionRaiz = 0.0;
	}

	public Double funcionDerecha(int xderecha) {
		funcionDer = Math.pow(xderecha, 5) - Math.pow(xderecha, 4) + Math.pow(xderecha, 3) - 3;
		Logger.getLogger(LOG).log(Level.INFO, "f(xder)=" + funcionDer);
		return funcionDer;
	}

	public Double funcionIzquierda(int xizquierda) {
		funcionIzq = Math.pow(xizquierda, 5) - Math.pow(xizquierda, 4) + Math.pow(xizquierda, 3) - 3;
		Logger.getLogger(LOG).log(Level.INFO, "f(xizquierda)=" + funcionIzq);
		return funcionIzq;
	}

	public Double xr(int xizq, int xder, double funcionIzq, Double funcionDer) {

		xr = xder - funcionDer * (xizq - xder) / (funcionIzq - funcionDer);
		Logger.getLogger(LOG).log(Level.INFO, "xr=" + xr);
		return xr;
	}

	public Double funcionRaiz(double xr) {
		funcionRaiz = Math.pow(xr, 5) - Math.pow(xr, 4) + Math.pow(xr, 3) - 3;
		Logger.getLogger(LOG).log(Level.INFO, "f(xr)=" + funcionRaiz);

		return funcionRaiz;
	}

	public static String getLog() {
		return LOG;
	}

}
