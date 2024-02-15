package org.practice01.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;

    @Lob
    @Column( columnDefinition = "LONGBLOB")
    private byte[] photo;
    @ManyToOne
    Employee employee ;
//    private byte[] photo;
    @Setter
    @Getter
    private LocalDate date;
    @Transient
    private String timeSinceAdded;

    public Photo(Integer pid,  byte[] photo, LocalDate date) {
        this.pid = pid ;

        this.photo = photo;
        this.date = date;
    }



    public Photo(Integer pid, byte[] photo) {
        this.pid = pid;
        this.photo = photo;

    }
    public Photo( byte[] photo,LocalDate date) {
        this.date = date;
        this.photo = photo;

    }
}
