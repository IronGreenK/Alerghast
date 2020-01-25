package loginRol.springbootmongodb.entity;

import lombok.Data;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Document(collection= "user")
public class User implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @NotNull
    private String id;

    private String email;
    private String password;
    private String fullname;
    private Set<AllergenUser> allergens;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Set<AllergenUser> getAllergens() {
        return allergens;
    }

    public void setAllergens(Set<AllergenUser> allergens) {
        this.allergens = allergens;
    }
}
