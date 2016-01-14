package com.zhangyu.util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

public class WindowUtil {
	//将窗口大小设置成500*309
	public static Dimension getSize(){
		return new Dimension(500, 309);
	}
	
	//计算窗体居中显示时左上角的坐标
	public static Point getLocation(){
		Toolkit tooKit = Toolkit.getDefaultToolkit();
		Dimension screenSize = tooKit.getScreenSize();
		if((screenSize.width < getSize().width) || (screenSize.height < getSize().height)){
			JOptionPane.showMessageDialog(null, "显示器分辨率应至少为500*309", "", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		int x = (screenSize.width - getSize().width)/2;
		int y = (screenSize.height - getSize().height)/2;
		return new Point(x, y);
	}
}
