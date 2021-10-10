package com.tnicacio.weatherorama.services.subject;

import com.tnicacio.weatherorama.services.observer.Observer;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
