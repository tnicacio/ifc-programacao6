package com.tnicacio.weatherorama.services.observer;

import com.tnicacio.weatherorama.entities.WeatherData;
import com.tnicacio.weatherorama.services.subject.WeatherDataManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class HeatIndexDisplayTest {

    private HeatIndexDisplay heatIndexDisplay;
    private WeatherDataManager weatherDataManager;

    @BeforeEach
    void setUp() {
        weatherDataManager = new WeatherDataManager();
        heatIndexDisplay = new HeatIndexDisplay(weatherDataManager);
    }

    @Nested
    class Constructor {

        @Test
        void shouldSetWeatherDataManager() {
            assertThat(heatIndexDisplay.getWeatherDataManager()).isSameAs(weatherDataManager);
        }

        @Test
        void shouldRegisterItselfAsAnObserver() {
            assertThat(weatherDataManager.getObservers()).hasSize(1).containsOnlyOnce(heatIndexDisplay);
        }

    }

    @Nested
    class Update {

        @Test
        void shouldSetNewHeatIndex() {
            heatIndexDisplay.update(new WeatherData(36f, 65f, 1.00f));
            assertThat(heatIndexDisplay.getHeatIndex()).isEqualTo(51.018593f);
        }

        @Test
        void shouldReturnIndependentCoefficientWhenTemperatureAndHumidityAreEqualToZero() {
            heatIndexDisplay.update(new WeatherData(0f, 0f, 1.00f));
            assertThat(heatIndexDisplay.getHeatIndex()).isEqualTo(-8.784695f);
        }

    }

    @Nested
    class Display {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @AfterEach
        void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldPrintTheHeatIndex() {
            WeatherData data = new WeatherData(36f, 65f, 1.0f);
            heatIndexDisplay.update(data);

            heatIndexDisplay.display();

            assertThat(outputStreamCaptor.toString().trim())
                    .startsWith("--- Heat Index ---")
                    .containsOnlyOnce("51.018593°C");
        }

    }

    @Nested
    class Subscribe {

        @Test
        void shouldRegisterItselfAsAnObserver() {
            heatIndexDisplay.subscribe();
            assertThat(weatherDataManager.getObservers()).containsOnlyOnce(heatIndexDisplay);
        }

    }

    @Nested
    class Unsubscribe {

        @Test
        void shouldUnregisterItselfAsAnObserver() {
            heatIndexDisplay.unsubscribe();
            assertThat(weatherDataManager.getObservers()).doesNotContain(heatIndexDisplay);
        }

    }

}
