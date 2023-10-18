package domainpost.post.web;

import domainpost.post.domain.Post;
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
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequiredArgsConstructor
public class PostWritingController {

    @Autowired
    PostService service;

    @GetMapping("/api-main")
    public String mainPage() {
        return "redirect:/api-post-list";
    }

    @GetMapping("/api-posting")
    public String input(Model model) {
        model.addAttribute("request", new PostInputRequestDto());
        return "post";
    }

    @PostMapping("/api-posting")
    public ResponseEntity<Void> writing(@RequestBody @Validated PostInputRequestDto requestDto, BindingResult bindingResult) {
        log.info("requestDto={}", requestDto);

        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("입력한 값을 확인해주세요");
        }

        service.writingAndSaving(requestDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/api-findPost/{findPostId}")
    public String findPost(@PathVariable Long findPostId, Model model) {
        Post posts = service.findAPost(findPostId);

        model.addAttribute("post", posts);

        return "post_list";
    }


}
