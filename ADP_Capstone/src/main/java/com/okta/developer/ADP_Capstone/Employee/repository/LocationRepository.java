package com.okta.developer.ADP_Capstone.Employee.repository;

import com.okta.developer.ADP_Capstone.Employee.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}