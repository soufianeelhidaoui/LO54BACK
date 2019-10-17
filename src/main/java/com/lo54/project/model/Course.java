package com.lo54.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "COURSE")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCourse;
    @NotNull
    private String codeCourse;
    @NotNull
    private String title;

    //------------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_location" , nullable = false, updatable = false)
    private Location location;
    //------------


}
