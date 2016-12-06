package data.datahelper;

import java.util.Map;

import po.PromotionPo;

public interface PromotionDataHelper {
	
	/**
	 * @return	从数据文件中读取策略数据
	 */
	public Map<String,PromotionPo> getPromotionData();
	
	/**
	 * 向数据文件中写入策略数据
	 * @param list	
	 */
	public void updatePromotionData(Map<String,PromotionPo> map);
	
	/**
	 * 删除数据文件中的策略数据
	 */
	public void deletePromotionData(Map<String,PromotionPo> map,String promotionName);

}
