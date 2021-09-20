package com.tnicacio.weatherorama.services.observers;

import com.tnicacio.weatherorama.entities.WeatherData;
import com.tnicacio.weatherorama.services.display.DisplayElement;
import com.tnicacio.weatherorama.services.subjects.WeatherDataManager;
import com.tnicacio.weatherorama.services.subscribe.Subscriber;

public class CurrentConditionsDisplay implements Observer, DisplayElement, Subscriber {

    private WeatherDataManager weatherDataManager;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherDataManager weatherDataManager) {
        this.weatherDataManager = weatherDataManager;
        weatherDataManager.registerObserver(this);
    }

    @Override
    public void update(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void display() {
        System.out.println("--- Current conditions ---");
        System.out.println("Temperature: " + weatherData.getTemperature() + "°C");
        System.out.println("Humidity: " + weatherData.getHumidity() + "%");
        System.out.println("Pressure: " + weatherData.getPressure() + "atm");
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

    public WeatherData getWeatherData() {
        return weatherData;
    }

}
