package at.technikum.slm_project_2;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OpeningHoursControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void validateDefaultGetOpeningHours() throws Exception {
        // reset opening hours
        this.mockMvc.perform(put("/api/hours/reset"))
                .andExpect(status().isOk());

        validateDefaultOpeningHours();
    }

    @Test
    void validateSetOpeningHours() throws Exception {
        // invalid day --> should return 500 internal server error
        this.mockMvc.perform(put("/api/hours/set")
                        .queryParam("day", "mox")
                        .queryParam("open", "15")
                        .queryParam("close", "12")
                )
                .andExpect(status().isInternalServerError());

        // day missing --> 400 client error
        this.mockMvc.perform(put("/api/hours/set")
                        .queryParam("open", "15")
                        .queryParam("close", "12")
                )
                .andExpect(status().is4xxClientError());

        // open time out of range --> 500 internal server error
        this.mockMvc.perform(put("/api/hours/set")
                        .queryParam("day", "mo")
                        .queryParam("open", "99")
                        .queryParam("close", "12")
                )
                .andExpect(status().isInternalServerError());

        // close time out of range --> 500 internal server error
        this.mockMvc.perform(put("/api/hours/set")
                        .queryParam("day", "mo")
                        .queryParam("open", "15")
                        .queryParam("close", "99")
                )
                .andExpect(status().isInternalServerError());

        // correct request
        this.mockMvc.perform(put("/api/hours/set")
                        .queryParam("day", "mo")
                        .queryParam("open", "15")
                        .queryParam("close", "22")
                )
                .andExpect(content().string("updated opening hours for mo (open: 15, close: 22)"))
                .andExpect(status().isOk());

        // validate response of get /api/hours, updated times for monday, rest stays the same
        this.mockMvc.perform(get("/api/hours"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.Mo").value("15:00 - 22:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Tu").value("closed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.We").value("09:00 - 17:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Th").value("09:00 - 17:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Fr").value("08:00 - 19:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Sa").value("08:00 - 19:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Su").value("08:00 - 19:00"));
    }

    @Test
    void validateResetOpeningHours() throws Exception {
        // correct request
        this.mockMvc.perform(put("/api/hours/reset"))
                .andExpect(status().isOk())
                .andExpect(content().string("working hours were reset"));

        // validate response of get /api/hours for default opening hours
        validateDefaultOpeningHours();
    }

    @Test
    void validateCloseDay() throws Exception {
        // 400 client error --> day query parameter not present
        this.mockMvc.perform(put("/api/hours/close"))
                .andExpect(status().is4xxClientError());

        // 500 internal server error --> day not valid
        this.mockMvc.perform(put("/api/hours/close").queryParam("day", "mox"))
                .andExpect(status().isInternalServerError());

        // correct request
        this.mockMvc.perform(put("/api/hours/close").queryParam("day", "mo"))
                .andExpect(status().isOk())
                .andExpect(content().string("closed day: mo"));

        // validate response of get /api/hours, monday should be closed now
        this.mockMvc.perform(get("/api/hours"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.Mo").value("closed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Tu").value("closed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.We").value("09:00 - 17:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Th").value("09:00 - 17:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Fr").value("08:00 - 19:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Sa").value("08:00 - 19:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Su").value("08:00 - 19:00"));
    }

    private void validateDefaultOpeningHours() throws Exception {
        this.mockMvc.perform(get("/api/hours"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.Mo").value("09:00 - 17:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Tu").value("closed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.We").value("09:00 - 17:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Th").value("09:00 - 17:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Fr").value("08:00 - 19:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Sa").value("08:00 - 19:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Su").value("08:00 - 19:00"));
    }
}
