package org.practice01.service;


import org.practice01.entity.Employee;
import org.practice01.entity.Photo;
import org.practice01.repository.EmployeeRepository;
import org.practice01.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class EmployeeService {


    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    public void saveData(MultipartFile file, Integer eid, String ename, LocalDate date) throws IOException {
        Employee employee = new Employee();
        Photo photo = new Photo();
        employee.setEid(eid); employee.setEname(ename) ;
        photo.setDate(date); photo.setPhoto(file.getBytes());
//        booksRepository.save(books);
//        System.out.println(books.getId());
//        books.setBid(books.getId());
        employeeRepository.save(employee);
        photo.setEmployee(employee);
        photoRepository.save(photo);
//        System.out.println(books.getId());




    }
}
