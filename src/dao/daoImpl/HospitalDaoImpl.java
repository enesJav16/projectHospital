package dao.daoImpl;

import dao.HospitalDao;
import database.Database;
import generateId.GenerateId;
import models.Doctor;
import models.Hospital;
import models.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HospitalDaoImpl implements HospitalDao {
    @Override
    public String addHospital(Hospital hospital) {
        Database.hospitals.add(hospital);
        return "Successfully added!.";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital h : Database.hospitals) {
            if (h.getId() == id) {
                return h;
            }
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return Database.hospitals;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for (Hospital h : Database.hospitals) {
            if (h.getId() == id) {
                return h.getPatients();
            }
        }
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        for (Hospital h : Database.hospitals) {
            if (h.getId() == id) {
                Database.hospitals.remove(h);
                return "Hospital is deleted!";
            }
        }
        return "There is no such Hospital!";

    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {

        List<Hospital> hospitalList = Database.hospitals;
        Map<String, Hospital> result = new HashMap<>();

        for (Hospital hospital : hospitalList) {
            if (hospital.getAddress().equalsIgnoreCase(address)) {
                result.put(hospital.getHospitalName(), hospital);
            }
        }

        return result;
    }

}
