package com.infotitans.dailydevotional.web.application;

import com.infotitans.dailydevotional.business.service.AuthorService;
import com.infotitans.dailydevotional.business.service.MessageService;
import com.infotitans.dailydevotional.data.entity.Author;
import com.infotitans.dailydevotional.data.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(MessageController.class)
public class MessageControllerTest {

    @MockBean
    private MessageService messageService;

    @Autowired
    private MockMvc mockMvc;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void getMessages() throws Exception {
        Date date  = DATE_FORMAT.parse("2020-01-01");

        List<Message> mockMessageList = new ArrayList<>();
        Message mockMessage = new Message();
        Author author = new Author();
        author.setId(1);
        author.setName("Pastor Ron");

        mockMessage.setId(1);
        mockMessage.setTitle("Some Title");
        mockMessage.setBody("Some Mock Body");
        mockMessage.setDate(date);
        mockMessage.setAuthor(author);
        mockMessageList.add(mockMessage);

        given(messageService.getAllMessages()).willReturn(mockMessageList);

        this.mockMvc.perform(get("/messages")).andExpect(status().isOk()).andExpect(content().string(containsString("Some Title")));

    }

}
