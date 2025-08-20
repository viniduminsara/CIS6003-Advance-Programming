package dev.viniduminsara.pahanaedu.persistence.user.dao;

import dev.viniduminsara.pahanaedu.business.user.model.User;

public interface UserDAO {

    User findByUsernameAndPassword(String username, String password);

}
