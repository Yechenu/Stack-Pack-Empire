package com.okta.developer.ADP_Capstone.FormI9.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="section1")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class Section1 {

    //Initialize table variables(Table column names)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section1id", nullable = false, length = 20)
    private Long section1id;



}
