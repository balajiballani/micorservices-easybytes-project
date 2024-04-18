package com.easybytes.loans.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoansException extends RuntimeException{
   public LoansException(String msg){
        super(msg);
    }
}
