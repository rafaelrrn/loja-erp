package dev.rafanascimento.commerce.catalog.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String code;

    @Column(length = 255, nullable = false)
    private String name;

    @JoinColumn(name = "parent_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category parent;

    @Column(updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    protected Category() {
    }

    public Category(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    public Category getParent() {
        return parent;
    }

    public Instant getCreatedAt() {return createdAt; }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
    public void setName(String name) {
        this.name = name;
    }
}
