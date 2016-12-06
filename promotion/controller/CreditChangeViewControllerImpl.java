package promotion.controller;

import promotion.view.CreditChangeView;
import promotion.view.CreditChangeViewControllerService;
import service.CreditService;
import service.impl.CreditServiceImpl;


public class CreditChangeViewControllerImpl implements CreditChangeViewControllerService{
	
	private CreditChangeView view;
	
	private CreditService creditService;
	
	public CreditChangeViewControllerImpl(){
		creditService = new CreditServiceImpl();
	}
	
	
	public void setView(CreditChangeView view){
		this.view = view;
	}
	
	public void confirmButtonClicked(){
		view.confirmButtonClicked();
	}

}
