package by.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:candidate.properties")
public class CandidateHelper {

	@Autowired
	private Environment env;

	public String getSector() {
		return env.getRequiredProperty("candidate." + 1 + ".sector").split(",")[0];
		
	}

	public String[] getCandidates() {
		return env.getRequiredProperty("candidate." + 1 + ".name").split(",");
	}
	

}
