package br.com.deodato07.controllers;

import br.com.deodato07.exception.UnsupportedMathOperationException;
import br.com.deodato07.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathService mathService;

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) {
        validateNumbers(numberOne, numberTwo);
        return mathService.sum(numberOne, numberTwo);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo) {
        validateNumbers(numberOne, numberTwo);
        return mathService.subtraction(numberOne, numberTwo);
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable String numberOne, @PathVariable String numberTwo) {
        validateNumbers(numberOne, numberTwo);
        return mathService.multiplication(numberOne, numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable String numberOne, @PathVariable String numberTwo) {
        validateNumbers(numberOne, numberTwo);
        return mathService.division(numberOne, numberTwo);
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable String numberOne, @PathVariable String numberTwo) {
        validateNumbers(numberOne, numberTwo);
        return mathService.mean(numberOne, numberTwo);
    }

    @RequestMapping("/squareRoot/{numberOne}/{numberTwo}")
    public String squareRoot(@PathVariable String numberOne, @PathVariable String numberTwo) {
        validateNumbers(numberOne, numberTwo);
        return mathService.squareRoot(numberOne, numberTwo);
    }

    private void validateNumbers(String numberOne, String numberTwo) {
        if (!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
    }
}