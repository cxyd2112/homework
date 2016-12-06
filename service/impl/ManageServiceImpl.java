package service.impl;

import service.ManageService;
import vo.UserVo;

import java.util.List;

import po.HotelPo;
import po.UserPo;

public class ManageServiceImpl implements ManageService{
	
	private UserVo userVo;
	
	private List<UserPo> userList;
	
	public boolean addUser(UserPo userPo){
		//userDao.addUserPo(userPo);
		return true;
	}
	
	public boolean changeUserInfo(int id,UserPo usPo){
		for(UserPo userPo :userList){
			if(userPo.getId() == id){
				userPo.setUserName(usPo.getUserName());
				userPo.setCompany(usPo.getCompany());
				userPo.setPhone(usPo.getPhone());
				userPo.setBirthday(usPo.getBirthday());
				
				return true;
			}
			
		}
		return false;
	}
	
	public boolean addHotel(HotelPo hotelPo){
		//hotelDao.addHotelPo(hotelPo);
		return true;
	}
	
	public UserVo uploadUser(int id){
		for(UserPo userPo : userList){
			if(userPo.getId() == id){
				userVo = new UserVo(userPo);
			}
		}
		return userVo;
	}

}
