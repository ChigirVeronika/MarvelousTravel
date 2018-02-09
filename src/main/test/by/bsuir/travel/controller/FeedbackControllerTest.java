package by.bsuir.travel.controller;

import by.bsuir.travel.entity.Feedback;
import by.bsuir.travel.service.FeedbackService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackControllerTest {

    @InjectMocks
    private FeedbackController feedbackController;

    @Mock
    private FeedbackService feedbackService;

    @Mock
    private Feedback feedback;

    @Mock
    private List<Feedback> feedbacks;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(feedbackController)
                .build();

        feedback = new Feedback();
        feedback.setId(1);
        feedback.setContent("Lorem ipsum");
        feedback.setMark(4);
        feedbacks.add(feedback);

        feedback.setId(2);
        feedbacks.add(feedback);
    }

    @Test
    public void getList_success() throws Exception {
        when(feedbackService.findAll()).thenReturn(feedbacks);

        mockMvc.perform(get("/feedback/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("feedback-list"))
                .andExpect(model().attribute("feedbacks", hasSize(2)))
                .andExpect(model().attribute("feedbacks", hasItem(
                        allOf(
                                hasProperty("id", is(1)),
                                hasProperty("content", is("Lorem ipsum")),
                                hasProperty("mark", is(4))
                        )
                )))
                .andExpect(model().attribute("todos", hasItem(
                        allOf(
                                hasProperty("id", is(2)),
                                hasProperty("content", is("Lorem ipsum")),
                                hasProperty("mark", is(4))
                        )
                )));
        verify(feedbackService, times(1)).findAll();
        verifyNoMoreInteractions(feedbackService);
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}