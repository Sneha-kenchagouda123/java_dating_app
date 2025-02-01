package com.dating_app.model;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "app_user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private int age;

    @ElementCollection
    private List<String> interests;
    
    public User() {
        // Default constructor for JPA
    }
    
    public User(long id, String name, String gender, int age, List<String> interests) {
    	this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.interests = interests;
	}
    public Long getId() {
        return id;
    }
	public Object getName() {
		
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		
		return age;
	}

	public List<String> getInterests() {
		return interests;
	}
}
