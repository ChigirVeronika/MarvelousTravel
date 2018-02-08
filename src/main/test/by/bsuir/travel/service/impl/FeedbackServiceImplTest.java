package by.bsuir.travel.service.impl;

import by.bsuir.travel.dao.FeedbackDao;
import by.bsuir.travel.entity.Feedback;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackServiceImplTest {

    @InjectMocks
    private FeedbackServiceImpl feedbackService;

    @Mock
    private FeedbackDao feedbackDao;

    @Mock
    private Feedback feedback;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        feedback = new Feedback();
        feedback.setId(1);
        feedback.setMark(4);
    }

    @Test
    public void saveWhenNotExist() throws Exception {
        Integer id = 2;
        when(feedbackDao.read(id)).thenReturn(null);
        doNothing().when(feedbackDao).create(feedback);
        feedbackService.save(feedback);
        verify(feedbackDao, times(1)).create(feedback);
        verify(feedbackDao, never()).update(feedback);
    }

    @Test
    public void saveWhenExist() throws Exception {
        Integer id = feedback.getId();
        when(feedbackDao.read(id)).thenReturn(feedback);
        doNothing().when(feedbackDao).update(feedback);
        feedbackService.save(feedback);
        verify(feedbackDao, times(1)).update(feedback);
        verify(feedbackDao, never()).create(feedback);
    }

    @Test
    public void findAllForMarksInRange() throws Exception {
        Integer low = feedback.getMark() - 1;
        Integer up = feedback.getMark() + 1;
        when(feedbackDao.readAllForMarksInRange(low,up)).thenReturn(Arrays.asList(feedback));
        List<Feedback> result = feedbackService.findAllForMarksInRange(low, up);
        assertEquals(feedbackDao.readAllForMarksInRange(low,up), result);
        verify(feedbackDao, atLeastOnce()).readAllForMarksInRange(low, up);
    }

    @Test
    public void find() throws Exception {
        Integer id = feedback.getId();
        when(feedbackDao.read(id)).thenReturn(feedback);
        Feedback result = feedbackService.find(id);
        assertEquals(feedbackDao.read(id), result);
        verify(feedbackDao, atLeastOnce()).read(id);
    }

    @Test
    public void delete() throws Exception {
        Integer id = feedback.getId();
        when(feedbackDao.read(id)).thenReturn(feedback);
        doNothing().when(feedbackDao).delete(id);
        feedbackService.delete(id);
        verify(feedbackDao, times(1)).delete(id);
    }
}