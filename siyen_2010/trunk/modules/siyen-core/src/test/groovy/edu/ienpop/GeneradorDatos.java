package edu.ienpop;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class GeneradorDatos {

	private static String[] nombres = new String[] { "Juan", "Pedro", "Maria",
			"Alejandro", "Francisco", "Luis", "Juan Miguel", "Adolfo",
			"Maribel", "Ana" };

	private static String[] apellidosPaternos = new String[] { "Aguirre",
			"Pantoja", "Ramirez", "Zavala", "Benitez", "Carmona", "Hinojosa",
			"Jimenez", "Fernandez", "Romero" };

	private static String[] apellidosMaternos = new String[] { "Betancourt",
			"Paniagua", "Rosales", "Zamora", "Basilio", "Corona", "Jasso",
			"Martinez", "Gutierrez", "Uribe" };

	private static String[] instructores = new String[] { "BORDA",
			"BUSTAMANTE", "FAUSTO", "GARCIA_G", "GONZALEZ_G", "GONZALEZ_T",
			"HDEZDELOS_P", "MAGALI", "MENDOZA", "MERCADO", "MLADINEO",
			"OSUNA_O", "OSUNA_P", "OSUNA_S", "RAMIREZ", "SALDIVAR" };

	private static String[] cursos = new String[] { "CAPACO3234", "CAPACO3235",
			"CAPALI3233", "CAPASOC3235", "CAPASOC3236", "CAPATCO3232",
			"CAPATLI3231", "CAPATPES3235", "CAPCAM311", "CAPCAM312",
			"CAPCOC312", "CAPCON322", "CAPESOC3236", "CAPMAY313", "CAPMOT331",
			"CAPMOT331_P", "CAPMOT332", "CAPMOT332_P", "CAPMOT333",
			"CAPMOT333P", "CAPMOT333_P", "CAPMOT335_P", "CAPTIM321",
			"COURSE2_09", "FAMBT1", "INICIA", "INICIA1", "INICIA1_D",
			"INICIA1_P", "MOTPESOC", "NAVSEG2_I", "NAVSEG2_II", "NAVSEG2_III",
			"OPBOTS1", "PATMAR", "PATRON_DE_YATE", "PATRON_DE_YATE_I",
			"PATRON_DE_YATE_II", "PATRON_DE_YATE_III", "RI-11", "RI/11",
			"SEGBAPES", "SEGBATUR", "SEPLAC4.1", "SMODU95", "STCW95",
			"STCW95_1", "STCW95_2", "STCW95_P1", "STCW95_P2", "STCW95_R" };

	public static String[] puertos = new String[] { "ACG", "ATL", "ATS",
			"BABC", "BTBC", "CATV", "CHAC", "CHIC", "CHJ", "CHX", "CSL", "DF",
			"ENS", "FFC", "GNBC", "GYS", "HOX", "ICBC", "INBJ", "LBC", "LCM",
			"LPB", "MOCH", "MPCH", "MZO", "MZS", "PABC", "PAO", "PEO", "PMCH",
			"PPS", "PVJ", "PZM", "RBC", "RIN", "SBN", "SCBC", "SCO", "SFBC",
			"SJBC", "SRBC", "TOP", "VBEM", "YAS", "YUR", "ZIH" };

	/**
	 * Logger para todas las instancias de la clase
	 */
	// private static final Log logger =
	// LogFactory.getLog(GeneradorDatos.class);

	public static String getNombreCompletoAleatorio() {
		String nombreCompleto = getNombreAleatorio() + " "
				+ getApPaternoAleatorio() + " " + getApMaternoAleatorio();
		return nombreCompleto.toUpperCase();
	}

	private static String getNombreAleatorio() {
		return nombres[(int) (Math.random() * nombres.length)];
	}

	private static String getApMaternoAleatorio() {
		return apellidosMaternos[(int) (Math.random() * apellidosMaternos.length)];
	}

	private static String getApPaternoAleatorio() {
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

	public static Date getDateAleatorio() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		calendar.set(Calendar.DAY_OF_MONTH, (int) (Math.random() * 28));
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
		return calendar.getTime();
	}

	public static String getInstructorAleatorio() {
		return instructores[(int) (Math.random() * instructores.length)];
	}

	public static String getCursoAleatorio() {
		return cursos[(int) (Math.random() * cursos.length)];
	}
	
	public static String getPuertoAleatorio() {
		return puertos[(int) (Math.random() * puertos.length)];
	}
}
