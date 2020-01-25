package loginRol.springbootmongodb.entity;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

public class GroceryProductMappingInput implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @NotNull
    private String id;
    private String ingredients;
    private int servings;


    public String getId() {
        return id;
    }

    public int getServings() {
        return servings;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }
}
