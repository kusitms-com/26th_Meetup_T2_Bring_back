package com.example.demo.src.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class StringArrayConverter implements AttributeConverter<List<Integer>, String> {

    private static final String SPLIT_CHAR = ",";

    @Override
    public String convertToDatabaseColumn(List<Integer> attribute) {
        return attribute.stream().map(String::valueOf).collect(Collectors.joining(SPLIT_CHAR));
    }

    @Override
    public List<Integer> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(SPLIT_CHAR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }
}