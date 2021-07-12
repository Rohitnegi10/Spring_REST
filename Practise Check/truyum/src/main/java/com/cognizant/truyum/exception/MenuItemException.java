package com.cognizant.truyum.exception;


public class MenuItemException extends RuntimeException{

    public MenuItemException(String message) {
        super(message);
    }

    public MenuItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuItemException(Throwable cause) {
        super(cause);
    }
}