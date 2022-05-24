package UserService;

import java.util.List;

public class Service {
    public Service() {

    }

    private IUserDAO userDAO;

    public Service(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<ServiceDTO> getAllUser() {
        return userDAO.getAll();
    }

    public String createUser(ServiceDTO serviceDTO) {
        return userDAO.create(serviceDTO);
    }

    public String updateUser(Long id, ServiceDTO serviceDTO) {
        return userDAO.update(id, serviceDTO);
    }

    public boolean deleteUser(Long id){
        return userDAO.deleteUser(id);
    }

}
