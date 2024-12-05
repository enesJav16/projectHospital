package dao.daoImpl;

import dao.DepartmentDao;
import database.Database;
import genericService.GenericService;
import models.Department;
import models.Hospital;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao, GenericService<Department> {
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for(Hospital h: Database.hospitals){
            if(h.getId()==id){
                return h.getDepartments();
            }
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for(Hospital h:Database.hospitals){
            for(Department d: h.getDepartments()){
                if(d.getDepartmentName().equals(name)){
                    return d;
                }
            }
        }
        return null;
    }

    @Override
    public String add(Long hospitalId, Department department) {
        for(Hospital h:Database.hospitals){
            if(h.getId()==hospitalId){
                h.getDepartments().add(department);
                return "Department is added";
            }
        }
        return "There is no such Hospital!";
    }

    @Override
    public void removeById(Long id) {
        boolean check=true;
        for(Hospital h:Database.hospitals){
            for(Department d:h.getDepartments()){
                if(d.getId()==id){
                    h.getDepartments().remove(d);
                    System.out.println("Department is removed!");
                    check=false;
                    break;
                }
            }
        }
        if(check) {
            System.out.println("There is no such Department!");
        }
    }

    @Override
    public String updateById(Long id, Department department) {
        for(Hospital h:Database.hospitals){
            for(Department d:h.getDepartments()){
                if(d.getId()==id){
                    d.setDepartmentName(department.getDepartmentName());
                    d.setDoctors(department.getDoctors());
                    return "Department is updated.";
                }
            }
        }
        return "There is no such Department!";
    }
}
