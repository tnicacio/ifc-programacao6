package com.tnicacio.weatherorama.services.observers;

import com.tnicacio.weatherorama.entities.WeatherData;
import com.tnicacio.weatherorama.services.subjects.WeatherDataManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class CurrentConditionsDisplayTest {

    private CurrentConditionsDisplay currentConditionsDisplay;
    private WeatherDataManager weatherDataManager;

    @Nested
    class Constructor {

        @BeforeEach
        public void setUp() {
            weatherDataManager = new WeatherDataManager();
        }

        @Test
        void shouldSetWeatherDataManager() {
            currentConditionsDisplay = new CurrentConditionsDisplay(weatherDataManager);
            assertThat(currentConditionsDisplay.getWeatherDataManager()).isSameAs(weatherDataManager);
        }

        @Test
        void shouldRegisterItselfAsAnObserver() {
            currentConditionsDisplay = new CurrentConditionsDisplay(weatherDataManager);
            assertThat(weatherDataManager.getObservers()).hasSize(1).containsOnlyOnce(currentConditionsDisplay);
        }

    }

    @Nested
    class Update {

        @BeforeEach
        public void setUp() {
            weatherDataManager = new WeatherDataManager();
            currentConditionsDisplay = new CurrentConditionsDisplay(weatherDataManager);
        }

        @Test
        void shouldSetNewWeatherData() {
            WeatherData data = new WeatherData(36f, 70f, 1.1f);

            currentConditionsDisplay.update(data);

            assertThat(currentConditionsDisplay.getWeatherData()).isSameAs(data);
        }

    }

    @Nested
    class Display {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            weatherDataManager = new WeatherDataManager();
            currentConditionsDisplay = new CurrentConditionsDisplay(weatherDataManager);
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldPrintCurrentConditions() {
            WeatherData data = new WeatherData(36f, 70f, 1.1f);
            currentConditionsDisplay.update(data);

            currentConditionsDisplay.display();

            assertThat(outputStreamCaptor.toString().trim())
                    .startsWith("--- Current conditions ---")
                    .containsOnlyOnce("Temperature: 36.0°C")
                    .containsOnlyOnce("Humidity: 70.0%")
                    .endsWith("Pressure: 1.1atm");
        }

    }

    @Nested
    class Subscribe {

        @BeforeEach
        public void setUp() {
            weatherDataManager = new WeatherDataManager();
            currentConditionsDisplay = new CurrentConditionsDisplay(weatherDataManager);
        }

        @Test
        public void shouldRegisterItselfAsAnObserver() {
            currentConditionsDisplay.subscribe();
            assertThat(weatherDataManager.getObservers()).containsOnlyOnce(currentConditionsDisplay);
        }

    }

    @Nested
    class Unsubscribe {

        @BeforeEach
        public void setUp() {
            weatherDataManager = new WeatherDataManager();
            currentConditionsDisplay = new CurrentConditionsDisplay(weatherDataManager);
        }

        @Test
        public void shouldUnregisterItselfAsAnObserver() {
            currentConditionsDisplay.unsubscribe();
            assertThat(weatherDataManager.getObservers()).doesNotContain(currentConditionsDisplay);
        }

    }

}