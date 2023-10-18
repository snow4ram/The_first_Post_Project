package domainpost.post.service;


import domainpost.post.domain.Post;
import domainpost.post.repository.PostInformationRepository;
import domainpost.post.web.request.PostInputRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    @Autowired
    final PostInformationRepository repository;

    @Transactional
    public void writingAndSaving(PostInputRequestDto requestDto) {
        Post post = requestDto.postEntity();
        repository.save(post);
    }

    @Transactional
    public Post findAPost(Long findPost) {
        Post result = repository.findById(findPost);

        if (result == null){
            throw new IllegalArgumentException("찾은 값이 없습니다.");
        }

        return result;
    }

    @Transactional
    public List<Post> findAllPost() {
        return repository.findAll();
    }

    @Transactional
    public void postDelete(Long deletePost) {
        repository.deleteById(deletePost);
    }


}
