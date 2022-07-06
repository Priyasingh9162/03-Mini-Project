package priya.in.service;

import java.util.List;

import priya.in.entity.AccountStatus;
import priya.in.entity.InsuracePlanDetails;
import priya.in.entity.InsurancePlan;

public interface InsuranceService {

	List<InsuracePlanDetails> getAllByNameStatus(String planName, String status);

	List<InsuracePlanDetails> getDataByStatus(String status);

	List<InsuracePlanDetails> getDataByplan(String planName);

	List<InsuracePlanDetails> getAllData();

	List<InsurancePlan> getPlan();

	List<AccountStatus> getStatus();

}
