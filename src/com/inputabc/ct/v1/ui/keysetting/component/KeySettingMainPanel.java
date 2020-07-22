package com.inputabc.ct.v1.ui.keysetting.component;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
/**
 * 
 * @author gaoweiyi
 *
 */
public class KeySettingMainPanel extends JPanel{
	private KeySettingKeyItemPanel keySettingKeyItemPanel;
	private KeySettingControlPanel keySettingControlPanel;
	{
		this.setName(this.getClass().getName());
		keySettingKeyItemPanel = new KeySettingKeyItemPanel();
		keySettingControlPanel = new KeySettingControlPanel();
	}
	public KeySettingMainPanel() {
		add(keySettingKeyItemPanel);
		add(keySettingControlPanel);
	}
	
	
	public KeySettingKeyItemPanel getKeySettingKeyItemPanel() {
		return keySettingKeyItemPanel;
	}


	public void setKeySettingKeyItemPanel(KeySettingKeyItemPanel keySettingKeyItemPanel) {
		this.keySettingKeyItemPanel = keySettingKeyItemPanel;
	}


	public KeySettingControlPanel getKeySettingControlPanel() {
		return keySettingControlPanel;
	}

	public void setKeySettingControlPanel(KeySettingControlPanel keySettingControlPanel) {
		this.keySettingControlPanel = keySettingControlPanel;
	}

	
	
}
