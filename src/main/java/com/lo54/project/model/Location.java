package com.lo54.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "LOCATION")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocation;
    @NotNull
    private String city;

    //------------
    @OneToMany(mappedBy="location", fetch = FetchType.EAGER)
    private List<CourseSession> courseSession ;
    //------------
}
