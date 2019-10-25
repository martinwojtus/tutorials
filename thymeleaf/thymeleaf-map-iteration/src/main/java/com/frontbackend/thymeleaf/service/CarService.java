package com.frontbackend.thymeleaf.service;

import com.frontbackend.thymeleaf.model.Car;
import com.frontbackend.thymeleaf.model.Color;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Service
public class CarService {

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public List<Car> randomCars() throws ParseException {
        return Arrays.asList(Car.builder()
                                .color(Color.RED)
                                .model("VW")
                                .vin("2A4GF48466R791008")
                                .productionDate(formatter.parse("2019-01-10"))
                                .build(),
                Car.builder()
                   .vin("WVWRH63B61E166480")
                   .productionDate(formatter.parse("2017-12-19"))
                   .color(Color.BLACK)
                   .model("Ford")
                   .build(),
                Car.builder()
                   .vin("2GCDC14H9F1156453")
                   .productionDate(formatter.parse("2014-10-19"))
                   .color(Color.BLACK)
                   .model("Suzuki")
                   .build(),
                Car.builder()
                   .vin("1FTWW33Y46EA25751")
                   .productionDate(formatter.parse("2019-03-18"))
                   .color(Color.BLACK)
                   .model("Kia")
                   .build(),
                Car.builder()
                   .vin("1GNDT13W3W2168654")
                   .productionDate(formatter.parse("2017-12-19"))
                   .color(Color.WHITE)
                   .model("Tesla")
                   .build(),
                Car.builder()
                   .vin("1FMCU5K3XCKA67800")
                   .productionDate(formatter.parse("2019-09-23"))
                   .color(Color.WHITE)
                   .model("Opel")
                   .build());
    }
}
