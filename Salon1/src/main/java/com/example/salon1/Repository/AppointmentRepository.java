package com.example.salon1.Repository;

import com.example.salon1.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    Appointment findAppointmentById(Integer id);

   @Query("select a from Appointment a where a.day=?1")
   List<Appointment> getAppointmentsByDay(Integer day);
}
