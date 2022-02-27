package GpsUtilService;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import GpsUtil.Application;
import GpsUtil.exception.UUIDException;
import GpsUtil.service.GpsUtilService;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GpsUtilServiceTest {

	@Autowired
	private GpsUtilService gpsUtilService;

	@Test
	public void getAttractionsGpsUtilTest() {

		List<Attraction> attractions = gpsUtilService.getAttractionsGpsUtil();

		assertEquals(26, attractions.size());
	}

	@Test
	public void getUserLocationGpsUtilTest() throws UUIDException {

		VisitedLocation visitedLocation = gpsUtilService.getUserLocationGpsUtil(String.valueOf(UUID.randomUUID()));

		assertEquals(true, !visitedLocation.equals(null));
	}
}
