package com.tnicacio.starbuzzcoffee2000.beverage;

import com.tnicacio.starbuzzcoffee2000.enums.Size;

public interface Beverage {

    String getDescription();
    double cost();
    void setSize(Size size);
    Size getSize();

}
