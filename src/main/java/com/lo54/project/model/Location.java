package com.lo54.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "LOCATION")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLocation;
    @NotNull
    private String city;

}
