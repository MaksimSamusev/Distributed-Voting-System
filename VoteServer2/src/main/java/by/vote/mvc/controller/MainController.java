package by.vote.mvc.controller;

import static org.springframework.util.Assert.notNull;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import by.vote.CandidateHelper;
import by.vote.data.entity.Vote;
import by.vote.data.service.VoteService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private CandidateHelper helper;
	@Autowired
	private VoteService vs;

	@RequestMapping(method = RequestMethod.GET)
	public String start(Model model) throws JsonGenerationException, JsonMappingException, IOException {
		model.addAttribute("names", helper.getCandidates());
		ObjectMapper mapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, Visibility.ANY);
		ArrayList <String> candidates = new ArrayList<String>(Arrays.asList(helper.getCandidates())); 
		candidates.add(helper.getSector());	
		String voteRequestBody = mapper.writeValueAsString(candidates);		
		String url = "http://localhost:8080/CenterServer/sendCandidates";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);		
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
		out.write(voteRequestBody);		
		out.close();
		int responseCode = con.getResponseCode();		
		if (responseCode == 200) {			
			System.out.println("Ok!Candidate update");
		}else{
			System.out.println("ERROR "+responseCode);			
		}		
		return "/pages/index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void okVote(@RequestParam("check_candidate") final String candidate) {
		notNull(vs.create(new Vote(candidate)), "Vote not create");
	}

	@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public String test(Model model) {
		System.out.println("work");
		return "work";
	}

}
