package com.tnicacio.weatherorama.services.observers;

import com.tnicacio.weatherorama.entities.WeatherData;
import com.tnicacio.weatherorama.entities.WeatherStatistics;
import com.tnicacio.weatherorama.services.display.DisplayElement;
import com.tnicacio.weatherorama.services.subjects.Subject;
import com.tnicacio.weatherorama.services.subscribe.Subscriber;

public class StatisticsDisplay implements Observer, DisplayElement, Subscriber {

    private Subject weatherDataManager;
    private WeatherStatistics weatherStatistics;

    public StatisticsDisplay(Subject weatherDataManager) {
        this.weatherDataManager = weatherDataManager;
        weatherDataManager.registerObserver(this);
        weatherStatistics = new WeatherStatistics(-274f, -274f, 0f, 0);
    }

    @Override
    public void update(WeatherData weatherData) {
        weatherStatistics.setTempSum(weatherStatistics.getTempSum() + weatherData.getTemperature());
        weatherStatistics.setNumReadings(weatherStatistics.getNumReadings() + 1);

        if (weatherData.getTemperature() > weatherStatistics.getMaxTemp()) {
            weatherStatistics.setMaxTemp(weatherData.getTemperature());
        }

        if (weatherData.getTemperature() < weatherStatistics.getMinTemp()) {
            weatherStatistics.setMinTemp(weatherData.getTemperature());
        }

        if (weatherStatistics.getMinTemp() == -274f) {
            weatherStatistics.setMinTemp(weatherData.getTemperature());
        }

    }

    @Override
    public void display() {
        System.out.println("--- Weather Stats ---");
        System.out.println("Avg temp: "
                + weatherStatistics.getTempSum() / weatherStatistics.getNumReadings() + "°C");
        System.out.println("Min temp: " + weatherStatistics.getMinTemp() + "°C");
        System.out.println("Max temp: " + weatherStatistics.getMaxTemp() + "°C");
    }

    @Override
    public void subscribe() {
        weatherDataManager.registerObserver(this);
    }

    @Override
    public void unsubscribe() {
        weatherDataManager.removeObserver(this);
    }

    public Subject getWeatherDataManager() {
        return weatherDataManager;
    }

    public WeatherStatistics getWeatherStatistics() {
        return weatherStatistics;
    }

}
