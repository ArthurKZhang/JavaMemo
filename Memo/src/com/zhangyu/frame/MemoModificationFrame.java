package com.zhangyu.frame;

import java.awt.BorderLayout;
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

public class MemoModificationFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7659407649973249815L;
	private List<MemoBean> results;
	private int index;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField memotypeTextField;
	private JTextField memotimeTextField;
	private JTextField titleTextField;
	private JTextArea contentTextArea;

	public MemoModificationFrame() {
		setTitle("增加备忘录");
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

		JButton previousButton = new JButton("previous one");
		previousButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_previousButton_actionPerformed(e);
			}
		});
		previousButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
		buttonPanel.add(previousButton);// 应用按钮

		JButton nextButton = new JButton("next one");
		nextButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_nextButton_actionPerformed(e);
			}
		});
		nextButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
		buttonPanel.add(nextButton);// 应用按钮

		JButton saveButton = new JButton("save");
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_saveButton_actionPerformed(e);
			}
		});
		saveButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
		buttonPanel.add(saveButton);// 应用按钮

		JButton cleanButton = new JButton("clean");
		cleanButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_cleanButton_actionPerformed(e);
			}
		});
		cleanButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
		buttonPanel.add(cleanButton);// 应用按钮

		JButton backButton = new JButton("back");
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

		results = JdbcHelper.queryAll();
		updateContent(index);
	}
	
	protected void do_previousButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(index <= 0){
			JOptionPane.showMessageDialog(this, "this is the first one!", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
		updateContent(--index);
	}

	protected void do_nextButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(index);
		//System.out.println(results.size()-1);
		if(index >= (results.size()-1)){
			JOptionPane.showMessageDialog(this, "this is the last one!", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
		updateContent(++index);
	}

	private void updateContent(int index){
		MemoBean memo = results.get(index);
		usernameTextField.setText(memo.getUserName());
		memotypeTextField.setText(memo.getMemoType());
		memotimeTextField.setText(memo.getMemoTime());
		titleTextField.setText(memo.getTitle());
		contentTextArea.setText(memo.getContent());
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

	protected void do_saveButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String username = usernameTextField.getText().trim();
		if (username.isEmpty()) {
			JOptionPane.showMessageDialog(this, "name space cannot be empty!",
					"", JOptionPane.WARNING_MESSAGE);
			return;
		}

		String memotype = memotypeTextField.getText().trim();
		if (memotype.isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"memotype space cannot be empty!", "",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		String memotime = memotimeTextField.getText().trim();
		if (memotime.isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"memotime space cannot be empty!", "",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		String title = titleTextField.getText().trim();
		if (title.isEmpty()) {
			JOptionPane.showMessageDialog(this, "title space cannot be empty!",
					"", JOptionPane.WARNING_MESSAGE);
			return;
		}

		String content = contentTextArea.getText().trim();
		if (content.isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"content space cannot be empty!", "",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		// 检验日期格式代码在此
		MemoBean memo = results.get(index);
		memo.setContent(content);
		memo.setMemoTime(memotime);
		memo.setMemoType(memotype);
		memo.setTitle(title);
		memo.setUserName(username);

		int result = JdbcHelper.update(memo);
		if (result >= 0) {
			JOptionPane.showMessageDialog(this, "备忘录添加成功！");
			dispose();
			return;
		} else {
			JOptionPane.showMessageDialog(this, "备忘录添加失败！");
			return;
		}
	}
}