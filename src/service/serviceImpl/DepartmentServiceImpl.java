package service.serviceImpl;

import dao.DepartmentDao;
import dao.daoImpl.DepartmentDaoImpl;
import generateId.GenerateId;
import genericService.GenericService;
import models.Department;
import service.DepartmentService;

import java.util.List;
import java.util.Scanner;

public class DepartmentServiceImpl implements DepartmentService {
    DepartmentDaoImpl departmentDao=new DepartmentDaoImpl();

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return departmentDao.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return departmentDao.findDepartmentByName(name);
    }

    @Override
    public String add(Long hospitalId, Department department) {
        return departmentDao.add(hospitalId,department);
    }

    @Override
    public void removeById(Long id) {
        departmentDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Department department) {
        return departmentDao.updateById(id, department);
    }

    public static Department newDepartment(){
        Department department=new Department();

        department.setId(GenerateId.departmentId());
        System.out.println("Type Department name:");
        department.setDepartmentName(new Scanner(System.in).nextLine());

        return department;
    }
}
