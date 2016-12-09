package promotion.view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import promotion.controller.CreditChangeViewControllerImpl;
import service.CreditService;
import service.impl.CreditServiceImpl;

public class CreditChangeView extends JPanel{
	
	public static void main(String args[]){
		JFrame creditFrame = new JFrame();
		creditFrame.setSize(800, 600);
		creditFrame.setLocation(300, 100);
		creditFrame.setTitle("恢复信用值");
		CreditChangeViewControllerService controller = new CreditChangeViewControllerImpl();
		CreditChangeView view = new CreditChangeView(controller);
		controller.setView(view);
		creditFrame.getContentPane().add(view);
		creditFrame.setVisible(true);
	}
	
	private CreditChangeViewControllerService controller;
	
	private JLabel creditLabel1,creditLabel2;
	
	private JTextField creditTextField1,creditTextField2;
	
	private JButton confirmButton;
	
	private JButton cancleButton;
	
	public CreditChangeView(CreditChangeViewControllerService controller){
		this.controller = controller;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//初始化操作按钮
		initCreditScene();
				
		this.validate();
	}
	
	private void initCreditScene(){
		
		creditLabel1 = new JLabel("请输入ID");
		creditLabel1.setFont(new Font("宋体",Font.BOLD,20));
		creditTextField1 = new JTextField(20);
		creditTextField1.setFont(new Font("宋体",Font.BOLD,20));
		creditLabel2 = new JLabel("需恢复的信用值");
		creditLabel2.setFont(new Font("宋体",Font.BOLD,20));
		creditTextField2 = new JTextField(20);
		creditTextField2.setFont(new Font("宋体",Font.BOLD,20));
		
		confirmButton = new JButton("确认");
		confirmButton.setFont(new Font("宋体",Font.BOLD,20));
		//设置监听事件
		confirmButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				//事件处理
				controller.confirmButtonClicked();
			}
		});
		
		cancleButton = new JButton("返回");
		cancleButton.setFont(new Font("宋体",Font.BOLD,20));
		//设置监听事件
		cancleButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		creditLabel1.setBounds(200,100,100,100);
		creditTextField1.setBounds(350, 130, 300, 38);
		creditLabel2.setBounds(180,200,150,100);
		creditTextField2.setBounds(350,230,300,38);
		confirmButton.setBounds(150, 400, 150, 40);
		cancleButton.setBounds(420, 400, 150, 40);
		panel.add(creditLabel1);
		panel.add(creditTextField1);
		panel.add(creditLabel2);
		panel.add(creditTextField2);
		panel.add(confirmButton);
		panel.add(cancleButton);
		
		
		confirmButton.setEnabled(true);
		cancleButton.setEnabled(true);
		
		this.add(panel);
		
	}
	
	public void confirmButtonClicked(){
		int id = Integer.valueOf(creditTextField1.getText());
		int credit = Integer.valueOf(creditTextField2.getText());
		CreditService creditService = new CreditServiceImpl();
		if(creditService.recoverCredit(id, credit)){
			JOptionPane.showMessageDialog(null,"信用恢复成功","",JOptionPane.ERROR_MESSAGE);
		}
		else{
			JOptionPane.showMessageDialog(null,"信用恢复失败","",JOptionPane.ERROR_MESSAGE);
		}
	}

}
