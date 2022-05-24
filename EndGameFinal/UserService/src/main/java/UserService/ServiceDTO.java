package UserService;

public class ServiceDTO {
    private long id;
    private String name;

    public ServiceDTO(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public ServiceDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}