package com.inputabc.ct.v1.ui.keysetting;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class KeySettingMainPanel extends JPanel{
	private KeySettingYoudaoPanel keySettingYoudaoPanel;
	private KeySettingBaiduPanel keySettingBaiduPanel;
	private KeySettingControlPanel keySettingControlPanel;
	{
		setName(this.getClass().getName());
		keySettingYoudaoPanel = new KeySettingYoudaoPanel();
		keySettingBaiduPanel = new KeySettingBaiduPanel();
		keySettingControlPanel = new KeySettingControlPanel();
	}
	public KeySettingMainPanel() {
		setBackground(Color.white);
		setLayout(new GridLayout(3,1));
		keySettingYoudaoPanel.setBorder(BorderFactory.createTitledBorder("有道翻译"));
		keySettingBaiduPanel.setBorder(BorderFactory.createTitledBorder("百度翻译"));
		add(keySettingYoudaoPanel);
		add(keySettingBaiduPanel);
		add(keySettingControlPanel);
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

	public KeySettingControlPanel getKeySettingControlPanel() {
		return keySettingControlPanel;
	}

	public void setKeySettingControlPanel(KeySettingControlPanel keySettingControlPanel) {
		this.keySettingControlPanel = keySettingControlPanel;
	}

	
	
}
