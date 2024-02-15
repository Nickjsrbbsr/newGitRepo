package org.practice01.entity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

public class EmployeePhotoEntity {
    Employee employee;
    Photo photo;
    Integer eid;
    String ename;

    LocalDate fromDate;
    LocalDate toDate;
boolean showHistory;
    LocalDate date;
}
