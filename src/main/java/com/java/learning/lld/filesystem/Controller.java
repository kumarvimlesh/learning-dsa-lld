package com.java.learning.lld.filesystem;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/v1/filesystem")
public class Controller {
    private final String FILES_DIRECTORY = "/home/bluepi/vimlesh/projects/learning-dsa-lld/src/main/java/com/java/learning//lld/filesystem/files";

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        Path uploadFolder = Path.of(FILES_DIRECTORY);
        Path filePath = uploadFolder.resolve(fileName);
        if(!Files.exists(uploadFolder)){
            Files.createDirectories(uploadFolder);
        }
        Files.copy(file.getInputStream(), filePath);
        return fileName + " uploaded successfully";
    }

    @GetMapping("/download")
    public String getFileNames(@RequestParam(value = "file", defaultValue = "") String fileName, HttpServletResponse response) throws IOException {
        if(Files.exists(Path.of(FILES_DIRECTORY+"/"+fileName))){
            Files.copy(Path.of(FILES_DIRECTORY+"/"+fileName), response.getOutputStream());
            return "Successfully downloaded";
        }
        return "File not found";
    }
}
