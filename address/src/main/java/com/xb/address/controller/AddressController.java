package com.xb.address.controller;


import com.xb.address.model.Address;
import com.xb.address.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;

@RestController
@RequestMapping("/rsc-address")
public class AddressController {

    @Autowired
    AddressRepo addressRepo;

    @RequestMapping(value = "/getAddressById", method = RequestMethod.GET)
    public ResponseEntity<Address> getAddress(@RequestParam(name = "addressId") Long addressId) {
        return new ResponseEntity<>(this.addressRepo.findById(addressId).get(), HttpStatus.OK);
    }


}
