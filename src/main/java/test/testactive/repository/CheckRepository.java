package test.testactive.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import test.testactive.domain.Checklist;

public interface CheckRepository extends JpaRepository<Checklist,Long>{}