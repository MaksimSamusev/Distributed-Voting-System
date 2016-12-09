package by.center.mvc.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import by.center.data.entity.Vote;
import by.center.data.entity.Candidate;
import by.center.data.entity.Statistic;
import by.center.data.service.VoteService;
import by.center.data.service.CandidateService;
import by.center.data.service.StatisticService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private VoteService voteService;
	
	@Autowired
	private StatisticService statisticService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String start(Model model) {
		List<Statistic> statistics=new ArrayList<Statistic>();
		List<String>sectors=new ArrayList<String>();
		for(Candidate candidate:candidateService.getAll()){
			long votes=0;			
			for(Vote vote:voteService.getAll()){
				if(vote.getCandidate().equals(candidate.getCandidate())){
					votes++;
				}
			}
			if(!sectors.contains(candidate.getSector())){
				sectors.add(candidate.getSector());				
			}
			statistics.add(new Statistic(candidate.getCandidate(),candidate.getSector(),votes));			
		}
		Collections.sort(statistics, Statistic.COMPARE_BY_COUNT);
		model.addAttribute("listSectors", sectors);
		model.addAttribute("listStatistics", statistics);
		try{
			for(Statistic statistic:statistics){
				statisticService.create(statistic);
			}
			voteService.deleteAll();
		}catch(Exception e){
			
		}
		return "/pages/index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void okVote(@RequestParam("check_candidate") final String candidate) {
		
	}
	
	@RequestMapping(value = "/sendVotes", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void sendVotes(@RequestBody List<Vote> votes) throws JsonParseException, JsonMappingException, IOException {
		for(Vote vote:votes){
			voteService.create(vote);
			}		
		votes.clear();
	}
	

	
	@RequestMapping(value = "/sendCandidates", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void sendCandidates(@RequestBody List<String> candidates) throws JsonParseException, JsonMappingException, IOException {
		for(int h=0;h<=(candidates.size()-2);h++){
			try{
				if(candidateService.check(candidates.get(h)).equals(false)){					
					candidateService.create(new Candidate(candidates.get(h),candidates.get(candidates.size()-1)));
					
					System.out.println(candidates.get(h)+" v sektore "+candidates.get(candidates.size()-1));
				}
			
			}
			catch(Exception e){
				
				//candidateService.create(new Candidate(candidate,1));
			}
		}		
		candidates.clear();
	}
}
