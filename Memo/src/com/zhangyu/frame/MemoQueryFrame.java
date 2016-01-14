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
		setTitle("��ѯ����¼");
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

		JButton saveButton = new JButton("��ѯ");
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_queryButton_actionPerformed(e);
			}
		});
		saveButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
		buttonPanel.add(saveButton);// Ӧ�ð�ť

		JButton cleanButton = new JButton("���");
		cleanButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_cleanButton_actionPerformed(e);
			}
		});
		cleanButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
		buttonPanel.add(cleanButton);// Ӧ�ð�ť

		JButton backButton = new JButton("����");
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
			JOptionPane.showMessageDialog(this, "��ѯ��������Ϊ��", "", JOptionPane.WARNING_MESSAGE);
		}
		
		
		// �������ڸ�ʽ�����ڴ�
		
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
			JOptionPane.showMessageDialog(this, "��ѯ�ļ�¼�����ڣ�");
			return;
		}
	}
}
