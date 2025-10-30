package com.hex.trs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidIdException extends RuntimeException{
    private String message;
}
