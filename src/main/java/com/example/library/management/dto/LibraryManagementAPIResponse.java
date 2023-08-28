package com.example.library.management.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryManagementAPIResponse {

    private int statusCode;

    private String message;

    @JsonInclude(content = JsonInclude.Include.ALWAYS)
    private Object data;

    public LibraryManagementAPIResponse(int value, String userNotFound) {
    }
}
