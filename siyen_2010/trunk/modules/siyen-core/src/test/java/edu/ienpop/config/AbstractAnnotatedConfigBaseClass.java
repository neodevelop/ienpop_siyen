package edu.ienpop.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author neodevelop
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/Persistence-AppCtx.xml" })
public abstract class AbstractAnnotatedConfigBaseClass {

}
