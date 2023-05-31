package com.example.salon1.Controller;


import com.example.salon1.DTO.DTO;
import com.example.salon1.Model.Appointment;
import com.example.salon1.Service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(appointmentService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addAppointment(@Valid @RequestBody DTO dto){
        appointmentService.addAppointment(dto);
        return ResponseEntity.status(200).body("Appointment added");
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity updateAppointment(@PathVariable Integer id, @Valid @RequestBody Appointment appointment){
        appointmentService.updateAppointment(id, appointment);
        return ResponseEntity.status(200).body("Appointment updated");
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAppointment(@PathVariable Integer id){
        appointmentService.deleteAppointment(id);
        return ResponseEntity.status(200).body("Appointment deleted");
    }
    
    @GetMapping("/get-day/{day}")
    public ResponseEntity getAppointmentByDay(@PathVariable Integer day){
        return ResponseEntity.status(200).body(appointmentService.getAppointmentByDay(day));
    }
}

