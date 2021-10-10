package com.tnicacio.weatherorama.services.observer;

import com.tnicacio.weatherorama.entities.WeatherData;
import com.tnicacio.weatherorama.services.displayelement.DisplayElement;
import com.tnicacio.weatherorama.services.subject.WeatherDataManager;
import com.tnicacio.weatherorama.services.subscriber.Subscriber;

public class ForecastDisplay implements Observer, DisplayElement, Subscriber {

    private final WeatherDataManager weatherDataManager;
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

    public WeatherDataManager getWeatherDataManager() {
        return weatherDataManager;
    }

    public float getCurrentPressure() {
        return currentPressure;
    }

    public float getLastPressure() {
        return lastPressure;
    }

}
