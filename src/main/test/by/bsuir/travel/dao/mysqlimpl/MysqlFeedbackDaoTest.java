package by.bsuir.travel.dao.mysqlimpl;

import org.hibernate.service.spi.InjectService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class MysqlFeedbackDaoTest {

    @InjectMocks
    private final MysqlFeedbackDao feedbackDao = new MysqlFeedbackDao();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void read() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void readAll() throws Exception {
    }

    @Test
    public void readAllForUser() throws Exception {
    }

    @Test
    public void readAllForMark() throws Exception {
    }

    @Test
    public void readAllForMarksInRange() throws Exception {
    }

}