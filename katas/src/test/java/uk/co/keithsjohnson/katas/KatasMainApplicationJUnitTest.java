package uk.co.keithsjohnson.katas;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KatasMainApplication.class)
public class KatasMainApplicationJUnitTest {

	@Autowired
	ApplicationContext ctx;

	@Test
	public void testContextLoads() throws Exception {
		assertNotNull(this.ctx);
		assertTrue(this.ctx.containsBean("tenPinBowlingScoreCalculatorImpl"));
		assertTrue(this.ctx.containsBean("tenPinBowlingScorePrinterImpl"));
	}
}
