package com.mediscreen.rapport.service;

import com.mediscreen.rapport.constant.Assessment;
import com.mediscreen.rapport.domain.Note;
import com.mediscreen.rapport.domain.Patient;
import com.mediscreen.rapport.domain.Rapport;
import com.mediscreen.rapport.proxy.NoteMicroserviceProxy;
import com.mediscreen.rapport.proxy.PatientMicroserviceProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class in charge of managing the services for Rapport entities.
 */
//@PropertySource(value="declencheurs", encoding = "UTF-8")
@PropertySource("declencheurs")
@Service
public class RapportServiceImpl implements IRapportService {

    @Value("${listDeclencheurs}")
    private String[] declencheurs;

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

        Assessment assessment = computeRiskAssessment(patient, notes);

        Rapport rapport = new Rapport(patient.getLastName(), patient.getFirstName(), patient.getDateOfBirth(), patient.getSex(), assessment);

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

        Assessment assessment = computeRiskAssessment(patient, notes);

        Rapport rapport = new Rapport(patient.getLastName(), patient.getFirstName(), patient.getDateOfBirth(), patient.getSex(), assessment);

        return rapport;
    }

    /**
     * Compute the diabetes risk assessment for a patient and its notes history.
     *
     * @param patient The patient for which to generate the report
     * @param notes The patient notes history
     * @return The diabetes risk assessment for the patient
     */
    @Override
    public Assessment computeRiskAssessment(Patient patient, List<Note> notes) {

        long nbDeclencheurs = computeNbDeclencheurs(notes);

        // TO DO
        Assessment assessment = Assessment.None;

        return assessment;
    }

    /**
     * Compute the number of diabetes risk declencheurs for a patient and its notes history.
     *
     * @param notes The patient notes history
     * @return The number of diabetes risk declencheurs for the patient
     */
    @Override
    public long computeNbDeclencheurs(List<Note> notes) {

        Arrays.stream(declencheurs).forEach((a)->System.out.println(a));

        String notesString = notes.stream()
                .map(note -> note.getNoteText())
                .map(noteText -> noteText.toLowerCase())
                .map(noteText -> noteText.trim())
                .collect(Collectors.joining());

        long nbDeclencheurs = Arrays.stream(declencheurs)
                .map(declencheur -> declencheur.toLowerCase())
                .filter(s->notesString.contains(s))
                .distinct()
                .count();

        System.out.println("notes =" + notesString);
        System.out.println("nbDeclencheurs =" + nbDeclencheurs);

        return nbDeclencheurs;
    }
}
