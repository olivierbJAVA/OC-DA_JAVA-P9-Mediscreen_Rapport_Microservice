package com.mediscreen.rapport.service;

import com.mediscreen.rapport.domain.Rapport;

/**
 * Interface to be implemented to manage the services for Rapport entities.
 */
public interface IRapportService {

    Rapport getRapport(String lastName, String firstName);

}
