package com.tnicacio.weatherorama.services.subjects;

import com.tnicacio.weatherorama.entities.WeatherData;
import com.tnicacio.weatherorama.services.observers.Observer;

import java.util.HashSet;
import java.util.Set;

public class WeatherDataManager implements Subject {

    private Set<Observer> observers;
    private WeatherData weatherData;

    public WeatherDataManager() {
        observers = new HashSet<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(weatherData));
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(WeatherData weatherData) {
        this.weatherData = weatherData;
        measurementsChanged();
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

}
