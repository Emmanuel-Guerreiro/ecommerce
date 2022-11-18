package com.bezkoder.springjwt.Cliente;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.bezkoder.springjwt.Base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends BaseEntity {

    @Column(name = "nombre")
    private String nombre;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String usuario;

    @Column(nullable = false)
    private String password;
}
