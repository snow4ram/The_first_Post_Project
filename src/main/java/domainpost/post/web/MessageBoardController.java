package domainpost.post.web;

import domainpost.post.service.PostService;
import domainpost.post.web.request.PostInputRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@Controller
@RequiredArgsConstructor
public class MessageBoardController {

    @Autowired
    PostService service;

    @GetMapping("/api-posting")
    public String input() {
        return "post";
    }


    @PostMapping("/api-posting")
    public ResponseEntity<Void> postResult(@RequestBody @Validated PostInputRequestDto requestDto, BindingResult bindingResult) {

        log.info("requestDto={}", requestDto);

        //error
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("입력한 값을 확인해주세요");
        }

        service.writingAndSaving(requestDto);

        //여기랑
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api-post_list")
    public String list(){
        return "post_list";
    }
}
