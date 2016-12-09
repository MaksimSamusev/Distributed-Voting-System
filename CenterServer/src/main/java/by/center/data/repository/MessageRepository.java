package by.center.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.center.data.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
	
}
