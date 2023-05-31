package com.example.salon1.Repository;

import com.example.salon1.Model.Serv;
import com.example.salon1.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServRepository extends JpaRepository<Serv,Integer> {
    Serv findServById(Integer id);
    List<Serv> findServByCategory(String category);

    //@Query("select s from S")
    //Staff getAvailableStaff(Integer id);
}
