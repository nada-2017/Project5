package com.example.salon1.Controller;

import com.example.salon1.Model.Staff;
import com.example.salon1.Service.StaffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @GetMapping("/get")
    public ResponseEntity getStaff(){return ResponseEntity.status(200).body(staffService.getAllStaffs());}

    @PostMapping("/add")
    public ResponseEntity addStaff(@Valid @RequestBody Staff staff){
        staffService.addStaff(staff);
        return ResponseEntity.status(200).body("staff added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStaff(@Valid @RequestBody Staff staff, @PathVariable Integer id){
        staffService.updateStaff(id,staff);
        return ResponseEntity.status(200).body("staff updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStaff(@PathVariable Integer id){
        staffService.deleteStaff(id);
        return ResponseEntity.status(200).body("staff deleted");
    }

    @GetMapping("/get-salary/{id}")
    public ResponseEntity getSalary(@PathVariable Integer id){
        return ResponseEntity.status(200).body(staffService.getSalaryStaff(id));
    }

    @PutMapping("/assign-staff/{staff_id}/{appointment_id}")
    public ResponseEntity assignStaffToAppointment(@PathVariable Integer staff_id, @PathVariable Integer appointment_id){
        staffService.assignStaffToAppointment(staff_id,appointment_id);
        return ResponseEntity.status(200).body("assigned done");
    }

    @GetMapping("/get-appointment/{staff_id}")
    public ResponseEntity getAppointment(@PathVariable Integer staff_id){
        return ResponseEntity.status(200).body(staffService.getAppointment(staff_id));
    }
    @PutMapping("/rating/{customer_id}/{staff_id}/{rating}")
    public  ResponseEntity getRating(@PathVariable Integer customer_id, @PathVariable Integer staff_id, @PathVariable double rating){
        staffService.rateStaff(customer_id,staff_id,rating);
        return ResponseEntity.status(200).body("rating done");
    }
}
