package by.bsuir.travel.controller;

import by.bsuir.travel.entity.News;
import by.bsuir.travel.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String newsList(ModelMap model) {
        List<News> news = newsService.findAll();
        for(News n:news){
            Date t;
            try {
                t = n.getDate();
            }catch (Exception e){
                t = new Date();
            }
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            Timestamp newt = null;
//            try {
//                newt = new Timestamp(dateFormat.parse(dateFormat.format(t)).getTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
            n.setDate(t);
        }
        model.addAttribute("news", news);
        return "news-list";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String showNewsCreateionPage(ModelMap model) {
        News news = new News();
        model.addAttribute("news",news);
        return "news-create";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String createNews(@Valid News news) {
        news.setDate(new Date());
        newsService.save(news);
        return "redirect:/news/list";
    }

    @RequestMapping(value = {"/delete/{name}"}, method = RequestMethod.GET)
    public String deleteNews(@PathVariable String name) {
        newsService.deleteByName(name);
        return "redirect:/news/list";
    }
}
