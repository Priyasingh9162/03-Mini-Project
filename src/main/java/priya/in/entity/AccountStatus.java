package priya.in.entity;

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
@Table(name="Account_Status")
public class AccountStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String status;
	public AccountStatus(){}
}
