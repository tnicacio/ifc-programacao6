package com.tnicacio.weatherorama.services.observers;

import com.tnicacio.weatherorama.entities.WeatherData;

public interface Observer {

    void update(WeatherData weatherData);

}
