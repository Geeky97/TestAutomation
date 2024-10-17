package org.example.Services;

public class ValidationService {
    public void stringValidation(String value, String typeOfValue) {
        if (value != null && !value.isEmpty()) {
            System.out.println(typeOfValue + ": " + value);
        } else {
            System.out.println(typeOfValue + " Name is not visible!");
        }
    }

    public void integerValidation(Integer value, String typeOfValue, String typeOfValidation, Integer minimumValue, Integer maximumValue) {
        if (typeOfValidation.equals("minimum") || typeOfValidation.equals("both")) {
            minimumIntegerValidation(value, typeOfValue, minimumValue);
        }

        if (typeOfValidation.equals("maximum") || typeOfValidation.equals("both")) {
            maximumIntegerValidation(value, typeOfValue, maximumValue);
        }
    }

    public void minimumIntegerValidation(Integer value, String typeOfValue, Integer minimumValue) {
        if (value != null && value < minimumValue) {
            System.out.println(typeOfValue + " is valid: ");
        } else {
            System.out.println("Minimum value must be greater than " + minimumValue);
        }
    }

    public void maximumIntegerValidation(Integer value, String typeOfValue, Integer maximumValue) {
        if (value != null && value > maximumValue) {
            System.out.println(typeOfValue + " is valid: ");
        } else {
            System.out.println("Minimum value must be less than " + maximumValue);
        }
    }


}
