package com.avanse.jpa.model.pennant;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

import com.avanse.jpa.model.elms.CustomerId;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Immutable
@Table(name="PENNANT_MCAAP_REPORT") //this is both prod and uat as well
public class PennantView {
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="LOAN_NO")
	private String loanNo;
	
	@Column(name="CUSTOMER_NAME")
	private String customer_name;
	
	@Column(name="LOAN_BRANCH")
	private String LOAN_BRANCH;
	
	@Column(name="TYPE")
	private String TYPE;

	@Column(name="CUSTOMER_DOB")
	@Temporal(TemporalType.DATE)
	private Date CUSTOMER_DOB;

	@Column(name="MOBILE_NUMBER")
	private String MOBILE_NUMBER;

	@Column(name="EMAIL_ID")
	private String EMAIL_ID;

	@Column(name="ADDRESS")
	private String ADDRESS;

	@Column(name="POS")
	private double POS;

	@Column(name="MODE_OF_REPAYMENT")
	private String MODE_OF_REPAYMENT;

	@Column(name="EMI_SI_PI_AMOUNT")
	private double EMI_SI_PI_AMOUNT;

	@Column(name="OVERDUE_PI_AMOUNT")
	private double OVERDUE_PI_AMOUNT;

	@Column(name="OVERDUE_SI_AMOUNT")
	private double OVERDUE_SI_AMOUNT;

	@Column(name="OVERDUE_EMI_AMOUNT")
	private double OVERDUE_EMI_AMOUNT;

	@Column(name="BOUNCE_CHARGE")
	private double BOUNCE_CHARGE;

	@Column(name="PENAL_CHARGE")
	private double PENAL_CHARGE;

	@Column(name="TOTAL_AMOUNT")
	private double TOTAL_AMOUNT;

	@Column(name="Employee")
	private String Employee;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date START_DATE;
	
	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date END_DATE;
	
	@Column(name="PROD_TYPE")
	private String PROD_TYPE;
	
	@Column(name="CURRENT_MONTH_INST")
	private double CURRENT_MONTH_INST;
	
	@Transient
	private Double availableCashLimit;
	
	public Double getAvailableCashLimit() {
		return availableCashLimit;
	}

	public void setAvailableCashLimit(Double availableCashLimit) {
		this.availableCashLimit = availableCashLimit;
	}

	public double getCURRENT_MONTH_INST() {
		return CURRENT_MONTH_INST;
	}

	public void setCURRENT_MONTH_INST(double cURRENT_MONTH_INST) {
		CURRENT_MONTH_INST = cURRENT_MONTH_INST;
	}

	public String getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLOAN_BRANCH() {
		return LOAN_BRANCH;
	}

	public void setLOAN_BRANCH(String lOAN_BRANCH) {
		LOAN_BRANCH = lOAN_BRANCH;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public Date getCUSTOMER_DOB() {
		return CUSTOMER_DOB;
	}

	public void setCUSTOMER_DOB(Date cUSTOMER_DOB) {
		CUSTOMER_DOB = cUSTOMER_DOB;
	}

	public String getMOBILE_NUMBER() {
		return MOBILE_NUMBER;
	}

	public void setMOBILE_NUMBER(String mOBILE_NUMBER) {
		MOBILE_NUMBER = mOBILE_NUMBER;
	}

	public String getEMAIL_ID() {
		return EMAIL_ID;
	}

	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public double getPOS() {
		return POS;
	}

	public void setPOS(double pOS) {
		POS = pOS;
	}

	public String getMODE_OF_REPAYMENT() {
		return MODE_OF_REPAYMENT;
	}

	public void setMODE_OF_REPAYMENT(String mODE_OF_REPAYMENT) {
		MODE_OF_REPAYMENT = mODE_OF_REPAYMENT;
	}

	public double getEMI_SI_PI_AMOUNT() {
		return EMI_SI_PI_AMOUNT;
	}

	public void setEMI_SI_PI_AMOUNT(double eMI_SI_PI_AMOUNT) {
		EMI_SI_PI_AMOUNT = eMI_SI_PI_AMOUNT;
	}

	public double getOVERDUE_PI_AMOUNT() {
		return OVERDUE_PI_AMOUNT;
	}

	public void setOVERDUE_PI_AMOUNT(double oVERDUE_PI_AMOUNT) {
		OVERDUE_PI_AMOUNT = oVERDUE_PI_AMOUNT;
	}

	public double getOVERDUE_SI_AMOUNT() {
		return OVERDUE_SI_AMOUNT;
	}

	public void setOVERDUE_SI_AMOUNT(double oVERDUE_SI_AMOUNT) {
		OVERDUE_SI_AMOUNT = oVERDUE_SI_AMOUNT;
	}

	public double getOVERDUE_EMI_AMOUNT() {
		return OVERDUE_EMI_AMOUNT;
	}

	public void setOVERDUE_EMI_AMOUNT(double oVERDUE_EMI_AMOUNT) {
		OVERDUE_EMI_AMOUNT = oVERDUE_EMI_AMOUNT;
	}

	public double getBOUNCE_CHARGE() {
		return BOUNCE_CHARGE;
	}

	public void setBOUNCE_CHARGE(double bOUNCE_CHARGE) {
		BOUNCE_CHARGE = bOUNCE_CHARGE;
	}

	public double getPENAL_CHARGE() {
		return PENAL_CHARGE;
	}

	public void setPENAL_CHARGE(double pENAL_CHARGE) {
		PENAL_CHARGE = pENAL_CHARGE;
	}

	public double getTOTAL_AMOUNT() {
		return TOTAL_AMOUNT;
	}

	public void setTOTAL_AMOUNT(double tOTAL_AMOUNT) {
		TOTAL_AMOUNT = tOTAL_AMOUNT;
	}

	public String getEmployee() {
		return Employee;
	}

	public void setEmployee(String employee) {
		Employee = employee;
	}

	public Date getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(Date sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public Date getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(Date eND_DATE) {
		END_DATE = eND_DATE;
	}

	public String getPROD_TYPE() {
		return PROD_TYPE;
	}

	public void setPROD_TYPE(String pROD_TYPE) {
		PROD_TYPE = pROD_TYPE;
	}
	
	
}
