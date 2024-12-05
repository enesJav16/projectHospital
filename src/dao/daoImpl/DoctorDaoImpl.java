package dao.daoImpl;

import dao.DoctorDao;
import database.Database;
import genericService.GenericService;
import models.Department;
import models.Doctor;
import models.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao, GenericService<Doctor> {
    @Override
    public Doctor findDoctorById(Long id) {
        for(Hospital h: Database.hospitals){
            for(Doctor d:h.getDoctors()){
                if(d.getId()==id){
                    return d;
                }
            }
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        List<Doctor>doctors=new ArrayList<>();
        long idc=1L;
        for (int i = 0; i < doctorsId.size(); i++) {
            for(Hospital h:Database.hospitals){
                for(Doctor d:h.getDoctors()){
                    if(idc==d.getId()){
                        doctors.add(d);
                    }
                }
            }
            idc++;
        }

        for(Hospital h: Database.hospitals){
            for(Department d:h.getDepartments()){
                if(d.getId()==departmentId){
                    d.getDoctors().addAll(doctors);
                    return "Doctors are assigned";
                }
            }
        }
        return "Failed!";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for(Hospital h:Database.hospitals){
            if(h.getId()==id){
                return h.getDoctors();
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for(Hospital h:Database.hospitals){
            for(Department d:h.getDepartments()){
                if(d.getId()==id){
                    return d.getDoctors();
                }
            }
        }
        return null;
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        for(Hospital h:Database.hospitals){
            if(h.getId()==hospitalId){
                h.getDoctors().add(doctor);
                return "Doctor is added to hospital";
            }
        }
        return "There is no such Hospital!";
    }

    @Override
    public void removeById(Long id) {
        boolean check=true;
        for(Hospital h:Database.hospitals){
            for(Doctor d:h.getDoctors()){
                if(d.getId()==id){
                    h.getDoctors().remove(d);
                    System.out.println("Doctor is removed!");
                    check=false;
                    break;
                }
            }
        }
        if(check) {
            System.out.println("There is no such doctor!");
        }
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        for(Hospital h:Database.hospitals){
            for(Doctor d:h.getDoctors()){
                if(d.getId()==id){
                    d.setFirstName(doctor.getFirstName());
                    d.setLastName(doctor.getLastName());
                    d.setExperienceYear(doctor.getExperienceYear());
                    d.setGender(doctor.getGender());
                    return "Doctor is updated.";

                }
            }
        }
        return "There is n such doctor.";
    }
}
