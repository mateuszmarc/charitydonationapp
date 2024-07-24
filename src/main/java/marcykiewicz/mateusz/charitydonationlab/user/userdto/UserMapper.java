package marcykiewicz.mateusz.charitydonationlab.user.userdto;

import marcykiewicz.mateusz.charitydonationlab.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO userDTO);

    UserDTO toDTO(User user);
}
