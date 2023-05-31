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
}
