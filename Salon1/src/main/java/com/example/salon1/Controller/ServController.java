package com.example.salon1.Controller;

import com.example.salon1.ApiResponse.ApiResponse;
import com.example.salon1.Model.Serv;
import com.example.salon1.Service.ServService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/serv")
@RequiredArgsConstructor
public class ServController {

    private final ServService servService;
    @GetMapping("/get")
    public ResponseEntity getAllServ(){
        List<Serv> servList=servService.getAllServ();
        return ResponseEntity.status(200).body(servList);
    }


    @PostMapping("/add")
    public ResponseEntity addServ(@Valid @RequestBody Serv serv){
        servService.addServ(serv);
        return ResponseEntity.status(200).body(new ApiResponse("Service added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateService(@Valid @RequestBody Serv serv, @PathVariable Integer id){
        servService.updateServ(serv, id);
        return ResponseEntity.status(200).body("Service Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCServ(@PathVariable Integer id){
        servService.deleteServ(id);
        return ResponseEntity.status(200).body("Service deleted");

    }

    @GetMapping("/get-category/{category}")
    public ResponseEntity getServByCategory(@PathVariable String category){
        servService.getServByCategory(category);
        return ResponseEntity.status(200).body("get by category");
    }


    @PutMapping("/{serv_id}/assign/{staff_id}")
    public ResponseEntity assignServiceToStaff(@PathVariable Integer serv_id,@PathVariable Integer staff_id) {
        servService.assignServiceToStaff(serv_id,staff_id);
        return ResponseEntity.status(200).body("Assign Done");
    }

    @PutMapping("/{appointment_id}/assign/{serv_id}")
    public ResponseEntity  assignAppointmentToService(@PathVariable Integer appointment_id,@PathVariable Integer serv_id ) {
        servService.assignAppointmentToService(appointment_id,serv_id);
        return ResponseEntity.status(200).body("Assign Done");
    }


}
