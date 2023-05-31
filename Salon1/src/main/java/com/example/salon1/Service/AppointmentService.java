package com.example.salon1.Service;

import com.example.salon1.ApiException.ApiException;
import com.example.salon1.DTO.DTO;
import com.example.salon1.Model.Appointment;
import com.example.salon1.Model.Customer;
import com.example.salon1.Model.Serv;
import com.example.salon1.Repository.AppointmentRepository;
import com.example.salon1.Repository.CustomerRepository;
import com.example.salon1.Repository.ServRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;
    private final ServRepository servRepository;

    public List<Appointment> getAll(){
        return appointmentRepository.findAll();
    }

    public void addAppointment(DTO dto){
        Customer customer = customerRepository.getCustomerById(dto.getCustomer_id());
        Serv serv = servRepository.findServById(dto.getServ_id());
        if (customer == null)
            throw new ApiException("Customer not found");
        Appointment appointment = new Appointment(null, dto.getDay(), dto.getMonth(),dto.getYear(),dto.getHour(),customer,null,null);
        appointmentRepository.save(appointment);
    }

    public void updateAppointment(Integer id,Appointment appointment){
        Appointment a = appointmentRepository.findAppointmentById(id);
        if (a == null)
            throw new ApiException("Not found");
        a.setDay(appointment.getDay());
        a.setMonth(appointment.getMonth());
        a.setYear(appointment.getYear());
        a.setHour(appointment.getHour());
        appointmentRepository.save(a);
    }

    public void deleteAppointment(Integer id){
        Appointment a = appointmentRepository.findAppointmentById(id);
        if (a == null)
            throw new ApiException("Not found");
        appointmentRepository.delete(a);
    }
}
