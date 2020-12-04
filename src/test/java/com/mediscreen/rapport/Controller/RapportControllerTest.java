package com.mediscreen.rapport.Controller;

import com.mediscreen.rapport.constant.Assessment;
import com.mediscreen.rapport.constant.Sex;
import com.mediscreen.rapport.controller.RapportController;
import com.mediscreen.rapport.domain.Rapport;
import com.mediscreen.rapport.service.IRapportService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class including unit tests for the RapportController Class.
 */
@WebMvcTest(value = RapportController.class)
@ActiveProfiles("test")
public class RapportControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(RapportControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IRapportService mockRapportService;

    @Test
    public void getRapportByLastNameAndFirstName() {
        //ARRANGE
        Rapport rapportToGet = new Rapport("PatientTestLastName", "PatientTestFirstName", Sex.M, 50L, Assessment.None);
        doReturn(rapportToGet).when(mockRapportService).getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        //ACT & ASSERT
        try {
            mockMvc.perform(get("/assess/lastNameAndFirstName")
                    .param("lastName","PatientTestLastName")
                    .param("firstName","PatientTestFirstName"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            logger.error("Error in MockMvc", e);
        }
        verify(mockRapportService, times(1)).getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportById() {
        //ARRANGE
        Rapport rapportToGet = new Rapport();
        rapportToGet.setLastName("PatientTestLastName");
        rapportToGet.setFirstName("PatientTestFirstName");
        rapportToGet.setSex(Sex.M);
        rapportToGet.setAge(50L);
        rapportToGet.setAssessment(Assessment.None);
        doReturn(rapportToGet).when(mockRapportService).getRapportById(1L);

        //ACT & ASSERT
        try {
            mockMvc.perform(get("/assess/id")
                    .param("id","1"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            logger.error("Error in MockMvc", e);
        }
        verify(mockRapportService, times(1)).getRapportById(1L);
    }

}
