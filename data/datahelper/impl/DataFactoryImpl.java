package data.datahelper.impl;

import data.dao.PromotionDao;
import data.dao.impl.PromotionDaoImpl;
import data.datahelper.DataFactory;
import data.datahelper.PromotionDataHelper;

public class DataFactoryImpl implements DataFactory{
	
	public PromotionDataHelper getPromotionDataHelper(){
		PromotionDataHelper promotionDao = new PromotionDataTxtHelper();
		//PromotionDao promotionDao = new PromotionDataMysqlHelper();
		return promotionDao;
	}

}
