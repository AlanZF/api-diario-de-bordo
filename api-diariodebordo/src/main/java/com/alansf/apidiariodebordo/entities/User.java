package com.alansf.apidiariodebordo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="`User`")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="seq_user", sequenceName="user_seq", allocationSize=1)
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_user")
    private Integer idUser;
    @Column(name="name", nullable=false)
    private String name;
    @Column(name="email", nullable=false, unique=true)
    private String email;
    @Column(name="password", nullable=false)
    private String password;
    @JsonManagedReference
    @OneToMany(mappedBy="user")
    private List<Registry> registries;
}
