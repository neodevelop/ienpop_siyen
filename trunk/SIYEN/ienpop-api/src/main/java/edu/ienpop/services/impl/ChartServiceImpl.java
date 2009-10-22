package edu.ienpop.services.impl;

import java.text.DecimalFormat;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ienpop.model.AlumnoCriteria;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.services.AlumnoService;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CursoService;

@Service("chartService")
public class ChartServiceImpl {

	@Autowired
	CursoService cursoService;
	@Autowired
	AlumnoService alumnoService;

	public JFreeChart generaGraficaSimple() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(15, "rowKey1", "Puerto1");
		dataset.addValue(25, "rowKey1", "Puerto2");
		dataset.addValue(35, "rowKey1", "Puerto3");
		dataset.addValue(45, "rowKey1", "Puerto4");
		dataset.addValue(55, "rowKey1", "Puerto5");
		dataset.addValue(55, "rowKey2", "Puerto1");
		dataset.addValue(45, "rowKey2", "Puerto2");
		dataset.addValue(35, "rowKey2", "Puerto3");
		dataset.addValue(25, "rowKey2", "Puerto4");
		dataset.addValue(15, "rowKey2", "Puerto5");

		return crearGraficaBarras3D("Ejemplode Gr‡fica", "Eje-X", "Eje-Y",
				dataset);
	}

	public JFreeChart generaGraficaCursos(CursoCriteria cursoCriteria)
			throws BusinessException {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		CursoCriteria localCriteria = new CursoCriteria();
		localCriteria.setFechaDesde(cursoCriteria.getFechaDesde());
		localCriteria.setFechaHasta(cursoCriteria.getFechaHasta());
		localCriteria.setIdStatusCurso(CursoCriteria.CONCLUIDO);
		if (cursoCriteria.getIdUsuario() != null) {
			for (String idUsuario : cursoCriteria.getIdUsuario()) {
				localCriteria.setIdUsuario(new String[] { idUsuario });
				for (String idTipoCurso : cursoCriteria.getIdTipoCurso()) {
					localCriteria.setIdTipoCurso(new String[] { idTipoCurso });
					dataset.addValue(cursoService
							.getCountCursosByCriteria(localCriteria),
							idTipoCurso, idUsuario);
					System.out.println(ToStringBuilder
							.reflectionToString(localCriteria));
				}

			}
		}

		return crearGraficaBarras3D("Titulo", "Instructores", "Cursos", dataset);
	}

	public JFreeChart generaGraficaAlumnos(AlumnoCriteria alumnoCriteria)
			throws BusinessException {

		return null;
	}

	private JFreeChart crearGraficaBarras3D(String titulo, String ejeX,
			String ejeY, DefaultCategoryDataset dataset) {
		JFreeChart chart = ChartFactory.createBarChart3D(titulo, // title
				ejeX, // x-axis label
				ejeY, // y-axis label
				dataset, PlotOrientation.VERTICAL, true, // legend displayed
				true, // tooltips displayed
				false); // no URLs*/

		CategoryItemRenderer renderer = new BarRenderer3D();
		DecimalFormat decimalformat1 = new DecimalFormat("##,###");
		renderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator(
						"{2}", decimalformat1));
		renderer.setBaseItemLabelsVisible(true);
		chart.getCategoryPlot().setRenderer(renderer);

		return chart;
		// return null;
	}

}
