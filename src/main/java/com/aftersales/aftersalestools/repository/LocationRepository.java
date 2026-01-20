package com.aftersales.aftersalestools.repository;

import com.aftersales.aftersalestools.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByType(String type);

    List<Location> findByParentId(Long parentId);
}
