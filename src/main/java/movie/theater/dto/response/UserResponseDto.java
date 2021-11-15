package movie.theater.dto.response;

import java.util.List;
import movie.theater.model.RolesEnum;

public class UserResponseDto {
    private Long id;
    private String email;
    private List<RolesEnum> userRoles;

    public List<RolesEnum> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<RolesEnum> userRoles) {
        this.userRoles = userRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
