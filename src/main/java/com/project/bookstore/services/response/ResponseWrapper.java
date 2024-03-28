package com.project.bookstore.services.response;

/**
 * A record representing a response wrapper containing a message and associated data. Used for the
 * {@link ResponseService} and for manipulation of the fields, if necessary.
 *
 * @param message The message for the response.
 * @param data The object that contains the data for the response.
 */
record ResponseWrapper<T>(String message, T data)  { }
