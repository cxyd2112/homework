package vo;

import java.util.Vector;

import po.PromotionPo;

/**
 * promotionNo  策略编号
 * promotionName策略名称
 * beginTime	策略开始时间
 * endTime		策略结束时间
 * discount     策略折扣
 * @author summer
 */

public class PromotionVo extends Vector<String>{
	public PromotionVo(PromotionPo promotionPo){
		this.add(String.valueOf(promotionPo.getPromotionNo()));
		this.add(promotionPo.getPromotionName());
		this.add(promotionPo.getBeginTime());
		this.add(promotionPo.getEndTime());
		this.add(String.valueOf(promotionPo.getDiscount()));
	}
	
	public PromotionVo(int promotionNo,String promotionName,String beginTime,String endTime,double discount){
		this.add(String.valueOf(promotionNo));
		this.add(promotionName);
		this.add(beginTime);
		this.add(endTime);
		this.add(String.valueOf(discount));
	}
	
	public int getPromotionNo(){
		return Integer.valueOf(this.get(0));
	}
	
	public String getPromotionName(){
		return this.get(1);
	}
	
	public String getBeginTime(){
		return this.get(2);
	}
	
	public String getEndTime(){
		return this.get(3);
	}
	
	public double getDiscount(){
		return Integer.valueOf(this.get(4));
	}

}
