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

class HeatIndexDisplayTest {

    private HeatIndexDisplay heatIndexDisplay;
    private WeatherDataManager weatherDataManager;

    @Nested
    class Constructor {

        @BeforeEach
        public void setUp() {
            weatherDataManager = new WeatherDataManager();
        }

        @Test
        void shouldSetWeatherDataManager() {
            heatIndexDisplay = new HeatIndexDisplay(weatherDataManager);
            assertThat(heatIndexDisplay.getWeatherDataManager()).isSameAs(weatherDataManager);
        }

        @Test
        void shouldRegisterItselfAsAnObserver() {
            heatIndexDisplay = new HeatIndexDisplay(weatherDataManager);
            assertThat(weatherDataManager.getObservers()).hasSize(1).containsOnlyOnce(heatIndexDisplay);
        }

    }

    @Nested
    class Update {

        @BeforeEach
        public void setUp() {
            weatherDataManager = new WeatherDataManager();
            heatIndexDisplay = new HeatIndexDisplay(weatherDataManager);
        }

        @Test
        void shouldSetNewHeatIndex() {
            WeatherData data = new WeatherData(36f, 65f, 1.00f);
            heatIndexDisplay.update(data);

            assertThat(heatIndexDisplay.getHeatIndex()).isEqualTo(51.018593f);
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
            heatIndexDisplay = new HeatIndexDisplay(weatherDataManager);
        }

        @AfterEach
        public void tearDown() {
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

        @BeforeEach
        public void setUp() {
            weatherDataManager = new WeatherDataManager();
            heatIndexDisplay = new HeatIndexDisplay(weatherDataManager);
        }

        @Test
        public void shouldRegisterItselfAsAnObserver() {
            heatIndexDisplay.subscribe();
            assertThat(weatherDataManager.getObservers()).containsOnlyOnce(heatIndexDisplay);
        }

    }

    @Nested
    class Unsubscribe {

        @BeforeEach
        public void setUp() {
            weatherDataManager = new WeatherDataManager();
            heatIndexDisplay = new HeatIndexDisplay(weatherDataManager);
        }

        @Test
        public void shouldUnregisterItselfAsAnObserver() {
            heatIndexDisplay.unsubscribe();
            assertThat(weatherDataManager.getObservers()).doesNotContain(heatIndexDisplay);
        }

    }

}