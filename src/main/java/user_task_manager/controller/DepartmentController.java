package user_task_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user_task_manager.data.entity.DepartmentEntity;
import user_task_manager.data.repository.DepartmentRepository;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("")
    public List<DepartmentEntity> getDepartments(){
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public DepartmentEntity getDepartmentById(@PathVariable("id") int id){
        return departmentRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public DepartmentEntity saveDepartment(@RequestBody DepartmentEntity department){
        return departmentRepository.save(department);
    }

    @PutMapping("/{id}")
    public DepartmentEntity updateDepartment(@PathVariable("id") int id, @RequestBody DepartmentEntity department){
        if(department.getDepId() > 0){
            return departmentRepository.save(department);
        }else{
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable("id") int id){
        departmentRepository.deleteById(id);
    }

}
