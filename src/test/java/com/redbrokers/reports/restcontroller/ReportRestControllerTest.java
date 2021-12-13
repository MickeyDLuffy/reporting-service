package com.redbrokers.reports.restcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redbrokers.reports.dto.ReportDTO;
import com.redbrokers.reports.enums.EventType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class ReportRestControllerTest  {
    @Autowired
    private MockMvc mockMvc;

    private ReportDTO report = new ReportDTO("demo description test", EventType.ORDER_CREATED);
    ObjectMapper obj = new ObjectMapper();
    String reportJsonStr = obj.writeValueAsString(report);

    ReportRestControllerTest() throws JsonProcessingException {
    }


    @Test
    public void testReportEndpointReceivesData() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/mq/message")
                .content(reportJsonStr)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
}