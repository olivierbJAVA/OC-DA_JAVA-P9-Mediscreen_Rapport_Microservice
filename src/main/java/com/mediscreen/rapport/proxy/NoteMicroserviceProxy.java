package com.mediscreen.rapport.proxy;

import com.mediscreen.rapport.domain.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Proxy for the Note Microservice using Feign to communicate with the Note Microservice.
 */
@FeignClient(name = "NOTE-MICROSERVICE", url = "${noteMicroserviceUrl}")
public interface NoteMicroserviceProxy {

    /**
     * Return the notes history for a patient given its last name and first name.
     *
     * @param lastName The last name of the patient for which to get the notes
     * @param firstName The first name of the patient for which to get the notes
     * @return The list of notes
     */
    @GetMapping(value = "/patHistoryByFamilyAndGiven")
    List<Note> getNotesByLastNameAndFirstName(@RequestParam("family") String lastName, @RequestParam("given") String firstName);

}
