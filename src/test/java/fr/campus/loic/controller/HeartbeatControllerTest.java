package fr.campus.loic.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class HeartbeatControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void HeartbeatIsIntBetween40And230() throws Exception {
        MvcResult result = this.mvc.perform(get("/heartbeat"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        int heartbeat;
        try {
            heartbeat = Integer.parseInt(content);
        } catch (NumberFormatException e) {
            throw new AssertionError("La réponse n'est pas un entier valide : " + content);
        }

        assertThat(heartbeat)
                .isBetween(40, 230);
    }
}
