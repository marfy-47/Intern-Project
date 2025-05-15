package com.example.Appointment.System.Repo;

import com.example.Appointment.System.DATA.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface HospitalRepo extends JpaRepository<Hospital,Long> {
    @Query("SELECT dc FROM Hospital dc" +
            " WHERE dc.hospitalName = :name" +
            " AND dc.country = :country AND dc.city = :city " +
            "AND dc.address = :address AND dc.roadNo = :roadNo " +
            "AND dc.holdingNo = :holdingNo")
    Optional<Hospital> findHospital(@Param("name") String name,
                                                    @Param("country") String country,
                                                    @Param("city") String city,
                                                    @Param("address") String address,
                                                    @Param("roadNo") String roadNo,
                                                    @Param("holdingNo") String holdingNo);

    Optional<Hospital> findByHospitalName(String hospitalName);
}