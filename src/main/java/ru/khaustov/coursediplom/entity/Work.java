package ru.khaustov.coursediplom.entity;

import javax.persistence.*;

@Entity
@Table(name = "work_service")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_id")
    private long id;

    @Column(name = "typeOfService", unique = true, nullable = false)
    private String typeOfService;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Column(name = "duration")
    private String duration;

    @Column(name = "priсe_type")
    private String price;
}
