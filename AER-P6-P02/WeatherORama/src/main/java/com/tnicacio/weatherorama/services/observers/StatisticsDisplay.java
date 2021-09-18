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
        initializeWeatherStatistics();
    }

    @Override
    public void update(WeatherData weatherData) {
        weatherStatistics.setTempSum(weatherStatistics.getTempSum() + weatherData.getTemperature());
        weatherStatistics.setNumReadings(weatherStatistics.getNumReadings() + 1);
        weatherStatistics.setMaxTemp(Math.max(weatherStatistics.getMaxTemp(), weatherData.getTemperature()));

        if (weatherStatistics.getMinTemp() == 0) {
            weatherStatistics.setMinTemp(weatherStatistics.getMaxTemp());
        }
        weatherStatistics.setMinTemp(Math.min(weatherStatistics.getMinTemp(), weatherData.getTemperature()));
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

    private void initializeWeatherStatistics() {
        weatherStatistics = new WeatherStatistics();
        weatherStatistics.setMaxTemp(0.0f);
        weatherStatistics.setMinTemp(0.0f);
        weatherStatistics.setNumReadings(0);
    }

}
