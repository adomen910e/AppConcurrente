package com.groupeonepoint.enseirb.war.meteo;

import java.util.HashMap;
import java.util.Map;

@ModelGfs
public class MeteoProviderGfs implements MeteoProvider{
	private static Map<String, Double> temperatureDependingOnCities;

	public MeteoProviderGfs() {
		temperatureDependingOnCities = new HashMap<>();
		temperatureDependingOnCities.put("BORDEAUX", 25.5);
		temperatureDependingOnCities.put("PARIS", 10.8);
		temperatureDependingOnCities.put("LYON", 18.0);
		temperatureDependingOnCities.put("MARSEILLE", 30.2);
		temperatureDependingOnCities.put("STRASBOURG", -20.9);
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
