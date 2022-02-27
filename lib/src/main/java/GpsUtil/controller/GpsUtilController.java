package GpsUtil.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import GpsUtil.service.GpsUtilService;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

@RestController
public class GpsUtilController {
	private Logger logger = LoggerFactory.getLogger(GpsUtilController.class);

	@Autowired
	GpsUtilService gpsUtilService;

	/**
	 * HTML GET request that returns a visited location
	 * 
	 * @param userId the UUID of the userId in a form of a string
	 * @return the Visited location model of a specific userId
	 * @throws UUIDException
	 */
	@RequestMapping("/getUserLocation")
	public VisitedLocation getUserLocationServer(@RequestParam UUID userId) {
//		logger.debug("Start getUserLocationServer at /getUserLocation for userId : " + userId);
//		userIdUUID = UUID.fromString(userId);
		
		return gpsUtilService.getUserLocationGpsUtil(userId);
	}

	/**
	 * HTML GET request that returns a list of attractions
	 * 
	 * @return a list of all attractions
	 */
	@GetMapping("/getAllAttractions")
	public List<Attraction> getAllAttractionsServer() {
//		logger.debug("Start getAllAttractionsServer at /getAllAttractions");
//	 attractionList = 
		return gpsUtilService.getAttractionsGpsUtil();
	}
}
