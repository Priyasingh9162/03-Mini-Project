package priya.in.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name="Insurance_plan_dtls")
public class InsuracePlanDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "plan_id")
	private Integer Id;
	@Column(name = "plan_name")
	private String planName;
	@Column(name = "plan_status")
	private String status;
	@Column(name = "holder_name")
	private String holderName;
	@Column(name = "benifit_amt")
	private Long benifitAmt;
	public InsuracePlanDetails(){}
}
