package com.acme.app1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Street {

    @Id
    private String id;
    private String name;

    public Street() {
    }

    public Street(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Street{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
