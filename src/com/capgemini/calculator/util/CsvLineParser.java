package com.capgemini.calculator.util;

import com.capgemini.calculator.validation.Validation;

import java.util.ArrayList;
import java.util.List;

public class CsvLineParser {

    public static String getOperatorFromCsvLine(String line) {
        String[] fileAttributes = line.split(",");
        List<String> allowedOperands = new ArrayList<>(List.of("+", "-", "*", "/"));

        Validation.checkLength(fileAttributes);
        Validation.checkIfNull(fileAttributes);

        Validation.checkAllowedOperand(fileAttributes, allowedOperands);

        return fileAttributes[2];
    }


    public static int[] getNumbersFromCsvLine(String line) {
        int[] numbers;
        String[] fileAttributes = line.split(",");

        Validation.checkLength(fileAttributes);
        Validation.checkIfNull(fileAttributes);

        if (Validation.isNotNumeric(fileAttributes[0]) || Validation.isNotNumeric(fileAttributes[1])) {
            System.out.println("You should have introduced numbers");
            System.exit(0);

        }

        int firstNumber = Integer.parseInt(fileAttributes[0]);
        int secondNumber = Integer.parseInt(fileAttributes[1]);

        numbers = new int[]{firstNumber, secondNumber};

        return numbers;


    }


}
