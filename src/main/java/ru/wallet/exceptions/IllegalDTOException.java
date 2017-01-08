package ru.wallet.exceptions;

import org.springframework.beans.factory.annotation.Value;

import java.text.MessageFormat;

/**
 * @author nivanov
 *         on 08.01.17.
 */

public class IllegalDTOException extends IllegalArgumentException {
    @Value("illegal.dto.exception.message")
    private static String messagePattern;
    private String dtoType;
    private String field;

    public IllegalDTOException(String dtoType, String field){
        super(MessageFormat.format(messagePattern, dtoType, field));
        this.dtoType = dtoType;
        this.field = field;
    }

    public String getDtoType() {
        return dtoType;
    }

    public String getField() {
        return field;
    }
}
