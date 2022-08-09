package ru.arizara.ff14LogServ.rest.controller;

import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageController {

    @RequestMapping(value = "/image/{dir}/{img}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> setImageOneDir(@PathVariable("dir") String dir,
                                                 @PathVariable("img") String img) throws IOException {

        var imgFile = new ClassPathResource("image/"+dir+"/"+img+".png");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    @RequestMapping(value = "/image/{dir1}/{dir2}/{img}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> setImageTwoDir(@PathVariable("dir1") String di1,
                                                 @PathVariable("dir2") String dir2,
                                                 @PathVariable("img") String img) throws IOException {

        var imgFile = new ClassPathResource("image/"+di1+"/"+dir2+"/"+img+".png");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

}
