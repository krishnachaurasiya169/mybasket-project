package com.mybasket.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BadExceptionDto {
    private String message;
    private int status;
    private  Long timestamp;
}
