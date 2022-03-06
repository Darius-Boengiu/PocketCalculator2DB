package com.capgemini.calculator.validation;

import java.util.List;
import java.util.Objects;

public class Validation {
    public static boolean isNotNumeric(String stringToNumber) {
        try {
            Integer.parseInt(stringToNumber);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public static void checkIfNull(String[] fileAttributes) {
        for (String attribute : fileAttributes) {
            if (Objects.isNull(attribute)) {
                System.exit(0);
            }
        }
    }

    public static void checkLength(String[] fileAttributes) {
        if (fileAttributes.length != 3) {
            System.out.println("Invalid file");
            System.exit(0);
        }
    }

    public static void checkAllowedOperand(String[] fileAttributes, List<String> allowedOperands) {
        if (!allowedOperands.contains(fileAttributes[2])) {
            System.out.println("You should enter one of these operands {+, -, *, /}");
            System.exit(0);
        }
    }
}
