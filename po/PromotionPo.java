package po;

/**
 * promotionNo  策略编号
 * promotionName策略名称
 * beginTime	策略开始时间
 * endTime		策略结束时间
 * discount     策略折扣
 * place        服务范围
 * @author summer
 */

public class PromotionPo {
	
	private int promotionNo;
	
	private String promotionName;
	
	private String beginTime;
	
	private String endTime;
	
	private double discount;
	
	private String place;
	
	public PromotionPo(){
		super();
	}
	
	public PromotionPo(int promotionNo,String promotionName,String beginTime,
			String endTime,double discount,String place){
		super();
		this.promotionNo = promotionNo;
		this.promotionName = promotionName;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.discount = discount;
		this.place = place;
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
	
	public String getPlace(){
		return place;
	}
	
	public void setPlace(String place){
		this.place = place;
	}

}
