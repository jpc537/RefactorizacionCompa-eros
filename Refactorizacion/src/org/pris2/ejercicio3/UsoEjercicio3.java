package org.pris2.ejercicio3;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsoEjercicio3 {
	private UsoEjercicio3() {
	}

	public static void main(String[] args) {
		Ejercicio3 ejer = new Ejercicio3();
		int xizq;
		int xder;
		double precision;
		double xr;
		double funcionDer;
		double funcionIzq;
		double funcionRaiz;

		Scanner in = new Scanner(System.in);
		Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "Introduzca el valor del extremo de la izquierda: ");
		xizq = in.nextInt();

		Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "Introduzca el valor del extremo de la derecha: ");
		xder = in.nextInt();

		Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "El intervalo es [" + xizq + "," + xder + "]");

		Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "Introduzca la precision deseada: ");
		precision = in.nextDouble();

		funcionDer = ejer.funcionDerecha(xder);
		funcionIzq = ejer.funcionIzquierda(xizq);
		xr = ejer.xr(xizq, xder, funcionIzq, funcionDer);
		funcionRaiz = ejer.funcionRaiz(xr);

		/**
		 * Si f(xizq)*f(xr)<0ïƒ redefinir lÃ­mite derecho del intervalo:
		 * xderïƒŸxr Si f(xizq)*f(xr)>0ïƒ redefinir lÃ­mite izquierdo
		 * del intervalo: xizqïƒŸxr Si f(xizq)*f(xr)=0ïƒ hay una raÃ­z
		 * en xr
		 **/
		while (funcionRaiz < precision) {
			if ((funcionIzq * funcionRaiz) < 0) {
				Logger.getLogger(Ejercicio3.getLog()).log(Level.WARNING,
						"Vuelva a introducir el limite derecho del intervalo: ");

				xder = in.nextInt();
				Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "El intervalo es: [" + xizq + "," + xder + "]");

				funcionDer = Math.pow(xder, 5) - Math.pow(xder, 4) + Math.pow(xder, 3) - 3;
				Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "f(xder)=" + funcionDer);

				funcionIzq = Math.pow(xizq, 5) - Math.pow(xizq, 4) + Math.pow(xizq, 3) - 3;
				Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "f(xizq)=" + funcionIzq);

				xr = xder - funcionDer * (xizq - xder) / (funcionIzq - funcionDer);
				Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "xr=" + xr);

				funcionRaiz = Math.pow(xr, 5) - Math.pow(xr, 4) + Math.pow(xr, 3) - 3;
				Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "f(xr)=" + xr);

			} else if ((funcionIzq * funcionRaiz) > 0) {
				Logger.getLogger(Ejercicio3.getLog()).log(Level.WARNING,
						"Vuelva a introducir el limite izquierdo del intervalo: ");
				xizq = in.nextInt();
				Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "El intervalo es [" + xizq + "," + xder + "]");

				funcionDer = Math.pow(xder, 5) - Math.pow(xder, 4) + Math.pow(xder, 3) - 3;
				Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "f(xder)=" + funcionDer);

				funcionIzq = Math.pow(xizq, 5) - Math.pow(xizq, 4) + Math.pow(xizq, 3) - 3;
				Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "f(xizq)=" + funcionIzq);

				xr = xder - funcionDer * (xizq - xder) / (funcionIzq - funcionDer);
				Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "xr=" + xr);

				funcionRaiz = Math.pow(xr, 5) - Math.pow(xr, 4) + Math.pow(xr, 3) - 3;
				Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "f(xr)=" + xr);

			} else if (Double.compare(funcionIzq * funcionRaiz, 0) == 0) {
				Logger.getLogger(Ejercicio3.getLog()).log(Level.INFO, "La raiz es: " + xr);
			}
		}

		in.close();

	}

}