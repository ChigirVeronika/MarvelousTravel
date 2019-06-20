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
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static java.time.LocalDate.now;

@Controller
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<News> news = newsService.findAll();
        for (News n : news) {
            Timestamp t;
            try {
                t = n.getDatetime();
            } catch (Exception e) {
                t = new Timestamp(System.currentTimeMillis());
            }
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            Timestamp newt = null;
//            try {
//                newt = new Timestamp(dateFormat.parse(dateFormat.format(t)).getTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
            n.setDatetime(t);
        }
        model.addAttribute("news", news);
        return "news-list";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String showCreationPage(ModelMap model) {
        News news = new News();
        model.addAttribute("news", news);
        return "news-create";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String create(@Valid News news) {
        news.setDatetime(new Timestamp(System.currentTimeMillis()));
        newsService.save(news);
        return "redirect:/news/list";
    }

    @RequestMapping(value = {"/delete/{name}"}, method = RequestMethod.GET)
    public String delete(@PathVariable String name) {
        newsService.deleteByName(name);
        return "redirect:/news/list";
    }
}
