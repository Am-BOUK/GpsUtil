package GpsUtil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import GpsUtil.exception.UUIDException;
import GpsUtil.service.GpsUtilService;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

@RestController
public class GpsUtilController {
	private Logger logger = LoggerFactory.getLogger("GpsUtilController");

	@Autowired
	private GpsUtilService gpsUtilService;

	/**
	 * Get user's location endpoint
	 * 
	 * @param userId : the userId String in UUID form of the user we want to get his
	 *               location
	 * @return VisitedLocation : the Visited location model of a specific userId
	 * @throws UUIDException
	 */
	@GetMapping("/getUserLocation")
	public VisitedLocation getUserLocationGpsUtil(@RequestParam String userId) throws UUIDException {
		logger.info("Get UserLocation GpsUtil for userId : " + userId);
		return gpsUtilService.getUserLocationGpsUtil(userId);
	}

	/**
	 * Get the list of all Attractions
	 * 
	 * @return a Attraction list
	 */
	@GetMapping("/getAllAttractions")
	public List<Attraction> getAttractionsGpsUtil() {
		logger.info("Get Attractions list in GpsUtil");
		return gpsUtilService.getAttractionsGpsUtil();
	}
}
