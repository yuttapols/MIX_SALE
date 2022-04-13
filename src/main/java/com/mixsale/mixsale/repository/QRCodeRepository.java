package com.mixsale.mixsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mixsale.mixsale.entity.QrCodeEntity;

@Repository
public interface QRCodeRepository extends JpaRepository<QrCodeEntity,Long>{

}
