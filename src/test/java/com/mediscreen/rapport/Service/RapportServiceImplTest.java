package com.mediscreen.rapport.Service;

import com.mediscreen.rapport.constant.Assessment;
import com.mediscreen.rapport.constant.Sex;
import com.mediscreen.rapport.domain.Note;
import com.mediscreen.rapport.domain.Patient;
import com.mediscreen.rapport.domain.Rapport;
import com.mediscreen.rapport.proxy.NoteMicroserviceProxy;
import com.mediscreen.rapport.proxy.PatientMicroserviceProxy;
import com.mediscreen.rapport.service.RapportServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@TestPropertySource("declencheurs")
@ExtendWith(MockitoExtension.class)
public class RapportServiceImplTest {

    private RapportServiceImpl rapportServiceImplUnderTest;

    @Mock
    private PatientMicroserviceProxy mockPatientProxy;

    @Mock
    private NoteMicroserviceProxy mockNoteProxy;

    @BeforeEach
    public void setup(){
        String[] declencheurs = new String[]{"Hemoglobin A1C", "Microalbumine", "Height", "Weight", "Smoker", "Abnormal", "Cholesterol", "Dizziness", "Relapse", "Reaction", "Antibodies"};
        rapportServiceImplUnderTest = new RapportServiceImpl( mockPatientProxy,  mockNoteProxy, declencheurs);
    }

    //Tests for patient with diabetes risk report assessment = NONE
    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexMDeclencheur0() {
        // ARRANGE
        Assessment assessmentTest = Assessment.None;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        List<Note> notesTest = new ArrayList<>();
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexFDeclencheur0() {
        // ARRANGE
        Assessment assessmentTest = Assessment.None;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        List<Note> notesTest = new ArrayList<>();
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexMDeclencheur0() {
        // ARRANGE
        Assessment assessmentTest = Assessment.None;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        List<Note> notesTest = new ArrayList<>();
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexFDeclencheur0() {
        // ARRANGE
        Assessment assessmentTest = Assessment.None;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        List<Note> notesTest = new ArrayList<>();
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexMDeclencheur1() {
        // ARRANGE
        Assessment assessmentTest = Assessment.None;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexFDeclencheur1() {
        // ARRANGE
        Assessment assessmentTest = Assessment.None;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexMDeclencheur1() {
        // ARRANGE
        Assessment assessmentTest = Assessment.None;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexFDeclencheur1() {
        // ARRANGE
        Assessment assessmentTest = Assessment.None;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexMDeclencheurs2() {
        // ARRANGE
        Assessment assessmentTest = Assessment.None;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexFDeclencheurs2() {
        // ARRANGE
        Assessment assessmentTest = Assessment.None;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexFDeclencheur3() {
        // ARRANGE
        Assessment assessmentTest = Assessment.None;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    //Tests for patient with diabetes risk report assessment = BORDERLINE
    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexMDeclencheurs2() {
        // ARRANGE
        Assessment assessmentTest = Assessment.Borderline;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexFDeclencheurs2() {
        // ARRANGE
        Assessment assessmentTest = Assessment.Borderline;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexMDeclencheurs3() {
        // ARRANGE
        Assessment assessmentTest = Assessment.Borderline;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexFDeclencheurs3() {
        // ARRANGE
        Assessment assessmentTest = Assessment.Borderline;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexMDeclencheurs4() {
        // ARRANGE
        Assessment assessmentTest = Assessment.Borderline;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexFDeclencheurs4() {
        // ARRANGE
        Assessment assessmentTest = Assessment.Borderline;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexMDeclencheurs5() {
        // ARRANGE
        Assessment assessmentTest = Assessment.Borderline;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexFDeclencheurs5() {
        // ARRANGE
        Assessment assessmentTest = Assessment.Borderline;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    //Tests for patient with diabetes risk report assessment = IN DANGER
    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexMDeclencheur3() {
        // ARRANGE
        Assessment assessmentTest = Assessment.InDanger;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexMDeclencheur4() {
        // ARRANGE
        Assessment assessmentTest = Assessment.InDanger;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexFDeclencheur4() {
        // ARRANGE
        Assessment assessmentTest = Assessment.InDanger;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexFDeclencheur5() {
        // ARRANGE
        Assessment assessmentTest = Assessment.InDanger;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexFDeclencheur6() {
        // ARRANGE
        Assessment assessmentTest = Assessment.InDanger;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);
        Note noteTest6 = new Note("PatientTestLastName", "PatientTestFirstName","Cholesterol");
        noteTest6.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        notesTest.add(noteTest6);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexMDeclencheur6() {
        // ARRANGE
        Assessment assessmentTest = Assessment.InDanger;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);
        Note noteTest6 = new Note("PatientTestLastName", "PatientTestFirstName","Cholesterol");
        noteTest6.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        notesTest.add(noteTest6);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexFDeclencheur6() {
        // ARRANGE
        Assessment assessmentTest = Assessment.InDanger;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);
        Note noteTest6 = new Note("PatientTestLastName", "PatientTestFirstName","Cholesterol");
        noteTest6.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        notesTest.add(noteTest6);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexMDeclencheur7() {
        // ARRANGE
        Assessment assessmentTest = Assessment.InDanger;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);
        Note noteTest6 = new Note("PatientTestLastName", "PatientTestFirstName","Cholesterol");
        noteTest6.setPatientId(1L);
        Note noteTest7 = new Note("PatientTestLastName", "PatientTestFirstName","Abnormal");
        noteTest7.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        notesTest.add(noteTest6);
        notesTest.add(noteTest7);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexFDeclencheur7() {
        // ARRANGE
        Assessment assessmentTest = Assessment.InDanger;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);
        Note noteTest6 = new Note("PatientTestLastName", "PatientTestFirstName","Cholesterol");
        noteTest6.setPatientId(1L);
        Note noteTest7 = new Note("PatientTestLastName", "PatientTestFirstName","Abnormal");
        noteTest7.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        notesTest.add(noteTest6);
        notesTest.add(noteTest7);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    //Tests for patient with diabetes risk report assessment = EARLY ONSET
    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexMDeclencheur5() {
        // ARRANGE
        Assessment assessmentTest = Assessment.EarlyOnset;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexMDeclencheur6() {
        // ARRANGE
        Assessment assessmentTest = Assessment.EarlyOnset;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);
        Note noteTest6 = new Note("PatientTestLastName", "PatientTestFirstName","Cholesterol");
        noteTest6.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        notesTest.add(noteTest6);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexFDeclencheur7() {
        // ARRANGE
        Assessment assessmentTest = Assessment.EarlyOnset;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);
        Note noteTest6 = new Note("PatientTestLastName", "PatientTestFirstName","Cholesterol");
        noteTest6.setPatientId(1L);
        Note noteTest7 = new Note("PatientTestLastName", "PatientTestFirstName","Abnormal");
        noteTest7.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        notesTest.add(noteTest6);
        notesTest.add(noteTest7);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_LessThan30SexFDeclencheur8() {
        // ARRANGE
        Assessment assessmentTest = Assessment.EarlyOnset;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(2010,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);
        Note noteTest6 = new Note("PatientTestLastName", "PatientTestFirstName","Cholesterol");
        noteTest6.setPatientId(1L);
        Note noteTest7 = new Note("PatientTestLastName", "PatientTestFirstName","Abnormal");
        noteTest7.setPatientId(1L);
        Note noteTest8 = new Note("PatientTestLastName", "PatientTestFirstName","Dizziness");
        noteTest8.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        notesTest.add(noteTest6);
        notesTest.add(noteTest7);
        notesTest.add(noteTest8);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexFDeclencheur8() {
        // ARRANGE
        Assessment assessmentTest = Assessment.EarlyOnset;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);
        Note noteTest6 = new Note("PatientTestLastName", "PatientTestFirstName","Cholesterol");
        noteTest6.setPatientId(1L);
        Note noteTest7 = new Note("PatientTestLastName", "PatientTestFirstName","Abnormal");
        noteTest7.setPatientId(1L);
        Note noteTest8 = new Note("PatientTestLastName", "PatientTestFirstName","Dizziness");
        noteTest8.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        notesTest.add(noteTest6);
        notesTest.add(noteTest7);
        notesTest.add(noteTest8);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexMDeclencheur8() {
        // ARRANGE
        Assessment assessmentTest = Assessment.EarlyOnset;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);
        Note noteTest6 = new Note("PatientTestLastName", "PatientTestFirstName","Cholesterol");
        noteTest6.setPatientId(1L);
        Note noteTest7 = new Note("PatientTestLastName", "PatientTestFirstName","Abnormal");
        noteTest7.setPatientId(1L);
        Note noteTest8 = new Note("PatientTestLastName", "PatientTestFirstName","Dizziness");
        noteTest8.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        notesTest.add(noteTest6);
        notesTest.add(noteTest7);
        notesTest.add(noteTest8);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexFDeclencheur9() {
        // ARRANGE
        Assessment assessmentTest = Assessment.EarlyOnset;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.F, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);
        Note noteTest6 = new Note("PatientTestLastName", "PatientTestFirstName","Cholesterol");
        noteTest6.setPatientId(1L);
        Note noteTest7 = new Note("PatientTestLastName", "PatientTestFirstName","Abnormal");
        noteTest7.setPatientId(1L);
        Note noteTest8 = new Note("PatientTestLastName", "PatientTestFirstName","Dizziness");
        noteTest8.setPatientId(1L);
        Note noteTest9 = new Note("PatientTestLastName", "PatientTestFirstName","Hemoglobin A1C");
        noteTest9.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        notesTest.add(noteTest6);
        notesTest.add(noteTest7);
        notesTest.add(noteTest8);
        notesTest.add(noteTest9);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportByLastNameAndFirstName_MoreThan30SexMDeclencheur9() {
        // ARRANGE
        Assessment assessmentTest = Assessment.EarlyOnset;

        Patient patientTest = new Patient("PatientTestLastName", "PatientTestFirstName", LocalDate.of(1950,01,01), Sex.M, "PatientTestHomeAddress","111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);
        Note noteTest6 = new Note("PatientTestLastName", "PatientTestFirstName","Cholesterol");
        noteTest6.setPatientId(1L);
        Note noteTest7 = new Note("PatientTestLastName", "PatientTestFirstName","Abnormal");
        noteTest7.setPatientId(1L);
        Note noteTest8 = new Note("PatientTestLastName", "PatientTestFirstName","Dizziness");
        noteTest8.setPatientId(1L);
        Note noteTest9 = new Note("PatientTestLastName", "PatientTestFirstName","Hemoglobin A1C");
        noteTest9.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        notesTest.add(noteTest6);
        notesTest.add(noteTest7);
        notesTest.add(noteTest8);
        notesTest.add(noteTest9);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

    @Test
    public void getRapportById_MoreThan30SexMDeclencheur9() {
        // ARRANGE
        Assessment assessmentTest = Assessment.EarlyOnset;

        Patient patientTest = new Patient();
        patientTest.setLastName("PatientTestLastName");
        patientTest.setFirstName("PatientTestFirstName");
        patientTest.setDateOfBirth(LocalDate.of(1950,01,01));
        patientTest.setSex(Sex.M);
        patientTest.setHomeAddress("PatientTestHomeAddress");
        patientTest.setPhoneNumber("111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientById(1L);

        Note noteTest1 = new Note("PatientTestLastName", "PatientTestFirstName","Height");
        noteTest1.setPatientId(1L);
        Note noteTest2 = new Note("PatientTestLastName", "PatientTestFirstName","Weight");
        noteTest2.setPatientId(1L);
        Note noteTest3 = new Note("PatientTestLastName", "PatientTestFirstName","Reaction");
        noteTest3.setPatientId(1L);
        Note noteTest4 = new Note("PatientTestLastName", "PatientTestFirstName","Antibodies");
        noteTest4.setPatientId(1L);
        Note noteTest5 = new Note("PatientTestLastName", "PatientTestFirstName","Smoker");
        noteTest5.setPatientId(1L);
        Note noteTest6 = new Note("PatientTestLastName", "PatientTestFirstName","Cholesterol");
        noteTest6.setPatientId(1L);
        Note noteTest7 = new Note("PatientTestLastName", "PatientTestFirstName","Abnormal");
        noteTest7.setPatientId(1L);
        Note noteTest8 = new Note("PatientTestLastName", "PatientTestFirstName","Dizziness");
        noteTest8.setPatientId(1L);
        Note noteTest9 = new Note("PatientTestLastName", "PatientTestFirstName","Hemoglobin A1C");
        noteTest9.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        notesTest.add(noteTest2);
        notesTest.add(noteTest3);
        notesTest.add(noteTest4);
        notesTest.add(noteTest5);
        notesTest.add(noteTest6);
        notesTest.add(noteTest7);
        notesTest.add(noteTest8);
        notesTest.add(noteTest9);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportById(1L);

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientById(1L);
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }


    //GetRapportById for patient with diabetes risk report assessment = NONE
    @Test
    public void getRapportById_LessThan30SexMDeclencheur1() {
        // ARRANGE
        Assessment assessmentTest = Assessment.None;

        Patient patientTest = new Patient();
        patientTest.setLastName("PatientTestLastName");
        patientTest.setFirstName("PatientTestFirstName");
        patientTest.setDateOfBirth(LocalDate.of(2010,01,01));
        patientTest.setSex(Sex.M);
        patientTest.setHomeAddress("PatientTestHomeAddress");
        patientTest.setPhoneNumber("111-222-3333");
        patientTest.setId(1L);
        doReturn(patientTest).when(mockPatientProxy).getPatientById(1L);

        Note noteTest1 = new Note();
        noteTest1.setPatientLastName("PatientTestLastName");
        noteTest1.setPatientFirstName("PatientTestFirstName");
        noteTest1.setNoteText("Height");
        noteTest1.setPatientId(1L);

        List<Note> notesTest = new ArrayList<>();
        notesTest.add(noteTest1);
        doReturn(notesTest).when(mockNoteProxy).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");

        // ACT
        Rapport rapportGenerated = rapportServiceImplUnderTest.getRapportById(1L);

        // ASSERT
        assertEquals(patientTest.getLastName(), rapportGenerated.getLastName());
        assertEquals(patientTest.getFirstName(), rapportGenerated.getFirstName());
        assertEquals(assessmentTest, rapportGenerated.getAssessment());

        verify(mockPatientProxy, times(1)).getPatientById(1L);
        verify(mockNoteProxy, times(1)).getNotesByLastNameAndFirstName("PatientTestLastName", "PatientTestFirstName");
    }

}

