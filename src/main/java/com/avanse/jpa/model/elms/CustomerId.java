package com.avanse.jpa.model.elms;

import java.io.Serializable;

//@Embeddable
public class CustomerId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8441059307747897578L;

	//@Column(name="LOAN_NO")
	private String loanNo;
	
	private boolean isValid;
	
	//@Column(name="CUSTOMER_NAME")
	//private String customer_name;

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}

	/*
	 * public String getCustomer_name() { return customer_name; }
	 * 
	 * public void setCustomer_name(String customer_name) { this.customer_name =
	 * customer_name; }
	 */
	
	

}
