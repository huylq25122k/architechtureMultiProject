package userController;

import UserService.Service;
import UserService.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private Service service;

    @Autowired
    public UserController(Service service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<ServiceDTO> getAll() {
        return service.getAllUser();
    }

    @PostMapping("/create")
    public String create(@RequestBody ServiceDTO serviceDTO) {
        return service.createUser(serviceDTO);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @Valid @RequestBody ServiceDTO serviceDTO) {
        return service.updateUser(id, serviceDTO);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return service.deleteUser(id);
    }

}