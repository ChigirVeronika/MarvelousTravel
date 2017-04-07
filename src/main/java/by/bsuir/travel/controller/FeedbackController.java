package by.bsuir.travel.controller;

import by.bsuir.travel.entity.Feedback;
import by.bsuir.travel.entity.User;
import by.bsuir.travel.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(value = {"/feedback/list"}, method = RequestMethod.GET)
    public String countriesList(ModelMap model) {
        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);

        List<Feedback> feedbacks = feedbackService.findAll();
        model.addAttribute("feedbacks", feedbacks);
        return "feedback-list";
    }

    @RequestMapping(value = {"/feedback/list"}, method = RequestMethod.POST)
    public String createFeedback(@Valid Feedback feedback, ModelMap model, HttpSession session) {
        Feedback nfeedback = new Feedback();
        model.addAttribute("feedback", nfeedback);

        //todo
        feedback.setDate(new Timestamp(0));
        feedback.setUser((User) session.getAttribute("user"));

        feedbackService.save(feedback);

        List<Feedback> feedbacks = feedbackService.findAll();
        model.addAttribute("feedbacks", feedbacks);
        return "feedback-list";
    }
}
