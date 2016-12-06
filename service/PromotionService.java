package service;

import java.util.List;
import java.util.Date;

import vo.PromotionVo;
import po.PromotionPo;

public interface PromotionService {
	
	/**
	* @param promotionVo
	* @return	增加销售策略
	*/
	public boolean addStrategy(PromotionPo promotionPo);
	/**
	* @param promotionName
	* @return	删除销售策略
	*/
	public boolean deleteStrategy(String promotionName);
	/**
	* @param date
	* @return	查看销售策略列表
	*/
	public List<PromotionVo> observeList(Date date);
}
