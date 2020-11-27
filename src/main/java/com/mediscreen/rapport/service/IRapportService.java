package com.mediscreen.rapport.service;

import com.mediscreen.rapport.constant.Assessment;
import com.mediscreen.rapport.domain.Note;
import com.mediscreen.rapport.domain.Patient;
import com.mediscreen.rapport.domain.Rapport;

import java.util.List;

/**
 * Interface to be implemented to manage the services for Rapport entities.
 */
public interface IRapportService {

    /**
     * Return a report assessing diabetes risk for a patient given its last name and first name.
     *
     * @param lastName The last name of the patient for which to generate the report
     * @param firstName The first name of the patient for which to generate the report
     * @return The report assessing diabetes risk for the patient
     */
    Rapport getRapportByLastNameAndFirstName(String lastName, String firstName);

    /**
     * Return a report assessing diabetes risk for a patient given its identifier.
     *
     * @param id The identifier of the patient for which to generate the report
     * @return The report assessing diabetes risk for the patient
     */
    Rapport getRapportById(long id);

    /**
     * Compute the diabetes risk assessment for a patient and its notes history.
     *
     * @param patient The patient for which to generate the report
     * @param notes The patient notes history
     * @return The diabetes risk assessment for the patient
     */
    Assessment computeRiskAssessment(Patient patient, List<Note> notes);

    /**
     * Compute the number of diabetes risk declencheurs for a patient and its notes history.
     *
     * @param notes The patient notes history
     * @return The number of diabetes risk declencheurs for the patient
     */
    long computeNbDeclencheurs(List<Note> notes);
}
