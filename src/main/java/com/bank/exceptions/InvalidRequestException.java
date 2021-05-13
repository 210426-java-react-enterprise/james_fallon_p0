package com.bank.exceptions;


/**
 * An exception thrown when invalid data would otherwise be saved into the Database.
 */
public class InvalidRequestException extends RuntimeException{

    /**
     * Constructed with message stating why the exception was thrown.
     * @param message
     */
    public InvalidRequestException(String message){super(message);}
}
