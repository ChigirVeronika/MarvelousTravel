package by.bsuir.travel.controller;

import by.bsuir.travel.dto.FeedbackDto;
import by.bsuir.travel.entity.Feedback;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String getList(ModelMap model) {
        FeedbackDto dto = new FeedbackDto();
        model.addAttribute("feedbackDto", dto);

        List<Feedback> feedbacks = feedbackService.findAll();
        model.addAttribute("feedbacks", feedbacks);
        return "feedback-list";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.POST)
    public String create(@Valid FeedbackDto feedbackDto,
                         ModelMap model, HttpSession session) {
        FeedbackDto dto = new FeedbackDto();
        model.addAttribute("feedbackDto", dto);

        Feedback feedback = new Feedback();
        feedback.setContent(feedbackDto.getContent());
        feedback.setMark(feedbackDto.getMark());
        feedback.setDate(new Date());
        feedback.setUser((User) session.getAttribute("user"));

        feedbackService.save(feedback);

        return "redirect:/feedback/list";
    }

    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String delete(@PathVariable Integer id, ModelMap model) {
        feedbackService.delete(id);
        return "redirect:/feedback/list";
    }


}
