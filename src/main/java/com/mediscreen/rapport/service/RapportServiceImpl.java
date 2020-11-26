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

    /**
     * Return a report assessing diabetes risk for a patient given its last name and first name.
     *
     * @param lastName The last name of the patient for which to generate the report
     * @param firstName The first name of the patient for which to generate the report
     * @return The report assessing diabetes risk for the patient
     */
    @Override
    public Rapport getRapportByLastNameAndFirstName(String lastName, String firstName) {

        Patient patient = patientProxy.getPatientByLastNameAndFirstName(lastName, firstName);

        List<Note> notes = noteProxy.getNotesByLastNameAndFirstName(lastName, firstName);

        Rapport rapport = new Rapport(patient.getLastName(), patient.getFirstName(), patient.getDateOfBirth(), patient.getSex());
        rapport.setNotes(notes);

        System.out.println("rapport = " + rapport.toString() );

        return rapport;
    }

    /**
     * Return a report assessing diabetes risk for a patient given its identifier.
     *
     * @param id The identifier of the patient for which to generate the report
     * @return The report assessing diabetes risk for the patient
     */
    @Override
    public Rapport getRapportById(long id) {

        Patient patient = patientProxy.getPatientById(id);

        List<Note> notes = noteProxy.getNotesByLastNameAndFirstName(patient.getLastName(), patient.getFirstName());

        Rapport rapport = new Rapport(patient.getLastName(), patient.getFirstName(), patient.getDateOfBirth(), patient.getSex());
        rapport.setNotes(notes);

        System.out.println("rapport = " + rapport.toString() );

        return rapport;
    }
}
