package com.infotitans.dailydevotional.web.application;

import com.infotitans.dailydevotional.business.service.AuthorService;
import com.infotitans.dailydevotional.data.entity.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @MockBean
    private AuthorService authorService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAuthors() throws Exception {
        List<Author> mockAuthors = new ArrayList<>();

        Author mockAuthor = new Author();
        mockAuthor.setId(1);
        mockAuthor.setName("Pastor Ron");

        mockAuthors.add(mockAuthor);

        given(authorService.getAllAuthors()).willReturn(mockAuthors);
        this.mockMvc.perform(get("/authors")).andExpect(status().isOk()).andExpect(content().string(containsString("Pastor Ron")));
    }

}
