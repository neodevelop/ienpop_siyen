package edu.ienpop.services;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.model.CursoCriteria;
import edu.ienpop.services.impl.ChartServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ServicesAppCtx.xml",
		"/DataSourceAppCtx.xml" })
public class TestChartService {

	@Autowired
	ChartServiceImpl chartService;

	@Test
	public void testChartService() {
		try {
			JFreeChart chart = chartService.generaGraficaSimple();
			ChartUtilities.saveChartAsPNG(new File("my.png"), chart, 500, 500);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testChartService2() {
		try {
			String[] usuarios = { "RAMIREZ", "MAGALI", "BORDA", "BUSTAMANTE",
					"MENDOZA", "MERCADO", "SALDIVAR", "BORDA" };
			String[] idTipoCurso = { "SEGBAPES", "STCW95", "INICIA1",
					"CAPACO3234", "PATRON_DE_YATE_I", "PATRON_DE_YATE_II",
					"PATRON_DE_YATE_III", "INICIA1_P" };
			CursoCriteria criteria = new CursoCriteria();
			criteria.setIdUsuario(usuarios);
			criteria.setIdTipoCurso(idTipoCurso);
			Calendar fechaInicio = Calendar.getInstance();
			fechaInicio.set(2005, 0, 1);
			Calendar fechaFin = Calendar.getInstance();
			criteria.setFechaDesde(fechaInicio.getTime());
			criteria.setFechaHasta(fechaFin.getTime());
			JFreeChart chart = chartService.generaGraficaCursos(criteria);
			ChartUtilities.saveChartAsPNG(new File("usuarios.png"), chart,
					1100, 600);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
