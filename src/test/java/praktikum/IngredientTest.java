package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Mayonnaise", 21.34F);
        Assert.assertEquals(ingredient.getPrice(), 21.34F, 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Mayonnaise", 21.34F);
        Assert.assertEquals("Mayonnaise", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Mayonnaise", 21.34F);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
