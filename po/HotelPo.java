package po;

public class HotelPo {
	int hotelID;
	String position;
	String hotelName;
	
	public HotelPo(){
		super();
	}
	public HotelPo(int hotelID,String position,String hotelName){
		this.hotelID = hotelID;
		this.position = position;
		this.hotelName = hotelName;
	
	}
	
	public int getHotelID(){
		return this.hotelID;
	}
	
	public void setHotelID(int hotelID){
		this.hotelID = hotelID;
	}

	public String getPosition(){
		return this.position;
	}
	
	public void setPosition(String position){
		this.position = position;
	}
	
	public String getHotelName(){
		return this.hotelName;
	}
	
	public void setHotelName(String hotelName){
		this.hotelName = hotelName;
	}

}
