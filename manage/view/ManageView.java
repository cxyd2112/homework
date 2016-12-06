package manage.view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import manage.controller.ManageViewControllerImpl;
import po.HotelPo;
import po.UserPo;
import service.ManageService;
import service.impl.ManageServiceImpl;
import vo.UserVo;

public class ManageView extends JPanel{
	
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
	
	private int userID;
	
	private ManageViewControllerService controller;
	
	private JComboBox<String> userTypeCombobox;
	
	private JButton searchButton;
	
	private JButton newMemberButton,newHotelButton;
	
	private JPanel userPanel;
	
	private JLabel userLabel;
	
	private JTextField userTextField;
	
	private JFrame searchFrame;
	
	private JPanel searchPanel;
	
	private JLabel searchLabel1,searchLabel2,searchLabel3,searchLabel4,searchLabel5,searchLabel6;
	
	private JTextField searchTextField1,searchTextField2,searchTextField3,searchTextField4,searchTextField5,searchTextField6;
	
	private JButton saveButton,cancleButton;
	
	private JFrame newMemberFrame;
	
	private JPanel newMemberPanel,newMemberPanel2;
	
	private JLabel newMemberLabel1,newMemberLabel2,newMemberLabel3,newMemberLabel4,newMemberLabel5,newMemberLabel6;
	
	private JTextField newMemberTextField1,newMemberTextField2,newMemberTextField3,newMemberTextField4,newMemberTextField5,newMemberTextField6;
	
	private JComboBox<String> newMemberCombobox;
	
	private JFrame newHotelFrame;
	
	private JLabel newHotelLabel1,newHotelLabel2,newHotelLabel3;
	
	private JTextField newHotelTextField1,newHotelTextField2,newHotelTextField3;
	
	private ManageService manageService;
	
	public ManageView(ManageViewControllerService controller){
		this.controller = controller;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//初始化页面
		initManageScene();
		
		this.validate();				
	}
	
	public void initManageScene(){
		
		userTypeCombobox = new JComboBox<String>();
		
		//用户类型列表
		List<String> list=new ArrayList<String>();
		list.add("类型");
		list.add("用户");
		list.add("酒店");
		
		//初始化combobox
		for(String str : list){
			userTypeCombobox.addItem(str);
		}
		
		//设置选择事件
		userTypeCombobox.addItemListener(new ItemListener(){
			
			public void itemStateChanged(ItemEvent evt){
				
				if(evt.getStateChange() == ItemEvent.SELECTED){
					
					String selected=(String)userTypeCombobox.getSelectedItem();
					
					controller.updateScene(selected);
				}
			}
		});
		
		JPanel userTypeJpanel = new JPanel();
		userTypeJpanel.setLayout(null);
		JLabel userTypeLabel = new JLabel("类型");
		userTypeLabel.setFont(new Font("宋体",Font.BOLD,20));
		userTypeCombobox.setFont(new Font("宋体",Font.BOLD,20));
		userTypeLabel.setBounds(50, 60, 100, 30);
		userTypeCombobox.setBounds(150, 60,100,30);
		userTypeJpanel.add(userTypeLabel);
		userTypeJpanel.add(userTypeCombobox);
		
		userLabel = new JLabel("请输入ID");
		userTextField = new JTextField(20);
		
		userLabel.setFont(new Font("宋体",Font.BOLD,20));
		userTextField.setFont(new Font("宋体",Font.BOLD,20));
		userLabel.setBounds(100, 200, 100, 30);
		userTextField.setBounds(300,200, 200, 30);
		userTypeJpanel.add(userLabel);
		userTypeJpanel.add(userTextField);
		
		searchButton = new JButton("查询（修改）信息");
		//添加按钮监听事件
		searchButton.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent arg0) {
						
				//界面跳转
				controller.searchButtonClicked();
			}
		});
		
		newMemberButton = new JButton("添加新人员");
		//添加按钮监听事件
		newMemberButton.addActionListener(new ActionListener() {
									
			public void actionPerformed(ActionEvent arg0) {
										
				//界面跳转
				controller.newMemberButtonClicked();
			}
		});
		
		newHotelButton = new JButton("添加新酒店");
		//添加按钮监听事件
		newHotelButton.addActionListener(new ActionListener() {
											
			public void actionPerformed(ActionEvent arg0) {
												
				//界面跳转
				controller.newHotelButtonClicked();
			}
		});
		
		searchButton.setFont(new Font("宋体",Font.BOLD,20));
		newMemberButton.setFont(new Font("宋体",Font.BOLD,20));
		newHotelButton.setFont(new Font("宋体",Font.BOLD,20));
		searchButton.setBounds(50, 400, 220,50);
		newMemberButton.setBounds(300, 400, 200,50);
		newHotelButton.setBounds(530, 400, 200,50);
		userTypeJpanel.add(searchButton);
		userTypeJpanel.add(newMemberButton);
		userTypeJpanel.add(newHotelButton);
				
		searchButton.setEnabled(false);
		newMemberButton.setEnabled(false);
		newHotelButton.setEnabled(false);
		
		this.add(userTypeJpanel);
		
	}
	
	/**
	 * 类型改变后更改数据源
	 */
	public void updateScene(String selected){
		if(selected == "用户"){
			searchButton.setEnabled(true);
			newMemberButton.setEnabled(true);
			newHotelButton.setEnabled(false);
		}else if(selected == "酒店"){
			searchButton.setEnabled(false);
			newMemberButton.setEnabled(false);
			newHotelButton.setEnabled(true);
		}
	}
	
	/**
	 * 打开查询修改信息界面
	 */
	public void searchButtonClicked(){
		searchFrame = new JFrame();
		searchFrame.setSize(600, 300);
		searchFrame.setLocation(400, 150);
		
		int id = Integer.valueOf(userTextField.getText());
		manageService = new ManageServiceImpl();
		UserVo userVo = manageService.uploadUser(id);		
		
		searchPanel = new JPanel();
		searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		searchLabel1 = new JLabel("姓名");
		searchLabel2 = new JLabel("ID");
		searchLabel3 = new JLabel("生日");
		searchLabel4 = new JLabel("手机号码");
		searchLabel5 = new JLabel("信用");
		searchLabel6 = new JLabel("公司");
		
		searchTextField1 = new JTextField(20);
		searchTextField1.setText(userVo.getUserName());
		searchTextField2 = new JTextField(20);
		searchTextField2.setText(String.valueOf(userVo.getId()));
		searchTextField3 = new JTextField(20);
		searchTextField3.setText(userVo.getBirthday());
		searchTextField4 = new JTextField(20);
		searchTextField4.setText(userVo.getPhone());
		searchTextField5 = new JTextField(20);
		searchTextField5.setText(String.valueOf(userVo.getCredit()));
		searchTextField6 = new JTextField(20);
		searchTextField6.setText(userVo.getCompany());
		searchTextField2.setEditable(false);
		searchTextField5.setEditable(false);
		saveButton = new JButton("保存");
		//保存信息修改
		saveButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				//事件处理
				if(saveUser()){
					searchFrame.dispose();
				}
			}
		});
		cancleButton = new JButton("取消");
		//取消查询修改处理
		cancleButton.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e) {
						//关闭窗口
				searchFrame.dispose();
						
			}
		});
		
		JPanel searchPanel1 = new JPanel();
		searchPanel1.setLayout(new GridLayout(7,2));
		searchPanel = new JPanel();
		searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		searchPanel1.add(searchLabel1);
		searchPanel1.add(searchTextField1);
		searchPanel1.add(searchLabel2);
		searchPanel1.add(searchTextField2);
		searchPanel1.add(searchLabel3);
		searchPanel1.add(searchTextField3);
		searchPanel1.add(searchLabel4);
		searchPanel1.add(searchTextField4);
		searchPanel1.add(searchLabel5);
		searchPanel1.add(searchTextField5);
		searchPanel1.add(searchLabel6);
		searchPanel1.add(searchTextField6);
		searchPanel1.add(saveButton);
		searchPanel1.add(cancleButton);
		searchPanel.add(searchPanel1);

		searchFrame.getContentPane().add(searchPanel);
		searchFrame.setVisible(true);
	}
	
	/**
	 * 打开添加新人员界面
	 */
	public void newMemberButtonClicked(){
		newMemberFrame = new JFrame();
		newMemberFrame.setSize(500, 250);
		newMemberFrame.setLocation(400, 200);
		
		newMemberPanel = new JPanel();
		newMemberPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		newMemberLabel1 = new JLabel("姓名");
		newMemberLabel2 = new JLabel("用户类型");
		newMemberLabel3 = new JLabel("生日");
		newMemberLabel4 = new JLabel("手机号码");
		newMemberLabel5 = new JLabel("信用");
		newMemberLabel6 = new JLabel("公司");
		newMemberCombobox = new JComboBox<String>();
		
		List<String> list=new ArrayList<String>();
		list.add("客户");
		list.add("酒店工作人员");
		list.add("网站营销人员");
		
		for(String str : list){
			newMemberCombobox.addItem(str);
		}
				
		newMemberCombobox.addItemListener(new ItemListener(){
					
			public void itemStateChanged(ItemEvent evt){
						
				if(evt.getStateChange() == ItemEvent.SELECTED){
							
					String selected=(String)newMemberCombobox.getSelectedItem();
				}
			}
		});
		
		newMemberTextField1 = new JTextField(20);
		newMemberTextField3 = new JTextField(20);
		newMemberTextField4 = new JTextField(20);
		newMemberTextField5 = new JTextField(20);
		newMemberTextField6 = new JTextField(20);
		saveButton = new JButton("保存");
		//保存信息
        saveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		cancleButton = new JButton("取消");
		//取消添加新人员处理
		cancleButton.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e) {
				//关闭窗口
				newMemberFrame.dispose();
						
			}
		});
		
		newMemberPanel = new JPanel();
		newMemberPanel2 = new JPanel();
		newMemberPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		newMemberPanel2.setLayout(new GridLayout(7,2));
		newMemberPanel2.add(newMemberLabel1);
		newMemberPanel2.add(newMemberTextField1);
		newMemberPanel2.add(newMemberLabel2);
		newMemberPanel2.add(newMemberCombobox);
		newMemberPanel2.add(newMemberLabel3);
		newMemberPanel2.add(newMemberTextField3);
		newMemberPanel2.add(newMemberLabel4);
		newMemberPanel2.add(newMemberTextField4);
		newMemberPanel2.add(newMemberLabel5);
		newMemberPanel2.add(newMemberTextField5);
		newMemberPanel2.add(newMemberLabel6);
		newMemberPanel2.add(newMemberTextField6);
		newMemberPanel2.add(saveButton);
		newMemberPanel2.add(cancleButton);
		newMemberPanel.add(newMemberPanel2);
		
		newMemberFrame.getContentPane().add(newMemberPanel);
		newMemberFrame.setVisible(true);
	}
	
	/**
	 * 打开新增酒店界面
	 */
	public void newHotelButtonClicked(){
		newHotelFrame = new JFrame();
		newHotelFrame.setSize(600, 200);
		newHotelFrame.setLocation(400, 200);
		
		newHotelLabel1 = new JLabel("酒店ID");
		newHotelLabel2 = new JLabel("酒店名称");
		newHotelLabel3 = new JLabel("酒店地址");
		newHotelTextField1 = new JTextField(20);
		newHotelTextField2 = new JTextField(20);
		newHotelTextField3 = new JTextField(20);
		saveButton = new JButton("保存");
		saveButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				
				if(saveHotel()){
					newHotelFrame.dispose();
				}
			}
		});
		cancleButton = new JButton("取消");
		cancleButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				newHotelFrame.dispose();
			}
		});
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4,2));
		panel2.add(newHotelLabel1);
		panel2.add(newHotelTextField1);
		panel2.add(newHotelLabel2);
		panel2.add(newHotelTextField2);
		panel2.add(newHotelLabel3);
		panel2.add(newHotelTextField3);
		panel2.add(saveButton);
		panel2.add(cancleButton);
		panel1.add(panel2);
		
		newHotelFrame.getContentPane().add(panel1);
		newHotelFrame.setVisible(true);
	}
	
	/**
	 * 保存按钮点击事件
	 */
	private boolean saveUser(){
		int id = Integer.valueOf(searchTextField2.getText());
		String userName = searchTextField1.getText();
		String birthday = searchTextField3.getText();
		String phone = searchTextField4.getText();
		int credit = Integer.valueOf(searchTextField5.getText());
		String company = searchTextField6.getText();
		UserPo userPo = new UserPo(id,userName,birthday,phone,credit,company);
		manageService = new ManageServiceImpl();
		if(manageService.changeUserInfo(id,userPo)){
			return true;
		}
		return false;
	}
	
	private boolean saveHotel(){
		int id = Integer.valueOf(newHotelTextField1.getText());
		String hotelName = newHotelTextField2.getText();
		String hotelAddress = newHotelTextField3.getText();
		HotelPo hotelPo = new HotelPo(id,hotelName,hotelAddress);
		manageService = new ManageServiceImpl();
		if(manageService.addHotel(hotelPo)){
			return true;
		}
		return false;
	}

}
