package com.raya.model;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

/**
 * Created by raya on 6/20/17.
 */
@Entity

public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String firstName;
    @Column
    private String foodType;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", foodType='" + foodType + '\'' +
                '}';
    }
}
