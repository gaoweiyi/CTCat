package com.inputabc.ct.v1.ui.keysetting.action;

import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.inputabc.EzGUIFramework.util.alias.Ez;
import com.inputabc.ct.v1.context.ContextParams;
import com.inputabc.ct.v1.ui.keysetting.KeySettingBuilder;
import com.inputabc.ct.v1.ui.keysetting.component.KeySettingBaiduPanel;
import com.inputabc.ct.v1.ui.keysetting.component.KeySettingControlPanel;
import com.inputabc.ct.v1.ui.keysetting.component.KeySettingFrame;
import com.inputabc.ct.v1.ui.keysetting.component.KeySettingYoudaoPanel;
import com.inputabc.ct.v1.util.KeyIOUtils;
/**
 * KeySettingControlPanel对象的事件处理类
 * @author gaoweiyi
 *
 */
public class KeySettingControlPanelAction {
	private KeySettingControlPanel keySettingControlPanel;
	private Map<Object, Object> contextParam = ContextParams.contextParam;
	public KeySettingControlPanelAction(KeySettingControlPanel keySettingControlPanel) {
		this.keySettingControlPanel = keySettingControlPanel;
	}

	public void clickApply(ActionEvent ae) {
		JTextField appKeyTextField = (JTextField) Ez.getComponentWithCrossParentByNameEqual(keySettingControlPanel, KeySettingYoudaoPanel.class.getName()+"-appKeyTextField");
		JTextField appSecretTextField = (JTextField) Ez.getComponentWithCrossParentByNameEqual(keySettingControlPanel, KeySettingYoudaoPanel.class.getName()+"-appSecretTextField");
		JTextField appIdTextField = (JTextField) Ez.getComponentWithCrossParentByNameEqual(keySettingControlPanel, KeySettingBaiduPanel.class.getName()+"-appIdTextField");
		JTextField securityKeyTextField = (JTextField) Ez.getComponentWithCrossParentByNameEqual(keySettingControlPanel, KeySettingBaiduPanel.class.getName()+"-securityKeyTextField");
		contextParam.put("youdaoAppKey", appKeyTextField.getText().trim());
		contextParam.put("youdaoAppSecret", appSecretTextField.getText().trim());
		contextParam.put("baiduAppId", appIdTextField.getText().trim());
		contextParam.put("baiduSecurityKey", securityKeyTextField.getText().trim());
		KeyIOUtils.store();//将密钥信息持久化到文件
		JButton applyButton = (JButton) ae.getSource();
		applyButton.setEnabled(false);
	}
	public void clickCancel() {
		KeySettingFrame keySettingFrame = (KeySettingFrame) Ez.getComponentWithCrossParentByNameEqual(keySettingControlPanel, KeySettingFrame.class.getName());
		keySettingFrame.dispose();
		KeySettingBuilder keySettingBuilder = (KeySettingBuilder) ContextParams.contextParam.get("keySettingBuilder");
		keySettingBuilder.destory();
	}
	public void clickOk(ActionEvent ae) {
		clickApply(ae);
		clickCancel();
	}

}
