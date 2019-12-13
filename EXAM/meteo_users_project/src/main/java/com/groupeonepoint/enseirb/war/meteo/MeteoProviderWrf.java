package com.groupeonepoint.enseirb.war.meteo;

import java.util.HashMap;
import java.util.Map;

@ModelWrf
public class MeteoProviderWrf implements MeteoProvider{
	private static Map<String, Double> temperatureDependingOnCities;

	public MeteoProviderWrf() {
		// TODO Auto-generated constructor stub
		temperatureDependingOnCities = new HashMap<>();
		temperatureDependingOnCities.put("BORDEAUX", 15.5);
		temperatureDependingOnCities.put("PARIS", 0.8);
		temperatureDependingOnCities.put("LYON", 8.0);
		temperatureDependingOnCities.put("MARSEILLE", 20.2);
		temperatureDependingOnCities.put("STRASBOURG", -30.9);
	}
	@Override
	public Double getTemperature(String city) {
		// TODO Auto-generated method stub
		Double temp = null;
		
		if (city != null) {
			city = city.toUpperCase();
			if (temperatureDependingOnCities.containsKey(city)) {
				temp = temperatureDependingOnCities.get(city);
			}
		}
		
		return temp;
	}

}
