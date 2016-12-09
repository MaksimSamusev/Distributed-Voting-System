package by.center.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.center.data.entity.Message;
import by.center.data.entity.Vote;
import by.center.data.service.MessageService;
import by.center.data.service.TransferService;
import by.center.data.service.VoteService;

@Service
public class TransferServiceImpl implements TransferService{

	@Autowired
	private VoteService voteService;
	
	@Autowired
	private MessageService messageService;

	@Override
	public void transfer() {
		try{
			List<Message> messages = messageService.getAll();
			for(Message message: messages){
				Vote vote = new Vote();
				vote.setSector(message.getSector());
				vote.setCandidate(message.getCandidate());
				voteService.create(vote);
				vote = null;
				messageService.delete(message.getId());
			}
		} catch (Exception e) {
			
		}
	}
}
