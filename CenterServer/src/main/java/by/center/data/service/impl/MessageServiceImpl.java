package by.center.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.center.data.entity.Message;
import by.center.data.repository.MessageRepository;
import by.center.data.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public Message create(Message message) {
		return messageRepository.saveAndFlush(message);
	}

	@Override
	public Message read(long id) {
		return messageRepository.findOne(id);
	}

	@Override
	public Message update(Message message) {
		return messageRepository.saveAndFlush(message);
	}

	@Override
	public void delete(long id) {
		messageRepository.delete(id);
	}

	@Override
	public List<Message> getAll() {
		return messageRepository.findAll();
	}

}
