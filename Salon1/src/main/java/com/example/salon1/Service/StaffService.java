package com.example.salon1.Service;

import com.example.salon1.ApiException.ApiException;
import com.example.salon1.Model.Staff;
import com.example.salon1.Repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepository staffRepository;


    public List<Staff> getAllStaffs(){

        return staffRepository.findAll();
    }

    public void addStaff(Staff staff){

        staffRepository.save(staff);
    }

    public void updateStaff(Integer id, Staff staff) {
        Staff staff1= staffRepository.findStaffById(id);
        if (staff1==null){
            throw new ApiException("wrong id");
        }
        staff1.setName(staff.getName());
        staff1.setSalary(staff.getSalary());
        staff1.setAge(staff.getAge());

        staffRepository.save(staff1);
    }

    public void deleteStaff(Integer id){
        Staff staff = staffRepository.findStaffById(id);
        if (staff==null){
            throw new ApiException("wrong id");
        }

        staffRepository.delete(staff);
    }
    
        public void assignStaffToAppointment(Integer staff_id, Integer appointment_id){
        Staff staff = staffRepository.findStaffById(staff_id);
        Appointment appointment = appointmentRepository.findAppointmentById(appointment_id);
        if (staff==null || appointment==null){
            throw new ApiException("id worng , can't assigned");
        }
        staff.getAppointmentSet().add(appointment);
        appointment.setStaff(staff);
        staffRepository.save(staff);
        appointmentRepository.save(appointment);

    }
    
     public Set<Appointment> getAppointment(Integer id){
        Staff staff =staffRepository.findStaffById(id);
        if (staff==null){
            throw new ApiException("wrong id");
        }
        return staff.getAppointmentSet();
    }
    public void getStaffByRating(Integer customer_id,Integer staff_id ,Double rating ){

        Customer customer = customerRepository.getCustomerById(customer_id);
        Staff s = staffRepository.findStaffById(staff_id);

        if (s!=customer.getAppointment().getStaff()){
            throw  new ApiException("staff ");
        }
        s.setRating(rating);
        staffRepository.save(s);

    }
    
    
    
    
}
