package com.example.salon1.Service;

import com.example.salon1.ApiException.ApiException;
import com.example.salon1.Model.Appointment;
import com.example.salon1.Model.Serv;
import com.example.salon1.Model.Staff;
import com.example.salon1.Repository.AppointmentRepository;
import com.example.salon1.Repository.ServRepository;
import com.example.salon1.Repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ServService {
    private final ServRepository servRepository;
    private final AppointmentRepository appointmentRepository;
    private final StaffRepository staffRepository;

    public List<Serv>getAllServ(){

        return servRepository.findAll();
    }

    public void addServ(Serv serv){

        servRepository.save(serv);
    }

    public void updateServ(Serv serv,Integer id){
        Serv oldServ=servRepository.findServById(id);
        if(oldServ==null){
            throw new ApiException("Service not found");
        }

        oldServ.setName(serv.getName());
        oldServ.setCategory(serv.getCategory());
        oldServ.setPrice(serv.getPrice());

        servRepository.save(oldServ);
    }


    public void deleteServ(Integer id){
        Serv serv=servRepository.findServById(id);

        if(serv==null){
            throw new ApiException("Service not found");
        }

        servRepository.delete(serv);
    }

    public List<Serv> getServByCategory(String category){
        List<Serv> servList=servRepository.findServByCategory(category);

        if(servList==null){

            throw new ArithmeticException("category not found");
        }
        return servList;

    }

    public void assignServiceToStaff(Integer serv_id ,Integer staff_id){
        Serv serv=servRepository.findServById(serv_id);
        Staff staff=staffRepository.findStaffById(staff_id);

        if(serv==null || staff==null){
            throw new ApiException("Data Wrong");
        }

        serv.getStaffSet().add(staff);
        staff.getServSet().add(serv);

        servRepository.save(serv);
        staffRepository.save(staff);

    }


    public void assignAppointmentToService(Integer appointment_id ,Integer serv_id ){
        Appointment appointment=appointmentRepository.findAppointmentById(appointment_id);
        Serv serv=servRepository.findServById(serv_id);


        if(serv==null || appointment==null){
            throw new ApiException("Data Wrong");
        }
        appointment.getServs().add(serv);
        serv.getAppointments().add(appointment);

        appointmentRepository.save(appointment);
        servRepository.save(serv);


    }

}
