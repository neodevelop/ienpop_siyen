package edu.ienpop;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class GeneradorDatos {

	public static String[] nombres = new String[] { "Juan", "Pedro", "Maria",
			"Alejandro", "Francisco", "Luis", "Juan Miguel", "Adolfo",
			"Maribel", "Ana" };

	public static String[] apellidosPaternos = new String[] { "Aguirre",
			"Pantoja", "Ramirez", "Zavala", "Benitez", "Carmona", "Hinojosa",
			"Jimenez", "Fernandez", "Romero" };

	public static String[] apellidosMaternos = new String[] { "Betancourt",
			"Paniagua", "Rosales", "Zamora", "Basilio", "Corona", "Jasso",
			"Martinez", "Gutierrez", "Uribe" };

	
	/**
	 * Logger para todas las instancias de la clase
	 */
	// private static final Log logger =
	// LogFactory.getLog(GeneradorDatos.class);

	public static String getNombreCompletoAleatorio(){
		String nombreCompleto = getNombreAleatorio()+" "+getApPaternoAleatorio()+ " "+getApMaternoAleatorio();
		return nombreCompleto.toUpperCase();
	}
	
	public static String getNombreAleatorio() {
		return nombres[(int) (Math.random() * nombres.length)];
	}

	public static String getApMaternoAleatorio() {
		return apellidosMaternos[(int) (Math.random() * apellidosMaternos.length)];
	}

	public static String getApPaternoAleatorio() {
		return apellidosPaternos[(int) (Math.random() * apellidosPaternos.length)];
	}

	public static Locale getLocaleAleatorio() {

		Locale[] paises = Locale.getAvailableLocales();
		return paises[(int) (Math.random() * paises.length)];
	}

	public static String creaObservcacionesSinSentido() {
		String RFC = "";
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < 4; i++) {
			RFC += abc.toCharArray()[(int) (Math.random() * abc.length())];
		}
		for (int i = 0; i < 6; i++) {
			RFC += String.valueOf(((int) (Math.random() * 9)));
		}
		return RFC;
	}

	public static Date getHoraAleatoria() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, (int) (Math.random() * 24));
		calendar.set(Calendar.MINUTE, (int) (Math.random() * 60));
		return calendar.getTime();
	}
	
	public static Date getDateAleatorio(){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(Calendar.MONTH, (int) (Math.random() * 12));
		calendar.set(Calendar.DAY_OF_MONTH, (int) (Math.random() * 28));
		calendar.set(Calendar.YEAR, 2010);
		return calendar.getTime();
	}
}
