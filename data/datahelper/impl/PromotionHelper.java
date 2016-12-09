package data.datahelper.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import data.datahelper.PromotionDataHelper;
import po.PromotionPo;

public class PromotionHelper implements PromotionDataHelper{
	
	 private Runner run;

	 public PromotionHelper(){
	     run=new Runner();
	 }
	 
	 public Map<String,PromotionPo> getPromotionData(){
		Map<String,PromotionPo> map = new HashMap<String,PromotionPo>();
		String str = "SElECT * FROM software.homework ";
		String str2 = run.read(str);
		String[] data = str2.split(";");
		for(int i=0;data[i]!=null;i=i+6){
			int promotionNo = Integer.valueOf(data[i]);
			String promotionName = data[i+1];
			String beginTime = data[i+2];
			String endTime = data[i+3];
			double discount = Double.valueOf(data[i+4]);
			String place = data[i+5];
			PromotionPo promotionPo = new PromotionPo(promotionNo,promotionName,beginTime,endTime,discount,place);
			map.put(promotionName,promotionPo);
		}	
		
		return map;				
	}
	 
	 public void updatePromotionData(Map<String,PromotionPo> map){
		 //写入数据		
		 //对map遍历
		 Iterator<Map.Entry<String, PromotionPo>> iterator = map.entrySet().iterator();
			 while(iterator.hasNext()){
				 Map.Entry<String, PromotionPo> entry = iterator.next();
				 PromotionPo promotionPo = entry.getValue();
				 String str = promotionPo.getPromotionNo()+","+promotionPo.getPromotionName()+","+
				 promotionPo.getBeginTime()+","+promotionPo.getEndTime()+","+promotionPo.getDiscount();
				 String str1 = "INSERT INTO software.homework(id,promotionName,beginTime,endTime,discount) VALUES("+str+")";
				 int i=run.write(str1);
			 }
			
		}
		
		public void deletePromotionData(Map<String,PromotionPo> map,String promotionName){
			
		}

}
