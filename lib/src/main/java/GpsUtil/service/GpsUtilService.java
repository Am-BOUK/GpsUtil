package GpsUtil.service;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * implementation of GpsUtil Service
 * 
 */
@Service
public class GpsUtilService {
	private Logger logger = LoggerFactory.getLogger(GpsUtilService.class);
	GpsUtil gpsUtil = new GpsUtil();

//	public GpsUtilService(GpsUtil gpsUtil) {
//		this.gpsUtil = gpsUtil;
//	}

	/**
	 * Get the user location of a user based on his UUID
	 * 
	 * @param userId the UUID
	 * @return a VisitedLocation model
	 */
	public VisitedLocation getUserLocationGpsUtil(UUID userId) {
		logger.debug("get User Location GpsUtil");
		VisitedLocation visitedLocation =  gpsUtil.getUserLocation(userId);
		return visitedLocation;
	}

	/**
	 * Get all the attractions in a form of a list of attractions
	 * 
	 * @return a list of attractions
	 */
	public List<Attraction> getAttractionsGpsUtil() {
		logger.debug("get Attractions GpsUtil");
		return gpsUtil.getAttractions();
	}

}
