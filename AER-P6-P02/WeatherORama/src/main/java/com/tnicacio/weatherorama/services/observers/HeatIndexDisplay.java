package com.tnicacio.weatherorama.services.observers;

import com.tnicacio.weatherorama.entities.WeatherData;
import com.tnicacio.weatherorama.services.display.DisplayElement;
import com.tnicacio.weatherorama.services.subjects.WeatherDataManager;
import com.tnicacio.weatherorama.services.subscribe.Subscriber;

import java.math.BigDecimal;

public class HeatIndexDisplay implements Observer, DisplayElement, Subscriber {

    private WeatherDataManager weatherDataManager;
    private float heatIndex;

    public HeatIndexDisplay(WeatherDataManager weatherDataManager) {
        this.weatherDataManager = weatherDataManager;
        weatherDataManager.registerObserver(this);
        heatIndex = 0.0f;
    }

    @Override
    public void update(WeatherData weatherData) {
        heatIndex = calculateHeatIndexInCelsius(weatherData);
    }

    @Override
    public void display() {
        System.out.println("--- Heat Index ---");
        System.out.println(heatIndex + "°C");
    }

    @Override
    public void subscribe() {
        weatherDataManager.registerObserver(this);
    }

    @Override
    public void unsubscribe() {
        weatherDataManager.removeObserver(this);
    }

    /**
     * Returns Heat Index in °C.
     * The calculation is based on https://en.wikipedia.org/wiki/Heat_index
     * heat index formula with coefficients when the temperature is given in Celsius
     *
     * @param weatherData an weather data object containing temperature and pressure values
     * @return the heat index in °C
     */
    private float calculateHeatIndexInCelsius(WeatherData weatherData) {
        BigDecimal t = BigDecimal.valueOf(weatherData.getTemperature());
        BigDecimal rh = BigDecimal.valueOf(weatherData.getHumidity());

        BigDecimal c1 = new BigDecimal("-8.78469475556");
        BigDecimal c2 = new BigDecimal("1.61139411");
        BigDecimal c3 = new BigDecimal("2.33854883889");
        BigDecimal c4 = new BigDecimal("-0.14611605");
        BigDecimal c5 = new BigDecimal("-0.012308094");
        BigDecimal c6 = new BigDecimal("-0.0164248277778");
        BigDecimal c7 = new BigDecimal("0.002211732");
        BigDecimal c8 = new BigDecimal("0.00072546");
        BigDecimal c9 = new BigDecimal("-0.000003582");

        BigDecimal heatIndexInCelsius = (c1
                .add(c2.multiply(t))
                .add(c3.multiply(rh))
                .add(c4.multiply(t).multiply(rh))
                .add(c5.multiply(t.pow(2)))
                .add(c6.multiply(rh.pow(2)))
                .add(c7.multiply(t.pow(2)).multiply(rh))
                .add(c8.multiply(t).multiply(rh.pow(2)))
                .add(c9.multiply(t.pow(2)).multiply(rh.pow(2)))
        );

        return heatIndexInCelsius.floatValue();
    }

}
