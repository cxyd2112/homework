package data.dao;

import java.util.List;
import java.util.Date;

import po.PromotionPo;

public interface PromotionDao {
	
	/**
	 * @param promotionPo
	 * @return	增加销售策略
	 */
	public boolean addStrategyPo(PromotionPo promotionPo);
	
	/**
	 * @param promotionName
	 * @return	删除销售策略
	 */
	public boolean deleteStrategyPo(PromotionPo promotionPo);
	
	/**
	 * @param promotionPo
	 * @return	更新销售策略信息
	 */
	public boolean updatePromotion(PromotionPo promotionPo);
	
	/**
	 * @param promotionName
	 * @return	获取销售策略信息
	 */
	public PromotionPo observeInfo(String promotionName);
	
	/**
	 * @return	获取销售策略列表
	 */
	public List<PromotionPo> observeList(Date date);

}
