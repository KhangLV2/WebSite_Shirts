package com.example.demo.repository;

import com.example.demo.model.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac,Integer> {

    //Lấy ra màu sắc theo tên màu sắc
    @Query("select ms from MauSac ms where ms.ten=?1")
    MauSac findByTen(String tenMauSac);

}
