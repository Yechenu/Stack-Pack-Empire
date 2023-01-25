package com.okta.developer.ADP_Capstone.FormI9.Form.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "form_I9")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER)
public class Form_I9 {
    @Id
    @GeneratedValue

    @Column(name = "FormID", length=60)
    private Integer formID;

    @Column(name = "EmployeeID", length=60)
    private Integer employeeID;

    @Column(name = "Section1_ID", length=60)
    private Integer section1_ID;

    @Column(name = "Section2_ID", length=60)
    private Integer section2_ID;

    @Column(name = "Modified_At", length=60)
    private Timestamp modified_At;

    @Column(name = "Created_At", length=60)
    private Timestamp created_At;


}



