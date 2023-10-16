package domainpost.post.service;


import domainpost.post.domain.Post;
import domainpost.post.repository.PostInformationRepository;
import domainpost.post.web.request.PostInputRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * 기능 : 제목 ,  작성자 , 날짜 , 글쓰기
 * 저장
 * 단 건 조회
 * 전체 조회
 * 수정
 * 삭제
 * */
@Service
@RequiredArgsConstructor
public class PostService {

    final PostInformationRepository repository;

    public void writingAndSaving(PostInputRequestDto requestDto) {
        Post post = requestDto.postEntity();
        repository.save(post);
    }

    //단건 조회

    public Post singleRecordRetrieval(Long findPost) {
        Post result = repository.findById(findPost);

        if (result == null){
            throw new IllegalArgumentException("찾은 값이 없습니다.");
        }

        return result;
    }

    public List<Post> findAllPost() {
        return repository.findAll();
    }


}
