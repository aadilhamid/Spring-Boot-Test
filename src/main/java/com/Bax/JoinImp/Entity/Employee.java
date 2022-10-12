package com.Bax.JoinImp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

@Id
@GeneratedValue
    private Long empId;
    private String name;
    private String designation;
    private Integer salary;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_add_id")
    private Address address;




}
