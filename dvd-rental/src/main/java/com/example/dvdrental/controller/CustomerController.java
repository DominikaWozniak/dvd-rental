package com.example.dvdrental.controller;

import com.example.dvdrental.model.Customer;
import com.example.dvdrental.services.CustomerService;
import com.example.dvdrental.services.RentCardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    private CustomerService customerService;
    private RentCardService rentCardService;

    public CustomerController(CustomerService customerService, RentCardService rentCardService) {
            this.customerService = customerService;
            this.rentCardService = rentCardService;
    }

    @GetMapping("/customers")
    public String viewCustomers(Model model){
        model.addAttribute("customersList", customerService.findAllItems());
        return "customers_list";
    }

    @RequestMapping("/newCustomer")
    public String newCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("newCustomer", customer);
        return "new_customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("newCustomer") Customer customer){
        customerService.saveItem(customer);
        return "redirect:/customers";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") Long id){
        this.customerService.deleteItemById(id);
        return "redirect:/customers";
    }

    @GetMapping("/customerUpdate/{id}")
    public String updateCustomer(@PathVariable("id") Long id, Model model){
        Customer customer = customerService.getItemById(id);
        model.addAttribute("customerUpdate", customer);
        return "customer_update";
    }
}
