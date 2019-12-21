package com.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.json.JsonParser;*/
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.demo.resource.Country;
/*import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;*/
/*import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;*/
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



@Controller
public class UIDemoController {
	
	private static List<Country> countryList = new ArrayList<Country>();
	
	@RequestMapping(value="/country", method = RequestMethod.POST)
    public ModelAndView listCountry(@ModelAttribute Country country) throws ParseException {
    	 ModelAndView mv = new ModelAndView();
    	 System.out.println("*********** UI listCountry method call *************");
    	 //http://api.worldbank.org/v2/country
    	 //http://api.worldbank.org/v2/country?format=json
    	 String url = "http://api.worldbank.org/v2/country?format=json";
    	 RestTemplate restTemplate = getRestTemplate();
    	 
    	 //ResponseEntity<List<Country>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Country>>(){});
    	 ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Object>(){});
    	 Object countryList = response.getBody();
    	 
		/*
		 * JSONParser js = new JSONParser(countryList.toString()); 
		 * LinkedHashMap<String, Object> map = js.parseObject();
		 */
    	 
		/*
		 * JsonArrayFormatVisitor jsArray = new JsonArrayFormatVisitor(countryList);
		 */    	 
    	 
    	 //String jsonString = new Gson().toJson(countryList);
    	 
    	 //Country cntry = new Gson().fromJson(jsonString, Country.class);
    	 //Type collectionType = (Type) new TypeToken<Collection<Country>>(){}.getType();
    	 //Collection<Country> enums = new Gson().fromJson(jsonString, collectionType);
    	 
    	 //Type collectionType = (Type) new TypeToken<List<Country>>(){}.getType();
    	 //List<Country> lcs = (List<Country>) new Gson().fromJson( jsonString , (java.lang.reflect.Type) collectionType);
    	 
    	 JSONParser parser = new JSONParser();
    	 JSONObject json = (JSONObject) parser.parse(countryList.toString()); 
    	 String name = (String) json.get("name");

		/*
		 * List<Country> list = new ArrayList<Country>(); Country c = new Country();
		 * c.setCapitalCity(capitalCity);
		 */
    	 mv.setViewName("countryDetails"); //TODO
    	 mv.addObject("countryList", countryList);
    	 return mv;
    }

	private RestTemplate getRestTemplate() {
		 RestTemplate restTemplate = new RestTemplate();
		 List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    	 MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    	 converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
    	 messageConverters.add(converter);
    	 restTemplate.setMessageConverters(messageConverters);
    	 return restTemplate;
	}
	
	
	
	
}
