package main;

import javax.swing.JFrame;

import manage.controller.ManageViewControllerImpl;
import manage.view.ManageView;
import manage.view.ManageViewControllerService;

public class Main2 {
	
	public static void main(String args[]){
		JFrame mFrame = new JFrame();
		mFrame.setSize(800,600);
		mFrame.setLocation(300,100);
		ManageViewControllerService controller = new ManageViewControllerImpl();
		ManageView view = new ManageView(controller);
		controller.setView(view);
		mFrame.getContentPane().add(view);
		mFrame.setVisible(true);
	}

}
