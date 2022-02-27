package GpsUtilController;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import GpsUtil.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class GpsUtilControllerIT {
	@Autowired
    private MockMvc mock;
	
	 @Test
	    public void shouldAccessAttractions() throws Exception {

	        mock.perform(get("/getAllAttractions"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.size()", is(26)));
	    }

	    @Test
	    public void shouldAccessUserLocation() throws Exception {

	        mock.perform(get("/getUserLocation").param("userId", String.valueOf(UUID.randomUUID())))
	                .andExpect(status().isOk())
	                .andExpect(content().string(containsString("longitude")))
	                .andExpect(content().string(containsString("latitude")));
	    }
}
