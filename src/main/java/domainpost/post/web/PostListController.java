package domainpost.post.web;

import domainpost.post.domain.Post;
import domainpost.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PostListController {

    @Autowired
    PostService listService;


    @GetMapping("/api-post-list")
    public String list(Model model) {

        List<Post> allPost = listService.findAllPost();

        model.addAttribute("allPost", allPost);

        return "post_list_form";
    }


}
