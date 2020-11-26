package com.mediscreen.rapport.proxy;

import com.mediscreen.rapport.domain.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "NOTE-MICROSERVICE", url = "localhost:8082")
public interface NoteMicroserviceProxy {

    @GetMapping(value = "/notes/patHistoryByFamilyAndGiven")
    List<Note> getNotesByLastNameAndFirstName(@RequestParam("family") String lastName, @RequestParam("given") String firstName);

}
