package com.lo54.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "COURSE_SESSION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class CourseSession {

    public CourseSession(Long idCourseSession) {
        this.idCourseSession = idCourseSession;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourseSession;
    @NotNull
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date endDate;

    private Long max;

    //------------
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCourse", nullable = false, updatable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idLocation", nullable = false, updatable = false)
    private Location location;

    //------------
    @OneToMany(mappedBy="courseSession", fetch = FetchType.EAGER)
    private List<Client> client ;
    //------------
}
