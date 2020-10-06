package task3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import task3.dto.PostingDTO;
import task3.service.PostingDtoService;

import java.util.List;

@RestController
public class PostingController {

    @Autowired
    private PostingDtoService postingDtoService;

    @GetMapping("/postings")
    public List<PostingDTO> getAll(@RequestParam(name = "period", required = false, defaultValue = "")
                                               String period,
                                   @RequestParam(name = "authorised", required = false, defaultValue = "")
                                               String authorised) {
        return postingDtoService.findAll(period, authorised);
    }
}
