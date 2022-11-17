package com.alansf.apidiariodebordo.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="`User`")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="seq_user", sequenceName="user_seq", allocationSize=1)
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_user")
    private Integer idUser;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

}
