package com.inputabc.ct.v1.ui.keysetting.action;

import javax.swing.JButton;

import com.inputabc.EzGUIFramework.util.alias.Ez;
import com.inputabc.ct.v1.ui.keysetting.KeySettingControlPanel;
import com.inputabc.ct.v1.ui.keysetting.KeySettingYoudaoPanel;

public class KeySettingYoudaoPanelAction {
	private KeySettingYoudaoPanel keySettingYoudaoPanel;
	public KeySettingYoudaoPanelAction(KeySettingYoudaoPanel keySettingYoudaoPanel) {
		this.keySettingYoudaoPanel = keySettingYoudaoPanel;
	}
	public void textFieldChange() {
		KeySettingControlPanel keySettingControlPanel = (KeySettingControlPanel) Ez.getComponentWithCrossParentByNameEqual(keySettingYoudaoPanel, KeySettingControlPanel.class.getName());
		JButton applyButton = keySettingControlPanel.getApplyButton();
		applyButton.setEnabled(true);
	}
}
