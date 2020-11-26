package com.mediscreen.rapport.service;

import com.mediscreen.rapport.domain.Rapport;

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
}
