package com.infotitans.dailydevotional;

import com.infotitans.dailydevotional.business.service.AuthorService;
import com.infotitans.dailydevotional.business.service.MessageService;
import com.infotitans.dailydevotional.data.entity.Author;
import com.infotitans.dailydevotional.data.entity.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
class DailydevotionalApplicationTests {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private MessageService messageService;

	@Test
	public void testCreateAuthor(){
		Author author = new Author();
		author.setName("Rev Eboda");
		author.setId(1L);
		authorService.addNewAuthor(author);

		Optional<Author> savedAuthor = authorService.findAuthorById(author.getId());
		assertNotNull(savedAuthor);
	}

	@Test
	public void testCreateMessage(){
		Author author = new Author();
		author.setName("Rev Eboda");
		author.setId(1L);
		authorService.addNewAuthor(author);

		Message message = new Message();
		message.setId(1L);
		message.setTitle("Test Title");
		message.setBody("Test Body");
		message.setDate(new Date());
		message.setAuthor(author);
		messageService.addNewMessage(message);

		Optional<Message> savedMessage = messageService.findMessageById(message.getId());
		assertNotNull(savedMessage);
	}

}
