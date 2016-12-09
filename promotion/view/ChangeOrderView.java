package promotion.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import promotion.view.ChangeOrderViewControllerService;
import vo.PromotionVo;
import promotion.controller.ChangeOrderViewControllerImpl;

public class ChangeOrderView extends JPanel{
	
	public static void main(String args[]){
		JFrame changeOrderFrame = new JFrame();
		changeOrderFrame.setSize(800,600);
		changeOrderFrame.setLocation(300, 100);
		changeOrderFrame.setTitle("更改异常订单状态");
		ChangeOrderViewControllerService controller = new ChangeOrderViewControllerImpl();
		ChangeOrderView view = new ChangeOrderView(controller);
		controller.setView(view);
		changeOrderFrame.getContentPane().add(view);
		changeOrderFrame.setVisible(true);
	}
	
	private ChangeOrderViewControllerService controller;
	
	private JTable orderTable;
	
	private DefaultTableModel orderListModel;
	
	private JButton changeButton;
	
	private JButton returnButton;
	
	public ChangeOrderView(ChangeOrderViewControllerService controller){
		this.controller = controller;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		initChangeOrderScene();
		
		initButtons();
		
		this.validate();
	}
	
	public void initChangeOrderScene(){
//		JScrollPane scrollPane = new JScrollPane();
//		
//		//表头
//		Vector<String> vColumns = new Vector<String>();
//		vColumns.add("订单编号");
//		vColumns.add("订单名称");
//		
//		//数据
//		Vector<PromotionVo> vData = new Vector<OrderVo>();
//		vData.addAll();
//		//模型
//		orderListModel = new DefaultTableModel(vData,vColumns);
//		//表格
//		orderTable = new JTable(orderListModel){
//			private static final long serialVersionUID = 1L;
//					
//			public boolean isCellEditable(int row,int column){
//				return false;
//			}
//		};
//		orderTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//				
//		scrollPane.getViewport().add(orderTable);
//		orderTable.setFillsViewportHeight(true);
//		this.add(scrollPane);	
	}
	
	public void initButtons(){
		changeButton = new JButton("更改状态");
		changeButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		
		returnButton = new JButton("返回");
		returnButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(changeButton);
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel2.add(returnButton);
		panel3.setLayout(new GridLayout(1,2));
		panel3.add(panel1);
		panel3.add(panel2);
		changeButton.setEnabled(true);
		returnButton.setEnabled(true);
		
		this.add(panel3);
	}

}
