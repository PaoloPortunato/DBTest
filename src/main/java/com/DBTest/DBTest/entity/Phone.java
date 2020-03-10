package com.DBTest.DBTest.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "Phone")
@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Long phone_id;
    @Column(name = "numero")
    private String numero;

    /*
        @ManyToOne(fetch = FetchType.LAZY)

         * mapped by usato sul lato di riferimento
         * mappa verso il lato proprietario


        private User user_id;
    */


    public Phone(String numero) {
        this.setNumero(numero);
    }
}
