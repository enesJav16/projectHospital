package service;

import genericService.GenericService;
import models.Patient;

import java.util.List;
import java.util.Map;

public interface PatientService extends GenericService<Patient> {
    String addPatientsToHospital(Long id, List<Patient> patients);
    Patient getPatientById(Long id);
    Map<Integer, Patient> getPatientByAge();
    List<Patient> sortPatientsByAge(String ascOrDesc);
}
