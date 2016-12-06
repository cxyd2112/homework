package service.impl;

import java.util.List;

import data.dao.PromotionDao;
import data.dao.impl.PromotionDaoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import service.PromotionService;
import vo.PromotionVo;
import po.PromotionPo;
import po.UserPo;

public class PromotionServiceImpl implements PromotionService{
	
	private List<PromotionPo> promotionList;
	
	private  Date date;
	
	private PromotionDao promotionDao;
	
	public PromotionServiceImpl(Date date){
		this.date = date;
		promotionDao = PromotionDaoImpl.getInstance();
		promotionList = promotionDao.observeList(date);
	}
	
	
	public boolean addStrategy(PromotionPo promotionPo){
		return promotionDao.addStrategyPo(promotionPo);
		
	}
	
	public boolean deleteStrategy(String promotionName){
		for(PromotionPo promotionPo : promotionList){
			if(promotionPo.getPromotionName() == promotionName){
				promotionDao.deleteStrategyPo(promotionPo);
				return true;
			}
		}
		return false;
	}
	
	public List<PromotionVo> observeList(Date date){
		List<PromotionVo> list = new ArrayList<PromotionVo>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		for(PromotionPo promotionPo : promotionList){
			PromotionVo promotionVo = new PromotionVo(promotionPo);
			try {
				Date dateBegin = sdf.parse(promotionVo.getBeginTime());
				if(date.getTime()<=dateBegin.getTime()){
					list.add(promotionVo);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return list;
	}
	
	
}