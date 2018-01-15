package nl.hsleiden.service;

import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;
import nl.hsleiden.model.User;
import nl.hsleiden.persistence.UserDAO;

/**
 *
 * @author Peter van Vliet
 */
@Singleton
public class UserService extends BaseService<User>
{
    private final UserDAO dao;
    
    @Inject
    public UserService(UserDAO dao)
    {
        this.dao = dao;
    }
    
    public Collection<User> getAll()
    {
        return dao.getAll();
    }
     /**
      * @author DannyY
      * @return all users with their information
      * THIS IS USED FOR TESTING PURPOSES ONLY
      */
//    public Collection<User> initAll()
//    {
//        System.out.println("executing initialization of users...");
//        Collection<User> users = dao.getAll();
//        for (User user: users) {
//            user.setSalt(PasswordService.getNextSalt());
//            user.setHash(PasswordService.hash(user.getPassword(), user.getSalt()));
//        }
//        return users;
//    }
    
    public User getByEmail(String emailAdress) {
        return requireResult(dao.getByEmailAddress(emailAdress));
    }
    
    public User getById(int id)
    {
        return requireResult(dao.getById(id));
    }
    
    public void add(User user)
    {
        user.setRole("COACH");
        
        //user.setSalt(PasswordService.getNextSalt());
        //user.setHash(PasswordService.hash(user.getPassword().toCharArray(), user.getSalt()));
        
        dao.add(user);
    }
    
    public void update(User authenticator, int id, User user)
    {
        // Controleren of deze gebruiker wel bestaat
        User oldUser = getById(id);
        
        if (!authenticator.isRole("ADMIN"))
        {
            // Vaststellen dat de geauthenticeerde gebruiker
            // zichzelf aan het aanpassen is
            assertSelf(authenticator, oldUser);
        }
        
        dao.update(id, user);
    }
    
    public void delete(int id)
    {
        // Controleren of deze gebruiker wel bestaat
        User user = getById(id);
        
        dao.delete(id);
    }
    
}
