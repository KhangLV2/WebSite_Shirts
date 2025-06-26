package com.example.demo.repository;

import com.example.demo.model.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhAnhRepository extends JpaRepository<HinhAnh,Integer> {

    @Query("select img from HinhAnh img where img.idCTSP.id=?1")
    HinhAnh findByHinhAnhTheoIdCTSP(Integer idCTSP);

}
