package edu.ienpop.services.impl;

import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Service;

import edu.ienpop.services.ChartService;

@Service
public class ChartServiceImpl implements ChartService {

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
        
		JFreeChart chart = ChartFactory.createBarChart3D( "example graph", // title
		        "x-axis",  // x-axis label
		        "y-axis",  // y-axis label
		        dataset,
		        PlotOrientation.VERTICAL,
		        true,      // legend displayed
		        true,      // tooltips displayed
		        false );   // no URLs*/
		
		CategoryItemRenderer renderer = new BarRenderer3D();
		DecimalFormat decimalformat1 = new DecimalFormat("##,###");
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", decimalformat1));
		renderer.setBaseItemLabelsVisible(true);
		chart.getCategoryPlot().setRenderer(renderer);
		
		return chart;
	}

}
