package com.example.datastoremicroservice.web.controller;

import com.example.datastoremicroservice.model.exception.SensorNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAdvice {

    @ExceptionHandler
    public String sensorNotFound(SensorNotFoundException e) {
        return "Sensor not found";
    }

    @ExceptionHandler
    public String server(Exception e) {
        e.printStackTrace();
        return "Something happened.";
    }
}
