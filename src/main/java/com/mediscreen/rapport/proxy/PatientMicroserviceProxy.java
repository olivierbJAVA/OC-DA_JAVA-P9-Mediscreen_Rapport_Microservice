package com.mediscreen.rapport.proxy;

import com.mediscreen.rapport.domain.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PATIENT-MICROSERVICE", url = "localhost:8081")
public interface PatientMicroserviceProxy {

    @GetMapping(value = "/patients/patientByFamilyAndGiven")
    //ResponseEntity<Patient> getPatientByLastNameAndFirstName(@RequestParam("family") String lastName, @RequestParam("given") String firstName);
    Patient getPatientByLastNameAndFirstName(@RequestParam("family") String lastName, @RequestParam("given") String firstName);

}
