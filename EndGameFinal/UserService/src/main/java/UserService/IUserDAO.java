package UserService;

import java.util.List;

public interface IUserDAO {
    List<ServiceDTO> getAll();

    String create(ServiceDTO serviceDTO);

    String update(Long id, ServiceDTO serviceDTO);

    boolean deleteUser(Long id);
}
