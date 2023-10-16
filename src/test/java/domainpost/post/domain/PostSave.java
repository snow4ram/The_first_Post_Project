package domainpost.post.domain;


import domainpost.post.repository.PostInformationRepository;
import domainpost.post.service.PostService;
import domainpost.post.web.request.PostInputRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


//@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostSave {


    @Autowired
    PostInformationRepository repository;

    @Autowired
    PostService service;

    @Test
    @DisplayName("사용자 정의")
    public void post_save() {

        PostInputRequestDto requestDto = new PostInputRequestDto(
                "test title",
                "userA",
                LocalDate.now(),
                "test writing");

        PostInputRequestDto requestDto2 = new PostInputRequestDto(
                "test title",
                "userA",
                LocalDate.now(),
                "test writing");
        service.writingAndSaving(requestDto);
        service.writingAndSaving(requestDto2);

    }

    @AfterEach
    void delete() {

    }

}
