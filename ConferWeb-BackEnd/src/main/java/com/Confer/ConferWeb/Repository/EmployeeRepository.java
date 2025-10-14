package com.Confer.ConferWeb.Repository;

import com.Confer.ConferWeb.Model.DTO.EmployeeDTO;
import com.Confer.ConferWeb.Model.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Query("DELETE FROM Employee e WHERE e.idEmployee IN :ids")
    void deleteByIdList(@Param("ids") List<Integer> ids);


    @Query("SELECT NEW com.Confer.ConferWeb.Model.DTO.EmployeeDTO(e.idEmployee, e.name)" +
            "FROM Employee e " +
            "WHERE e.idEmployee = :idEmployee")
    Optional<EmployeeDTO> findDtoById(@Param("idEmployee") Integer id);

    @Query("SELECT NEW com.Confer.ConferWeb.Model.DTO.EmployeeDTO(e.idEmployee, e.name) FROM Employee e")
    List<EmployeeDTO> findAllAsDto();
}
