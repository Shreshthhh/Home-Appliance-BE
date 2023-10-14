package com.HomeAppliances;

import jakarta.persistence.*;

@Entity
@Table(name = "test")
@NamedQueries({
        @NamedQuery(name = "Test.findAll", query = "select t from Test t")
})
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
