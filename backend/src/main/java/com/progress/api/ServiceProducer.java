package com.progress.api;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.modelmapper.ModelMapper;

public class ServiceProducer {
    
    @Produces
    public ModelMapper produceAccount(InjectionPoint injectionPoint) {
        return new ModelMapper();
    }
}
