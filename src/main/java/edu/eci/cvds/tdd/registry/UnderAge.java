package edu.eci.cvds.tdd.registry;

import static edu.eci.cvds.tdd.registry.Gender.FEMALE;
import static edu.eci.cvds.tdd.registry.Gender.MALE;

public class UnderAge {
    public boolean isUnderAge(int age)  {

            if (age < 0) {
                throw new IllegalArgumentException("La edad no puede ser negativa");
            }
            return age >= 0 && age <= 17;
        }
    }

