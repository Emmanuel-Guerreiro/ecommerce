package com.example.ecommerce.ImageStorage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Scope("singleton")
public class IndireccionImageStorage {

    // Uploads an image and returns it url in the storage
    public String uploadImage(MultipartFile file) throws java.io.IOException {
        StringBuilder fileNames = new StringBuilder();

        // Se asegura que exista el directorio antes de guardar la imagen
        // Files.createDirectories(Paths.get("/tmp/images-taller"));

        Path fileNameAndPath = Paths.get("/tmp", file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());

        System.out.println("0000000000");
        Files.write(fileNameAndPath, file.getBytes());

        return fileNameAndPath.toString();
    }

}