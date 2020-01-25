package loginRol.springbootmongodb.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;



@Data
@Document(collection = "allegen")
public class AllergenUser implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @NotNull
    private String id;
    private String allergen;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAllergen() {
        return allergen;
    }

    public void setAllergen(String allergen) {
        this.allergen = allergen;
    }
}
