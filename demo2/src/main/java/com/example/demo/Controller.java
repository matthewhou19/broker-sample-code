package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class Controller {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerResponseRepository customerResponseRepository;

    @GetMapping
    public ResponseEntity<List<CustomerRespondEntity>>handleCustomerRequest(
            @RequestParam(required = false) String Zip,
            @RequestParam(required = false) String originState,
            @RequestParam(required = false) String destinationZip,
            @RequestParam(required = false) String destinationState,
            @RequestParam(required = false) String originRadius,
            @RequestParam(required = false) String destinationRadius,
            @RequestBody CustomerRequest customerRequest) {

        if (!customerService.validateInput(Zip, originState, destinationZip, destinationState, originRadius, destinationRadius, customerRequest)) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
        return ResponseEntity.ok(customerService.filterResponseData(Zip, originState, destinationZip, destinationState));
    }
}
