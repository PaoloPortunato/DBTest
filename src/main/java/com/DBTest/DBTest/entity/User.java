package com.DBTest.DBTest.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;

    /**
     * JoinColumn viene usato sul lato proprietario
     *      * lato proprietario definito sul lata "molti"
     *
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id")
    private List<Phone> phoneList;


    public User(String nome, String cognome) {
        this.setNome(nome);
        this.setCognome(cognome);
    }


}

