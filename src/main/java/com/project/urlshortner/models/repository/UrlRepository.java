package com.project.urlshortner.models.repository;

import com.project.urlshortner.models.entities.Url;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<Url, ObjectId> {
    public Url findByPrefix(String prefix);
}
