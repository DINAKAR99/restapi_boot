package cgg.springboot.restapi.restapi.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    // public static final String upload_dir =
    // "C:\\TRAINING\\restapi\\src\\main\\resources\\static\\images";

    public FileUploadHelper() throws IOException {
    }

    public final String upload_dir = new ClassPathResource("/static/images/").getFile().getAbsolutePath();

    public boolean uploadFilee(MultipartFile f1) {
        boolean b1 = false;

        try {
            System.out.println(upload_dir);
            Files.copy(f1.getInputStream(), Paths.get(upload_dir + File.separator + f1.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);

            b1 = true;

            return b1;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            return b1;
        }

    }

}
