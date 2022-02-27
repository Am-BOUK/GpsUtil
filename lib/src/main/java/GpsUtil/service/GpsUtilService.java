package GpsUtil.service;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import GpsUtil.exception.UUIDException;

/**
 * implementation of GpsUtil Service
 * 
 */
@Service
public class GpsUtilService {
	private Logger logger = LoggerFactory.getLogger("GpsUtilService");
	private GpsUtil gpsUtil = new GpsUtil();
	private final static Pattern UUID_REGEX_PATTERN = Pattern
			.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");

	/**
	 * Get the user location of a user based on his UUID
	 * 
	 * @param userId the UUID
	 * @return a VisitedLocation model
	 * @throws UUIDException
	 */
	public VisitedLocation getUserLocationGpsUtil(String userId) throws UUIDException {
		logger.debug("get User Location GpsUtil");

		if (!isValidUUID(userId)) {
			logger.error("format UUID of userId invalid!");
			throw new UUIDException("format UUID userId is invalid!");
		}
		UUID attractionIdUUID = UUID.fromString(userId);
		return gpsUtil.getUserLocation(attractionIdUUID);
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

	private static boolean isValidUUID(String str) {
		if (str == null) {
			return false;
		}
		return UUID_REGEX_PATTERN.matcher(str).matches();
	}

}
