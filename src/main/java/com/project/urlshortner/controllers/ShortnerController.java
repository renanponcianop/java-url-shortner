package com.project.urlshortner.controllers;

import com.google.zxing.WriterException;
import com.project.urlshortner.models.DTO.UrlDto;
import com.project.urlshortner.models.entities.Url;
import com.project.urlshortner.service.ShortnerService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/shortner")
public class ShortnerController {

    @Autowired
    ShortnerService service;

    @PostMapping
    public ResponseEntity<?> shortUrl(@Valid @RequestBody UrlDto url) throws IOException, WriterException {
        service.insert(url);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getURLData(@RequestParam("prefix") String prefix){
        Url url = service.findByPrefix(prefix);
        UrlDto urlDto = new UrlDto(url);
        return ResponseEntity.ok().body(urlDto);
    }

    @ResponseBody
    @RequestMapping(value = "/qrcode", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getURLQRCode(@RequestParam("prefix") String prefix) throws IOException {
        BufferedImage bImage = ImageIO.read(new File("QRCode/"+prefix+".png"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "png", bos );
        byte [] data = bos.toByteArray();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(data);
    }
}
