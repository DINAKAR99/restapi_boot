package cgg.springboot.restapi.restapi.controllers;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cgg.springboot.restapi.restapi.helper.FileUploadHelper;

@Controller
public class FileUploadController {
    @Autowired
    private FileUploadHelper h1;

    @PostMapping("/uploadfile")
    public ResponseEntity<String> uploadFile(@RequestParam("filee") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(file.getName());

        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");

            }

            // if (!file.getContentType().equals("image/png")) {
            // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("images
            // must be png file");

            // }

            else {

                String ext2 = FilenameUtils.getExtension(file.getOriginalFilename());
                System.out.println(ext2);
                if (ext2.equals("png")) {
                    boolean uploadFilee = h1.uploadFilee(file);
                    if (uploadFilee) {
                        return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/")
                                .path(file.getOriginalFilename()).toUriString());
                    }

                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("images must be png  file");
                }
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file upload success");

    }
}
