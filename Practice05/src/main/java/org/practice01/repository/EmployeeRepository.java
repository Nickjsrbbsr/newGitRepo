package org.practice01.repository;

import org.practice01.entity.Photo;
import org.practice01.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

//    @Query("SELECT l FROM Library l JOIN FETCH l.booksList")
//    List<Library> findAllLibrariesWithBooks();
//@Query("SELECT b FROM Books b WHERE b.library.lid = :lid")
//List<Books> findBooksByLibraryId(@Param("lid") Integer libraryId);

}
