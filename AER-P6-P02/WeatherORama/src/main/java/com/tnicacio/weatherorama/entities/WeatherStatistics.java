package com.tnicacio.weatherorama.entities;

import java.util.Objects;

public class WeatherStatistics {

    private float maxTemp;
    private float minTemp;
    private float tempSum;
    private int numReadings;

    public WeatherStatistics() {
    }

    public WeatherStatistics(float maxTemp, float minTemp, float tempSum, int numReadings) {
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.tempSum = tempSum;
        this.numReadings = numReadings;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(float minTemp) {
        this.minTemp = minTemp;
    }

    public float getTempSum() {
        return tempSum;
    }

    public void setTempSum(float tempSum) {
        this.tempSum = tempSum;
    }

    public int getNumReadings() {
        return numReadings;
    }

    public void setNumReadings(int numReadings) {
        this.numReadings = numReadings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherStatistics that = (WeatherStatistics) o;
        return Float.compare(that.maxTemp, maxTemp) == 0 && Float.compare(that.minTemp, minTemp) == 0 && Float.compare(that.tempSum, tempSum) == 0 && numReadings == that.numReadings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxTemp, minTemp, tempSum, numReadings);
    }

}
