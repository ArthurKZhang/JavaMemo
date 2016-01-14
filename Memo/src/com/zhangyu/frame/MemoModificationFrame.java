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
		setTitle("���ӱ���¼");
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

		JLabel usernameLabel = new JLabel("������ ");
		usernameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		nttPanel.add(usernameLabel);

		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		nttPanel.add(usernameTextField);
		usernameTextField.setColumns(6);

		JLabel memotypeLabel = new JLabel("���ͣ� ");
		memotypeLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		nttPanel.add(memotypeLabel);

		memotypeTextField = new JTextField();
		memotypeTextField.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		nttPanel.add(memotypeTextField);
		memotypeTextField.setColumns(6);

		JLabel memotimeLabel = new JLabel("ʱ�䣺 ");
		memotimeLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		nttPanel.add(memotimeLabel);

		memotimeTextField = new JTextField();
		memotimeTextField.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		nttPanel.add(memotimeTextField);
		memotimeTextField.setColumns(6);

		JPanel titlePanel = new JPanel();// �������
		titlePanel
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// �������ı߿�
		FlowLayout fl_titlePanel = (FlowLayout) titlePanel.getLayout();// �����岼��
		fl_titlePanel.setAlignment(FlowLayout.LEFT);// ����пؼ����������
		othersPanel.add(titlePanel);// Ӧ�����

		JLabel titleLabel = new JLabel("���⣺");// ������ǩ
		titleLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
		titlePanel.add(titleLabel);// Ӧ�ñ�ǩ

		titleTextField = new JTextField();// �����ı���
		titleTextField.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
		titlePanel.add(titleTextField);// Ӧ���ı���
		titleTextField.setColumns(28);// �����ı�����

		JPanel contentPanel = new JPanel();// �������
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null));// �������ı߿�
		FlowLayout fl_contentPanel = (FlowLayout) contentPanel.getLayout();// �����岼��
		fl_contentPanel.setAlignment(FlowLayout.LEFT);// ����пؼ����������
		contentPane.add(contentPanel, BorderLayout.CENTER);// Ӧ�����

		JLabel contentLabel = new JLabel("���ݣ�");// ������ǩ
		contentLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
		contentPanel.add(contentLabel);// Ӧ�ñ�ǩ

		contentTextArea = new JTextArea();// �����ı���
		contentTextArea.setColumns(28);// �����ı�������
		contentTextArea.setLineWrap(true);// �����ı����Զ�����
		contentTextArea.setRows(5);// �����ı�������
		contentTextArea.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
		JScrollPane contentScrollPane = new JScrollPane(contentTextArea);// ʹ���ı���������������
		contentPanel.add(contentScrollPane);// Ӧ�ù�������

		JPanel buttonPanel = new JPanel();// �������
		buttonPanel
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// �������ı߿�
		contentPane.add(buttonPanel, BorderLayout.SOUTH);// Ӧ�����

		JButton previousButton = new JButton("previous one");
		previousButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_previousButton_actionPerformed(e);
			}
		});
		previousButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
		buttonPanel.add(previousButton);// Ӧ�ð�ť

		JButton nextButton = new JButton("next one");
		nextButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_nextButton_actionPerformed(e);
			}
		});
		nextButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
		buttonPanel.add(nextButton);// Ӧ�ð�ť

		JButton saveButton = new JButton("save");
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_saveButton_actionPerformed(e);
			}
		});
		saveButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
		buttonPanel.add(saveButton);// Ӧ�ð�ť

		JButton cleanButton = new JButton("clean");
		cleanButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_cleanButton_actionPerformed(e);
			}
		});
		cleanButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
		buttonPanel.add(cleanButton);// Ӧ�ð�ť

		JButton backButton = new JButton("back");
		backButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_backButton_actionPerformed(e);
			}
		});
		backButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
		buttonPanel.add(backButton);// Ӧ�ð�ť

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
		// �������ڸ�ʽ�����ڴ�
		MemoBean memo = results.get(index);
		memo.setContent(content);
		memo.setMemoTime(memotime);
		memo.setMemoType(memotype);
		memo.setTitle(title);
		memo.setUserName(username);

		int result = JdbcHelper.update(memo);
		if (result >= 0) {
			JOptionPane.showMessageDialog(this, "����¼��ӳɹ���");
			dispose();
			return;
		} else {
			JOptionPane.showMessageDialog(this, "����¼���ʧ�ܣ�");
			return;
		}
	}
}