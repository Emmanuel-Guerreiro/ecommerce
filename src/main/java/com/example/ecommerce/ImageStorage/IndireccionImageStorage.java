package com.example.ecommerce.ImageStorage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Scope("singleton")
public class IndireccionImageStorage {

    // Uploads an image and returns it url in the storage
    public String uploadImage(MultipartFile archivo) throws Exception {
        try {
            System.out.println("--------------------------------------");
            String ruta = "/tmp";

            String originalFilename = archivo.getOriginalFilename();
            System.out.println("--------------------------------------");
            if (originalFilename == null) {
                System.out.println("--------------------------------------");

                throw new Exception();
            }
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

            int index = originalFilename.indexOf(".");
            String extension = "";
            extension = "." + originalFilename.substring(index + 1);
            String nombreFoto = Calendar.getInstance().getTimeInMillis() + extension;
            Path rutaAbsoluta = Paths.get(ruta + nombreFoto);
            Files.write(rutaAbsoluta, archivo.getBytes());

            return nombreFoto;

        } catch (Exception e) {
            throw new Exception();
        }
    }

}