package br.com.deodato07.services;

import br.com.deodato07.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) {
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) {
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {
        Double divisor = convertToDouble(numberTwo);
        if (divisor == 0) throw new UnsupportedMathOperationException("Division by zero is not allowed!");
        return convertToDouble(numberOne) / divisor;
    }

    public Double mean(String numberOne, String numberTwo) {
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    public String squareRoot(String numberOne, String numberTwo) {
        double sqrtOne = Math.sqrt(convertToDouble(numberOne));
        double sqrtTwo = Math.sqrt(convertToDouble(numberTwo));
        return "Raiz de " + numberOne + ": " + sqrtOne + ", Raiz de " + numberTwo + ": " + sqrtTwo;
    }

    public boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replaceAll(",", ".");
        return Double.parseDouble(number);
    }
}
