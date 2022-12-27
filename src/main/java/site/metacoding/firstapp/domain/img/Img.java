package site.metacoding.firstapp.domain.img;

import org.springframework.web.multipart.MultipartFile;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Img {
  private Integer id;
  private String title;
  private String imgName;
  private String content;
  private Timestamp createdAt;
  private MultipartFile[] file;

  public Img() {

  }

  public Img(String title, String imgName, String content) {
    this.title = title;
    this.imgName = imgName;
    this.content = content;

  }
}