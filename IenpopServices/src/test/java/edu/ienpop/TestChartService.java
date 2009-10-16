package edu.ienpop;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.services.ChartService;
import edu.ienpop.services.impl.ChartServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ServicesAppCtx.xml","/DataSourceAppCtx.xml" })
public class TestChartService {

	@Test
	public void testChartService() throws IOException {
		ChartService chartService = new ChartServiceImpl();
		JFreeChart chart = chartService.generaGraficaSimple();
		ChartUtilities.saveChartAsPNG(new File("my.png"), chart, 500, 500);
	}
}
