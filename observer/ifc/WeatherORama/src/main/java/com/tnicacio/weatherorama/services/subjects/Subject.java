package com.tnicacio.weatherorama.services.subjects;

import com.tnicacio.weatherorama.services.observers.Observer;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
