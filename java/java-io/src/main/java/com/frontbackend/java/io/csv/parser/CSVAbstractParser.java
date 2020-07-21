package com.frontbackend.java.io.csv.parser;

import com.frontbackend.java.io.csv.model.CSVField;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class CSVAbstractParser<T> {

    private final static int FIRST_LINE_INDEX = 0;

    private final static String COMMA_DELIMITER = ",";

    public List<T> parse(Path path, Class<T> cls) throws IOException {
        List<List<String>> lines = Files.readAllLines(path)
                                        .stream()
                                        .map(line -> Arrays.asList(line.split(COMMA_DELIMITER)))
                                        .collect(Collectors.toList());
        if (lines.size() > 0) {
            Map<Integer, Field> header = getHeaders(cls, lines.get(FIRST_LINE_INDEX));
            return lines.subList(FIRST_LINE_INDEX + 1, lines.size() - 1)
                        .stream()
                        .map(line -> getT(cls, header, line))
                        .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    private T getT(Class<T> cls, Map<Integer, Field> header, List<String> line) {
        try {
            T obj = cls.getDeclaredConstructor()
                       .newInstance();

            for (int index = 0; index < line.size(); index++) {
                Field field = header.get(index);
                String fieldName = field.getName();
                Optional<Method> setter = getSetterMethod(obj, fieldName);

                if (setter.isPresent()) {
                    Method setMethod = setter.get();
                    setMethod.invoke(obj, line.get(index));
                }
            }

            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private Optional<Method> getSetterMethod(T obj, String fieldName) {
        return Arrays.stream(obj.getClass()
                                .getDeclaredMethods())
                     .filter(method -> method.getName()
                                             .equals("set" + fieldName.substring(0, 1)
                                                                      .toUpperCase()
                                                     + fieldName.substring(1)))
                     .findFirst();
    }

    private Map<Integer, Field> getHeaders(Class<T> cls, List<String> firstLine) {
        final Map<Integer, Field> map = new HashMap<>();

        Stream.of(cls.getDeclaredFields())
              .filter(field -> field.getAnnotation(CSVField.class) != null)
              .forEach(field -> {
                  CSVField csvField = field.getAnnotation(CSVField.class);
                  String columnName = csvField.column()
                                              .getColumn()
                                              .trim();
                  int columnIndex = firstLine.indexOf(columnName);
                  map.put(columnIndex, field);
              });

        return map;
    }
}
