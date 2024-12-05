package service;

import genericService.GenericService;
import models.Department;

import java.util.List;

public interface DepartmentService extends GenericService<Department> {

    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
}
