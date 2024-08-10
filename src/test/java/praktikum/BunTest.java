package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void getNameTest(){
        Bun bun = new Bun("Test", 10.54F);
        Assert.assertEquals("Test", bun.getName());
    }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun("Test", 10.54F);
        Assert.assertEquals(10.54F, bun.getPrice(), 0);
    }


}
