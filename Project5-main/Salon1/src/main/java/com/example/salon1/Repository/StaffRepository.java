package com.example.salon1.Repository;

import com.example.salon1.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {
 Staff findStaffById(Integer id);
}
