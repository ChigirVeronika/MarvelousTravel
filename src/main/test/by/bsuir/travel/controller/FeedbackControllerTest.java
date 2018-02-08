package by.bsuir.travel.controller;

import by.bsuir.travel.entity.Feedback;
import by.bsuir.travel.service.FeedbackService;
import by.bsuir.travel.service.impl.FeedbackServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackControllerTest {

    @InjectMocks
    private FeedbackController feedbackController;

    @Mock
    private FeedbackService feedbackService;

    @Mock
    private Feedback feedback;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(feedbackController)
                .build();
    }

    @Test
    public void getList_success() throws Exception {

    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}