package com.tnicacio.weatherorama.services.subjects;

import com.tnicacio.weatherorama.entities.WeatherData;
import com.tnicacio.weatherorama.services.observers.Observer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WeatherDataManagerTest {

    @Nested
    class Constructor {

        @Test
        void setOfObserversShouldNotBeNull() {
            WeatherDataManager weatherDataManager = new WeatherDataManager();
            assertThat(weatherDataManager.getObservers()).isNotNull();
        }

        @Test
        void setOfObserversShouldBeEmpty() {
            WeatherDataManager weatherDataManager = new WeatherDataManager();
            assertThat(weatherDataManager.getObservers()).isEmpty();
        }

    }

    @Nested
    class RegisterObserver {

        @Test
        void shouldAddObserverToTheSetOfObservers() {
            WeatherDataManager weatherDataManager = new WeatherDataManager();
            Observer mockObserver = w -> {
            };

            weatherDataManager.registerObserver(mockObserver);

            assertThat(weatherDataManager.getObservers()).containsOnlyOnce(mockObserver);
        }

    }

    @Nested
    class UnregisterObserver {

        @Test
        void shouldRemoveObserverFromTheSetOfObservers() {
            WeatherDataManager weatherDataManager = new WeatherDataManager();
            Observer mockObserver = w -> {
            };

            weatherDataManager.registerObserver(mockObserver);
            weatherDataManager.removeObserver(mockObserver);

            assertThat(weatherDataManager.getObservers()).doesNotContain(mockObserver);
        }

    }

    @Nested
    class NotifyObservers {

        private Set<Observer> observers;
        private WeatherDataManager weatherDataManager;

        @BeforeEach
        void setUp() {
            weatherDataManager = new WeatherDataManager();
            observers = Set.of(mock(Observer.class),
                    mock(Observer.class),
                    mock(Observer.class));
            observers.forEach(weatherDataManager::registerObserver);
        }

        @Test
        void shouldCallUpdateMethodOfAllObservers() {
            weatherDataManager.notifyObservers();

            observers.forEach(observer ->
                    verify(observer, only())
                            .update(weatherDataManager.getWeatherData()));
        }

        @Test
        void shouldCallUpdateMethodOnlyOnceForEachObserver() {
            weatherDataManager.notifyObservers();

            observers.forEach(observer ->
                    verify(observer, times(1))
                            .update(weatherDataManager.getWeatherData()));
        }

    }

    @Nested
    class MeasurementsChanged {

        @Test
        void shouldCallNotifyObserversOnlyOnce() {
            WeatherDataManager weatherDataManager = spy(WeatherDataManager.class);

            weatherDataManager.measurementsChanged();

            verify(weatherDataManager, times(1)).notifyObservers();
        }

    }

    @Nested
    class SetMeasurements {

        @Test
        void shouldSetWeatherData() {
            WeatherDataManager weatherDataManager = new WeatherDataManager();
            WeatherData weatherData = new WeatherData(36f, 70f, 1.05f);

            weatherDataManager.setMeasurements(weatherData);

            assertThat(weatherDataManager.getWeatherData()).isEqualTo(weatherData);
        }

        @Test
        void shouldCallMethodMeasurementsChanged() {
            WeatherDataManager weatherDataManager = spy(WeatherDataManager.class);
            WeatherData weatherData = new WeatherData(36f, 70f, 1.05f);

            weatherDataManager.setMeasurements(weatherData);

            verify(weatherDataManager, times(1)).measurementsChanged();
        }

    }

}