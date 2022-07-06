package priya.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import priya.in.entity.InsurancePlan;

public interface InsurancePlanRepo  extends JpaRepository<InsurancePlan, Integer> {

}
