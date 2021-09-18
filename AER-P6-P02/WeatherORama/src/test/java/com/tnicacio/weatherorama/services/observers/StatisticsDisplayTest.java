package com.tnicacio.weatherorama.services.observers;

import com.tnicacio.weatherorama.entities.WeatherData;
import com.tnicacio.weatherorama.services.subjects.WeatherDataManager;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsDisplayTest {

    private StatisticsDisplay statisticsDisplay;
    private WeatherDataManager weatherDataManager;

    @Nested
    class Constructor {

        @BeforeEach
        public void setUp() {
            weatherDataManager = new WeatherDataManager();
        }

        @Test
        void shouldSetWeatherDataManager() {
            statisticsDisplay = new StatisticsDisplay(weatherDataManager);
            assertThat(statisticsDisplay.getWeatherDataManager()).isSameAs(weatherDataManager);
        }

        @Test
        void shouldRegisterItselfAsAnObserver() {
            statisticsDisplay = new StatisticsDisplay(weatherDataManager);
            assertThat(weatherDataManager.getObservers()).hasSize(1).containsOnlyOnce(statisticsDisplay);
        }

        @Test
        void shouldInitializeWeatherStatistics() {
            statisticsDisplay = new StatisticsDisplay(weatherDataManager);
            assertThat(statisticsDisplay.getWeatherStatistics()).isNotNull();
        }

    }

    @Nested
    class Update {

        @BeforeEach
        public void setUp() {
            weatherDataManager = new WeatherDataManager();
            statisticsDisplay = new StatisticsDisplay(weatherDataManager);
        }

        @Test
        void shouldSetNewTemperatureSum() {
            WeatherData data = new WeatherData(36f, 70f, 1.2f);
            statisticsDisplay.update(data);

            WeatherData newData = new WeatherData(36.5f, 70f, 1.2f);
            statisticsDisplay.update(newData);

            assertThat(statisticsDisplay.getWeatherStatistics().getTempSum()).isEqualTo(72.5f);
        }

        @Test
        void shouldIncreaseTheNumberOfReadingsByOne() {
            WeatherData data = new WeatherData(36f, 70f, 1.2f);
            statisticsDisplay.update(data);

            assertThat(statisticsDisplay.getWeatherStatistics().getNumReadings()).isEqualTo(1);
        }

        @Test
        void shouldSetMaxTemperatureWhenNewTemperatureIsGreaterThanOldMaxTemperature() {
            WeatherData data = new WeatherData(36f, 70f, 1.2f);
            statisticsDisplay.update(data);

            WeatherData newData = new WeatherData(40f, 70f, 1.2f);
            statisticsDisplay.update(newData);

            assertThat(statisticsDisplay.getWeatherStatistics().getMaxTemp()).isEqualTo(40f);
        }

        @Test
        void shouldSetNewMinTemperatureWhenNewTemperatureIsLessThanOldMinTemperature() {
            WeatherData data = new WeatherData(36f, 70f, 1.2f);
            statisticsDisplay.update(data);

            WeatherData newData = new WeatherData(32f, 70f, 1.2f);
            statisticsDisplay.update(newData);

            assertThat(statisticsDisplay.getWeatherStatistics().getMinTemp()).isEqualTo(32f);
        }

        @Test
        void shouldSetNewTemperatureAsNewMinTemperatureWhenOldMinTemperatureIsLessThanZeroKelvin() {
            WeatherData newData = new WeatherData(32f, 70f, 1.2f);
            statisticsDisplay.update(newData);

            assertThat(statisticsDisplay.getWeatherStatistics().getMinTemp()).isEqualTo(32f);
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
            statisticsDisplay = new StatisticsDisplay(weatherDataManager);
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldPrintTheWeatherStats() {
            WeatherData data = new WeatherData(36f, 70f, 1.1f);
            statisticsDisplay.update(data);

            WeatherData newData = new WeatherData(36.5f, 71f, 0.9f);
            statisticsDisplay.update(newData);

            statisticsDisplay.display();

            assertThat(outputStreamCaptor.toString().trim())
                    .startsWith("--- Weather Stats ---")
                    .containsOnlyOnce("Avg temp: 36.25°C")
                    .containsOnlyOnce("Min temp: 36.0°C")
                    .containsOnlyOnce("Max temp: 36.5°C");
        }

    }

    @Nested
    class Subscribe {

        @BeforeEach
        public void setUp() {
            weatherDataManager = new WeatherDataManager();
            statisticsDisplay = new StatisticsDisplay(weatherDataManager);
        }

        @Test
        public void shouldRegisterItselfAsAnObserver() {
            statisticsDisplay.subscribe();
            assertThat(weatherDataManager.getObservers()).containsOnlyOnce(statisticsDisplay);
        }

    }

    @Nested
    class Unsubscribe {

        @BeforeEach
        public void setUp() {
            weatherDataManager = new WeatherDataManager();
            statisticsDisplay = new StatisticsDisplay(weatherDataManager);
        }

        @Test
        public void shouldUnregisterItselfAsAnObserver() {
            statisticsDisplay.unsubscribe();
            assertThat(weatherDataManager.getObservers()).doesNotContain(statisticsDisplay);
        }

    }

}