package user_task_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import user_task_manager.data.entity.DepartmentEntity;
import user_task_manager.data.repository.DepartmentRepository;
import user_task_manager.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/company/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<DepartmentEntity> getDepartments(){
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public DepartmentEntity getDepartmentById(@PathVariable("id") int id){
        return departmentRepository.findById(id).orElse(null);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("")
    public DepartmentEntity saveDepartment(@RequestBody DepartmentEntity department){
        return departmentRepository.save(department);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PutMapping("/{id}")
    public DepartmentEntity updateDepartment(@PathVariable("id") int id, @RequestBody DepartmentEntity department){
        if(department.getDepId() > 0){
            return departmentRepository.save(department);
        }else{
            return null;
        }
    }

    @PreAuthorize("hasAuthority('Admin')")
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable("id") int id){
        departmentRepository.deleteById(id);
    }

}
