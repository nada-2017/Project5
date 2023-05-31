package com.example.salon1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DTO {
    private Integer customer_id;

    private Integer serv_id;

    private Integer staff_id;

    private Integer day;

    private Integer month;

    private Integer year;

    private Integer hour;

}
