package com.example.salon1.Controller;


import com.example.salon1.Model.Customer;
import com.example.salon1.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(customerService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body("Customer updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer deleted");
    }
    
    @GetMapping("/get-appointment/{id}")
    public ResponseEntity getAppointmentOfCustomer(@PathVariable Integer id){
        return ResponseEntity.status(200).body(customerService.getAppointmentOfCustomer(id));
    }
}
