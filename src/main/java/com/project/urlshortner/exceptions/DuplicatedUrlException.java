package com.project.urlshortner.exceptions;

public class DuplicatedUrlException extends RuntimeException{
    public DuplicatedUrlException(String msg) {
        super (msg);
    }

    public DuplicatedUrlException(String msg, Throwable cause){
        super(msg, cause);
    }
}
