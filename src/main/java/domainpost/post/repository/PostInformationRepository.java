package domainpost.post.repository;

import domainpost.post.domain.Post;
import domainpost.post.web.request.PostInputRequestDto;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PostInformationRepository extends Repository<Post , Long> {



    @Transactional
    void save(Post post);

    @Transactional
    Post findById(Long findByPost);


    @Transactional
    List<Post> findAll();
}
