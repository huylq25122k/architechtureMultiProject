package userDAO;

import UserService.IUserDAO;
import UserService.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import userDAO.h.UserRepository;
import userDAO.h.UserDAO;

import java.util.ArrayList;
import java.util.List;

@Component
public class IUserDAOImpl implements IUserDAO {

    private UserRepository userRepository;

    List<ServiceDTO> serviceDTOs = new ArrayList<>();

    @Autowired
    public IUserDAOImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<ServiceDTO> getAll() {

        List<ServiceDTO> serviceDTO = new ArrayList<ServiceDTO>();
        for (UserDAO userDAO : userRepository.findAll()) {
            serviceDTO.add(toServiceEntity(userDAO));
        }
        return serviceDTO;

    }

    @Override
    public String create(ServiceDTO serviceDTO) {
        userRepository.save(toDAOEntity(serviceDTO));
        return "something";
    }

    @Override
    public String update(Long id, ServiceDTO serviceDTO) {
        if (serviceDTO != null) {
            UserDAO userDAO = userRepository.getById(id);
            if (userDAO != null) {
                userDAO.setName(serviceDTO.getName());
                userRepository.save(toDAOEntity(serviceDTO));
                return "ok";
            }

        }
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        UserDAO userDAO = userRepository.getById(id);
        userRepository.delete(toDAOEntity(toServiceEntity(userDAO)));
        return false;
    }


    public static ServiceDTO toServiceEntity(UserDAO userDAO) {
        if (userDAO == null) {
            return null;
        }
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(userDAO.getId());
        serviceDTO.setName(userDAO.getName());
        return serviceDTO;
    }

    public static UserDAO toDAOEntity(ServiceDTO serviceDTO) {
        UserDAO userDAO = new UserDAO();
        userDAO.setId(serviceDTO.getId());
        userDAO.setName(serviceDTO.getName());
        return userDAO;
    }

}
