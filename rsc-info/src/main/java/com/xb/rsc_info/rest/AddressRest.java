package com.xb.rsc_info.rest;

import com.xb.rsc_info.rest.dto.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "RSC-ADDRESS" ,url = "http://localhost:8082")
public interface AddressRest {

    @GetMapping(value = "/getAddressById")
     ResponseEntity<Address> getAddress ( @RequestParam Long addressId);
}
