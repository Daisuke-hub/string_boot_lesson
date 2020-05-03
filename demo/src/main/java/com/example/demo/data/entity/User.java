package com.example.demo.data.entity;

import javax.persistence.Entity;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data // Getter、Setterを省略するためのLombokのアノテーション
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}

// public class User {

//   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   private Long id;
//   private String name;
//   private String email;

//   private Long getId(){
//     return this.id;
//   }

//   private void setId(Long id){
//     this.id = id;
//   }

//   private String getName(){
//     return this.name;
//   }

//   private void setName(String name){
//     this.name = name;
//   }

//   private String getEmail(){
//     return this.email;
//   }

//   private void setEmail(String email){
//     this.email = email;
//   }
// }