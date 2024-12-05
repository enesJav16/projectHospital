package service.serviceImpl;

import dao.PatientDao;
import dao.daoImpl.PatientDaoImpl;
import enums.Gender;
import generateId.GenerateId;
import models.Patient;
import service.PatientService;

import java.util.*;

public class PatientServiceImpl implements PatientService {
    PatientDaoImpl patientDao=new PatientDaoImpl();

    @Override
    public String add(Long hospitalId, Patient patient) {
        return patientDao.add(hospitalId,patient);
    }

    @Override
    public void removeById(Long id) {
        patientDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Patient patient) {
        return patientDao.updateById(id,patient);
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return patientDao.addPatientsToHospital(id,patients);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return patientDao.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return patientDao.sortPatientsByAge(ascOrDesc);
    }

    public static Patient newPatient()throws IllegalArgumentException, InputMismatchException {
        Scanner scanner=new Scanner(System.in);
        Patient patient=new Patient();

        patient.setId(GenerateId.patientId());
        System.out.println("Type Patient first name:");
        patient.setFirstName(scanner.nextLine());
        System.out.println("Type Patient last name:");
        patient.setLastName(scanner.nextLine());
        while(true) {
            try {
                System.out.println("Type Patient age:");
                patient.setAge(new Scanner(System.in).nextInt());
                break;
            }catch (InputMismatchException e){
                System.out.println("Give number!");
            }
        }
        while(true) {
            try {
                System.out.println("Type patient gender(male/female)");
                patient.setGender(Gender.valueOf(scanner.nextLine().toUpperCase()));
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Give correct gender!");
            }
        }

        return patient;
    }

    public static List<Patient>patientList()throws InputMismatchException{
        Scanner scanner=new Scanner(System.in);
        List<Patient>patients=new ArrayList<>();

        boolean check=true;

        System.out.println("Enter Patient Credentials.");

        while (check) {
            System.out.println("To add new Patient type 1");
            System.out.println("When you finished type 0");
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> {
                        Patient p = newPatient();
                        patients.add(p);
                    }
                    default -> check=false;

                }
            }catch (InputMismatchException e){
                System.out.println("Type 1 or 0.");

            }
        }
        return patients;
    }
}
