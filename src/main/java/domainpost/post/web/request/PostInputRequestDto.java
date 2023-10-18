package domainpost.post.web.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import domainpost.post.domain.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PostInputRequestDto {

    @NotBlank(message = "제목을 입력해주세요")
    private String title; //제목

    @NotBlank(message = "작성자를 입력해주세요")
    private String writer; //작성자

    @JsonFormat(shape = JsonFormat.Shape.STRING  , pattern = "yyyy-MM-dd" , timezone = "Asia/Seoul")
    private LocalDate creation_date;//작성 날짜

    @NotBlank
    @Size(max = 500, message = "0이상 , 500자 미만으로 입력해주세요")
    private String writing;//글쓰기

    public PostInputRequestDto(String title, String writer, LocalDate creation_date, String writing) {
        this.title = title;
        this.writer = writer;
        this.creation_date = creation_date;
        this.writing = writing;
    }

    //Byilder
    public Post postEntity(){
        return new Post(title, writer, creation_date, writing);
    }


    @Override
    public String toString() {
        return "PostInputRequestDto{" +
                "title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", creation_date=" + creation_date +
                ", writing='" + writing + '\'' +
                '}';
    }
}
