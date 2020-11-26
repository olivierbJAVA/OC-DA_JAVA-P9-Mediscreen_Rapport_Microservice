package com.mediscreen.rapport.controller;

import com.mediscreen.rapport.domain.Rapport;
import com.mediscreen.rapport.service.IRapportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller in charge of managing the endpoints for Rapport entities.
 */
@Controller
public class RapportController {

    private static final Logger logger = LoggerFactory.getLogger(RapportController.class);

    private IRapportService rapportService;

    public RapportController(IRapportService rapportService) {
        this.rapportService = rapportService;
    }

    /**
     * Method managing the GET "/patients/patientByFamilyAndGiven" endpoint HTTP request to get a patient given its last name and first name in JSON data.
     *
     * @param lastName The last name of the patient for which to generate the report
     * @param firstName The first name of the patient for which to generate the report
     * @return A ResponseEntity containing the report and the HTTP status code
     */
    @GetMapping("/rapport/patientByFamilyAndGiven")
    public ResponseEntity<Rapport> getRapportByLastNameAndFirstName(@RequestParam("family") String lastName, @RequestParam("given") String firstName) {

        logger.info("Request : GET /rapport/patientByFamilyAndGiven with last name = {} & first name = {}", lastName, firstName);

        Rapport rapport = rapportService.getRapport(lastName, firstName);

        logger.info("Success : rapport for patient with last name {} and first name {} generated", lastName, firstName);

        return new ResponseEntity<>(rapport, HttpStatus.OK);
    }
}
