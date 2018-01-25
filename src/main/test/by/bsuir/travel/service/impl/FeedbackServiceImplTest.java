package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.FeedbackDao;
import by.bsuir.travel.entity.Feedback;
import by.bsuir.travel.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;

import static org.junit.Assert.*;
import static org.mockito.Matchers.doubleThat;
import static org.mockito.Mockito.when;

public class FeedbackServiceImplTest {

    @InjectMocks
    private FeedbackServiceImpl service;

    @Mock
    private FeedbackDao dao;

    @Mock
    private Feedback feedback;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        feedback = new Feedback();
        feedback.setId(1);
        feedback.setDate(new Timestamp(System.currentTimeMillis()));
        feedback.setUser(new User());
        feedback.setMark(5);
        feedback.setContent("lorem ipsum");
    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void find() throws Exception {
        Integer id = 1;
        when(dao.read(id)).thenReturn(feedback);
        assertEquals(feedback, dao.read(id));
    }

    @Test
    public void delete() throws Exception {
    }

}