package task3.util;

import task3.entity.MainEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface CsvParser<T extends MainEntity> {

    T parseString(String data);

    default List<T> parseStrings(List<String> data) {
        if (data != null) {
            return data.stream().map(this::parseString).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }
}
