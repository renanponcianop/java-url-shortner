package com.project.urlshortner.models.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "urls")
public class Url {
    private ObjectId _id;
    private String url;
    private String prefix;
    private Integer access;
}
