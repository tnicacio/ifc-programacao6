package com.tnicacio.weatherorama.services.observers;

import com.tnicacio.weatherorama.entities.WeatherData;
import com.tnicacio.weatherorama.services.display.DisplayElement;
import com.tnicacio.weatherorama.services.subjects.WeatherDataManager;
import com.tnicacio.weatherorama.services.subscribe.Subscriber;

public class ForecastDisplay implements Observer, DisplayElement, Subscriber {

    private WeatherDataManager weatherDataManager;
    private float currentPressure;
    private float lastPressure;

    public ForecastDisplay(WeatherDataManager weatherDataManager) {
        this.weatherDataManager = weatherDataManager;
        weatherDataManager.registerObserver(this);
    }

    @Override
    public void update(WeatherData weatherData) {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();
    }

    @Override
    public void display() {
        System.out.println("--- Forecast ---");
        if (currentPressure > lastPressure) {
            System.out.println("The weather is improving! \\o/");
        } else if (currentPressure < lastPressure) {
            System.out.println("The weather is getting worse ;/");
        } else {
            System.out.println("Same old");
        }
    }

    @Override
    public void subscribe() {
        weatherDataManager.registerObserver(this);
    }

    @Override
    public void unsubscribe() {
        weatherDataManager.removeObserver(this);
    }

}
