package promotion.controller;

import promotion.view.ChangeOrderView;
import promotion.view.ChangeOrderViewControllerService;

public class ChangeOrderViewControllerImpl implements ChangeOrderViewControllerService{
	
	private ChangeOrderView view;
	
	public ChangeOrderViewControllerImpl(){
		
	}
	
	public void setView(ChangeOrderView view){
		this.view = view;
	}

}
