package com.frontbackend.libraries.mockito.service;

public class ComplexBusinessLogicService {

    private final SimpleSummingService simpleSummingService;
    private final SimpleMultiplicationService simpleMultiplicationService;
    private final SimpleMailService simpleMailService;

    private ComplexBusinessLogicService(SimpleSummingService simpleSummingService, SimpleMultiplicationService simpleMultiplicationService,
            SimpleMailService simpleMailService) {
        this.simpleSummingService = simpleSummingService;
        this.simpleMultiplicationService = simpleMultiplicationService;
        this.simpleMailService = simpleMailService;
    }

    public void businessLogic(double a, double b) {
        // some initial business logic
        double newA = a * 1000 + 90;
        double newB = b * 800 + 100;

        double sum = simpleSummingService.sum(newA, newB);

        // some more business logic
        sum = sum + 80;
        double multiplication = simpleMultiplicationService.multiplication(sum, 10);

        simpleMailService.sendEmail(String.format("This is calculated value: %s", multiplication));
    }
}
