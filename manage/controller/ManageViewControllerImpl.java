package manage.controller;

import manage.view.ManageViewControllerService;
import manage.view.ManageView;

public class ManageViewControllerImpl implements ManageViewControllerService{
	
	private ManageView view;
	
	public ManageViewControllerImpl (){
		
	}
	
	public void setView(ManageView view){
		this.view = view;
	}
	
	public void updateScene(String comboboxValue){
		view.updateScene(comboboxValue);
	}
	
	public void searchButtonClicked(){
		view.searchButtonClicked();
	}
	
	public void newMemberButtonClicked(){
		view.newMemberButtonClicked();
	}
	
	public void newHotelButtonClicked(){
		view.newHotelButtonClicked();
	}
	
}
