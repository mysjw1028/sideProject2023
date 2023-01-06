package site.metacoding.firstapp.domain.img;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    public String saveFile(MultipartFile file);
}
