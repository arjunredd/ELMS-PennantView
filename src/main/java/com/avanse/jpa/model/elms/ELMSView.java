/*
 * package com.avanse.jpa.model.elms;
 * 
 * import java.util.Date;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.Id; import javax.persistence.Table; import
 * javax.persistence.Temporal; import javax.persistence.TemporalType; import
 * javax.persistence.Transient;
 * 
 * import org.hibernate.annotations.Immutable;
 * 
 * @Entity
 * 
 * @Immutable
 * 
 * @Table(name = "mcaap_report") // this is UAT view name //@Table(name =
 * "coll_overdue_view",schema="elms") // this prod view name public class
 * ELMSView {
 * 
 * @Id
 * 
 * @Column(name = "ID") private int id;
 * 
 * @Column(name = "LOAN_NO") private String loanNo;
 * 
 * @Column(name = "CUSTOMER_NAME") private String customer_name;
 * 
 * @Column(name = "LOAN_BRANCH") private String LOAN_BRANCH;
 * 
 * @Column(name = "TYPE") private String TYPE;
 * 
 * @Temporal(TemporalType.DATE)
 * 
 * @Column(name = "CUSTOMER_DOB") private Date CUSTOMER_DOB;
 * 
 * @Column(name = "MOBILE_NUMBER") private String MOBILE_NUMBER;
 * 
 * @Column(name = "EMAIL_ID") private String EMAIL_ID;
 * 
 * @Column(name = "ADDRESS") private String ADDRESS;
 * 
 * @Column(name = "POS") private Double POS;
 * 
 * @Column(name = "MODE_OF_REPAYMENT") private String MODE_OF_REPAYMENT;
 * 
 * @Column(name = "EMI_SI_PI_AMOUNT") private Double EMI_SI_PI_AMOUNT;
 * 
 * @Column(name = "OVERDUE_PI_AMOUNT") private Double OVERDUE_PI_AMOUNT;
 * 
 * @Column(name = "OVERDUE_SI_AMOUNT") private Double OVERDUE_SI_AMOUNT;
 * 
 * @Column(name = "OVERDUE_EMI_AMOUNT") private Double OVERDUE_EMI_AMOUNT;
 * 
 * @Column(name = "BOUNCE_CHARGE") private Double BOUNCE_CHARGE;
 * 
 * @Column(name = "PENAL_CHARGE") private Double PENAL_CHARGE;
 * 
 * @Column(name = "TOTAL_AMOUNT") private Double TOTAL_AMOUNT;
 * 
 * @Column(name = "Employee") private String Employee;
 * 
 * @Temporal(TemporalType.DATE)
 * 
 * @Column(name = "START_DATE") private Date START_DATE;
 * 
 * @Temporal(TemporalType.DATE)
 * 
 * @Column(name = "END_DATE") private Date END_DATE;
 * 
 * @Column(name = "PROD_TYPE") private String PROD_TYPE;
 * 
 * @Column(name="CURRENT_MONTH_INST") private Double CURRENT_MONTH_INST;
 * 
 * @Transient private Double availableCashLimit;
 * 
 * public Double getAvailableCashLimit() { return availableCashLimit; }
 * 
 * public void setAvailableCashLimit(Double availableCashLimit) {
 * this.availableCashLimit = availableCashLimit; }
 * 
 * public Double getCURRENT_MONTH_INST() { return CURRENT_MONTH_INST; }
 * 
 * public void setCURRENT_MONTH_INST(Double cURRENT_MONTH_INST) {
 * CURRENT_MONTH_INST = cURRENT_MONTH_INST; }
 * 
 * public String getLoanNo() { return this.loanNo; }
 * 
 * public void setLoanNo(String loanNo) { this.loanNo = loanNo; }
 * 
 * public String getCustomer_name() { return this.customer_name; }
 * 
 * public void setCustomer_name(String customer_name) { this.customer_name =
 * customer_name; }
 * 
 * public int getId() { return this.id; }
 * 
 * public void setId(int id) { this.id = id; }
 * 
 * public String getLOAN_BRANCH() { return this.LOAN_BRANCH; }
 * 
 * public void setLOAN_BRANCH(String lOAN_BRANCH) { this.LOAN_BRANCH =
 * lOAN_BRANCH; }
 * 
 * public String getTYPE() { return this.TYPE; }
 * 
 * public void setTYPE(String tYPE) { this.TYPE = tYPE; }
 * 
 * public Date getCUSTOMER_DOB() { return this.CUSTOMER_DOB; }
 * 
 * public void setCUSTOMER_DOB(Date cUSTOMER_DOB) { this.CUSTOMER_DOB =
 * cUSTOMER_DOB; }
 * 
 * public String getMOBILE_NUMBER() { return this.MOBILE_NUMBER; }
 * 
 * public void setMOBILE_NUMBER(String mOBILE_NUMBER) { this.MOBILE_NUMBER =
 * mOBILE_NUMBER; }
 * 
 * public String getEMAIL_ID() { return this.EMAIL_ID; }
 * 
 * public void setEMAIL_ID(String eMAIL_ID) { this.EMAIL_ID = eMAIL_ID; }
 * 
 * public String getADDRESS() { return this.ADDRESS; }
 * 
 * public void setADDRESS(String aDDRESS) { this.ADDRESS = aDDRESS; }
 * 
 * public Double getPOS() { return this.POS; }
 * 
 * public void setPOS(Double pOS) { this.POS = pOS; }
 * 
 * public String getMODE_OF_REPAYMENT() { return this.MODE_OF_REPAYMENT; }
 * 
 * public void setMODE_OF_REPAYMENT(String mODE_OF_REPAYMENT) {
 * this.MODE_OF_REPAYMENT = mODE_OF_REPAYMENT; }
 * 
 * public Double getEMI_SI_PI_AMOUNT() { return this.EMI_SI_PI_AMOUNT; }
 * 
 * public void setEMI_SI_PI_AMOUNT(Double eMI_SI_PI_AMOUNT) {
 * this.EMI_SI_PI_AMOUNT = eMI_SI_PI_AMOUNT; }
 * 
 * public Double getOVERDUE_PI_AMOUNT() { return this.OVERDUE_PI_AMOUNT; }
 * 
 * public void setOVERDUE_PI_AMOUNT(Double oVERDUE_PI_AMOUNT) {
 * this.OVERDUE_PI_AMOUNT = oVERDUE_PI_AMOUNT; }
 * 
 * public Double getOVERDUE_SI_AMOUNT() { return this.OVERDUE_SI_AMOUNT; }
 * 
 * public void setOVERDUE_SI_AMOUNT(Double oVERDUE_SI_AMOUNT) {
 * this.OVERDUE_SI_AMOUNT = oVERDUE_SI_AMOUNT; }
 * 
 * public Double getOVERDUE_EMI_AMOUNT() { return this.OVERDUE_EMI_AMOUNT; }
 * 
 * public void setOVERDUE_EMI_AMOUNT(Double oVERDUE_EMI_AMOUNT) {
 * this.OVERDUE_EMI_AMOUNT = oVERDUE_EMI_AMOUNT; }
 * 
 * public Double getBOUNCE_CHARGE() { return this.BOUNCE_CHARGE; }
 * 
 * public void setBOUNCE_CHARGE(Double bOUNCE_CHARGE) { this.BOUNCE_CHARGE =
 * bOUNCE_CHARGE; }
 * 
 * public Double getPENAL_CHARGE() { return this.PENAL_CHARGE; }
 * 
 * public void setPENAL_CHARGE(Double pENAL_CHARGE) { this.PENAL_CHARGE =
 * pENAL_CHARGE; }
 * 
 * public Double getTOTAL_AMOUNT() { return this.TOTAL_AMOUNT; }
 * 
 * public void setTOTAL_AMOUNT(Double tOTAL_AMOUNT) { this.TOTAL_AMOUNT =
 * tOTAL_AMOUNT; }
 * 
 * public String getEmployee() { return this.Employee; }
 * 
 * public void setEmployee(String employee) { this.Employee = employee; }
 * 
 * public Date getSTART_DATE() { return this.START_DATE; }
 * 
 * public void setSTART_DATE(Date sTART_DATE) { this.START_DATE = sTART_DATE; }
 * 
 * public Date getEND_DATE() { return this.END_DATE; }
 * 
 * public void setEND_DATE(Date eND_DATE) { this.END_DATE = eND_DATE; }
 * 
 * public String getPROD_TYPE() { return this.PROD_TYPE; }
 * 
 * public void setPROD_TYPE(String pROD_TYPE) { this.PROD_TYPE = pROD_TYPE; } }
 */