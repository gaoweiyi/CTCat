package com.inputabc.ct.v1.app;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.SystemUtils;

import com.inputabc.EzGUIFramework.util.alias.Ez;
import com.inputabc.ct.v1.context.ContextParams;
import com.inputabc.ct.v1.listener.SystemClipboardListener;
import com.inputabc.ct.v1.ui.TextBox;
import com.inputabc.ct.v1.util.MessageBox;
import com.inputabc.ct.v1.util.PFileUtils;

/**
 * CT猫 （剪切板内容翻译工具）
 * 
 * @author gaoweiyi
 * @version 1.8.2
 * @date 2020-07-22
 */
public class App {
	static {
		// 1.8.2
		if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_UNIX || SystemUtils.IS_OS_OPEN_BSD || SystemUtils.IS_OS_MAC) {
			boolean runAsRootForUnix = PFileUtils.isRunAsRootForUnix();
			if (runAsRootForUnix == false) {
				Ez.setTheme(Ez.THEME_OS_DEFAULT);
				Ez.messager.alert("必须以root用户运行！", "错误", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
		////
	}

	public static void main(String[] args) {
		try {
			SystemClipboardListener systemClipboardListener = new SystemClipboardListener();// 给剪切板注册监听器
			ContextParams.contextParam.put("systemClipboardListener", systemClipboardListener);
			// EzGUI.debug(new TextBox());
			new TextBox();
		} catch (Exception e) {
			e.printStackTrace();
			MessageBox.alert(e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
		}
	}
}
