package cn.edu.zucc.uvtp.ui.susers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;

import cn.edu.zucc.uvtp.control.SysUsersManager;
import cn.edu.zucc.uvtp.model.SystemUsers;
import cn.edu.zucc.uvtp.ui.diyclass.ImageButton;
import cn.edu.zucc.uvtp.util.BaseException;

import cn.edu.zucc.uvtp.control.SysUsersManager;
import cn.edu.zucc.uvtp.ui.diyclass.ImageButton;
import cn.edu.zucc.uvtp.util.BaseException;

public class FrmSuModifypwd extends JDialog implements ActionListener {
	private String suname1 = "";
	private JPanel pd_main = new JPanel();
  	private JPanel pd_T = new JPanel();
	private JPanel pd_w = new JPanel();
	private JPanel pd_t = new JPanel();
	
	private JPasswordField t_n = new JPasswordField(11);
	private JPasswordField t_p = new JPasswordField(11);
	private JPasswordField t_p2 = new JPasswordField(11);
	
	private ImageButton b_OK = new ImageButton(new ImageIcon("Image/O1.png"));
	private ImageButton b_Cancel = new ImageButton(new ImageIcon("Image/X1.png"));
	
	public FrmSuModifypwd(JFrame x, String s, boolean b,String suname) {
		super(x,s,b);
		
		this.setResizable(false);																	//禁止修改窗口大小
		this.setUndecorated(true);																	//取消顶部栏
		this.setSize(400, 400);
		
		suname1 = suname;
		//------------------------屏幕居中显示-------------------------------------------------
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,(int) (height - this.getHeight()) / 2);
		//------------------------鼠标事件:拖拽标题栏------------------------------------------
		/*MouseEventListener mouseListener = new MouseEventListener(this,this.pd_main);
	    this.pd_main.addMouseListener(mouseListener);
	    this.pd_main.addMouseMotionListener(mouseListener);*/
	  	//------------------------主界面------------------------------------------------------
	  	FlowLayout f = new FlowLayout(FlowLayout.CENTER);
	  	f.setHgap(0);
	  	f.setVgap(20);
	  	pd_main.setLayout(f);
	  	pd_main.setBackground(new Color(54,54,54));
	  	//------------------------输入栏------------------------------------------------------
	  	JLabel l_t = new JLabel (suname+"用户修改密码");
	  	JLabel l_n = new JLabel ("旧密码");
	  	JLabel l_p = new JLabel ("新密码");
	  	JLabel l_p2 = new JLabel("重复密码");

	  	JPanel t_1 = new JPanel();
	  	JPanel t_2 = new JPanel();
	  	JPanel t_3 = new JPanel();
	  	
	  	Font font = new Font("微软雅黑",Font.BOLD,32);
	  	l_t.setForeground(new Color(105,105,105));
	  	l_t.setFont(font);
	  	pd_T.setOpaque(false);
	  	pd_T.setPreferredSize(new Dimension(400,60));
	  	pd_T.add(l_t,new BorderLayout().CENTER);
	  	
	  	f = new FlowLayout(FlowLayout.CENTER);
	  	f.setHgap(0);
	  	f.setVgap(20);
	  	pd_w.setLayout(f);
	  	pd_w.setOpaque(false);
	  	pd_w.setPreferredSize(new Dimension(this.getWidth(),200));
	  	
	  	f = new FlowLayout(FlowLayout.CENTER);
	  	f.setHgap(0);
	  	f.setVgap(0);
	  	t_1.setLayout(f);
	  	t_1.setOpaque(false);
	  	t_1.setPreferredSize(new Dimension(110,40));
	  	t_1.setBorder(BorderFactory.createLineBorder(new Color(28,28,28),3));
	  	t_2.setLayout(f);
	  	t_2.setOpaque(false);
	  	t_2.setPreferredSize(new Dimension(110,40));
	  	t_2.setBorder(BorderFactory.createLineBorder(new Color(28,28,28),3));
	  	t_3.setLayout(f);
	  	t_3.setOpaque(false);
	  	t_3.setPreferredSize(new Dimension(110,40));
	  	t_3.setBorder(BorderFactory.createLineBorder(new Color(28,28,28),3));
	  	
	  	font = new Font("微软雅黑",Font.PLAIN,20);
	  	l_n.setForeground(new Color(105,105,105));
	  	l_n.setFont(font);
	  	l_p.setForeground(new Color(105,105,105));
	  	l_p.setFont(font);
	  	l_p2.setForeground(new Color(105,105,105));
	  	l_p2.setFont(font);
	  	
	  	t_1.add(l_n);
	  	t_2.add(l_p);
	  	t_3.add(l_p2);
	  	
	  	font = new Font("等线",Font.PLAIN,24);
	  	t_n.setPreferredSize(new Dimension(300,40));
	  	t_n.setOpaque(false);
	  	t_n.setForeground(new Color(105,105,105));
	  	t_n.setBorder(BorderFactory.createLineBorder(new Color(28,28,28),3));
	  	t_n.setCaretColor(new Color(105,105,105));
	  	t_n.setFont(font);
	  	
	  	t_p.setPreferredSize(new Dimension(300,40));
	  	t_p.setOpaque(false);
	  	t_p.setForeground(new Color(105,105,105));
	  	t_p.setBorder(BorderFactory.createLineBorder(new Color(28,28,28),3));
	  	t_p.setCaretColor(new Color(105,105,105));
	  	t_p.setFont(font);

	  	t_p2.setPreferredSize(new Dimension(300,40));
	  	t_p2.setOpaque(false);
	  	t_p2.setForeground(new Color(105,105,105));
	  	t_p2.setBorder(BorderFactory.createLineBorder(new Color(28,28,28),3));
	  	t_p2.setCaretColor(new Color(105,105,105));
	  	t_p2.setFont(font);
	  	
	  	pd_w.add(t_1);	pd_w.add(t_n);
	  	pd_w.add(t_2);	pd_w.add(t_p);
	  	pd_w.add(t_3);	pd_w.add(t_p2);
	  	//-------------------------------------------------------------------------------------
	  	f = new FlowLayout();
	  	f.setHgap(80);
	  	f.setVgap(0);
	  	pd_t.setLayout(f);
	  	pd_t.setOpaque(false);
	  	pd_t.setPreferredSize(new Dimension(400,40));
	  	pd_t.add(b_OK);
	  	pd_t.add(b_Cancel);
	  	b_OK.setRolloverIcon(new ImageIcon("Image/O2.png"));
	  	b_OK.setPressedIcon(new ImageIcon("Image/O2.png"));
	  	b_Cancel.setRolloverIcon(new ImageIcon("Image/X2.png"));
	  	b_Cancel.setPressedIcon(new ImageIcon("Image/X2.png"));
	  	b_OK.addActionListener(this);
	  	b_Cancel.addActionListener(this);
	  	//-------------------------------------------------------------------------------------
	  	pd_main.add(pd_T);
	  	pd_main.add(pd_w);
	  	pd_main.add(pd_t);
	  	this.getContentPane().add(pd_main,new BorderLayout().CENTER);
	  	this.validate();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.b_Cancel){
			this.setVisible(false);
			return;
		}
		else if(e.getSource() == this.b_OK){
			String supwd = new String(this.t_n.getPassword());
			String supwd1 = new String(this.t_p.getPassword());
			String supwd2 = new String(this.t_p2.getPassword());
			try {
				new SysUsersManager().modifyPwd(this.suname1,supwd, supwd1, supwd2);
				this.setVisible(false);
				return;
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
	}
}
