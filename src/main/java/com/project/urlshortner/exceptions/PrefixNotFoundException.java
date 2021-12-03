package com.project.urlshortner.exceptions;

public class PrefixNotFoundException extends RuntimeException{
    public PrefixNotFoundException(String msg) {
        super (msg);
    }

    public PrefixNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
