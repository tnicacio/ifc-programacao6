package com.tnicacio.weatherorama.services.observer;

import com.tnicacio.weatherorama.entities.WeatherData;

public interface Observer {

    void update(WeatherData weatherData);

}
