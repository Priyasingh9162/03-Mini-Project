package priya.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import priya.in.entity.AccountStatus;

public interface AccountStatusRepo  extends JpaRepository<AccountStatus, Integer> {

}
