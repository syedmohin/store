package com.sunday.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_table")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @JsonIgnore
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String username;
    private String password;
}
