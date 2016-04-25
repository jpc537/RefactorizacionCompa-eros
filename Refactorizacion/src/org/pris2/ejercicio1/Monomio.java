package org.pris2.ejercicio1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Monomio implements Comparable<Monomio> {

	private double coeficiente;
	private int grado;
	private char literal;

	public Monomio(double coeficiente, int grado, char literal) {
		this.coeficiente = coeficiente;
		this.grado = grado;
		this.literal = literal;
	}

	/**
	 * Genera un objeto de tipo Monomio a partir de otro para los aux
	 */
	public Monomio(Monomio otro) {
		this(otro.coeficiente, otro.grado, otro.literal);
	}

	@Override
	public String toString() {
		if (Double.compare(coeficiente, 0) == 0)
			return "";
		// en funcion de si es positivo o negativo definimos 2 formas de mostrar
		DecimalFormat form = new DecimalFormat("+#.#;-#.#");
		// establecemos el punto como separador decimal
		DecimalFormatSymbols dc = form.getDecimalFormatSymbols();
		dc.setDecimalSeparator('.');
		form.setDecimalFormatSymbols(dc);
		// en funcion de grado mostramos el literal y la potencia
		return form.format(coeficiente) + (grado != 0 ? literal : "") + (grado > 1 ? "^" + grado : "");
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Monomio))
			return false;
		Monomio otro = (Monomio) o;
		int coefIguales = Double.compare(coeficiente, otro.coeficiente);

		return grado == otro.grado && coefIguales == 0 && literal == otro.literal;
	}

	@Override
	public int compareTo(Monomio o) {
		if (equals(o))
			return 0;
		Monomio otro = o;
		if (grado < otro.grado)
			return -1;
		else
			return 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coeficiente);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + grado;
		result = prime * result + literal;
		return result;
	}

	/**
	 * Comprueba si 2 monomios son compatibles
	 */
	public boolean compatible(Monomio otro) {
		return grado == otro.grado;

	}

	/**
	 * Suma el monomio this con otro
	 * 
	 * @throws Exception
	 *             si los monomios no son compatibles
	 */
	public Monomio sumar(Monomio otro) throws Exception {
		if (!compatible(otro)) {
			throw new Exception("(" + this + ") + (" + otro + ")");
		} else
			return new Monomio(coeficiente + otro.coeficiente, grado, literal);
	}

	/**
	 * Multiplica el monomio this con otro
	 */
	public Monomio mult(Monomio otro) {
		return new Monomio(coeficiente * otro.coeficiente, grado + otro.grado, literal);
	}

	/**
	 * Suma dos monomios
	 */
	public static Monomio sumar(Monomio a, Monomio b) throws Exception {
		return a.sumar(b);
	}

	/**
	 * Multiplica dos monomios
	 */
	public static Monomio mult(Monomio a, Monomio b) {
		return a.mult(b);
	}

	/**
	 * Suma al monomio this otro
	 */
	public void addSumar(Monomio otro) throws Exception {
		if (!compatible(otro))
			throw new Exception("(" + this + ") + (" + otro + ")");
		else
			coeficiente += otro.coeficiente;
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public int getGrado() {
		return grado;
	}
}