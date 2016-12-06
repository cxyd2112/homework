package service;

public interface CreditService {
	
	/**
	 * @param id,credit
	 * @return   恢复信用值
	 */
	public boolean recoverCredit(int id,int credit);

}
