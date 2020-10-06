package task3.exception;

import java.io.FileNotFoundException;

public class CsvFileNotFoundException extends FileNotFoundException {

    public CsvFileNotFoundException() {
        super();
    }

    public CsvFileNotFoundException(String s) {
        super(s);
    }
}
