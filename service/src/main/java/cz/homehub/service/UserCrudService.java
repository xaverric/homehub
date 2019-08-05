package cz.homehub.service;

import cz.homehub.entity.User;
import cz.homehub.repository.UserDao;
import cz.homehub.service.api.UserService;
import cz.homehub.service.configuration.ServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserCrudService implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ServiceConfig serviceConfig;

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User getById(Long id) throws EntityNotFoundException {
        return userDao.findById(id).orElseThrow(() -> new EntityNotFoundException(serviceConfig.getUserNotFoundIdMessage() + id));
    }

    @Override
    public User getByUsername(String username) throws EntityNotFoundException {
        return userDao.findByUserName(username).orElseThrow(() -> new EntityNotFoundException(serviceConfig.getUserNotFoundUsernameMessage() + username));
    }

    @Override
    public User insert(User entity) {
        throw new UnsupportedOperationException(serviceConfig.getOperationNotSupportedMessage());
    }

    @Override
    public User update(User entity) throws EntityNotFoundException {
        Optional<User> userOpt = userDao.findById(entity.getId());
        if (userOpt.isPresent()){
            User user = userOpt.get();
            user.setName(entity.getName());
            user.setSurname(entity.getSurname());
            user.setUsername(entity.getUsername());
            user.setPassword(entity.getPassword());
            user.setEmailAddress(entity.getEmailAddress());
            user.setPhoneNumber(entity.getPhoneNumber());
            userDao.save(user);

            return user;
        }
        throw new EntityNotFoundException(serviceConfig.getUserNotFoundIdMessage() + entity.getId());
    }

    @Override
    public User delete(User entity) throws EntityNotFoundException {
        return null;
    }

}
