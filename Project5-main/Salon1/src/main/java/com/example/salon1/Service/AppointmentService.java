package com.example.salon1.Service;

import com.example.salon1.ApiException.ApiException;
import com.example.salon1.DTO.DTO;
import com.example.salon1.Model.Appointment;
import com.example.salon1.Model.Customer;
import com.example.salon1.Model.Serv;
import com.example.salon1.Model.Staff;
import com.example.salon1.Repository.AppointmentRepository;
import com.example.salon1.Repository.CustomerRepository;
import com.example.salon1.Repository.ServRepository;
import com.example.salon1.Repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;
    private final ServRepository servRepository;
    private final StaffRepository staffRepository;

    public List<Appointment> getAll(){
        return appointmentRepository.findAll();
    }

    public void addAppointment(DTO dto){
        Customer customer = customerRepository.getCustomerById(dto.getCustomer_id());
        Serv serv = servRepository.findServById(dto.getServ_id());
        Staff staff  = staffRepository.findStaffById(dto.getStaff_id());
        if (customer == null || serv == null || staff == null)
            throw new ApiException("Invalid");
        Appointment a = customer.getAppointment();
        if (a != null) {
            appointmentRepository.delete(customer.getAppointment());
            customer.setAppointment(null);
        }
        customer.setCount(customer.getCount()+1);
        Appointment appointment = new Appointment(null, dto.getDay(), dto.getMonth(),dto.getYear(),dto.getHour(), serv.getPrice(), customer,staff,serv);
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
        a.setServPrice(appointment.getServPrice());
        appointmentRepository.save(a);
    }

    public void deleteAppointment(Integer id){
        Appointment a = appointmentRepository.findAppointmentById(id);
        if (a == null)
            throw new ApiException("Not found");
        appointmentRepository.delete(a);
    }

    public List<Appointment> getAppointmentByMonth(Integer month){
        return appointmentRepository.getAppointmentsByMonth(month);
    }

    public void assignAppointmentToService(Integer appointment_id ,Integer serv_id ){
        Appointment appointment=appointmentRepository.findAppointmentById(appointment_id);
        Serv serv=servRepository.findServById(serv_id);
        if(serv == null || appointment == null){
            throw new ApiException("Invalid");
        }
        appointment.setServ(serv);
        serv.getAppointments().add(appointment);

        appointmentRepository.save(appointment);
        servRepository.save(serv);

    }

}
