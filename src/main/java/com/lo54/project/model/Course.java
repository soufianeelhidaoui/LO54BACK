package com.lo54.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "COURSE")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;
    @NotNull
    private String codeCourse;
    @NotNull
    private String title;

    //------------
    @OneToMany(mappedBy="course", fetch = FetchType.EAGER)
    private List<CourseSession> courseSessions ;
    //------------


}
