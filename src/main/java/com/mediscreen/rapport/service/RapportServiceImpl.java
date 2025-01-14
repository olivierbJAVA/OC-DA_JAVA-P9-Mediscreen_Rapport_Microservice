package com.mediscreen.rapport.service;

import com.mediscreen.rapport.constant.Assessment;
import com.mediscreen.rapport.constant.Sex;
import com.mediscreen.rapport.domain.Note;
import com.mediscreen.rapport.domain.Patient;
import com.mediscreen.rapport.domain.Rapport;
import com.mediscreen.rapport.proxy.NoteMicroserviceProxy;
import com.mediscreen.rapport.proxy.PatientMicroserviceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class in charge of managing the services for Rapport entities.
 */
@PropertySource("declencheurs")
@Service
public class RapportServiceImpl implements IRapportService {

    private static final Logger logger = LoggerFactory.getLogger(RapportServiceImpl.class);

    private final PatientMicroserviceProxy patientProxy;
    private final NoteMicroserviceProxy noteProxy;
    private final String[] declencheurs;

    public RapportServiceImpl(PatientMicroserviceProxy patientProxy, NoteMicroserviceProxy noteProxy, @Value("${listDeclencheurs}") String[] declencheurs) {
        this.patientProxy = patientProxy;
        this.noteProxy = noteProxy;
        this.declencheurs = declencheurs;
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

        Rapport rapport = new Rapport(patient.getLastName(), patient.getFirstName(), patient.getSex(), getPatientAge(patient), assessment);

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

        Rapport rapport = new Rapport(patient.getLastName(), patient.getFirstName(), patient.getSex(), getPatientAge(patient), assessment);

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

        long agePatient = getPatientAge(patient);

        Assessment assessment = Assessment.None;

        if( (agePatient>30 && nbDeclencheurs>=8) ||
            (Sex.F.equals(patient.getSex()) && agePatient<30 && nbDeclencheurs>=7) ||
            (Sex.M.equals(patient.getSex()) && agePatient<30 && nbDeclencheurs>=5)
        ) {
            assessment = Assessment.EarlyOnset;
        } else if ( (agePatient>30 && nbDeclencheurs>=6 ) ||
                    (Sex.F.equals(patient.getSex()) && agePatient<30 && nbDeclencheurs>=4 && nbDeclencheurs<=6) ||
                    (Sex.M.equals(patient.getSex()) && agePatient<30 && nbDeclencheurs>=3 && nbDeclencheurs<=4)
        ) {
            assessment = Assessment.InDanger;
        } else if ( agePatient>30 && nbDeclencheurs>=2
        ) {
            assessment = Assessment.Borderline;
        }

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

        String notesConcatenated = notes.stream()
                .map(Note::getNoteText)
                .map(String::toLowerCase)
                .map(String::trim)
                .collect(Collectors.joining());

        long nbDeclencheurs = Arrays.stream(declencheurs)
                .map(String::toLowerCase)
                .filter(notesConcatenated::contains)
                .distinct()
                .count();

        logger.debug("notes : {}", notesConcatenated);
        logger.debug("nbDeclencheurs : {}", nbDeclencheurs);

        return nbDeclencheurs;
    }

    /**
     * Compute the age of a patient.
     *
     * @param patient The patient
     * @return The age of a patient
     */
    @Override
    public long getPatientAge(Patient patient) {

        return ChronoUnit.YEARS.between(patient.getDateOfBirth(), LocalDate.now());
    }
}
