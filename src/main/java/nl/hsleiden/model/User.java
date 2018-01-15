package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.security.Principal;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Meer informatie over validatie:
 *  http://hibernate.org/validator/
 * 
 * @author Peter van Vliet
 */
public class User implements Principal
{
    
    public enum UserRoles {
        KLANT, ADMIN
    }
    
    @JsonView(View.Public.class)
    private int userId;

    @NotEmpty
    @Length(min = 2, max = 100)
    @JsonView(View.Public.class)
    private String firstName;
    
    @Length(min = 0, max = 100)
    @JsonView(View.Public.class)
    private String middleName;
    
    @NotEmpty
    @Length(min = 2, max = 100)
    @JsonView(View.Public.class)
    private String lastName;
    
    @NotEmpty
    @Length(min = 1, max = 40)
    @JsonView(View.Internal.class)
    private String password;
    
    @NotEmpty
    @Email
    @JsonView(View.Public.class)
    private String emailAddress;
    
    @JsonView(View.Public.class)
    private UserRoles role;
    
    public boolean equals(User user)
    {
        return getEmailAddress().equals(user.getEmailAddress());
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getFirstName() {
        return firstName;
    }

  
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getMiddleName() {
        return middleName;
    }


    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

 
    public String getEmailAddress() {
        return emailAddress;
    }


    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public boolean isRole(String role)
    {
        return role.equals(this.getRole().name());
    }

 
    public UserRoles getRole() {
        return role;
    }


    public void setRole(UserRoles role) {
        this.role = role;
    }
    
    public void setRole(String role) {
        this.role = UserRoles.valueOf(role.toUpperCase());
    }

    @Override
    @JsonIgnore
    public String getName() {
        return this.firstName + this.lastName;
        //To change body of generated methods, choose Tools | Templates.
    }

 
    public String getPassword() {
        return password;
    }

 
    public void setPassword(String password) {
        this.password = password;
    }

 

    

}
