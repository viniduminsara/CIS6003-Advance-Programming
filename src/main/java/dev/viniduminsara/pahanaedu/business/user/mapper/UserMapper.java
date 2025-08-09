package dev.viniduminsara.pahanaedu.business.user.mapper;

import dev.viniduminsara.pahanaedu.business.user.dto.UserDTO;
import dev.viniduminsara.pahanaedu.business.user.model.User;

public class UserMapper {

    public static User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        return new User.Builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .fullName(dto.getFullName())
                .contactNumber(dto.getContactNumber())
                .email(dto.getEmail())
                .build();
    }

    public static UserDTO toDTO(User entity) {
        if (entity == null) {
            return null;
        }
        return new UserDTO.Builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .fullName(entity.getFullName())
                .contactNumber(entity.getContactNumber())
                .email(entity.getEmail())
                .build();
    }

}
