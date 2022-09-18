package com.example.javapentalog.SecondModule.web.rest;

import com.example.javapentalog.SecondModule.model.PageRequestTest;
import com.example.javapentalog.SecondModule.services.impl.CompetitorServiceImpl;
import com.example.javapentalog.SecondModule.services.impl.MatchServiceImpl;
import com.example.javapentalog.SecondModule.services.impl.TeamServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class ThymeleafController {

    private final CompetitorServiceImpl competitorService;

    private final MatchServiceImpl matchService;

    private final TeamServiceImpl teamService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        PageRequestTest pageRequest = new PageRequestTest(0,20);
        model.addAttribute("competitors",competitorService.findAllCompetitors(pageRequest));
        return "index";
    }
}
