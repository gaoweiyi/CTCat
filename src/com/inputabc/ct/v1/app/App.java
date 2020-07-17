package com.inputabc.ct.v1.app;

import javax.swing.JOptionPane;

import com.inputabc.ct.v1.context.ContextParams;
import com.inputabc.ct.v1.listener.SystemClipboardListener;
import com.inputabc.ct.v1.ui.TextBox;
import com.inputabc.ct.v1.util.MessageBox;
/**
 * CT猫
 * （剪切板内容翻译工具）
 * @author gaoweiyi
 * @version 1.8.0
 * @date 2020-07-17
 */
public class App {

	public static void main(String[] args) {
		try {
			SystemClipboardListener systemClipboardListener = new SystemClipboardListener();//给剪切板注册监听器
			ContextParams.contextParam.put("systemClipboardListener", systemClipboardListener);
			//EzGUI.debug(new TextBox());
			new TextBox();
		} catch (Exception e) {
			e.printStackTrace();
			MessageBox.alert(e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
		}
	}
}
