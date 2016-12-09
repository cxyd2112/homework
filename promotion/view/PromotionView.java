package promotion.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
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

import promotion.controller.PromotionViewControllerImpl;
import promotion.view.PromotionViewControllerService;
import service.PromotionService;
import service.impl.PromotionServiceImpl;
import po.PromotionPo;
import vo.PromotionVo;

public class PromotionView extends JPanel{
	
	public static void main(String args[]){
		JFrame promotionFrame = new JFrame();
		promotionFrame.setSize(800,600);
		promotionFrame.setLocation(300,100);
		promotionFrame.setTitle("查看销售策略");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse("2015/01/01 00:00:01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		PromotionViewControllerService controller = new PromotionViewControllerImpl(date);
		PromotionView view = new PromotionView(controller);
		controller.setView(view);
		promotionFrame.getContentPane().add(view);
		promotionFrame.setVisible(true);
		
	}
	
	private static final long serialVersionUID = 1L;
	
	private PromotionViewControllerService controller;
	
	private PromotionService promotionService;
	
	private JButton newStrategyButton;
	
	private JButton deleteStrategyButton;
	
	private JButton inputDateButton;
	
	private JButton returnButton;
	
	private JTable promotionTable;
	
	private DefaultTableModel promotionListModel;
	
	private JFrame newStrategyFrame;
	
	private JPanel newStrategyPanel,newStrategyPanel2;
	
	private JComboBox<String> newStrategyCombobox1,newStrategyCombobox2,newStrategyCombobox3;
	
	private JLabel newStrategyLabel1,newStrategyLabel2,newStrategyLabel3,newStrategyLabel4,newStrategyLabel5,newStrategyLabel6;
	
	private JTextField newStrategyTextField1,newStrategyTextField2,newStrategyTextField3,newStrategyTextField4,newStrategyTextField5;

	private JButton confirmButton;
	
	private JButton cancleButton;
	
	private Date date;
	
	private JFrame inputDateFrame;
	
	private JLabel inputDateLabel;
	
	private JTextField inputDateTextField;
	
	private PromotionPo promotionPo;
	
	private PromotionVo promotionVo;
	
	private List<PromotionPo> promotionList;
	
	public PromotionView(PromotionViewControllerService controller){
		this.controller = controller;
		this.date = controller.getDate();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//初始化操作按钮
		initPromotionButtons();
		
		//初始化订单列表
		initPromotionListTable();
		
		this.validate();
	}
	
	private void initPromotionButtons(){
		
		newStrategyButton = new JButton("创建新策略");
		//添加按钮监听事件
		newStrategyButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				
				//界面跳转
				controller.newStrategyButtonClicked();
			}
		});
		
		deleteStrategyButton = new JButton("删除原策略");
		//添加按钮监听事件
		deleteStrategyButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				
				//删除销售策略按钮点击事件
				controller.deleteStrategyButtonClicked();
			}
		});
		
		inputDateButton = new JButton("输入日期");
		//添加按钮监听事件
		inputDateButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				
				//界面跳转
				controller.inputDateButtonClicked();
			}
		});
		
		returnButton = new JButton("返回");
		//添加按钮监听事件
		returnButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				
				//界面跳转
			}
		});
		
		//添加策略处理栏
		JPanel processPanel = new JPanel();
		JPanel processPanel1 = new JPanel();	
		processPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		processPanel.add(newStrategyButton);
		processPanel.add(deleteStrategyButton);
		processPanel.add(inputDateButton);
		processPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		processPanel1.add(returnButton);
		JPanel processPanel2 = new JPanel();
		processPanel2.setLayout(new GridLayout(1,2));
		processPanel2.add(processPanel);
		processPanel2.add(processPanel1);
		
		newStrategyButton.setEnabled(true);
		deleteStrategyButton.setEnabled(true);
		inputDateButton.setEnabled(true);
		returnButton.setEnabled(true);
		
		this.add(processPanel2);
		
	}
	
	private void initPromotionListTable(){
		JScrollPane scrollPane = new JScrollPane();
		
		//表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("策略编号");
		vColumns.add("策略名称");
		vColumns.add("开始日期");
		vColumns.add("结束日期");
		vColumns.add("折扣");
		vColumns.add("服务范围");
		
		//数据
		Vector<PromotionVo> vData = new Vector<PromotionVo>();
		vData.addAll(controller.observeList(date));
		//模型
		promotionListModel = new DefaultTableModel(vData,vColumns);
		//表格
		promotionTable = new JTable(promotionListModel){
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row,int column){
				return false;
			}
		};
		promotionTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.getViewport().add(promotionTable);
		promotionTable.setFillsViewportHeight(true);
		this.add(scrollPane);		
	}
	
	/**
	 * 删除销售策略按钮点击事件
	 */
	public void deleteStrategyButtonClicked(){
		int index = promotionTable.getSelectedRow();
		if(index==-1){
			JOptionPane.showMessageDialog(null,"请选择销售策略","",JOptionPane.ERROR_MESSAGE);
		}
		
		String promotionName = (String)promotionTable.getValueAt(index,1);
		promotionService = new PromotionServiceImpl(date);
		if(promotionService.deleteStrategy(promotionName)){
			promotionListModel.removeRow(index);
		}else{
			JOptionPane.showMessageDialog(null,"删除销售策略失败","",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 输入日期按钮点击事件
	 */
	public void inputDateButtonClicked(){
		inputDateFrame = new JFrame();
		inputDateFrame.setSize(600,100);
		inputDateFrame.setLocation(400, 200);
		
		inputDateLabel = new JLabel("请输入日期(yyyy-MM-dd HH:mm:ss)：");
		inputDateTextField = new JTextField(25);
		confirmButton = new JButton("确定");
		//确定显示
		confirmButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				String newDateS = inputDateTextField.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date newDate = null;
				try {
					newDate = sdf.parse(newDateS);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				promotionListModel.setRowCount(0);
				for(PromotionVo prmotionVo : controller.observeList(newDate)){
					promotionListModel.addRow(prmotionVo);
				}
				inputDateFrame.dispose();
			}
		});
		cancleButton = new JButton("取消");
		//取消显示
		cancleButton.addActionListener(new ActionListener(){
					
			public void actionPerformed(ActionEvent e){
				//关闭窗口
				inputDateFrame.dispose();
			}
		});
		
		JPanel inputDatePanel1 = new JPanel();
		JPanel inputDatePanel2 = new JPanel();
		inputDatePanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		inputDatePanel2.setLayout(new GridLayout(2,2));
		inputDatePanel2.add(inputDateLabel);
		inputDatePanel2.add(inputDateTextField);
		inputDatePanel2.add(confirmButton);
		inputDatePanel2.add(cancleButton);
		inputDatePanel1.add(inputDatePanel2);
		
		inputDateFrame.setTitle("输入日期");
		inputDateFrame.getContentPane().add(inputDatePanel1);
		inputDateFrame.setVisible(true);
		
	}
	
	/**
	 * 打开制定新销售策略界面
	 * @param index
	 */
	public void newStrategyButtonClicked(){
		
		newStrategyFrame = new JFrame();
		newStrategyFrame.setSize(700,300);
		newStrategyFrame.setLocation(400,200);
		
		newStrategyPanel = new JPanel();
		newStrategyPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		newStrategyLabel1 = new JLabel("策略序号（4位）");
		newStrategyTextField1 = new JTextField(20);
		newStrategyLabel2 = new JLabel("策略名称（不超过20字）");
		newStrategyTextField2 = new JTextField(35);
		newStrategyLabel3 = new JLabel("开始时间（yyyy/MM/dd HH:mm:ss）");
		newStrategyTextField3 = new JTextField(20);
		newStrategyLabel4 = new JLabel("结束时间（yyyy/MM/dd HH:mm:ss）");
		newStrategyTextField4 = new JTextField(20);
		newStrategyLabel5 = new JLabel("折扣");
		newStrategyTextField5 = new JTextField(20);
		newStrategyLabel6 = new JLabel("服务范围");
		newStrategyCombobox1 = new JComboBox<String>();
			List<String> list=new ArrayList<String>();
			list.add("全国");
			list.add("江苏");
			list.add("辽宁");		
			for(String str : list){
				newStrategyCombobox1.addItem(str);
			}
		newStrategyCombobox2 = new JComboBox<String>();
			list=new ArrayList<String>();
			list.add("全省");
			list.add("南京");
			list.add("苏州");		
			for(String str : list){
				newStrategyCombobox2.addItem(str);
			}
		newStrategyCombobox3 = new JComboBox<String>();
			list=new ArrayList<String>();
			list.add("全区/商圈");
			list.add("新街口");
			list.add("栖霞区");		
			for(String str : list){
				newStrategyCombobox3.addItem(str);
			}
		confirmButton = new JButton("确定");
		//确定增加新策略
		confirmButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent args0){
				int index = Integer.valueOf(newStrategyTextField1.getText());
				if(newPromotion(index)){
					promotionVo = new PromotionVo(promotionPo);
					promotionListModel.addRow(promotionVo);
				};
			}
		});
		cancleButton = new JButton("取消");
		//取消制定策略
		cancleButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				//关闭窗口
				newStrategyFrame.dispose();
			}
		});
		newStrategyPanel = new JPanel();
		newStrategyLabel1.setBounds(200,10,100,30);
		newStrategyTextField1.setBounds(350,10,200,30);
		newStrategyLabel2.setBounds(150,50,200,30);
		newStrategyTextField2.setBounds(350,50,200,30);
		newStrategyLabel3.setBounds(100,90,300,30);
		newStrategyTextField3.setBounds(350,90,200,30);
		newStrategyLabel4.setBounds(100,130,300,30);
		newStrategyTextField4.setBounds(350,130,200,30);
		newStrategyLabel5.setBounds(250,170,100,30);
		newStrategyTextField5.setBounds(350,170,200,30);
		newStrategyLabel6.setBounds(200,210,100,30);
		newStrategyCombobox1.setBounds(350,210,60,30);
		newStrategyCombobox2.setBounds(420,210,60,30);
		newStrategyCombobox3.setBounds(490,210,80,30);
		newStrategyPanel.setLayout(null);
		newStrategyPanel.add(newStrategyLabel1);
		newStrategyPanel.add(newStrategyTextField1);
		newStrategyPanel.add(newStrategyLabel2);
		newStrategyPanel.add(newStrategyTextField2);
		newStrategyPanel.add(newStrategyLabel3);
		newStrategyPanel.add(newStrategyTextField3);
		newStrategyPanel.add(newStrategyLabel4);
		newStrategyPanel.add(newStrategyTextField4);
		newStrategyPanel.add(newStrategyLabel5);
		newStrategyPanel.add(newStrategyTextField5);
		newStrategyPanel.add(newStrategyLabel6);
		newStrategyPanel.add(newStrategyCombobox1);
		newStrategyPanel.add(newStrategyCombobox2);
		newStrategyPanel.add(newStrategyCombobox3);
		newStrategyPanel.add(confirmButton);
		newStrategyPanel.add(cancleButton);
		
		newStrategyFrame.setTitle("创建新策略");
		newStrategyFrame.getContentPane().add(newStrategyPanel);
		newStrategyFrame.setVisible(true);		
		
	}
	
	//新策略确定按钮点击事件
	private boolean newPromotion(int promotionNo){
		String promotionName = newStrategyTextField2.getText();
		String beginTime = newStrategyTextField3.getText();
		String endTime = newStrategyTextField4.getText();
		double discount = Double.valueOf(newStrategyTextField5.getText());
		String place = (String)newStrategyCombobox1.getSelectedItem()+(String)newStrategyCombobox2.getSelectedItem()+(String)newStrategyCombobox3.getSelectedItem();
		promotionService = new PromotionServiceImpl(date);
		promotionPo = new PromotionPo(promotionNo,promotionName,beginTime,endTime,discount,place);	
		if(promotionService.addStrategy(promotionPo)){
			newStrategyFrame.dispose();
			return true;
		}
		else{
			JOptionPane.showMessageDialog(null,"增加销售策略失败","",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

}
