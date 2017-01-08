package ru.wallet.converting.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

/**
 * @author nivanov
 *         on 08.01.17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {
    @NotNull
    private Long id;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
