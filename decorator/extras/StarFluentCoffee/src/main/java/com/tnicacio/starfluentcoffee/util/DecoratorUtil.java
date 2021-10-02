package com.tnicacio.starfluentcoffee.util;

public interface DecoratorUtil<T, U> {

    T decorate(T objectToDecorate, U decorateWith);

}
