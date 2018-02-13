package by.bsuir.travel.dto;

import by.bsuir.travel.entity.Tour;
import org.springframework.stereotype.Component;

@Component("feedbackDto")
public class FeedbackDto {

    private Integer id;

    private Integer mark;

    private String content;

    private Tour tour;

    public FeedbackDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
