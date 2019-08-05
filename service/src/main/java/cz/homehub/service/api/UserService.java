package cz.homehub.service.api;

import cz.homehub.entity.User;

import javax.persistence.EntityNotFoundException;

public interface UserService extends CrudService<User>{

    User getByUsername(String username) throws EntityNotFoundException;
}
