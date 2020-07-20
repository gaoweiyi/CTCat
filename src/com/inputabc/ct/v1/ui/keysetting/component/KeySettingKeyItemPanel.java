package com.inputabc.ct.v1.ui.keysetting.component;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class KeySettingKeyItemPanel extends JPanel {
	private KeySettingYoudaoPanel keySettingYoudaoPanel;
	private KeySettingBaiduPanel keySettingBaiduPanel;
	{
		setName(this.getClass().getName());
		keySettingYoudaoPanel = new KeySettingYoudaoPanel();
		keySettingBaiduPanel = new KeySettingBaiduPanel();
	}

	public KeySettingKeyItemPanel() {
		add(keySettingYoudaoPanel);
		add(keySettingBaiduPanel);
	}

	public KeySettingYoudaoPanel getKeySettingYoudaoPanel() {
		return keySettingYoudaoPanel;
	}

	public void setKeySettingYoudaoPanel(KeySettingYoudaoPanel keySettingYoudaoPanel) {
		this.keySettingYoudaoPanel = keySettingYoudaoPanel;
	}

	public KeySettingBaiduPanel getKeySettingBaiduPanel() {
		return keySettingBaiduPanel;
	}

	public void setKeySettingBaiduPanel(KeySettingBaiduPanel keySettingBaiduPanel) {
		this.keySettingBaiduPanel = keySettingBaiduPanel;
	}

}
