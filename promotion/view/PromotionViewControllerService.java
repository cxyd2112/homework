package promotion.view;

import java.util.List;
import java.util.Date;

import promotion.view.PromotionView;
import vo.PromotionVo;



public interface PromotionViewControllerService {
	
	public void setView(PromotionView view);
	
	public Date getDate();
	
	public List<PromotionVo> observeList(Date date);
	
	public void newStrategyButtonClicked();
	
	public void deleteStrategyButtonClicked();
	
	public void inputDateButtonClicked();

}
