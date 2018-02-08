package by.bsuir.travel.dao.mysqlimpl;

import by.bsuir.travel.entity.Feedback;
import by.bsuir.travel.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.spi.InjectService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MysqlFeedbackDaoTest {

    @InjectMocks
    private MysqlFeedbackDao feedbackDao;

    @Mock
    private Feedback feedback;

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        sessionFactory = mock(SessionFactory.class);
        session = mock(Session.class);

        when(sessionFactory.getCurrentSession()).thenReturn(session);

        feedback = new Feedback();
        feedback.setId(1);
        feedback.setDate(new Timestamp(System.currentTimeMillis()));
        feedback.setUser(new User());
        feedback.setMark(4);
        feedback.setContent("lorem ipsum");
    }

    @Test
    public void create() throws Exception {
        doNothing().when(getSession()).persist(feedback);
        feedbackDao.create(feedback);
        verify(getSession(), times(1)).persist(feedback);
    }

    @Test
    public void read() throws Exception {
        Integer id = feedback.getId();
        when(getSession().get(Feedback.class, id)).thenReturn(feedback);
        Feedback result = feedbackDao.read(id);
        assertEquals(getSession().get(Feedback.class, id), result);
    }

    @Test
    public void update() throws Exception {
        doNothing().when(getSession()).update(feedback);
        feedbackDao.update(feedback);
        verify(getSession(), times(1)).update(feedback);
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(getSession()).delete(feedback);
        feedbackDao.delete(feedback.getId());
        verify(getSession(), times(1)).delete(feedback);
        verify(getSession().get(Feedback.class, feedback.getId()), times(1));
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}