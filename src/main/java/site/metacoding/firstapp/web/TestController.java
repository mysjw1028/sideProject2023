package site.metacoding.firstapp.web;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import site.metacoding.firstapp.web.dto.CMRespDto;

@Controller
public class TestController<ImgDto> {
    @PostMapping(value = "/resume/save", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE })
    public @ResponseBody CMRespDto<?> create(@RequestPart("file") MultipartFile file,
            @RequestPart("imgDto") ImgDto imgDto) throws Exception {
        int pos = file.getOriginalFilename().lastIndexOf(".");
        String extension = file.getOriginalFilename().substring(pos + 1);
        String filePath = "C:\\\\temp\\\\img\\\\";
        String imgSaveName = UUID.randomUUID().toString();
        String imgName = imgSaveName + "." + extension;

        File makeFileFolder = new File(filePath);
        if (!makeFileFolder.exists()) {
            if (!makeFileFolder.mkdir()) {
                throw new Exception("File.mkdir():Fail.");
            }
        }

        File dest = new File(filePath, imgName);
        try {
            Files.copy(file.getInputStream(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

     //   imgDto.setResumePhoto(imgName);
    //    resumeService.이력서저장(resume);
        return new CMRespDto<>(1, "업로드 성공", imgName);
    }
}
