package org.practice01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
//@AllArgsConstructor
public class Employee {

    @Id
    private Integer eid;
    private String ename;

    public Employee(Integer eid, String ename) {
        this.eid = eid;
        this.ename =  ename ;
    }


//    @OneToMany
// private List<Books> booksList;


}
