package com.project.bookstore.services.response;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Locale;

import static com.project.bookstore.services.response.ResponseMessage.LOCALIZED_NOT_FOUND_MESSAGE;
import static com.project.bookstore.services.response.ResponseMessage.LOCALIZED_NOT_FOUND_MESSAGE_ERROR;

/**
 * This class is a service used as a response for the controllers. It also uses {@link MessageSource} to localize the
 * messages. The keys for the messages are set as static fields.
 */
@Service
public class ResponseService {

    /**
     * Field used for dependency injection for the {@link MessageSource}.
     */
    private final MessageSource messageSource;

    /**
     * Initializes the messageSource field using dependency injection.
     * @param messageSource Dependency injection parameter.
     */
    public ResponseService(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    /**
     * Creates a response with a message, which will be localized, a body and a http status.
     * @param responseMessage The response message to be sent, the enumerator {@link ResponseMessage} is used because
     *                        the localization is based on keys.
     * @param body The body of the response, which is converted to a JSON object.
     * @param status The http status of the response.
     * @return The response entity built.
     */
    public <T> @NotNull ResponseEntity<Object> localizedResponse(@NotNull ResponseMessage responseMessage,
                                                                 T body,
                                                                 HttpStatus status) {
        String localizedMessage = getLocalizedMessage(responseMessage.getValue());
        return ResponseEntity.status(status).body(new ResponseWrapper<>(localizedMessage, body));
    }

    /**
     * Gets the localization, based on the code provided.
     * <p><p><p>
     * The localized text is set in the bundle <b>messages</b> defined on the {@link MessageConfig} class.
     * The file <b>messages.properties</b> is where the base messages should be, usually in english, for the remaining
     * files, they should be name <b>messages_{locale}.properties</b>, for example, for a portuguese localization file
     * the name should be <b>messages_pt_PT.properties</b>.
     * <p><p><p>
     * For the keys, they should be set like this (e.g.):
     * <p>success.message=Operation successful.</p>
     * <p>error.invalid.input=Invalid input provided.</p>
     * <p>information.not.found=Information not found.</p>
     * <p><p><p>
     * In the localized files the key stays the same, but the right side you define the translation.
     * @param messageCode The code of the message.
     * @return The localized message, based on the locale and the message code.
     */
    private String getLocalizedMessage(String messageCode){
        try{
            String localizedMessage = messageSource.getMessage(messageCode, null, Locale.getDefault());

            if(messageCode.equals(localizedMessage)){

                String errorLocalizedMessage = messageSource.getMessage(LOCALIZED_NOT_FOUND_MESSAGE.getValue(),
                        null,
                        Locale.getDefault());

                return STR."\"\{messageCode}\" \{errorLocalizedMessage}";
            }

            return localizedMessage;

        } catch (NoSuchMessageException e){

            String errorLocalizedMessage = messageSource.getMessage(LOCALIZED_NOT_FOUND_MESSAGE.getValue(),
                    null,
                    Locale.getDefault());

            String errorLocalizedMessageError = messageSource.getMessage(LOCALIZED_NOT_FOUND_MESSAGE_ERROR.getValue(),
                    null,
                    Locale.getDefault());

            return STR."\"\{messageCode}\" \{errorLocalizedMessage} \{errorLocalizedMessageError} -> \"\{e.getMessage()}\"";
        }
    }
}
