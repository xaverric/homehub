package cz.homehub.repository;

import cz.homehub.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatDao extends JpaRepository<Flat, Long> {

    @Query("SELECT f FROM Flat f where f.number = :number")
    Flat findByFlatNumber(@Param("number") Integer number);
}
