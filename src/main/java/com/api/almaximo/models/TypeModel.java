package com.api.almaximo.models;
import jakarta.persistence.*;

@Entity
@Table(name="type")
public class TypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Name", length = 64, nullable = false)
    private String name;
    @Column(name = "Description", length = 255, nullable = false)
    private String description;

    public TypeModel() {
    }

    public TypeModel(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public TypeModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
