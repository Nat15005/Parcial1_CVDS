package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;
import static edu.eci.cvds.tdd.registry.Gender.*;

public class RegistryTest {
    private Registry registry = new Registry();

    @Test
    public void validateValidAge() {
        Person person = new Person("Cris", 123456789, 21, MALE, true );
        Person person2 = new Person("Esperanza", 123463089, 135, FEMALE, true );
        Person person3 = new Person("Junior", 363463089, 0, MALE, true );
        RegisterResult result = registry.registerVoter(person);
        RegisterResult result2 = registry.registerVoter(person2);
        RegisterResult result3 = registry.registerVoter(person3);

        Assert.assertEquals(RegisterResult.VALID, result);
        Assert.assertEquals(RegisterResult.VALID, result2);
        Assert.assertEquals(RegisterResult.UNDERAGE, result3);
    }
    @Test
    public void validateUnderAge() {
        Person person = new Person("Maddie", 543217893, 1, FEMALE, true );
        Person person2 = new Person("katalina", 145617893, 17, FEMALE, true );
        RegisterResult result0 = registry.registerVoter(person);
        RegisterResult result = registry.registerVoter(person2);

        Assert.assertEquals(RegisterResult.UNDERAGE, result0);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    @Test
    public void validateInvalidAge() {
        Person person = new Person("Georgina", 543217893, -14, FEMALE, true );
        Person person2 = new Person("Ricardo", 673017893, 136, MALE, true );
        RegisterResult result0 = registry.registerVoter(person);
        RegisterResult result = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result0);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    @Test
    public void validateDead() {
        Person person = new Person("Mac Miller", 511158942, 26, MALE, false );
        Person person2 = new Person("Ariana", 260693111, 30, FEMALE, true );
        RegisterResult result0 = registry.registerVoter(person2);
        RegisterResult result = registry.registerVoter(person);

        Assert.assertNotEquals(RegisterResult.DEAD, result0);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    @Test
    public void validateDuplicate() {
        Person person = new Person("Mateo", 444411111, 21, MALE, true );
        RegisterResult result0 = registry.registerVoter(person);
        Person person2 = new Person("Trueno", 444411111, 21, MALE, true );
        RegisterResult result = registry.registerVoter(person2);

        Assert.assertEquals(RegisterResult.VALID, result0);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }
}

