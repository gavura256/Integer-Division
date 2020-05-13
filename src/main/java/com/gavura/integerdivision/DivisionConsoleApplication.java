package com.gavura.integerdivision;

import com.gavura.integerdivision.provider.DivisionCalculator;
import com.gavura.integerdivision.provider.DivisionMathProvider;
import com.gavura.integerdivision.provider.DivisionMathProviderImp;
import com.gavura.integerdivision.provider.DivisionViewProvider;
import com.gavura.integerdivision.provider.DivisionViewProviderImp;
import com.gavura.integerdivision.reader.ConsoleReader;
import com.gavura.integerdivision.reader.ConsoleReaderImpl;
import com.gavura.integerdivision.validator.DivisionValidator;
import com.gavura.integerdivision.validator.DivisionValidatorImp;


public class DivisionConsoleApplication {
    public static void main(final String[] args) {
        final ConsoleReader consoleReader = new ConsoleReaderImpl();
        final DivisionValidator validator = new DivisionValidatorImp();
        final DivisionMathProvider mathProvider = new DivisionMathProviderImp();
        final DivisionViewProvider viewProvider = new DivisionViewProviderImp();
        final DivisionCalculator divisionCalculator =
                new DivisionCalculator(validator, mathProvider, viewProvider);

        System.out.println("Please input dividend");
        int divisor = consoleReader.readIntValue();

        System.out.println("Please input divisor");
        int division = consoleReader.readIntValue();

        final String result = divisionCalculator
                .calculateDivision(divisor, division);

        System.out.println(result);

        consoleReader.close();
    }
}
