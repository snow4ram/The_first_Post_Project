package domainpost.post;

import domainpost.post.domain.Post;
import domainpost.post.repository.PostInformationRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TestPost {

    @Autowired
    PostInformationRepository repository;

    @PostConstruct
    public void init() {

        repository.save(new Post("test1" , "user_a", LocalDate.now() ,"test 1 입니다"));
        repository.save(new Post("test2" , "user_b", LocalDate.now() ,"test 2 입니다"));
        repository.save(new Post("test3" , "user_c", LocalDate.now() ,"test 3 입니다"));

    }
}
