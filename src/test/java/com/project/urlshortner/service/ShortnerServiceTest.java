package com.project.urlshortner.service;

import com.project.urlshortner.models.entities.Url;
import com.project.urlshortner.models.repository.UrlRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ShortnerServiceTest {

    @Mock
    UrlRepository urlRepository;

    @InjectMocks
    private ShortnerService service;

    @Test
    public void checkUrlCount(){
        Url url = new Url(null, "https://www.google.com.br", "google.png", 0);
        doReturn(url).when(urlRepository).findByPrefix("google.png");
        when(urlRepository.save(any(Url.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        service.findAndRedirect("google.png");
        service.findAndRedirect("google.png");
        service.findAndRedirect("google.png");
        service.findAndRedirect("google.png");
        Url urlCounted = service.findAndRedirect("google.png");
        Assert.assertEquals(java.util.Optional.of(5).get(),urlCounted.getAccess());
        service.findAndRedirect("google.png");
        service.findAndRedirect("google.png");
        service.findAndRedirect("google.png");
        service.findAndRedirect("google.png");
        urlCounted = service.findAndRedirect("google.png");
        Assert.assertEquals(java.util.Optional.of(10).get(),urlCounted.getAccess());
    }
}
