package edu.ienpop.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/PersistenceAnnotated-AppCtx.xml"})
public class TestAppContext {

	@Autowired
	ApplicationContext ctx;

	@Test
	public void thereIsAppCtx() {
		Assert.notNull(ctx);
	}

	@Test
	public void testContainer() {
		Assert.isTrue(ctx.getBeanDefinitionCount() > 0);
	}
}
