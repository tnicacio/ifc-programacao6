package com.tnicacio.starfluentcoffee.beverage;

import com.tnicacio.starfluentcoffee.enums.Size;

public interface Beverage {

    String getDescription();

    double cost();

    Size getSize();

    void setSize(Size size);

}
