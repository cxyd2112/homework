package data.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Date;

import po.PromotionPo;
import data.dao.PromotionDao;
import data.datahelper.DataFactory;
import data.datahelper.PromotionDataHelper;
import data.datahelper.impl.DataFactoryImpl;
import data.datahelper.impl.PromotionDataTxtHelper;

public class PromotionDaoImpl implements PromotionDao{
	
	private Map<String,PromotionPo> map;
	
	private PromotionDataHelper promotionDataHelper;
	
	private DataFactory dataFactory;
	
	private static PromotionDaoImpl promotionDataServiceImpl;
	
	public static PromotionDaoImpl getInstance(){
		if(promotionDataServiceImpl == null){
			promotionDataServiceImpl = new PromotionDaoImpl();
		}
		return promotionDataServiceImpl;
	}
	
	public PromotionDaoImpl(){
		if(map == null){
			dataFactory = new DataFactoryImpl();
			promotionDataHelper = dataFactory.getPromotionDataHelper();
			map = promotionDataHelper.getPromotionData();
		}
	}
	
	public PromotionPo observeInfo(String promotionName){
		PromotionPo promotionPo = map.get(promotionName);
		return promotionPo;
	}
	
	public List<PromotionPo> observeList(Date date){
		List<PromotionPo> promotionList = new ArrayList<PromotionPo>();
		Iterator<Map.Entry<String, PromotionPo>> iterator = map.entrySet().iterator();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		while(iterator.hasNext()){
			Map.Entry<String, PromotionPo> entry = iterator.next();
			PromotionPo promotionPo = entry.getValue();
			try {
				Date dateBegin = sdf.parse(promotionPo.getBeginTime());
				if(dateBegin.getTime()>=date.getTime()){
					promotionList.add(promotionPo);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return promotionList;
	}
	
	public boolean updatePromotion(PromotionPo promotionPo){
		String promotionName = promotionPo.getPromotionName();
		if(map.get(promotionName) != null){
			map.put(promotionName, promotionPo);
			promotionDataHelper.updatePromotionData(map);
			return true;
		}
		return false;
	}
	
	public boolean addStrategyPo(PromotionPo promotionPo){
		/*
		 * 列表中添加策略并写入数据文件中
		 */
		String promotionName = promotionPo.getPromotionName();
		if(map.get(promotionName) == null){
			map.put(promotionName, promotionPo);
			promotionDataHelper.updatePromotionData(map);
			return true;
		}
		return false;
	}
	
	public boolean deleteStrategyPo(PromotionPo promotionPo){
		/*
		 * 列表中删除策略并更新数据文件
		 */
		String promotionName = promotionPo.getPromotionName();
		if(map.get(promotionName) != null){
			map.put(promotionName, promotionPo);
			promotionDataHelper.deletePromotionData(map,promotionName);
			return true;
		}
		return false;
	}

}
