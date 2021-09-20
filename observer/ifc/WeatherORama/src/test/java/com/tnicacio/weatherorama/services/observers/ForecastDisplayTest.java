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

class ForecastDisplayTest {

    private ForecastDisplay forecastDisplay;
    private WeatherDataManager weatherDataManager;

    @BeforeEach
    void setUp() {
        weatherDataManager = new WeatherDataManager();
        forecastDisplay = new ForecastDisplay(weatherDataManager);
    }

    @Nested
    class Constructor {

        @Test
        void shouldSetWeatherDataManager() {
            assertThat(forecastDisplay.getWeatherDataManager()).isSameAs(weatherDataManager);
        }

        @Test
        void shouldRegisterItselfAsAnObserver() {
            assertThat(weatherDataManager.getObservers()).hasSize(1).containsOnlyOnce(forecastDisplay);
        }

    }

    @Nested
    class Update {

        @Test
        void shouldSetCurrentPressure() {
            WeatherData data = new WeatherData(36f, 70f, 1.2f);
            forecastDisplay.update(data);
            assertThat(forecastDisplay.getCurrentPressure()).isEqualTo(1.2f);
        }

        @Test
        void shouldUpdateLastPressure() {
            WeatherData data = new WeatherData(36f, 70f, 1.1f);
            forecastDisplay.update(data);

            WeatherData newData = new WeatherData(36.5f, 72f, 1.0f);
            forecastDisplay.update(newData);

            assertThat(forecastDisplay.getLastPressure()).isEqualTo(1.1f);
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
        void shouldPrintTheWeatherIsImprovingWhenCurrentPressureIsGreaterThanLastPressure() {
            WeatherData data = new WeatherData(36f, 70f, 1.1f);
            forecastDisplay.update(data);

            WeatherData newData = new WeatherData(36f, 70f, 1.2f);
            forecastDisplay.update(newData);

            forecastDisplay.display();

            assertThat(outputStreamCaptor.toString().trim())
                    .startsWith("--- Forecast ---")
                    .containsOnlyOnce("The weather is improving!")
                    .endsWith("\\o/");
        }

        @Test
        void shouldPrintTheWeatherIsGettingWorseWhenCurrentPressureIsLessThanLastPressure() {
            WeatherData data = new WeatherData(36f, 70f, 1.1f);
            forecastDisplay.update(data);

            WeatherData newData = new WeatherData(36f, 70f, 1.0f);
            forecastDisplay.update(newData);

            forecastDisplay.display();

            assertThat(outputStreamCaptor.toString().trim())
                    .startsWith("--- Forecast ---")
                    .containsOnlyOnce("The weather is getting worse")
                    .endsWith(";/");
        }

        @Test
        void shouldPrintSameOldWhenCurrentPressureIsEqualToLastPressure() {
            WeatherData data = new WeatherData(36f, 70f, 1.0f);
            forecastDisplay.update(data);

            WeatherData newData = new WeatherData(37f, 71f, 1.0f);
            forecastDisplay.update(newData);

            forecastDisplay.display();

            assertThat(outputStreamCaptor.toString().trim())
                    .startsWith("--- Forecast ---")
                    .containsOnlyOnce("Same old");
        }

    }

    @Nested
    class Subscribe {

        @Test
        void shouldRegisterItselfAsAnObserver() {
            forecastDisplay.subscribe();
            assertThat(weatherDataManager.getObservers()).containsOnlyOnce(forecastDisplay);
        }

    }

    @Nested
    class Unsubscribe {

        @Test
        void shouldUnregisterItselfAsAnObserver() {
            forecastDisplay.unsubscribe();
            assertThat(weatherDataManager.getObservers()).doesNotContain(forecastDisplay);
        }

    }

}
