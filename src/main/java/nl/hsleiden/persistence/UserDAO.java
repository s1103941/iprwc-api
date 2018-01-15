package nl.hsleiden.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Singleton;
import nl.hsleiden.model.User;

/**
 *
 * @author Peter van Vliet
 */
@Singleton
public class UserDAO
{
    private final List<User> users;
    
    public UserDAO()
    {
        User user1 = new User();
        user1.setUserId(123);
        user1.setFirstName("Student");
        user1.setMiddleName("hey");
        user1.setLastName("Account");
        user1.setEmailAddress("student@user.com");
        user1.setPassword("student");
        user1.setRole("KLANT");
        
        User user2 = new User();
        user2.setUserId(234);
        user2.setFirstName("Admin");
        user2.setMiddleName("heyy");
        user2.setLastName("Account");
        user2.setEmailAddress("admin@user.com");
        user2.setPassword("admin");
        user2.setRole("ADMIN");
        
        User user3 = new User();
        user3.setUserId(345);
        user3.setFirstName("Docent");
        user3.setLastName("Account");
        user3.setEmailAddress("docent@user.com");
        user3.setPassword("docent");
        user3.setRole("KLANT");
   
        
        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }
    
    public List<User> getAll()
    {
        return users;
    }
    
    public User getById(int id) {
        Optional<User> result = users.stream()
            .filter(user -> user.getUserId() == id)
            .findAny();
        
        return result.isPresent()
            ? result.get()
            : null;
    }
    
    public User getByName(String name)
    {
        Optional<User> result = users.stream()
            .filter(user -> user.getName().equals(name))
            .findAny();
        
        return result.isPresent()
            ? result.get()
            : null;
    }
    
    public User getByEmailAddress(String emailAddress)
    {
        Optional<User> result = users.stream()
            .filter(user -> user.getEmailAddress().equals(emailAddress))
            .findAny();
        
        return result.isPresent()
            ? result.get()
            : null;
    }
    
    public void add(User user)
    {
        users.add(user);
    }
    
    public void update(int id, User user)
    {
        int index = -1;
        for(int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == id)
                index = i;
        }
        if(index != -1)
            users.set(index, user);
    }
    
    public void delete(int id)
    {
        int index = -1;
        for(int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == id)
                index = i;
        }
        if(index != -1)
            users.remove(index);
    }
}
