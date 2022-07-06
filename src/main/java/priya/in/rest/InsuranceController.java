package priya.in.rest;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import priya.in.input;
import priya.in.entity.AccountStatus;
import priya.in.entity.InsuracePlanDetails;
import priya.in.entity.InsurancePlan;
import priya.in.service.InsuranceServiceImpl;

@RestController
public class InsuranceController {
	@Autowired
	private InsuranceServiceImpl ins;

	@GetMapping("/get-plan")
	public List<InsurancePlan> getPlan() {
		return ins.getPlan();
	}

	@GetMapping("/get-status")
	public List<AccountStatus> getStatus() {
		return ins.getStatus();
	}

	@PostMapping("/pdf")
	public String genrateReportPDF(@RequestBody input inp) throws FileNotFoundException, JRException, Exception {
		if (inp.getPlanName() == null && inp.getStatus() == null) {
			List<InsuracePlanDetails> temp = ins.getAllData();
			return ins.exportdata("pdf", temp);
		} else if (inp.getPlanName() != null && inp.getStatus() != null) {
			List<InsuracePlanDetails> temp = ins.getAllByNameStatus(inp.getPlanName(), inp.getStatus());
			return ins.exportdata("pdf", temp);
		} else if (inp.getPlanName() != null) {
			List<InsuracePlanDetails> temp = ins.getDataByplan(inp.getPlanName());
			return ins.exportdata("pdf", temp);
		} else {
			List<InsuracePlanDetails> temp = ins.getDataByStatus(inp.getStatus());
			return ins.exportdata("pdf", temp);
		}
	}
	@PostMapping("/html")
	public String genrateReportHTML(@RequestBody input inp) throws FileNotFoundException, JRException, Exception {
		if (inp.getPlanName() == null && inp.getStatus() == null) {
			List<InsuracePlanDetails> temp = ins.getAllData();
			return ins.exportdata("html", temp);
		} else if (inp.getPlanName() != null && inp.getStatus() != null) {
			List<InsuracePlanDetails> temp = ins.getAllByNameStatus(inp.getPlanName(), inp.getStatus());
			return ins.exportdata("html", temp);
		} else if (inp.getPlanName() != null) {
			List<InsuracePlanDetails> temp = ins.getDataByplan(inp.getPlanName());
			return ins.exportdata("html", temp);
		} else {
			List<InsuracePlanDetails> temp = ins.getDataByStatus(inp.getStatus());
			return ins.exportdata("html", temp);
		}
	}

	@PostMapping("/get-all")
	public List<InsuracePlanDetails> getAll(@RequestBody input inp) {
		if (inp.getPlanName() == null && inp.getStatus() == null)
			return ins.getAllData();
		else if (inp.getPlanName() != null && inp.getStatus() != null)
			return ins.getAllByNameStatus(inp.getPlanName(), inp.getStatus());
		else if (inp.getPlanName() != null)
			return ins.getDataByplan(inp.getPlanName());
		else
			return ins.getDataByStatus(inp.getStatus());
	}

}
