package com.sunday.controller;

import com.sunday.model.Customer;
import com.sunday.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;
@CrossOrigin("*")
@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("all")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return ok(customerService.getAllData());
    }

    @GetMapping("allnames")
    public ResponseEntity<List<String>> getAllCustomerName() {
        return ok(customerService.getAllCustomerNames());
    }

    @PostMapping("save")
    public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer) {
        return ok(customerService.insert(customer));
    }

    @DeleteMapping("delete/{custId}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable("custId") String custId) {
        return ok(customerService.deleteRecord(custId.toUpperCase()));
    }

    @PostMapping("updatebalance/{custId}/{bal}")
    public ResponseEntity<Customer> updateBalance(@PathVariable("custId") String custId,
                                                  @PathVariable("bal") int bal) {
        return ok(customerService.updateBalance(custId.toUpperCase(), bal));
    }

    @PostMapping("updatecrate/{custId}/{crate}")
    public ResponseEntity<Customer> updateCrate(@PathVariable("custId") String custId,
                                                @PathVariable("crate") int crate) {
        return ok(customerService.updateCrate(custId.toUpperCase(), crate));
    }

    @PostMapping("updaterate/{custId}/{rate}")
    public ResponseEntity<Customer> updateRate(@PathVariable("custId") String custId,
                                               @PathVariable("rate") int rate) {
        return ok(customerService.updateRate(custId.toUpperCase(), rate));
    }

    @PostMapping("updatereturnrate/{custId}/{crate}")
    public ResponseEntity<Customer> updateReturnCrate(@PathVariable("custId") String custId,
                                                      @PathVariable("crate") int crate) {
        return ok(customerService.updateReturnCrate(custId.toUpperCase(), crate));
    }

    @PostMapping("updateweight/{custId}/{weight}")
    public ResponseEntity<Customer> updateWeight(@PathVariable("custId") String custId,
                                                 @PathVariable("weight") int weight) {
        return ok(customerService.updateWeight(custId.toUpperCase(), weight));
    }

    @PostMapping("updateweight/{custId}/{name}")
    public ResponseEntity<Customer> updateName(@PathVariable("custId") String custId,
                                               @PathVariable("name") String name) {
        return ok(customerService.updateCustomerName(custId.toUpperCase(), name));
    }
}
