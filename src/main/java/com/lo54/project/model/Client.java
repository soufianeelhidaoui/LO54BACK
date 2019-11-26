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
@Table(name = "CLIENT")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String address;
    @NotNull
    private String phone;
    @NotNull
    private String email;

    //------------
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "courseSessionId", nullable = false, updatable = false)
    private CourseSession courseSession;
    //------------
}
