package com.okta.developer.ADP_Capstone.Blacklist.controller;


import com.okta.developer.ADP_Capstone.Blacklist.entity.Blacklist;
import com.okta.developer.ADP_Capstone.Blacklist.payload.Blacklist_Request;
import com.okta.developer.ADP_Capstone.Blacklist.repository.BlacklistRepository;
import com.okta.developer.ADP_Capstone.Blacklist.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("capstoneApi/auth/Blacklist")
public class BlacklistController {
    @Autowired
    BlacklistService blacklistService;
    @Autowired
    BlacklistRepository blacklistRepository;

    public BlacklistController( BlacklistService blacklistService, BlacklistRepository blacklistRepository) {
        this. blacklistService =  blacklistService;
        this.blacklistRepository= blacklistRepository;
    }

    @GetMapping("/blacklist")
    public List<Blacklist> getBlacklist(){
        return this.blacklistRepository.findAll();
    }

    // build create Blacklist REST API
    @PostMapping("/saveBlack")
    public Blacklist completeBlacklist(@RequestBody Blacklist_Request request) throws URISyntaxException {
        Blacklist savedBlacklist= blacklistService.setBlacklist(request);
        blacklistService.save(savedBlacklist);
        return ResponseEntity.created(
                new URI("/blacklist/" + savedBlacklist.getBlacklistID())).body(savedBlacklist).getBody();
    }

}