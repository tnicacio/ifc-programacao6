package com.tnicacio.weatherorama;

import com.tnicacio.weatherorama.entities.WeatherData;
import com.tnicacio.weatherorama.services.displayelement.DisplayElement;
import com.tnicacio.weatherorama.services.observer.CurrentConditionsDisplay;
import com.tnicacio.weatherorama.services.observer.ForecastDisplay;
import com.tnicacio.weatherorama.services.observer.HeatIndexDisplay;
import com.tnicacio.weatherorama.services.observer.StatisticsDisplay;
import com.tnicacio.weatherorama.services.subject.WeatherDataManager;

import java.util.List;

public class WeatherORamaApplication {

    public static void main(String... args) {
        WeatherDataManager dataManager = new WeatherDataManager();

        DisplayElement currentConditionsDisplay = new CurrentConditionsDisplay(dataManager);
        DisplayElement statisticsDisplay = new StatisticsDisplay(dataManager);
        DisplayElement forecastDisplay = new ForecastDisplay(dataManager);
        DisplayElement heatIndexDisplay = new HeatIndexDisplay(dataManager);

        dataManager.setMeasurements(new WeatherData(36f, 65f, 1f));

        List<DisplayElement> displayElements = List.of(
                currentConditionsDisplay,
                statisticsDisplay,
                forecastDisplay,
                heatIndexDisplay);

        displayElements.forEach(DisplayElement::display);
    }

}
