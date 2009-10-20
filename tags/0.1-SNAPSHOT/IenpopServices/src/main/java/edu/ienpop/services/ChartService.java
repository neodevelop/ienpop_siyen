package edu.ienpop.services;

import org.jfree.chart.JFreeChart;

import edu.ienpop.model.AlumnoCriteria;
import edu.ienpop.model.CursoCriteria;

public interface ChartService {
	JFreeChart generaGraficaSimple() throws BusinessException;
	JFreeChart generaGraficaCursos(CursoCriteria cursoCriteria) throws BusinessException;
	JFreeChart generaGraficaAlumnos(AlumnoCriteria alumnoCriteria) throws BusinessException;
}
