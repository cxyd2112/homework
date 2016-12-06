package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import promotion.controller.PromotionViewControllerImpl;
import promotion.view.PromotionView;
import promotion.view.PromotionViewControllerService;

public class Main {
	
	public static void main(String args[]){
		JFrame mFrame = new JFrame();
		mFrame.setSize(800,600);
		mFrame.setLocation(300,100);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse("2015/01/01 00:00:01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		PromotionViewControllerService controller = new PromotionViewControllerImpl(date);
		PromotionView view = new PromotionView(controller);
		controller.setView(view);
		mFrame.getContentPane().add(view);
		mFrame.setVisible(true);
		
	}
	
}

