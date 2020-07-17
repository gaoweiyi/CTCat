package com.inputabc.ct.v1.ui.keysetting;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.inputabc.ct.v1.context.ContextParams;
import com.inputabc.ct.v1.ui.keysetting.action.KeySettingBaiduPanelAction;
import com.inputabc.ct.v1.ui.keysetting.action.KeySettingYoudaoPanelAction;

public class KeySettingBaiduPanel extends JPanel {
	private JLabel appIdLabel;
	private JTextField appIdTextField;
	private JLabel securityKeyLabel;
	private JTextField securityKeyTextField;
	private Map<Object, Object> contextParam = ContextParams.contextParam;
	{
		setName(this.getClass().getName());
		appIdLabel = new JLabel("app_id");
		appIdTextField = new JTextField();
		appIdTextField.setName(this.getClass().getName()+"-appIdTextField");
		securityKeyLabel = new JLabel("security_key");
		securityKeyTextField = new JTextField();
		securityKeyTextField.setName(this.getClass().getName()+"-securityKeyTextField");
	}

	public KeySettingBaiduPanel() {
		setBackground(Color.white);
		setLayout(new FlowLayout());
		add(appIdLabel);
		add(appIdTextField);
		add(securityKeyLabel);
		add(securityKeyTextField);
		appIdTextField.setColumns(46);
		securityKeyTextField.setColumns(40);
		String baiduAppId = (String) contextParam.get("baiduAppId");
		String baiduSecurityKey = (String) contextParam.get("baiduSecurityKey");
		appIdTextField.setText(baiduAppId);
		securityKeyTextField.setText(baiduSecurityKey);
		
		final KeySettingBaiduPanelAction keySettingBaiduPanelAction = new KeySettingBaiduPanelAction(this);
		DocumentListener documentListener = new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				keySettingBaiduPanelAction.textFieldChange();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				keySettingBaiduPanelAction.textFieldChange();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				keySettingBaiduPanelAction.textFieldChange();
			}
		};
		appIdTextField.getDocument().addDocumentListener(documentListener);
		securityKeyTextField.getDocument().addDocumentListener(documentListener);
	}

	public JLabel getAppIdLabel() {
		return appIdLabel;
	}

	public void setAppIdLabel(JLabel appIdLabel) {
		this.appIdLabel = appIdLabel;
	}

	public JTextField getAppIdTextField() {
		return appIdTextField;
	}

	public void setAppIdTextField(JTextField appIdTextField) {
		this.appIdTextField = appIdTextField;
	}

	public JLabel getSecurityKeyLabel() {
		return securityKeyLabel;
	}

	public void setSecurityKeyLabel(JLabel securityKeyLabel) {
		this.securityKeyLabel = securityKeyLabel;
	}

	public JTextField getSecurityKeyTextField() {
		return securityKeyTextField;
	}

	public void setSecurityKeyTextField(JTextField securityKeyTextField) {
		this.securityKeyTextField = securityKeyTextField;
	}

}
