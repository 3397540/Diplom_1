package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun mockBun;

    @Mock
    Ingredient mockIngredient;

    @Mock
    Ingredient mockIngredient2;

    @Spy
    Burger spyBurger;

    @Test
    public void setBunTest(){
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        Assert.assertEquals(burger.bun, mockBun);
    }

    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient);
        Assert.assertEquals(mockIngredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        List<Ingredient> expected = new ArrayList<>();
        expected.add(0, mockIngredient2);
        burger.ingredients.add(0, mockIngredient);
        burger.ingredients.add(1, mockIngredient2);
        burger.removeIngredient(0);
        Assert.assertEquals(expected, burger.ingredients);
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        List<Ingredient> expected = new ArrayList<>();
        expected.add(0, mockIngredient2);
        expected.add(1, mockIngredient);
        burger.ingredients.add(0, mockIngredient);
        burger.ingredients.add(1,mockIngredient2);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(expected, burger.ingredients);
    }

    @Test
    public void getPriceTest(){
        Burger burger = new Burger();
        burger.bun = mockBun;
        burger.ingredients.add(mockIngredient);
        burger.ingredients.add(mockIngredient2);
        Mockito.when(mockBun.getPrice()).thenReturn(10F);
        Mockito.when(mockIngredient.getPrice()).thenReturn(12.5F);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(22.5F);
        Float expected = 55F;
        Assert.assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest(){
        spyBurger.bun = mockBun;
        spyBurger.ingredients.add(mockIngredient);
        spyBurger.ingredients.add(mockIngredient2);
        Mockito.when(mockBun.getName()).thenReturn("NiceBun");
        Mockito.when(mockIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(mockIngredient.getName()).thenReturn("Mayonnaise");
        Mockito.when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mockIngredient2.getName()).thenReturn("Meat");
        Mockito.when(spyBurger.getPrice()).thenReturn(55F);
        String expected = "(==== NiceBun ====)\n= sauce Mayonnaise =\n= filling Meat =\n(==== NiceBun ====)\n\nPrice: 55,000000\n";
        Assert.assertEquals(expected,spyBurger.getReceipt());
    }
}
