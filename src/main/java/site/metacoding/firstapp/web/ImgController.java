package site.metacoding.firstapp.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.img.Img;
import site.metacoding.firstapp.domain.img.ImgDto;
import site.metacoding.firstapp.domain.post.Post;
import site.metacoding.firstapp.domain.post.PostDao;
import site.metacoding.firstapp.service.ImgService;
import site.metacoding.firstapp.web.dto.CMRespDto;
import site.metacoding.firstapp.web.dto.post.PostReadDto;
import site.metacoding.firstapp.web.dto.post.PostWriteDto;

@RequiredArgsConstructor
@Controller
public class ImgController {

    private final ImgService imgService;
    private final PostDao postDao;

    @GetMapping("/test")
    public String main() {
        return "index";
    }

    @GetMapping("/imgtest/imgView/{userId}") // 나중에 테스트
    public String imgView(@PathVariable Integer id, Model model) {
        Img img = imgService.아이디로사진찾기(id);
        System.out.println("=====================");
        System.out.println(img.getImgName());
        System.out.println(img.getId());
        System.out.println("=====================");

        model.addAttribute("img", img);
        return "imgtest/imgView";
    }

    @GetMapping("/imgtest/imgSaveForm")
    public String imgSaveForm() {
        return "imgtest/imgSaveForm";
    }

    @PostMapping("/imgtest/img")
    public @ResponseBody CMRespDto<?> create(MultipartHttpServletRequest request, ImgDto imgDto) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        MultipartFile file = request.getFile("file");

        // 파일이름에서 " . " 이후의 문자열이 확장자가 됨.
        int pos = file.getOriginalFilename().lastIndexOf(".");

        // 확장자명을 나중에 합치기 위한 작업.
        String extension = file.getOriginalFilename().substring(pos + 1);

        // 경로지정하는 구간.
        String filePath = "C:\\Users\\mysjw\\OneDrive\\바탕 화면\\MyBatis-Jstory\\src\\main\\resources\\static\\img";

        // 파일명을 UUID화 하여 중복을 방지하고
        String imgSaveName = UUID.randomUUID().toString();

        // UUID화 한 파일명 + 확장자
        String imgName = imgSaveName + "." + extension;

        File dest = new File(filePath, imgName);
        try {
            Files.copy(file.getInputStream(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=====================");
        System.out.println("title : " + title);
        System.out.println("content : " + content);
        System.out.println("imgName : " + imgName);
        System.out.println("=====================");

        Img img = imgDto.toEntity(imgName);

        imgService.사진저장(img);
        return new CMRespDto<>(1, "파일저장성공", imgName);
    }

    /*************************************************************************/
    @PostMapping(value = "/post/save", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE })
    public @ResponseBody CMRespDto<?> create(@RequestPart("file") MultipartFile file,
            @RequestPart("imgDto") ImgDto imgDto, Post post, PostReadDto postReadDto, PostWriteDto postWriteDto)
            throws Exception {
        int pos = file.getOriginalFilename().lastIndexOf(".");
        String extension = file.getOriginalFilename().substring(pos + 1);
        String filePath = "C:\\Users\\mysjw\\OneDrive\\바탕 화면\\MyBatis-Jstory\\src\\main\\resources\\static\\img";
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

        imgDto.setPostThumnail(imgName);
        postReadDto.setPostThumnail(imgName);
        postWriteDto.setPostThumnail(imgName);
        imgService.사진저장(imgDto);
        postDao.insert(imgDto);

        return new CMRespDto<>(1, "업로드 성공", imgName);
    }

}
