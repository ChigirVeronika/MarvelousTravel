package by.bsuir.travel.controller;

import by.bsuir.travel.entity.News;
import by.bsuir.travel.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = {"/newslist"}, method = RequestMethod.GET)
    public String tasksList(ModelMap model) {
        List<News> news = newsService.getAll();
        model.addAttribute("news", news);
        return "newslist";
    }
}
