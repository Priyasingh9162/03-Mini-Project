package priya.in.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import priya.in.entity.AccountStatus;
import priya.in.entity.InsuracePlanDetails;
import priya.in.entity.InsurancePlan;
import priya.in.repo.AccountStatusRepo;
import priya.in.repo.InsurancePlanDetailsRepo;
import priya.in.repo.InsurancePlanRepo;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	@Autowired
	private InsurancePlanDetailsRepo repo;

	@Autowired
	private InsurancePlanRepo planrepo;

	@Autowired
	private AccountStatusRepo statusrepo;

	@Override
	public List<InsuracePlanDetails> getAllByNameStatus(String planName, String status) {
		InsuracePlanDetails temp = new InsuracePlanDetails();
		temp.setPlanName(planName);
		temp.setStatus(status);
		return repo.findAll(Example.of(temp));

	}

	@Override
	public List<InsuracePlanDetails> getDataByStatus(String status) {
		InsuracePlanDetails temp = new InsuracePlanDetails();
		temp.setStatus(status);
		return repo.findAll(Example.of(temp));
	}

	@Override
	public List<InsuracePlanDetails> getDataByplan(String planName) {
		InsuracePlanDetails temp = new InsuracePlanDetails();
		temp.setPlanName(planName);
		return repo.findAll(Example.of(temp));
	}

	@Override
	public List<InsuracePlanDetails> getAllData() {
		System.out.println(repo.findAll());
		return repo.findAll();
	}

	@Override
	public List<InsurancePlan> getPlan() {
		return planrepo.findAll();
	}

	@Override
	public List<AccountStatus> getStatus() {
		return statusrepo.findAll();
	}

	public String exportdata(String formate, List<InsuracePlanDetails> details)
			throws FileNotFoundException, JRException, Exception {
		File file = ResourceUtils.getFile("classpath:abc.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(details);
		Map<String, Object> parm = new HashMap<>();
		parm.put("createdBy", "priya");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parm, datasource);
		if (formate.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint,
					"C:\\Users\\LENOVO\\Desktop\\New folder\\Dsa" + "\\insurance.html");
		}
		if (formate.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"C:\\Users\\LENOVO\\Desktop\\New folder\\Dsa" + "\\insurance.pdf");
		}
		return "genrated";
	}

}
