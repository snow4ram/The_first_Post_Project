package domainpost.post.repository;

import domainpost.post.domain.Post;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PostInformationRepository extends Repository<Post , Long> {

    void save(Post post);

    Post findById(Long findByPost);

    List<Post> findAll();

    void deleteById(Long postDelete);

}
