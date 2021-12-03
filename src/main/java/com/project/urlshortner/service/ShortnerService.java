package com.project.urlshortner.service;

import com.project.urlshortner.exceptions.DuplicatedUrlException;
import com.project.urlshortner.models.DTO.UrlDto;
import com.project.urlshortner.models.entities.Url;
import com.project.urlshortner.models.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ShortnerService {

    @Autowired
    UrlRepository urlRepository;

    public void insert(UrlDto urlDTO){
        Url urlAlreadyExist = urlRepository.findByPrefix(urlDTO.getPrefix());
        if (Objects.nonNull(urlAlreadyExist)){
            throw new DuplicatedUrlException("Cannot save URL because this prefix is already in use");
        }
        Url url = new Url(null, urlDTO.getUrl(),urlDTO.getPrefix(),0);
        urlRepository.save(url);
    }

    public Url findByPrefix(String prefix){
        return urlRepository.findByPrefix(prefix);
    }

    public Url findAndRedirect(String prefix){
        Url url = findByPrefix(prefix);
        if (Objects.isNull(url)){
            throw new DuplicatedUrlException("Cannot find prefix URL");
        }
        int currentAccessCount = url.getAccess();
        url.setAccess(currentAccessCount+1);
        Url urlCounted = urlRepository.save(url);
        return urlCounted;
    }
}
