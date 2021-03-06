package cn.edu.zucc.uvtp.ui.users;

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

import cn.edu.zucc.uvtp.control.UsersManager;
import cn.edu.zucc.uvtp.ui.diyclass.ImageButton;
import cn.edu.zucc.uvtp.ui.susers.FrmSuMain;
import cn.edu.zucc.uvtp.util.BaseException;

public class FrmURegister extends JDialog implements ActionListener {
	//private JPanel pu_main = new JPanel();														//顶部容器：欢迎，搜索，缩小，关闭
	//private ImageButton b_close = new ImageButton(new  ImageIcon("Image/Button_Close_1.png"));
	private JPanel pd_main = new JPanel();
  	private JPanel pd_T = new JPanel();
	private JPanel pd_w = new JPanel();
	private JPanel pd_t = new JPanel();
	
	private JTextField t_n = new JTextField(11);
	private JPasswordField t_p = new JPasswordField(11);
	private JPasswordField t_p2 = new JPasswordField(11);
	private JTextField t_c = new JTextField(11);
	
	private ImageButton b_OK = new ImageButton(new ImageIcon("Image/O1.png"));
	private ImageButton b_Cancel = new ImageButton(new ImageIcon("Image/X1.png"));
	
	public FrmURegister(JFrame x, String s, boolean b) {
		super(x,s,b);
		this.setResizable(false);																	//禁止修改窗口大小
		this.setUndecorated(true);																	//取消顶部栏
		this.setSize(400, 460);
		//------------------------屏幕居中显示-------------------------------------------------
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,(int) (height - this.getHeight()) / 2);
		//------------------------鼠标事件:拖拽标题栏------------------------------------------
		/*MouseEventListene mouseListener = new MouseEventListene(this,this.pd_main);
	    this.pd_main.addMouseListener(mouseListener);
	    this.pd_main.addMouseMotionListener(mouseListener);*/
	  	//------------------------主界面------------------------------------------------------
	  	FlowLayout f = new FlowLayout(FlowLayout.CENTER);
	  	f.setHgap(0);
	  	f.setVgap(20);
	  	pd_main.setLayout(f);
	  	pd_main.setBackground(new Color(54,54,54));
	  	//------------------------输入栏------------------------------------------------------
	  	JLabel l_t = new JLabel ("注册");
	  	JLabel l_n = new JLabel ("用户名");
	  	JLabel l_p = new JLabel ("密码");
	  	JLabel l_p2 = new JLabel ("重复密码");
	  	JLabel l_c = new JLabel ("手机号");
	  	
	  	JPanel t_1 = new JPanel();
	  	JPanel t_2 = new JPanel();
	  	JPanel t_3 = new JPanel();
	  	JPanel t_4 = new JPanel();
	  	
	  	Font font = new Font("微软雅黑",Font.BOLD,48);
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
	  	pd_w.setPreferredSize(new Dimension(this.getWidth(),260));
	  	
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
	  	t_4.setLayout(f);
	  	t_4.setOpaque(false);
	  	t_4.setPreferredSize(new Dimension(110,40));
	  	t_4.setBorder(BorderFactory.createLineBorder(new Color(28,28,28),3));
	  	
	  	font = new Font("微软雅黑",Font.PLAIN,20);
	  	l_n.setForeground(new Color(105,105,105));
	  	l_n.setFont(font);
	  	l_p.setForeground(new Color(105,105,105));
	  	l_p.setFont(font);
	  	l_p2.setForeground(new Color(105,105,105));
	  	l_p2.setFont(font);
	  	l_c.setForeground(new Color(105,105,105));
	  	l_c.setFont(font);
	  	
	  	t_1.add(l_n);
	  	t_2.add(l_p);
	  	t_3.add(l_p2);
	  	t_4.add(l_c);
	  	
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
	  	
	  	t_c.setPreferredSize(new Dimension(300,40));
	  	t_c.setOpaque(false);
	  	t_c.setForeground(new Color(105,105,105));
	  	t_c.setBorder(BorderFactory.createLineBorder(new Color(28,28,28),3));
	  	t_c.setCaretColor(new Color(105,105,105));
	  	t_c.setFont(font);
	  	
	  	
	  	pd_w.add(t_1);	pd_w.add(t_n);
	  	pd_w.add(t_2);	pd_w.add(t_p);
	  	pd_w.add(t_3);	pd_w.add(t_p2);
	  	pd_w.add(t_4);  pd_w.add(t_c);
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
			new FrmLogin();
		}
		else if(e.getSource() == this.b_OK){
			String suname = this.t_n.getText();
			String supwd1 = new String(this.t_p.getPassword());
			String supwd2 = new String(this.t_p2.getPassword());
			String call = this.t_c.getText();
			try {
				(new UsersManager()).create(suname,supwd1,supwd2,call);
				new FrmUMain();
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
	}
}
class MouseEventListene implements MouseInputListener {
	Point origin;
	 //鼠标拖拽想要移动的目标组件
	JPanel p = new JPanel();
	JFrame frm;
	public MouseEventListene(JFrame Frm,JPanel p) {
		this.p = p;
	    this.frm = Frm;
	    origin = new Point();
	}
	
	@Override
    public void mouseClicked(MouseEvent e) {}
 
    /**
    * 记录鼠标按下时的点
    */
    @Override
    public void mousePressed(MouseEvent e) {
    	origin.x = e.getX(); 
        origin.y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}
 
     /**
     * 鼠标移进标题栏时，设置鼠标图标为移动图标
     */
     @Override
     public void mouseEntered(MouseEvent e) {
       //this.p.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
     }
     
     /**
     * 鼠标移出标题栏时，设置鼠标图标为默认指针
     */
     @Override
     public void mouseExited(MouseEvent e) {
       //this.p.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
     }
 
     /**
     * 鼠标在标题栏拖拽时，设置窗口的坐标位置
     * 窗口新的坐标位置 = 移动前坐标位置+（鼠标指针当前坐标-鼠标按下时指针的位置）
     */
     @Override
     public void mouseDragged(MouseEvent e) {
    	Point f = this.frm.getLocation();
    	Point p = this.p.getLocation();
    	this.frm.setLocation(
    			f.x + (e.getX() - origin.x), 
    			f.y + (e.getY() - origin.y)); 
     }
 
     @Override
     public void mouseMoved(MouseEvent e) {}
}