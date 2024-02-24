package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class UnderAgeTest {

    @Test
    public void testIsUnderAge() {
        UnderAge underAge = new UnderAge();

        boolean result1 = underAge.isUnderAge(17);
        Assert.assertTrue(result1);
    }

    @Test
    public void testNotUnderAge() {
        UnderAge underAge = new UnderAge();

        boolean result3 = underAge.isUnderAge(25);

        Assert.assertFalse(result3);
    }

    @Test
    public void testIsUnderAge_LowerLimit() {
        UnderAge underAge = new UnderAge();
        boolean result = underAge.isUnderAge(0);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsUnderAge_Invalid() {
        UnderAge underAge = new UnderAge();
        boolean result = false;
        try {
            result = underAge.isUnderAge(-10);
            Assert.fail("Se esperaba una excepción ");
        } catch (IllegalArgumentException e) {
            Assert.assertFalse("No debería devolver resultado válido para edad negativa", result);
        }
    }

}
