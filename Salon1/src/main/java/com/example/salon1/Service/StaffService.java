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
    
        public Double getSalaryStaff(String name){
        Staff staff = staffRepository.findStaffByName(name);
        if (staff==null){
            throw new ApiException("wrong data");
        }
        return staff.getSalary();
    }
    
    
        public Set<Appointment> getAppointment(Integer id){
        Staff staff =staffRepository.findStaffById(id);
        if (staff==null){
            throw new ApiException("wrong id");
        }
        return staff.getAppointmentSet();
    }
    
    
    
    
    
    
    
    
}
