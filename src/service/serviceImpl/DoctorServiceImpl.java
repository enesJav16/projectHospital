package service.serviceImpl;

import dao.DoctorDao;
import dao.daoImpl.DoctorDaoImpl;
import enums.Gender;
import generateId.GenerateId;
import genericService.GenericService;
import models.Doctor;
import service.DoctorService;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DoctorServiceImpl implements DoctorService {
    DoctorDaoImpl doctorDao = new DoctorDaoImpl();

    @Override
    public Doctor findDoctorById(Long id) {
        return doctorDao.findDoctorById(id);
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return doctorDao.assignDoctorToDepartment(departmentId, doctorsId);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorDao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return doctorDao.getAllDoctorsByDepartmentId(id);
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        return doctorDao.add(hospitalId, doctor);
    }

    @Override
    public void removeById(Long id) {
        doctorDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        return doctorDao.updateById(id, doctor);
    }

    public static Doctor newDoctor() throws IllegalArgumentException, InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        Doctor doctor = new Doctor();

        doctor.setId(GenerateId.doctorId());
        System.out.println("Type first name:");
        doctor.setFirstName(scanner.nextLine());
        System.out.println("Type last name:");
        doctor.setLastName(scanner.nextLine());
        while (true) {
            try {
                System.out.println("Type experience year:");
                doctor.setExperienceYear(new Scanner(System.in).nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Give number.");
            }
        }
        while (true) {
            try {
                System.out.println("Type gender(male/female):");
                doctor.setGender(Gender.valueOf(scanner.nextLine().toUpperCase()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Give correct gender");
            }
        }
        return doctor;
    }

    public static List<Long> doctorsId() throws InputMismatchException{
        Scanner scanner = new Scanner(System.in);
        List<Long> ids = new ArrayList<>();
        boolean check = true;
        System.out.println("Give doctors id:");
        System.out.println("To finish giving ids type '0'");
        while (check) {

                System.out.println("Give id:");
                long id = scanner.nextLong();
                if (id == 0) {
                    break;
                }
                ids.add(id);

        }
        return ids;
    }

}
