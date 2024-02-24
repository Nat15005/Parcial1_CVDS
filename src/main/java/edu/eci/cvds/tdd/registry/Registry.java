package edu.eci.cvds.tdd.registry;

import java.util.HashMap;

public class Registry {
    private HashMap<Integer, Person> registrados = new HashMap<>();
    public RegisterResult registerVoter(Person p) {
        if(!p.isAlive()){
            return RegisterResult.DEAD;
        } else if (p.getAge() < 0 | p.getAge() > 135){
            return RegisterResult.INVALID_AGE;
        }else if (p.getAge() >= 0 && p.getAge() < 18){
            return RegisterResult.UNDERAGE;
        } else if (registrados.containsKey(p.getId())){
            return RegisterResult.DUPLICATED;
        }else{
            registrados.put(p.getId(), p);
            return RegisterResult.VALID;
        }
    }
}