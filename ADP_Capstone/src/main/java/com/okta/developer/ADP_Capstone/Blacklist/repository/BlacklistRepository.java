package com.okta.developer.ADP_Capstone.Blacklist.repository;

import com.okta.developer.ADP_Capstone.Blacklist.entity.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist, String> {

}
