package domainpost.post.web.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {

    @NotBlank(message = "제목을 입력해주세요")
    private String title;


    @NotBlank(message = "작성자를 입력해주세요")
    private String writer;


    @JsonFormat(shape = JsonFormat.Shape.STRING  , pattern = "yyyy-MM-dd" , timezone = "Asia/Seoul")
    private LocalDate creation_date;

    @NotBlank
    @Size(max = 500, message = "0이상 , 500자 미만으로 입력해주세요")
    private String writing;//글쓰기

    public PostUpdateRequestDto(String title, String writer, LocalDate creation_date, String writing) {
        this.title = title;
        this.writer = writer;
        this.creation_date = creation_date;
        this.writing = writing;
    }
}
