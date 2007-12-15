package com.example;

import java.util.HashSet;
import java.util.Set;

public class People {
    @SuppressWarnings("unchecked")
	public People(){
    	Person p1 =  new Person();
    	p1.setId(1);
    	p1.setName("Juan");
    	p1.setAddress("my address...");
    	p1.setSalary(12000);
    	Person p2 =  new Person();
    	p2.setId(2);
    	p2.setName("Sara");
    	p2.setAddress("my address...");
    	p2.setSalary(15000);
    	people.add(p1);
    	people.add(p2);
    }
    
    private int getNextId(){
    	return people.size()+1;
    }

    @SuppressWarnings("unchecked")
	public Set getAllPeople() {
        return people;
    }

    @SuppressWarnings("unchecked")
	public void setPerson(Person person) {
        if (person.getId() == -1) {
            person.setId(getNextId());
        }

        people.remove(person);
        people.add(person);
    }

    public void deletePerson(Person person) {
        people.remove(person);
    }

    @SuppressWarnings("unchecked")
	private Set people = new HashSet();
}
