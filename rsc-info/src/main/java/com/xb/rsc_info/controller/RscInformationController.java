package com.xb.rsc_info.controller;


import com.xb.rsc_info.model.RscInfo;
import com.xb.rsc_info.repo.RscInfoRepo;
import com.xb.rsc_info.rest.AddressRest;
import com.xb.rsc_info.rest.dto.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rsc-info")
public class RscInformationController {

    @Autowired
    RscInfoRepo repo;

    @Autowired
    AddressRest addressRest;

    @GetMapping(value = "/getInfo")
    public ResponseEntity<List<RscInfo>> getInfo (){
       Address address= addressRest.getAddress(1l).getBody();
        //System.out.println(address);
        return new ResponseEntity<>(this.repo.findAll(), HttpStatus.OK);
    }
}
