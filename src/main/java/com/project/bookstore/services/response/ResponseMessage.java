package com.project.bookstore.services.response;

import lombok.Getter;


/**
 * An enumeration of response messages used in the application.
 * Each enum constant represents a specific response message.
 */
@Getter
public enum ResponseMessage {

    LOCALIZED_NOT_FOUND_MESSAGE("localized.not.found.message"),
    LOCALIZED_NOT_FOUND_MESSAGE_ERROR("localized.not.found.message.error"),
    DEFAULT("default");

    /**
     * The value representing the message.
     */
    private final String value;

    /**
     * Constructs a response message with the specified value.
     *
     * @param value The value representing the message.
     */
    ResponseMessage(String value) {
        this.value = value;
    }

}
