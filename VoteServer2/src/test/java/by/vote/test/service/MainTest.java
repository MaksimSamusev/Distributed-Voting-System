package by.vote.test.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import by.vote.CandidateHelper;
import by.vote.RequestSender;
import by.vote.config.DataConfig;
import by.vote.data.entity.Vote;
import by.vote.data.service.VoteService;

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
	private CandidateHelper helper;

	@Before
	public void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@Test
	public void test1() throws Exception {
		Vote v1 = new Vote();
		vs.create(v1);
		Vote v2 = vs.getOne(v1.getId());
		System.out.println(v2.getCandidate());
	}

	// @Test
	public void test3() throws Exception {
		RequestSender rs = new RequestSender();
		rs.getEmployees();
	}
}
