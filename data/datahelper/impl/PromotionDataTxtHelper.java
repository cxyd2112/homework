package data.datahelper.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import po.PromotionPo;
import data.datahelper.PromotionDataHelper;

public class PromotionDataTxtHelper implements PromotionDataHelper{
	
	public Map<String,PromotionPo> getPromotionData(){
		File file = new File("TxtData/promotion.txt");
		Map<String,PromotionPo> map = new HashMap<String,PromotionPo>();
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String str = br.readLine();
			
			while(str!=null){
				String[] data = str.split(";");
				int promotionNo = Integer.valueOf(data[0]);
				String promotionName = data[1];
				String beginTime = data[2];
				String endTime = data[3];
				double discount = Double.valueOf(data[4]);
				String place = data[5];
				
				PromotionPo promotionPo = new PromotionPo(promotionNo,promotionName,beginTime,endTime,discount,place);
				map.put(promotionName,promotionPo);
				
				str = br.readLine();
			}
			
			br.close();
			
			return map;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public void updatePromotionData(Map<String,PromotionPo> map){
		//写入数据
		File file = new File("TxtData/promotion.txt");
		try{
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			//对map遍历
			Iterator<Map.Entry<String, PromotionPo>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<String, PromotionPo> entry = iterator.next();
				PromotionPo promotionPo = entry.getValue();
				String str = promotionPo.getPromotionNo()+";"+promotionPo.getPromotionName()+";"+
				promotionPo.getBeginTime()+";"+promotionPo.getEndTime()+";"+promotionPo.getDiscount()+";"+promotionPo.getPlace();
				bw.write(str);
				bw.write("\r\n");
			}
			
			bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void deletePromotionData(Map<String,PromotionPo> map,String promotionName){
		//删除数据
		File file = new File("TxtData/promotion.txt");
		try{
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			//对map遍历
			Iterator<Map.Entry<String, PromotionPo>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<String, PromotionPo> entry = iterator.next();
				PromotionPo promotionPo = entry.getValue();
				String str ="";
				if(promotionPo.getPromotionName() != promotionName){
					str = promotionPo.getPromotionNo()+";"+promotionPo.getPromotionName()+";"+
							promotionPo.getBeginTime()+";"+promotionPo.getEndTime()+";"+promotionPo.getDiscount()+";"+promotionPo.getPlace();
				}	
				bw.write(str);
				if(str!=""){
					bw.write("\r\n");
				}		
			}
			
			bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}