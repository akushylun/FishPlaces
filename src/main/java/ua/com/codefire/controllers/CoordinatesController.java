package ua.com.codefire.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.codefire.services.PlaceService;

import java.util.logging.Logger;

@Controller
public class CoordinatesController {

	@Autowired
	private PlaceService placeService;

	private static final Logger LOGGER = Logger.getLogger(CoordinatesController.class.getName());

	@RequestMapping(value = "/coordinates")
	public String getMapPage() {
		return "coordinates";
	}

	@RequestMapping(value = "/coordinates/{id}", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	public @ResponseBody String getCoordinates(@PathVariable(value = "id") int id) {
		Gson gson = new Gson();
		String result = gson.toJson(placeService.findPlaceById(id));
		LOGGER.info(result);
		return result;
	}

	@RequestMapping(value = "/maxPlaceId", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	public @ResponseBody String getTestPage() {
		return new Gson().toJson(placeService.getMaxPlaceId());
	}

}
