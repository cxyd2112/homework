package manage.view;

import javax.swing.text.View;

import manage.view.ManageView;

public interface ManageViewControllerService {
	
	public void setView(ManageView view);
	
	public void updateScene(String comboboxValue);
	
	public void searchButtonClicked();
	
	public void newMemberButtonClicked();
	
	public void newHotelButtonClicked();

}
