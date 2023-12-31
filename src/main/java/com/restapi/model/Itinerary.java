package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;

    private String morning;
    private Boolean breakfast;

    private String afternoon;
    private Boolean lunch;

    private String night;
    private Boolean dinner;

    private String hotel;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "tour_id",referencedColumnName = "id")
    private Tour tour;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
