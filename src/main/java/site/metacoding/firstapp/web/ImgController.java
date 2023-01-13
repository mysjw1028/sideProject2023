package site.metacoding.firstapp.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.img.ImgDto;
import site.metacoding.firstapp.domain.post.Post;
import site.metacoding.firstapp.domain.post.PostDao;
import site.metacoding.firstapp.service.FileUploadServiceImpl;
import site.metacoding.firstapp.service.ImgService;
import site.metacoding.firstapp.web.dto.CMRespDto;
import site.metacoding.firstapp.web.dto.post.PostReadDto;
import site.metacoding.firstapp.web.dto.post.PostUpdateReqDto;
import site.metacoding.firstapp.web.dto.post.PostWriteDto;

@RequiredArgsConstructor
@Controller
public class ImgController {

    private final ImgService imgService;
    private final PostDao postDao;
    private final FileUploadServiceImpl fileUploadServiceImpl;

    @GetMapping("/uploadTest")
    public String main() {
        return "upload";
    }

    @RequestMapping(value = "/uploadTest") // jsp파일명이랑 이름이 같아야한다.
    public String fileUploadJsp(MultipartFile uploadfile, Model model) throws Exception {

        System.out.println("/uploadTest");

        return "upload";
    }

    // } 테스트 코드
    // @GetMapping("/imgtest/imgView/{userId}") // 나중에 테스트
    // public String imgView(@PathVariable Integer id, Model model) {
    // Img img = imgService.아이디로사진찾기(id);
    // System.out.println("=====================");
    // System.out.println(img.getImgName());
    // System.out.println(img.getId());
    // System.out.println("=====================");
    // model.addAttribute("img", img);
    // return "imgtest/imgView";
    // }
    // @GetMapping("/imgtest/imgSaveForm")
    // public String imgSaveForm() {
    // return "imgtest/imgSaveForm";
    // }

    @PostMapping(value = "/post/save", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE })
    public @ResponseBody CMRespDto<?> create(@RequestPart("file") MultipartFile file,
            @RequestPart("imgDto") ImgDto imgDto, Post post, PostReadDto postReadDto, PostWriteDto postWriteDto)
            throws Exception {
        int pos = file.getOriginalFilename().lastIndexOf(".");
        String extension = file.getOriginalFilename().substring(pos + 1);// 사진경로가 안맞을경우 직접 폴더 들어가서 경로를 맞춰줄것
        String filePath = "C:\\Users\\mysjw\\OneDrive\\바탕 화면\\취업준비 자료\\프로젝트 깃 정리\\Tstroy\\SpringBoot-Mybatis-Tstory\\src\\main\\resources\\static\\img";
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

    @PostMapping(value = "/post/update", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE })
    public @ResponseBody CMRespDto<?> create(@RequestPart("file") MultipartFile file,
            @RequestPart("imgDto") ImgDto imgDto, Post post, PostReadDto postReadDto, PostUpdateReqDto postUpdateReqDto)
            throws Exception {
        int pos = file.getOriginalFilename().lastIndexOf(".");
        String extension = file.getOriginalFilename().substring(pos + 1);// 사진경로가 안맞을경우 직접 폴더 들어가서 경로를 맞춰줄것
        String filePath = "C:\\Users\\mysjw\\OneDrive\\바탕 화면\\취업준비 자료\\프로젝트 깃 정리\\Tstroy\\SpringBoot-Mybatis-Tstory\\src\\main\\resources\\static\\img";
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
        postUpdateReqDto.setPostThumnail(imgName);
        imgService.사진저장(imgDto);
        postDao.update(imgDto);
        return new CMRespDto<>(1, "업로드 성공", imgName);
    }

    // 1 post컨트롤러가 돌아간다고 착각을 함
    // 2 실제로는 ImgController가 돌아감
    // 3 실제로는 다른컨토롤러에서 돌린거 처럼 imgController에서 findById해서 postId를 들고와서 DB에 있는 값을 찾아서
    // imgDto에 있는 postId가 그대로 값이 들어감 -> jsp에있는 js가 인식을 해서 값이 변겅

    @PostMapping(value = "/uploadTest", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE }) // jsp파일명이랑 이름이 같아야한다.
    public String multiFileUpload(MultipartFile[] uploadfiles, Model model) throws Exception {
        // 파일을 받을 수 있게끔 MultipartFile 배열을 매개변수 선언

        for (MultipartFile f : uploadfiles) {
            System.out.println("upload() POST 호출");
            // 파일 이름을 String 값으로 반환한다
            System.out.println("파일 이름(uploadfile.getOriginalFilename()) : " + f.getOriginalFilename());
            // 파일 크기를 반환한다
            System.out.println("파일 크기(uploadfile.getSize()) : " + f.getSize());

            fileUploadServiceImpl.saveFile(f);
        }
        System.out.println("사진 업로드 성공");
        return "upload";
    }

}