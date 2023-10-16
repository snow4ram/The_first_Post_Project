package domainpost.post.web.response;

import domainpost.post.domain.Post;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PostResultResponseDto {

    private final String title;

    private final String writer;

    private final LocalDate creation_date;

    private final String writing;


    //builder 로 변경해볼만한 부분.
    public PostResultResponseDto(Post post) {
        this.title = post.getTitle();
        this.writer = post.getWriter();
        this.creation_date = post.getCreation_date();
        this.writing = post.getWriting();
    }
}
