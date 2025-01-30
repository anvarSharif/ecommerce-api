package com.example.ecommerce_api.entity;


import com.example.ecommerce_api.entity.abc.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    @Column(unique = true,nullable = false)
    private String phone;

    private String password;
    @ManyToOne
    private Attachment personalPhoto;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> role;

    public User(Integer id,String firstName, String lastName, String phone, String password, Attachment personalPhoto, List<Role> role) {
        super.setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.password = password;
        this.personalPhoto = personalPhoto;
        this.role = role;
    }

    public String getFullName(){
        return firstName+" "+lastName;
    }
}
