package task3.util.impl;

import org.springframework.stereotype.Component;
import task3.exception.CsvFileNotFoundException;
import task3.util.FileReader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CsvFileReader implements FileReader {

    @Override
    public List<String> readStrings(String filename) throws CsvFileNotFoundException {
        Path csvPath = Paths.get(filename);
        if (!csvPath.toFile().exists()) {
            throw new CsvFileNotFoundException("File \"" + filename + "\" not found.");
        }

        try (Stream<String> stream = Files.lines(csvPath, StandardCharsets.UTF_8)) {
            return stream.collect(Collectors.toList());
        }
        catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
