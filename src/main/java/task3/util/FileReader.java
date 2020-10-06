package task3.util;

import task3.exception.CsvFileNotFoundException;

import java.util.List;

public interface FileReader {

    List<String> readStrings(String filename) throws CsvFileNotFoundException;
}
