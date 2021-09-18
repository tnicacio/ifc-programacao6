package com.tnicacio.weatherorama;

import com.tnicacio.weatherorama.entities.WeatherData;
import com.tnicacio.weatherorama.services.display.DisplayElement;
import com.tnicacio.weatherorama.services.observers.CurrentConditionsDisplay;
import com.tnicacio.weatherorama.services.observers.ForecastDisplay;
import com.tnicacio.weatherorama.services.observers.HeatIndexDisplay;
import com.tnicacio.weatherorama.services.observers.StatisticsDisplay;
import com.tnicacio.weatherorama.services.subjects.WeatherDataManager;

import java.util.List;

public class WeatherORamaApplication {

    public static void main(String... args) {
        WeatherDataManager dataManager = new WeatherDataManager();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(dataManager);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(dataManager);
        ForecastDisplay forecastDisplay = new ForecastDisplay(dataManager);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(dataManager);

        dataManager.setMeasurements(new WeatherData(36f, 65f, 1f));

        List<DisplayElement> displayElements = List.of(
                currentConditionsDisplay,
                statisticsDisplay,
                forecastDisplay,
                heatIndexDisplay);

        displayElements.forEach(DisplayElement::display);

        System.out.println("*** New Measurements ***");
        dataManager.setMeasurements(new WeatherData(36.5f, 70f, 0.9f));

        displayElements.forEach(DisplayElement::display);
    }

}
