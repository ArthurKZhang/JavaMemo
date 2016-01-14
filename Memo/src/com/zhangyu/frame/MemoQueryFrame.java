package com.zhangyu.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import com.zhangyu.bean.MemoBean;
import com.zhangyu.dao.JdbcHelper;
import com.zhangyu.util.WindowUtil;

public class MemoQueryFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6527450217430594638L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField memotypeTextField;
	private JTextField memotimeTextField;
	private JTextField titleTextField;
	private JTextArea contentTextArea;

	public MemoQueryFrame() {
		setTitle("查询备忘录");
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel othersPanel = new JPanel();
		contentPane.add(othersPanel, BorderLayout.NORTH);
		othersPanel.setLayout(new GridLayout(2, 1, 5, 5));

		JPanel nttPanel = new JPanel();
		nttPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout fl_nttPanel = (FlowLayout) nttPanel.getLayout();
		fl_nttPanel.setAlignment(FlowLayout.LEFT);
		othersPanel.add(nttPanel);

		JLabel usernameLabel = new JLabel("姓名： ");
		usernameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		nttPanel.add(usernameLabel);

		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		nttPanel.add(usernameTextField);
		usernameTextField.setColumns(6);

		JLabel memotypeLabel = new JLabel("类型： ");
		memotypeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		nttPanel.add(memotypeLabel);

		memotypeTextField = new JTextField();
		memotypeTextField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		nttPanel.add(memotypeTextField);
		memotypeTextField.setColumns(6);

		JLabel memotimeLabel = new JLabel("时间： ");
		memotimeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		nttPanel.add(memotimeLabel);

		memotimeTextField = new JTextField();
		memotimeTextField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		nttPanel.add(memotimeTextField);
		memotimeTextField.setColumns(6);

		JPanel titlePanel = new JPanel();// 创建面板
		titlePanel
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// 设置面板的边框
		FlowLayout fl_titlePanel = (FlowLayout) titlePanel.getLayout();// 获得面板布局
		fl_titlePanel.setAlignment(FlowLayout.LEFT);// 面板中控件采用左对齐
		othersPanel.add(titlePanel);// 应用面板

		JLabel titleLabel = new JLabel("主题：");// 创建标签
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
		titlePanel.add(titleLabel);// 应用标签

		titleTextField = new JTextField();// 创建文本域
		titleTextField.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
		titlePanel.add(titleTextField);// 应用文本域
		titleTextField.setColumns(28);// 设置文本域宽度

		JPanel contentPanel = new JPanel();// 创建面板
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null));// 设置面板的边框
		FlowLayout fl_contentPanel = (FlowLayout) contentPanel.getLayout();// 获得面板布局
		fl_contentPanel.setAlignment(FlowLayout.LEFT);// 面板中控件采用左对齐
		contentPane.add(contentPanel, BorderLayout.CENTER);// 应用面板

		JLabel contentLabel = new JLabel("内容：");// 创建标签
		contentLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
		contentPanel.add(contentLabel);// 应用标签

		contentTextArea = new JTextArea();// 创建文本区
		contentTextArea.setColumns(28);// 设置文本区列数
		contentTextArea.setLineWrap(true);// 设置文本区自动换行
		contentTextArea.setRows(5);// 设置文本区行数
		contentTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
		JScrollPane contentScrollPane = new JScrollPane(contentTextArea);// 使用文本区创建滚动窗格
		contentPanel.add(contentScrollPane);// 应用滚动窗格

		JPanel buttonPanel = new JPanel();// 创建面板
		buttonPanel
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// 设置面板的边框
		contentPane.add(buttonPanel, BorderLayout.SOUTH);// 应用面板

		JButton saveButton = new JButton("查询");
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_queryButton_actionPerformed(e);
			}
		});
		saveButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
		buttonPanel.add(saveButton);// 应用按钮

		JButton cleanButton = new JButton("清空");
		cleanButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_cleanButton_actionPerformed(e);
			}
		});
		cleanButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
		buttonPanel.add(cleanButton);// 应用按钮

		JButton backButton = new JButton("返回");
		backButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_backButton_actionPerformed(e);
			}
		});
		backButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
		buttonPanel.add(backButton);// 应用按钮

		setLocation(WindowUtil.getLocation());
		setSize(WindowUtil.getSize());

	}
	
	protected void do_cleanButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		usernameTextField.setText("");
		titleTextField.setText("");
		contentTextArea.setText("");
		memotypeTextField.setText("");
		memotimeTextField.setText("");
	}

	protected void do_backButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}

	protected void do_queryButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String username = usernameTextField.getText().trim();
		String memotype = memotypeTextField.getText().trim();
		String memotime = memotimeTextField.getText().trim();
		String title = titleTextField.getText().trim();
		String content = contentTextArea.getText().trim();
		
		if(username.isEmpty() && memotype.isEmpty() && memotime.isEmpty() && title.isEmpty() && content.isEmpty()){
			JOptionPane.showMessageDialog(this, "查询条件不能为空", "", JOptionPane.WARNING_MESSAGE);
		}
		
		
		// 检验日期格式代码在此
		
		MemoBean memo = new MemoBean();
		memo.setContent(content);
		memo.setMemoTime(memotime);
		memo.setMemoType(memotype);
		memo.setTitle(title);
		memo.setUserName(username);

		final List<MemoBean> results = JdbcHelper.query(memo);
		
		if (results.size() >= 0) {
			EventQueue.invokeLater(new Runnable() {
				
				public void run() {
					// TODO Auto-generated method stub
					try {
						MemoQueryResultsFrame frame = new MemoQueryResultsFrame(results);
						frame.setVisible(true);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "查询的记录不存在！");
			return;
		}
	}
}
