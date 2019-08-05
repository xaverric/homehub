package cz.homehub.init;

import cz.homehub.entity.Flat;
import cz.homehub.entity.User;
import cz.homehub.repository.FlatDao;
import cz.homehub.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class UserDataSet implements Dataset {

    @Autowired
    private UserDao userDao;

    @Autowired
    private FlatDao flatDao;

    @Override
    public void load() {
        createUser("David", "Jančura", 000000, "default@email.cz", "jancurada", "g61", flatDao.findByFlatNumber(61));
        createUser("Daniel", "Jílek", 000000, "default@email.cz", "jilekda", "g77", flatDao.findByFlatNumber(77));
    }

    private void createUser(String name, String surname, Integer phone, String email, String username, String password, Flat flat){
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPhoneNumber(phone);
        user.setEmailAddress(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setFlat(flat);
        userDao.save(user);
    }

}
