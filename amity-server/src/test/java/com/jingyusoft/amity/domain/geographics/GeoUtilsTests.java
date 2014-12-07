package com.jingyusoft.amity.domain.geographics;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class GeoUtilsTests {

	private static final double DELTA = 1e-15;

	@Test
	public void testCalculateDistance() {
		double distance = GeoUtils.distanceBetween(51.464339, -0.012469, 51.476871, 0.000529);
		Assert.assertEquals(1.658950626862948, distance, DELTA);
	}
}
