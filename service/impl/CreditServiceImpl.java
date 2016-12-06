package service.impl;

import java.util.List;

import po.UserPo;
import service.CreditService;

public class CreditServiceImpl implements CreditService{
	
	private List<UserPo> userList;
	
	//private UserDao userDao;
	
	public CreditServiceImpl(){
		//userList = userDao.getList();
	}
	
	public boolean recoverCredit(int id,int credit){
		for(UserPo userPo : userList){
			if(userPo.getId() == id){
				int creditBefore = userPo.getCredit();
				userPo.setCredit(creditBefore+credit);
				if(true){//userDao.updateUser(userPo)
					return true;
				}
			}
		}
		return false;
	}

}
