package by.center.data.service;

import java.util.List;

import by.center.data.entity.Message;

public interface MessageService {
	Message create(Message message);

	Message read(long id);

	Message update(Message message);

	void delete(long id);

	List<Message> getAll();
}
