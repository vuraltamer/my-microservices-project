package com.project.util;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ErrorMessages {

    private static final String RESPONSE_MESSAGE_TITLE = "response-message";

    public static MultiValueMap<String, String> createMesagge(String messageContent) {

        MultiValueMap<String, String> message = new LinkedMultiValueMap<>();
        message.set(RESPONSE_MESSAGE_TITLE, messageContent);

        return  message;
    }

    public static MultiValueMap<String, String> createMesagge(String entityName, String column, String messageContent) {

        MultiValueMap<String, String> message = new LinkedMultiValueMap<>();
        message.set(RESPONSE_MESSAGE_TITLE, entityName + " : " + column + " : " + messageContent);

        return  message;
    }

    public static MultiValueMap<String, String> createMesagge(ConstraintViolation<?> constraintViolation) {

        String entityName = BaseUtil.lastDotSubStringItem(constraintViolation.getRootBeanClass().getName());
        String columnName = constraintViolation.getPropertyPath().toString();
        String messageContent = constraintViolation.getMessage();

        MultiValueMap<String, String> message = new LinkedMultiValueMap<>();
        message.set(RESPONSE_MESSAGE_TITLE, "{" + entityName + "} " + " : " + columnName + " : " + messageContent);

        return  message;
    }

    public static String ENTITY_NOT_FOUND = "Entity is not found!";
}
