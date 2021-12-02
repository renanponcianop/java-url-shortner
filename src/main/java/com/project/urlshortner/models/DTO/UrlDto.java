package com.project.urlshortner.models.DTO;

import com.project.urlshortner.models.entities.Url;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UrlDto {
    @NotBlank(message = "This field cannot be null")
    private String url;
    @NotBlank(message = "This field cannot be null")
    private String prefix;
    @Min(value = 0, message = "Access should not be less than 0")
    @Max(value = 0, message = "Access should not be greater than 0")
    private Integer access;

    public UrlDto(Url url) {
        this.access = url.getAccess();
        this.prefix = url.getPrefix();
        this.url = url.getUrl();
    }
}
