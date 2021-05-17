package com.cg.grocerydeliveryapplication.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This class provides the payment entity
 * @author shaifali
 *
 */
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long paymentId;
	@NotBlank(message = "Payment mode should be selected")
	private String paymentMode;
	@NotBlank(message = "Cards number should be given")
	private String cardNumber;
	@NotBlank(message="Card holder name is required")
	private String cardHolderName;
	@NotBlank(message="expiry date is must")
	private String expiryDate;
	@NotNull(message="give the cvv")
	private int cvv;
	
	@NotNull(message="Provide the otp you got")
	private int otp;
	@NotBlank(message="amount should be entered")
	private String amount;
	
	
	public Payment (String paymentMode, String cardNumber, String cardHolderName, String expiryDate, int cvv, int otp,String amount) {
		super();
		this.paymentMode = paymentMode;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.otp = otp;
		this.amount = amount;
	}
	public Payment() {
		
	}
	/**
	 * return the payment id
	 * @return
	 */
	
	public long getId() {
		return paymentId;
		
		/**
		 * get the amount
		 * @return
		 */
	}
	public String getAmount() {
		return amount;
	}
	
	/**
	 * set the payment
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * set the payment
	 * @param paymentId
	 */
	public void setId(long paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * get the payment mode
	 * @return
	 */
	public String getPaymentMode() {
		return paymentMode;
	}
	/**
	 * set the payment mode
	 * @param paymentMode
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	/**
	 * get the card number
	 * @return
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * set the card number
	 * @param cardNumber
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * get the card holder name
	 * @return
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}
	/**
	 * set the card holder name
	 * @param cardHolderName
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	/**
	 * get the Expire date
	 * @return
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	/**
	 * set the Expire date
	 * @param expiryDate
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	/**
	 * get the cvv number
	 * @return
	 */
	public int getCvv() {
		return cvv;
	}
	/**
	 * set the cvv number
	 * @param cvv
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	/**
	 * get the otp number
	 * @return
	 */
	public int getOtp() {
		return otp;
	}
	/**
	 * set the otp number
	 * @param otp
	 */
	public void setOtp(int otp) {
		this.otp = otp;
	}
	

}



