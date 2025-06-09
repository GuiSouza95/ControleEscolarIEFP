package com.iefp.controle_escolar.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sexo;
    private String status;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "username", nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false)
    private String password;

    private boolean accountNonLocked;
    private Integer tentativas = 0;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> role = new ArrayList<>();
}

