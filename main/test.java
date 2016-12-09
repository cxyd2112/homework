package main;

import po.PromotionPo;
import data.dao.PromotionDao;
import data.dao.impl.PromotionDaoImpl;
import data.datahelper.impl.Runner;
import service.PromotionService;
import service.impl.PromotionServiceImpl;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class test {

private static PromotionService promotionService;

private static Runner run;
public static void main (String args[]){
	String str = "select * from software.homework where id=1";
	System.out.println(run.read(str));
 }

}
