package com.mediscreen.rapport.proxy;

import com.mediscreen.rapport.domain.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Proxy for the Patient Microservice using Feign to communicate with the Patient Microservice.
 */
@FeignClient(name = "PATIENT-MICROSERVICE", url = "localhost:8081")
public interface PatientMicroserviceProxy {

    /**
     * Return a patient given its last name and first name.
     *
     * @param lastName The last name of the patient
     * @param firstName The first name of the patient
     * @return The patient
     */
    @GetMapping(value = "/patients/patientByFamilyAndGiven")
    //ResponseEntity<Patient> getPatientByLastNameAndFirstName(@RequestParam("family") String lastName, @RequestParam("given") String firstName);
    Patient getPatientByLastNameAndFirstName(@RequestParam("family") String lastName, @RequestParam("given") String firstName);

    /**
     * Return a patient given its identifier.
     *
     * @param id The identifier of the patient
     * @return The patient
     */
    @GetMapping(value = "/patients/patientById")
    Patient getPatientById(@RequestParam("id") long id);

}
