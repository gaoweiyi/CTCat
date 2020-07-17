package com.inputabc.ct.v1.ui.keysetting;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.inputabc.EzGUIFramework.listener.ListenerBinder;
import com.inputabc.EzGUIFramework.util.alias.Ez;
import com.inputabc.ct.v1.context.ContextParams;
import com.inputabc.ct.v1.ui.keysetting.action.KeySettingYoudaoPanelAction;

public class KeySettingYoudaoPanel extends JPanel {
	private JLabel appKeyLabel;
	private JTextField appKeyTextField;
	private JLabel appSecretLabel;
	private JTextField appSecretTextField;
	private Map<Object, Object> contextParam = ContextParams.contextParam;
	{
		setName(this.getClass().getName());
		appKeyLabel = new JLabel("app_key");
		appKeyTextField = new JTextField();
		appKeyTextField.setName(this.getClass().getName()+"-appKeyTextField");
		appSecretLabel = new JLabel("app_secret");
		appSecretTextField = new JTextField();
		appSecretTextField.setName(this.getClass().getName()+"-appSecretTextField");
	}

	public KeySettingYoudaoPanel() {
		setBackground(Color.white);
		setLayout(new FlowLayout());
		add(appKeyLabel);
		add(appKeyTextField);
		add(appSecretLabel);
		add(appSecretTextField);
		appKeyTextField.setColumns(45);
		appSecretTextField.setColumns(42);
		String youdaoAppKey = (String) contextParam.get("youdaoAppKey");
		String youdaoAppSecret = (String) contextParam.get("youdaoAppSecret");
		appKeyTextField.setText(youdaoAppKey);
		appSecretTextField.setText(youdaoAppSecret);

		final KeySettingYoudaoPanelAction keySettingYoudaoPanelAction = new KeySettingYoudaoPanelAction(this);
		DocumentListener documentListener = new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				keySettingYoudaoPanelAction.textFieldChange();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				keySettingYoudaoPanelAction.textFieldChange();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				keySettingYoudaoPanelAction.textFieldChange();
			}
		};
		appKeyTextField.getDocument().addDocumentListener(documentListener);
		appSecretTextField.getDocument().addDocumentListener(documentListener);
	}

	public JLabel getAppKeyLabel() {
		return appKeyLabel;
	}

	public void setAppKeyLabel(JLabel appKeyLabel) {
		this.appKeyLabel = appKeyLabel;
	}

	public JTextField getAppKeyTextField() {
		return appKeyTextField;
	}

	public void setAppKeyTextField(JTextField appKeyTextField) {
		this.appKeyTextField = appKeyTextField;
	}

	public JLabel getAppSecretLabel() {
		return appSecretLabel;
	}

	public void setAppSecretLabel(JLabel appSecretLabel) {
		this.appSecretLabel = appSecretLabel;
	}

	public JTextField getAppSecretTextField() {
		return appSecretTextField;
	}

	public void setAppSecretTextField(JTextField appSecretTextField) {
		this.appSecretTextField = appSecretTextField;
	}

}
