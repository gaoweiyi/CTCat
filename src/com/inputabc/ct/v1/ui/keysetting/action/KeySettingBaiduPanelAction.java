package com.inputabc.ct.v1.ui.keysetting.action;

import javax.swing.JButton;

import com.inputabc.EzGUIFramework.util.alias.Ez;
import com.inputabc.ct.v1.ui.keysetting.component.KeySettingBaiduPanel;
import com.inputabc.ct.v1.ui.keysetting.component.KeySettingControlPanel;
/**
 * 
 * @author gaoweiyi
 *
 */
public class KeySettingBaiduPanelAction {
	private KeySettingBaiduPanel keySettingBaiduPanel;
	public KeySettingBaiduPanelAction(KeySettingBaiduPanel keySettingBaiduPanel) {
		this.keySettingBaiduPanel = keySettingBaiduPanel;
	}
	public void textFieldChange() {
		KeySettingControlPanel keySettingControlPanel = (KeySettingControlPanel) Ez.getComponentWithCrossParentByNameEqual(keySettingBaiduPanel, KeySettingControlPanel.class.getName());
		JButton applyButton = keySettingControlPanel.getApplyButton();
		applyButton.setEnabled(true);
	}
}
