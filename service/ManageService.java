package service;

import po.HotelPo;
import po.UserPo;
import vo.UserVo;

public interface ManageService {
	
	/**
	 * @param userPo
	 * @return 增加用户
	 */
	public boolean addUser(UserPo userPo);
	
	/**
	 * @param userPo
	 * @return 更改用户信息
	 */
	public boolean changeUserInfo(int id,UserPo userPo);
	
	/**
	 * @param hotelPo
	 * @return 增加酒店
	 */
	public boolean addHotel(HotelPo hotelPo);
	/**
	 * @param id
	 * @return 上传用户信息
	 */
	public UserVo uploadUser(int id);
	
}
