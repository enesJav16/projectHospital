import com.sun.security.jgss.GSSUtil;
import dao.daoImpl.DepartmentDaoImpl;
import service.DepartmentService;
import service.DoctorService;
import service.HospitalService;
import service.PatientService;
import service.serviceImpl.DepartmentServiceImpl;
import service.serviceImpl.DoctorServiceImpl;
import service.serviceImpl.HospitalServiceImpl;
import service.serviceImpl.PatientServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {
    public static void start() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        HospitalService hospitalService = new HospitalServiceImpl();
        DepartmentService departmentService=new DepartmentServiceImpl();
        DoctorService doctorService=new DoctorServiceImpl();
        PatientService patientService=new PatientServiceImpl();

        while (true) {
            try {
                System.out.println("=========================================================================");
                System.out.println("                         What do you want to do:");
                System.out.println("=========================================================================");
                System.out.println("""
                        1.  Add Hospital                      13. Remove Doctor by Id
                        2.  Find Hospital by Id               14. Update Doctor
                        3.  Get all Hospitals                 15. Find Doctor By Id
                        4.  Get all Patients from hospital    16. Assign Doctors to Department
                        5.  Delete Hospital by Id             17. Get all Doctors by Hospital
                        6.  Get All Hospital by address       18. Get all Doctors by Department
                        7.  Add Department to Hospital        19. Add Patient to Hospital
                        8.  Remove Department by Id           20. Remove Patient
                        9.  Update Department                 21. Update Patient
                        10. Get all Department by Hospital    22. Add Patients to Hospital
                        11. Find Department by Name           23. Get Patient by age
                        12. Add Doctor to Hospital            24. Sort Patients by age
                        """);
                int input = scanner1.nextInt();
                switch (input) {
                    case 1 -> System.out.println(hospitalService.addHospital(HospitalServiceImpl.newHospital()));

                    case 2 -> {
                        System.out.println("Type id:");
                        long hIInput = scanner1.nextInt();
                        if (hospitalService.findHospitalById(hIInput)!= null) {
                            System.out.println(hospitalService.findHospitalById(hIInput));
                        } else {
                            System.out.println("There is no such hospital.");
                        }

                    }
                    case 3 -> System.out.println(hospitalService.getAllHospital());
                    case 4 -> {
                        System.out.println("Type hospital id:");
                        long hIInput = scanner1.nextInt();
                        if (hospitalService.getAllPatientFromHospital(hIInput)!= null) {
                            System.out.println(hospitalService.getAllPatientFromHospital(hIInput));
                        } else {
                            System.out.println("There is no such hospital.");
                        }

                    }
                    case 5 -> {
                        System.out.println("Type hospital id:");
                        long hIInput = scanner1.nextInt();
                        System.out.println(hospitalService.deleteHospitalById(hIInput));
                    }
                    case 6 -> {
                        System.out.println("Type address you:");
                        String hAddressInput = scanner.nextLine();
                        if(!hospitalService.getAllHospitalByAddress(hAddressInput).isEmpty()){
                            System.out.println(hospitalService.getAllHospitalByAddress(hAddressInput));
                        }else{
                            System.out.println("There is no Hospital in that address.");
                        }

                    }
                    case 7 -> {
                        System.out.println("Type hospital id:");
                        long hIInput = scanner1.nextInt();
                        if(hospitalService.findHospitalById(hIInput)!=null) {
                            System.out.println(departmentService.add(hIInput, DepartmentServiceImpl.newDepartment()));
                        }else{
                            System.out.println("There is no such Hospital!");
                        }
                    }

                    case 8 ->{
                        System.out.println("Type Department id:");
                        long dIdInput=scanner1.nextLong();
                        departmentService.removeById(dIdInput);
                    }
                    case 9 ->{
                        System.out.println("Type Department id:");
                        long dIdInput=scanner1.nextLong();
                        System.out.println(departmentService.updateById(dIdInput,DepartmentServiceImpl.newDepartment()));
                    }
                    case 10 ->{
                        System.out.println("Type Hospital Id");
                        long hIdInput= scanner1.nextLong();
                        if(departmentService.getAllDepartmentByHospital(hIdInput)!=null) {
                            System.out.println(departmentService.getAllDepartmentByHospital(hIdInput));
                        }else{
                            System.out.println("There is no such Hospital!");
                        }
                    }
                    case 11 ->{
                        System.out.println("Type name of Department:");
                        String hNameInput= scanner.nextLine();
                        if(departmentService.findDepartmentByName(hNameInput)!=null){
                            System.out.println(departmentService.findDepartmentByName(hNameInput));
                        }else{
                            System.out.println("There is no such Department!");
                        }
                    }
                    case 12 ->{
                        System.out.println("Type Hospital ID:");
                        long hIdInput= scanner1.nextLong();
                        System.out.println(doctorService.add(hIdInput,DoctorServiceImpl.newDoctor()));
                    }
                    case 13 ->{
                        System.out.println("Type Doctor id:");
                        long dIdInput= scanner1.nextLong();
                        doctorService.removeById(dIdInput);
                    }
                    case 14 ->{
                        System.out.println("Type Doctor id:");
                        long dIdInput= scanner1.nextLong();
                        System.out.println(doctorService.updateById(dIdInput, DoctorServiceImpl.newDoctor()));
                    }
                    case 15 ->{
                        System.out.println("Type Doctor id:");
                        long dIdInput= scanner1.nextLong();
                        if(doctorService.findDoctorById(dIdInput)!=null){
                            System.out.println(doctorService.findDoctorById(dIdInput));
                        }else {
                            System.out.println("There is no such Doctor!");
                        }
                    }
                    case 16 ->{
                        System.out.println("Type Department id:");
                        long dIdInput= scanner1.nextLong();
                        System.out.println(doctorService.assignDoctorToDepartment(dIdInput, DoctorServiceImpl.doctorsId()));
                    }
                    case 17 ->{
                        System.out.println("Type Hospital id:");
                        long hIdInput= scanner1.nextLong();
                        if(doctorService.getAllDoctorsByHospitalId(hIdInput)!=null){
                            System.out.println(doctorService.getAllDoctorsByHospitalId(hIdInput));
                        }else{
                            System.out.println("There is no such Hospital");
                        }
                    }
                    case 18 ->{
                        System.out.println("Type Department id:");
                        long dIdInput= scanner1.nextLong();
                        if(doctorService.getAllDoctorsByDepartmentId(dIdInput)!=null){
                            System.out.println(doctorService.getAllDoctorsByDepartmentId(dIdInput));
                        }else{
                            System.out.println("There is o such Department.");
                        }
                    }
                    case 19 ->{
                        System.out.println("Type Hospital id:");
                        long hIdInput= scanner1.nextLong();
                        System.out.println(patientService.add(hIdInput,PatientServiceImpl.newPatient()));
                    }
                    case 20 ->{
                        System.out.println("Type Patient Id:");
                        long pIdInput= scanner1.nextLong();
                        patientService.removeById(pIdInput);
                    }
                    case 21 ->{
                        System.out.println("Type Patient Id You want to Update:");
                        long pIdInput= scanner1.nextLong();
                        System.out.println(patientService.updateById(pIdInput,PatientServiceImpl.newPatient()));
                    }
                    case 22 ->{
                        System.out.println("Type Hospital id:");
                        long hIdInput= scanner1.nextLong();
                        System.out.println(patientService.addPatientsToHospital(hIdInput,PatientServiceImpl.patientList()));
                    }
                    case 23 ->System.out.println(patientService.getPatientByAge());
                    case 24 ->{
                        System.out.println("Type how you want to sort(asc/desc):");
                        String order= scanner.nextLine();
                        System.out.println(patientService.sortPatientsByAge(order));
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Give correct format!");
                scanner1.nextLine();
            }
        }
    }
}
