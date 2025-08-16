package dev.viniduminsara.pahanaedu.business.user.service;

import dev.viniduminsara.pahanaedu.business.user.dto.UserDTO;

public interface UserService {

    UserDTO findUserByUsernameAndPassword(String username, String password);

}
