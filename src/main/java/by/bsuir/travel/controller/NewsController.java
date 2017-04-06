package by.bsuir.travel.controller;

import by.bsuir.travel.entity.News;
import by.bsuir.travel.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = {"/news/list"}, method = RequestMethod.GET)
    public String tasksList(ModelMap model) {
        List<News> news = newsService.findAll();
        for(News n:news){
            Timestamp t = n.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Timestamp newt = null;
            try {
                newt = new Timestamp(dateFormat.parse(dateFormat.format(t)).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            n.setDate(newt);
        }
        model.addAttribute("news", news);
        return "news-list";
    }
}
