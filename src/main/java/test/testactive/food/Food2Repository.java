package test.testactive.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Food2Repository extends JpaRepository<Food, Long> {
    @Query("SELECT p FROM Food p ORDER BY p.id DESC")
    List<Food> findAllDesc();

}
