package main;

import po.PromotionPo;
import data.dao.PromotionDao;
import data.dao.impl.PromotionDaoImpl;
import service.PromotionService;
import service.impl.PromotionServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class test {

private static PromotionService promotionService;
	public static void main(String args[]){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse("2015/01/01 00:00:01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		promotionService = new PromotionServiceImpl(date);
		PromotionPo promotionPo = new PromotionPo(4,"元旦","2017/01/01 00:00:01","2016/01/03 23:59:59",0.98);
		String promotionName = "元旦";
		System.out.println(promotionService.deleteStrategy(promotionName));
	}

}
