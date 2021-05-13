package com.bank.exceptions;


/**
 * An exception thrown when unique values would otherwise be duplicated.
 */
public class ResourcePersistenceException extends RuntimeException {

    /**
     * Constructed with message stating why the exception was thrown.
     * @param message
     */
    public ResourcePersistenceException(String message){super(message);}
}
