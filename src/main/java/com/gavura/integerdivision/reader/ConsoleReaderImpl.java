package com.gavura.integerdivision.reader;

import java.util.Scanner;

public class ConsoleReaderImpl implements ConsoleReader {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int readIntValue() {
        return scanner.nextInt();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
