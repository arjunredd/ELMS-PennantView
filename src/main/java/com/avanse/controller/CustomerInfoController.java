package com.avanse.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avanse.consumer.FinanceResponse;
import com.avanse.consumer.PennetAPI;
import com.avanse.exception.AppException;
import com.avanse.jpa.model.elms.CustomerId;
/*import com.avanse.jpa.model.elms.ELMSView;
import com.avanse.jpa.model.elms.ElmsViewRepository;*/
import com.avanse.jpa.model.pennant.PennantView;
import com.avanse.jpa.model.pennant.PennantViewOtherRepository;
import com.avanse.jpa.model.pennant.PennantViewRepository;
import com.avanse.models.MstSourceMappingRepository;

@RestController
@RequestMapping("/customer")
public class CustomerInfoController {

	/*
	 * @Autowired private ElmsViewRepository elmsViewRepository;
	 */

	@Autowired
	private PennantViewRepository pennantViewRepository;
	
	@Autowired
	private PennantViewOtherRepository pennantViewOtherRepository;
	
	@Autowired
	PennetAPI pennetAPI;
	
	@Autowired
	private MstSourceMappingRepository mstSourceMappingRepository;
	
	@Value("${getSystemDate}")
	private String getSystemDate_url;

	//Get all elms customer data
	/*
	 * @GetMapping("/elms") public ResponseEntity<?> getELMSViewData() { return
	 * ResponseEntity.ok(elmsViewRepository.findAll()); }
	 */

	//Get all pennant customer data
	@GetMapping("/pennant")
	public ResponseEntity<?> getPennantViewData() {
		return ResponseEntity.ok(pennantViewRepository.findAll());
	}
	
	//To get list of all elms customers where overdue amount is greater than zero.
	/*
	 * @PostMapping("/elmsOverdues") public ResponseEntity<?> getELMSOverdueData(){
	 * return ResponseEntity.ok(elmsViewRepository.
	 * getAllOverdueAmtGreaterThanZeroOrderByLoanNo());
	 * 
	 * }
	 */
	
	//To get list of all elms customers where overdue amount is greater than zero.
	@PostMapping("/pennantOverdues")
	public ResponseEntity<?> getPennantOverdueData(){
		return ResponseEntity.ok(pennantViewRepository.getAllOverdueAmtGreaterThanZeroOrderByLoanNo());
		
	}
	

	// CHECK IF VALID LANumber or not

	@PostMapping("/isValidLAN")
	public ResponseEntity<?> isValidLANumber(@RequestBody CustomerId customer) {
		
		String loanNo = customer.getLoanNo();
		if (loanNo != null) {

			//JSONObject o=new JSONObject();
			boolean isValid=false;
			/*
			 * if (loanNo.contains("/")) {
			 * 
			 * 
			 * isValid=elmsViewRepository.existsByLoanNo(loanNo);
			 * 
			 * } else {
			 */

				isValid=pennantViewRepository.existsByLoanNo(loanNo);
			/* } */
			
			//o.put("isValid", isValid);
			customer.setValid(isValid);
			return ResponseEntity.ok(customer);

		} else {
			throw new AppException("Loan no is null or blank");
		}
		//return null;
	}

	// GET OVERDUE ON LOAN_NO AND TYPE AS APPLICANT
	@PostMapping("/getOverdue")
	public ResponseEntity<?> getOverdue(@RequestBody CustomerId customer) {

		String loanNo = customer.getLoanNo();
		if (loanNo != null) {
			
			/*Date Logic*/
			System.out.println("Loan Number:"+loanNo);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String systemDate;
			FinanceResponse systemDateResp=null;

			systemDateResp = pennetAPI.callRestTemplateForReceipting(getSystemDate_url, null,
					"systemDateService",HttpMethod.GET);
			
			String appDate=systemDateResp.getAppDate();
			
			Date pennetDate;
			try {
				pennetDate=new SimpleDateFormat("yyyy-MM-dd").parse(appDate);
		    	systemDate = dateFormat.format(pennetDate);
		    	pennetDate = dateFormat.parse(systemDate);
			} catch (ParseException e1) {
				throw new AppException("Exception getting system date:"+e1.getMessage());
			}
			System.out.println("Pennent Date:"+pennetDate);
			/*Date Logic*/
			/*
			 * if (loanNo.contains("/")) {
			 * 
			 * System.out.println("1"); ELMSView
			 * e=elmsViewRepository.findByLoanNoAndTYPE(loanNo, "APPLICANT");
			 * System.out.println("2");
			 * 
			 * if(e!=null) { System.out.println("3"); Double
			 * cashLimt=mstSourceMappingRepository.getCashLimitForLoan(loanNo, pennetDate);
			 * System.out.println("4"); e.setAvailableCashLimit(cashLimt);
			 * System.out.println("CashLimit:"+cashLimt);
			 * 
			 * }
			 * 
			 * return ResponseEntity.ok(e); } else {
			 */
			System.out.println("5");
				PennantView p=pennantViewRepository.findByLoanNoAndTYPE(loanNo, "APPLICANT");
				System.out.println("6");
				if(p!=null) {
					System.out.println("7");
					Double cashLimt=mstSourceMappingRepository.getCashLimitForLoan(loanNo, pennetDate);
					System.out.println("8");
					p.setAvailableCashLimit(cashLimt);
					System.out.println("CashLimit:"+cashLimt);
				}
				
				System.out.println("9");

				return ResponseEntity.ok(p);
				
				//return ResponseEntity.ok(pennantViewRepository.findByLoanNoAndTYPE(loanNo, "Applicant"));
			/* } */

		} else {
			throw new AppException("Loan no is null or blank");
			
			//System.out.println("loan no null or blank");
		}
		//return null;
	}

	// GET DETAILS ONLY ON LOAN_NO
	@PostMapping("/getLoanDetails")
	public ResponseEntity<?> getLoanDetails(@RequestBody CustomerId customer) {

		String loanNo = customer.getLoanNo();

		if (loanNo != null) {

			/*
			 * if (loanNo.contains("/")) {
			 * 
			 * return ResponseEntity.ok(elmsViewRepository.findByLoanNo(loanNo));
			 * 
			 * } else {
			 */

				return ResponseEntity.ok(pennantViewRepository.findByLoanNo(loanNo));
			/* } */

		} else {
			throw new AppException("Loan no is null or blank");
		}
		//return null;
	}
	
	@PostMapping("/getLoanDetailsOthers")
	public ResponseEntity<?> getLoanDetailsOthers(@RequestBody CustomerId customer) {
		String loanNo = customer.getLoanNo();
		if (loanNo == null || loanNo.trim().equals("")) {
			throw new AppException("Loan no is null or blank");
		}
		return ResponseEntity.ok(pennantViewOtherRepository.findByLoanNo(loanNo));
	}

}
