package dao.daoImpl;

import dao.PatientDao;
import database.Database;
import genericService.GenericService;
import models.Hospital;
import models.Patient;

import java.util.*;

public class PatientDaoImpl implements PatientDao, GenericService<Patient> {
    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital h : Database.hospitals) {
            if (h.getId() == id) {
                h.getPatients().addAll(patients);
                return "Patients added";
            }
        }
        return "Failure!";
    }

    @Override
    public Patient getPatientById(Long id) {
        for(Hospital h:Database.hospitals){
            for(Patient p: h.getPatients()){
                if(p.getId()==id){
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {

        List<Patient> patientslList = new ArrayList<>();
        for(Hospital h:Database.hospitals){
            for(Patient p:h.getPatients()){
                patientslList.add(p);
            }
        }
        Map<Integer, Patient> result = new HashMap<>();

        for (Patient p : patientslList) {
            result.put(p.getAge(), p);
        }

        return result;

    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> patients = new ArrayList<>();
        for(Hospital h:Database.hospitals){
            for(Patient p:h.getPatients()){
                patients.add(p);
            }
        }
        if ("asc".equalsIgnoreCase(ascOrDesc)) {
            patients.sort(Comparator.comparingInt(Patient::getAge));
        } else if ("desc".equalsIgnoreCase(ascOrDesc)) {
            patients.sort(Comparator.comparingInt(Patient::getAge).reversed());
        }

        return patients;
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        for(Hospital h:Database.hospitals){
            if(h.getId()==hospitalId){
                h.getPatients().add(patient);
                return "Patient is added.";
            }
        }
        return "There is no such Patient!";
    }

    @Override
    public void removeById(Long id) {
        boolean check=true;
        for(Hospital h:Database.hospitals){
            for(Patient p:h.getPatients()){
                if(p.getId()==id){
                    h.getPatients().remove(p);
                    System.out.println("Success!");
                    check=false;
                    break;
                }
            }
        }
        if(check) {
            System.out.println("Failure!");
        }
    }

    @Override
    public String updateById(Long id, Patient patient) {
        for(Hospital h:Database.hospitals){
            for(Patient p:h.getPatients()){
                if(p.getId()==id){
                    p.setFirstName(patient.getFirstName());
                    p.setLastName(patient.getLastName());
                    p.setAge(patient.getAge());
                    p.setGender(patient.getGender());
                    return "Patient is updated!";
                }
            }
        }
        return "There is no such patient!";
    }
}
