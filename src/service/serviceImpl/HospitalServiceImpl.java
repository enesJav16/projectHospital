package service.serviceImpl;

import dao.HospitalDao;
import dao.daoImpl.HospitalDaoImpl;
import generateId.GenerateId;
import models.Hospital;
import models.Patient;
import service.HospitalService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HospitalServiceImpl implements HospitalService {
    HospitalDao hospitalDao=new HospitalDaoImpl();
    @Override
    public String addHospital(Hospital hospital) {
        return hospitalDao.addHospital(hospital);
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return hospitalDao.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalDao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        return hospitalDao.deleteHospitalById(id);
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return hospitalDao.getAllHospitalByAddress(address);
    }

    public static Hospital newHospital(){
        Scanner scanner=new Scanner(System.in);

        Hospital hospital=new Hospital();
        hospital.setId(GenerateId.hospitalId());
        System.out.println("Type name of hospital:");
        hospital.setHospitalName(scanner.nextLine());
        System.out.println("Type address of hospital:");
        hospital.setAddress(scanner.nextLine());

        return hospital;
    }
}
