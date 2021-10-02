package com.tnicacio.starfluentcoffee.mapper;

public interface Mapper<T, U, P> {

    U map(T object, P parameters);

}
