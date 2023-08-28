package com.example.library.management.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtil {

    private CommonUtil(){
    }
    public static String convertToString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            return null;
        }
    }

    public static Long getTimeTaken(Long startTime) {
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
