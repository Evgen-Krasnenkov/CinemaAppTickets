package movie.theater.service.mapper;

import java.util.stream.Collectors;
import movie.theater.dto.response.UserResponseDto;
import movie.theater.model.Role;
import movie.theater.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        responseDto.setUserRoles(user
                .getUserRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
