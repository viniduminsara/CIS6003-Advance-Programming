package dev.viniduminsara.pahanaedu.business.user.service.impl;

import dev.viniduminsara.pahanaedu.business.user.dto.UserDTO;
import dev.viniduminsara.pahanaedu.business.user.mapper.UserMapper;
import dev.viniduminsara.pahanaedu.business.user.service.UserService;
import dev.viniduminsara.pahanaedu.persistence.user.dao.UserDAO;
import dev.viniduminsara.pahanaedu.persistence.user.dao.impl.UserDAOImpl;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO = new UserDAOImpl();

    @Override
    public UserDTO findUserByUsernameAndPassword(String username, String password) {
        return UserMapper.toDTO(userDAO.findByUsernameAndPassword(username, password));
    }
}
