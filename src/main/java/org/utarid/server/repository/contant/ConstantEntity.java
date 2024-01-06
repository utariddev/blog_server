package org.utarid.server.repository.contant;

import jakarta.persistence.*;

@Entity
@Table(name = "blog_constant")
public class ConstantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "key", nullable = false, unique = true)
    private String key;

    @Column(name = "value", columnDefinition = "longtext")
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}