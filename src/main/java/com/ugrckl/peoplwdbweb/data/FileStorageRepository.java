package com.ugrckl.peoplwdbweb.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;


@Repository
public class FileStorageRepository {

    @Value("${STORAGE_FOLDER}")
    private String storageFolder;


    public void save(String originalFileName, InputStream inputStream){
        try {
            Path filePath = Path.of(storageFolder).resolve(originalFileName).normalize();
            Files.copy(inputStream, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Resource findByName(String filename){
        try {
            Path filePath = Path.of(storageFolder).resolve(filename).normalize();
            return new UrlResource(filePath.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}