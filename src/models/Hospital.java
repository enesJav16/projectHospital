package models;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private Long id;
    private String HospitalName;
    private String address;
    private List<Department> departments=new ArrayList<>();
    private List<Doctor> doctors=new ArrayList<>();
    private List<Patient> patients=new ArrayList<>();

    public Hospital(String address, Long id, String hospitalName, List<Department> departments, List<Doctor> doctors, List<Patient> patients) {
        this.address = address;
        this.id = id;
        HospitalName = hospitalName;
        this.departments = departments;
        this.doctors = doctors;
        this.patients = patients;
    }

    public Hospital() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String hospitalName) {
        HospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return
                "\nid           :" + id +
                "\nHospitalName :'" + HospitalName +
                "\naddress      :" + address +
                "\ndepartments  :" + departments +
                "\ndoctors      :" + doctors +
                "\npatients     :" + patients +
                "\n:::::::::::::::::::::::::::::::::::::::";
    }
}
