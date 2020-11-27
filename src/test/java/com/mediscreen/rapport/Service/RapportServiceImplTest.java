package com.mediscreen.rapport.Service;

import com.mediscreen.rapport.constant.Sex;
import com.mediscreen.rapport.domain.Note;
import com.mediscreen.rapport.domain.Patient;
import com.mediscreen.rapport.domain.Rapport;
import com.mediscreen.rapport.proxy.NoteMicroserviceProxy;
import com.mediscreen.rapport.proxy.PatientMicroserviceProxy;
import com.mediscreen.rapport.service.RapportServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class RapportServiceImplTest {

    @InjectMocks
    private RapportServiceImpl rapportServiceImplUnderTest;

    @Mock
    private PatientMicroserviceProxy mockPatientProxy;

    @Mock
    private NoteMicroserviceProxy mockNoteProxy;

    @Test
    public void getRapportByLastNameAndFirstName() {
        // ARRANGE
        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2000,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","NoteText1");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","NoteText2");
        noteTest1.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","NoteText3");
        noteTest1.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportFound = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportById() {
        // ARRANGE
        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2000,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientById(1L);

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","NoteText1");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","NoteText2");
        noteTest1.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","NoteText3");
        noteTest1.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportFound = rapportServiceImplUnderTest.getRapportById(1L);

        // ASSERT
        verify(mockPatientProxy, times(1)).getPatientById(1L);
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }
}
