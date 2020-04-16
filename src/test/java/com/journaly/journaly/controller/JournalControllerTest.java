package com.journaly.journaly.controller;

import com.journaly.journaly.model.JournalEntry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class JournalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSaveAJournalEntry() throws Exception {
        mockMvc.perform(post("/")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"content\": \"abcd\", \"date\": \"2020-04-15T21:00:30.259Z\"}"))
            .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetAllJournayEntries() throws Exception {
        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"content\": \"abcd\", \"date\": \"2020-04-15T21:00:30.259Z\"}"));

        mockMvc.perform(get("/entries"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("abcd")))
                .andExpect(content().string(containsString("2020-04-15T21:00:30.259Z")));
    }
}
