package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

import com.example.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{
    public Message findMessageByMessageId(int messageId);

    public List<Message> deleteByMessageId(int messageId);

    public List<Message> findMessagesByPostedBy(int postedBy);
}
