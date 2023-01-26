package com.okta.developer.ADP_Capstone.Blacklist.service;


import com.okta.developer.ADP_Capstone.Blacklist.entity.Blacklist;
import com.okta.developer.ADP_Capstone.Blacklist.payload.Blacklist_Request;
import com.okta.developer.ADP_Capstone.Blacklist.repository.BlacklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlacklistService {


    @Autowired
    BlacklistRepository blacklistRepository;

    public BlacklistService(BlacklistRepository blacklistRepository) {
        this.blacklistRepository = blacklistRepository;
    }

    public Blacklist setBlacklist(Blacklist_Request request) {
            Blacklist savedBlacklist = new Blacklist();
            savedBlacklist.setBlacklistID(request.getBlacklistID());
            savedBlacklist.setEmployeeID(request.getEmployeeID());
            savedBlacklist.setLName(request.getLName());
            savedBlacklist.setFName(request.getFName());
            savedBlacklist.setStatus(request.getStatus());
            return savedBlacklist;
    }
    public void save(Blacklist blacklist){
        blacklistRepository.save(blacklist);
    }



}