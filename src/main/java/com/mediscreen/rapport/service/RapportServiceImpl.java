package com.mediscreen.rapport.service;

import com.mediscreen.rapport.domain.Note;
import com.mediscreen.rapport.domain.Patient;
import com.mediscreen.rapport.domain.Rapport;
import com.mediscreen.rapport.proxy.NoteMicroserviceProxy;
import com.mediscreen.rapport.proxy.PatientMicroserviceProxy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class in charge of managing the services for Rapport entities.
 */
@Service
public class RapportServiceImpl implements IRapportService {

    private PatientMicroserviceProxy patientProxy;
    private NoteMicroserviceProxy noteProxy;

    public RapportServiceImpl(PatientMicroserviceProxy patientProxy, NoteMicroserviceProxy noteProxy) {
        this.patientProxy = patientProxy;
        this.noteProxy = noteProxy;
    }

    @Override
    public Rapport getRapport(String lastName, String firstName) {

        Patient patient = patientProxy.getPatientByLastNameAndFirstName(lastName, firstName);

        List<Note> notes = noteProxy.getNotesByLastNameAndFirstName(lastName, firstName);

        Rapport rapport = new Rapport(patient.getLastName(), patient.getFirstName(), patient.getDateOfBirth(), patient.getSex());
        rapport.setNotes(notes);

        System.out.println("rapport = " + rapport.toString() );

        return rapport;
    }

}
