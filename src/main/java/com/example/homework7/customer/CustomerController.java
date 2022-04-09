package com.example.homework7.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerModel> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("/customers")
    public void deleteCustomer(@RequestBody CustomerModel customerModel) {
        customerService.delete();
    }

    @PostMapping("/customers/update")
    public CustomerModel updateCustomer(@RequestBody CustomerModel customerModel) {
       customerService.update();
        return customerModel;
    }

    ResponseCookie negresa = ResponseCookie.from("Customer","1").httpOnly(true).secure(true).path("/").domain("localhost").maxAge(60*60*24*7).build();

    //return ResponseEntity.ok().header("SET_COOKIE",negresa.toString()).build();

    @GetMapping("/cookie")
    public String readCookie(@CookieValue(name = "customer-id", defaultValue= "default") Integer customerId) {
        return Integer.toString(customerId);
    }

    @PostMapping("/cookie")
    public ResponseEntity<String> createCookie(@RequestBody CustomerModel customerModel) {
        return ResponseEntity.ok().header("SET_COOKIE",negresa.toString()).build();
    }

    @PostMapping("/cookie/delete")
    public ResponseEntity<String> deleteCookie() {
        return ResponseEntity.ok().header("SET_COOKIE",negresa.toString()).build();
    }


}


