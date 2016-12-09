package by.vote.config;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import by.vote.CandidateHelper;
import by.vote.data.service.VoteService;

@Configuration
@EnableAsync
@EnableScheduling
public class TransferConfig {

	@Autowired
	private VoteService voteService;
	@Autowired
	private CandidateHelper candidateHelper;

	@Scheduled(fixedRate = 10000)
	private void sendPost() throws Exception {
		ObjectMapper mapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, Visibility.ANY);
		String voteRequestBody = mapper.writeValueAsString(voteService.getAll());
		
		String url = "http://localhost:8080/CenterServer/sendVotes";
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
			voteService.deleteAll();
		}
		else{
			System.out.println(String.valueOf(responseCode)+" "+con.getResponseMessage());
		}
	}
}
