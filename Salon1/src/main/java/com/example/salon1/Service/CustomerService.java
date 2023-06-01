package com.example.salon1.Service;

import com.example.salon1.ApiException.ApiException;
import com.example.salon1.Model.Appointment;
import com.example.salon1.Model.Customer;
import com.example.salon1.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer customer){
        Customer c = customerRepository.getCustomerById(id);
        if (c == null)
            throw new ApiException("Not found");
        c.setName(customer.getName());
        c.setAge(customer.getAge());
        c.setEmail(customer.getEmail());
        c.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(c);
    }

    public void deleteCustomer(Integer id){
        Customer c = customerRepository.getCustomerById(id);
        if (c == null)
            throw new ApiException("Not found");
        customerRepository.delete(c);
    }

    public Appointment getAppointmentOfCustomer(Integer id){
        Customer customer = customerRepository.getCustomerById(id);
        if (customer == null)
            throw new ApiException("Not found");
        return customer.getAppointment();
    }
    
    public void loyalty(Integer id){
        Customer customer = customerRepository.getCustomerById(id);
        if (customer == null)
            throw new ApiException("Not found");
        Integer price = customer.getAppointment().getServ().getPrice();
        if (customer.getCount() > 3) {
            customer.setLoyalty(true);
            customer.getAppointment().getServ().setPrice(price - (price * 20 / 100));
        }
        else
            throw new ApiException("Not enough visits");
    }
}
