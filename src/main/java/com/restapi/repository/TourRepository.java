package com.restapi.repository;

import com.restapi.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

//    @Query("select t from Tour t inner join t.category c where c.id=?1")
//    Optional <List<Tour>> findByCategoryId(Long categoryId);
    Optional <List<Tour>> findByCategoryId(Long id);

    Optional<Tour> findById(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Tour t SET t.totalSeats = t.totalSeats - :count WHERE t.id = :id")
    void updateTotalSeats(@Param("count") Integer count,@Param("id") Long id);
}
