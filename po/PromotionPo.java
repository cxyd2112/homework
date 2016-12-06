package po;

/**
 * promotionNo  策略编号
 * promotionName策略名称
 * beginTime	策略开始时间
 * endTime		策略结束时间
 * discount     策略折扣
 * @author summer
 */

public class PromotionPo {
	
	private int promotionNo;
	
	private String promotionName;
	
	private String beginTime;
	
	private String endTime;
	
	private double discount;
	
	public PromotionPo(){
		super();
	}
	
	public PromotionPo(int promotionNo,String promotionName,String beginTime,
			String endTime,double discount){
		super();
		this.promotionNo = promotionNo;
		this.promotionName = promotionName;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.discount = discount;
	}
	
	public int getPromotionNo(){
		return promotionNo;
	}
	
	public void setPromotionNo(int promotionNo){
		this.promotionNo = promotionNo;
	}
	
	public String getPromotionName(){
		return promotionName;
	}
	
	public void setPromotionName(String promotionName){
		this.promotionName = promotionName;
	}
	
	public String getBeginTime(){
		return beginTime;
	}
	
	public void setBeginTime(String beginTime){
		this.beginTime = beginTime;
	}
	
	public String getEndTime(){
		return endTime;
	}
	
	public void setEndTime(String endTime){
		this.endTime = endTime;
	}
	
	public double getDiscount(){
		return discount;
	}
	
	public void setDiscount(double discount){
		this.discount = discount;
	}

}
