package by.center.test.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import by.center.config.DataConfig;
import by.center.data.entity.Message;
import by.center.data.entity.Vote;
import by.center.data.service.MessageService;
import by.center.data.service.TransferService;
import by.center.data.service.VoteService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

//@Transactional
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
@WebAppConfiguration
public class MainTest {

    @Autowired
    private EntityManagerFactory emf;
    
    @Autowired
    protected EntityManager em;
    
    @Autowired
    private VoteService vs;
    
    @Autowired
    private MessageService ms;
    
    @Autowired
    private TransferService ts;;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void test1() throws Exception {
    	ts.transfer();
        System.out.println("ok");
    }

}
