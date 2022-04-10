package com.mixsale.mixsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mixsale.mixsale.entity.LogQrCodeEntity;

@Repository
public interface GenarateQRCodeRepository extends JpaRepository<LogQrCodeEntity,Long>{

}
