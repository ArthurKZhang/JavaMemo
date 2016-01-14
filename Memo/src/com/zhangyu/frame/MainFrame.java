package com.zhangyu.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.zhangyu.util.WindowUtil;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7210628130943804979L;
	private JPanel contentPane;

	public static void main(String[] str){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainFrame() {
		setTitle("备忘录模块");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu memoManagementMenu = new JMenu("备忘录管理");
		memoManagementMenu.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		menuBar.add(memoManagementMenu);

		JMenu toolMenu = new JMenu("小工具");
		toolMenu.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		menuBar.add(toolMenu);

		JMenuItem addMemoMenuItem = new JMenuItem("增加备忘录");
		addMemoMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				do_addMemoMenuItem_actionPerformed(e);
			}
		});
		addMemoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		memoManagementMenu.add(addMemoMenuItem);

		JMenuItem modifyMemoMenuItem = new JMenuItem("修改备忘录");
		modifyMemoMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				do_modifyMemoMenuItem_actionPerformed(e);
			}
		});
		modifyMemoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		memoManagementMenu.add(modifyMemoMenuItem);

		JMenuItem queryMemoMenuItem = new JMenuItem("查询备忘录");
		queryMemoMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_queryMemoMenuItem_actionPerformed(e);
			}
		});
		queryMemoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		memoManagementMenu.add(queryMemoMenuItem);

		JMenuItem deleteMemoMenuItem = new JMenuItem("删除备忘录");
		deleteMemoMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_deleteMemoMenuItem_actionPerformed(e);
			}
		});
		deleteMemoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		memoManagementMenu.add(deleteMemoMenuItem);

		JMenuItem notePadMenuItem = new JMenuItem("记事本");
		notePadMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_notePadMemoMenuItem_actionPerformed(e);
			}
		});
		notePadMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		toolMenu.add(notePadMenuItem);

		JMenuItem caculatorMenuItem = new JMenuItem("计算器");
		caculatorMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_caculatorMemoMenuItem_actionPerformed(e);
			}
		});
		caculatorMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		toolMenu.add(caculatorMenuItem);

		// 粘贴的代码
		contentPane = new JPanel() {

			//private static final long serialVersionUID = 2179076594345705736L;

			/**
			 * 
			 */
			private static final long serialVersionUID = 6376953736851215048L;

			@Override
			public void paint(Graphics g) {
				super.paint(g);// 调用父类构造方法
				Graphics2D g2 = (Graphics2D) g;// 获得Graphics2D对象
				String str = "备忘录模块";// 设置要显示的字符串
				Font font = new Font("隶书", Font.BOLD | Font.ITALIC, 40);// 创建新字体
				g2.setFont(font);// 应用字体
				for (int i = 0; i < str.length(); i++) {
					g2.setColor(Color.GRAY); // 设置前景色
					g2.drawString(str.charAt(i) + "", 50 + i * font.getSize(),
							50 + i * font.getSize()); // 在指定位置绘制文本
					g2.drawString(str.charAt(i) + "", 370 - i * font.getSize(),
							50 + i * font.getSize()); // 在指定位置绘制文本
				}
				for (int i = 0; i < str.length(); i++) {
					g2.setColor(Color.MAGENTA); // 设置前景色
					g2.drawString(str.charAt(i) + "", 40 + i * font.getSize(),
							40 + i * font.getSize()); // 在指定位置绘制文本
					g2.drawString(str.charAt(i) + "", 360 - i * font.getSize(),
							40 + i * font.getSize()); // 在指定位置绘制文本
				}
			}
		};
		setContentPane(contentPane);
		
		setLocation(WindowUtil.getLocation());
		setSize(WindowUtil.getSize());
	}

	protected void do_caculatorMemoMenuItem_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Runtime runTime = Runtime.getRuntime();
		try {
			runTime.exec("calc");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	protected void do_notePadMemoMenuItem_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Runtime runTime = Runtime.getRuntime();
		try {
			runTime.exec("notepad");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	protected void do_deleteMemoMenuItem_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				MemoDeletionFrame frame = new MemoDeletionFrame();
				frame.setVisible(true);
			}
		});
	}

	protected void do_queryMemoMenuItem_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					MemoQueryFrame frame = new MemoQueryFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	protected void do_modifyMemoMenuItem_actionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					MemoModificationFrame frame = new MemoModificationFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	protected void do_addMemoMenuItem_actionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemoAdditionFrame frame = new MemoAdditionFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
