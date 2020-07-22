package com.inputabc.ct.v1.service.impl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.inputabc.EzGUIFramework.listener.ListenerBinder;
import com.inputabc.EzGUIFramework.util.alias.Ez;
import com.inputabc.ct.v1.context.Components;
import com.inputabc.ct.v1.context.ComponentsBuilder;
import com.inputabc.ct.v1.service.KeySettingUIService;
import com.inputabc.ct.v1.ui.TextBox;
import com.inputabc.ct.v1.ui.keysetting.action.KeySettingBaiduPanelAction;
import com.inputabc.ct.v1.ui.keysetting.action.KeySettingControlPanelAction;
import com.inputabc.ct.v1.ui.keysetting.action.KeySettingFrameAction;
import com.inputabc.ct.v1.ui.keysetting.action.KeySettingYoudaoPanelAction;
import com.inputabc.ct.v1.ui.keysetting.component.KeySettingBaiduPanel;
import com.inputabc.ct.v1.ui.keysetting.component.KeySettingControlPanel;
import com.inputabc.ct.v1.ui.keysetting.component.KeySettingFrame;
import com.inputabc.ct.v1.ui.keysetting.component.KeySettingKeyItemPanel;
import com.inputabc.ct.v1.ui.keysetting.component.KeySettingMainPanel;
import com.inputabc.ct.v1.ui.keysetting.component.KeySettingYoudaoPanel;
/**
 * 
 * @author gaoweiyi
 *
 */
public class KeySettingUIServiceImpl implements KeySettingUIService {
	private Components textBoxComponents = ComponentsBuilder.getComponentsContext().get(TextBox.class);

	@Override
	public void setBounds(KeySettingFrame keySettingFrame) {
		keySettingFrame.setSize(400, 295);
		keySettingFrame.setLocationRelativeTo(textBoxComponents.get("textBoxFrame"));

		KeySettingMainPanel keySettingMainPanel = keySettingFrame.getKeySettingMainPanel();
		KeySettingControlPanel keySettingControlPanel = keySettingMainPanel.getKeySettingControlPanel();
		keySettingControlPanel.setSize(keySettingFrame.getWidth() - 5, 42);
		keySettingControlPanel.setLocation(0, keySettingFrame.getHeight() - keySettingControlPanel.getHeight() - 28);
		JButton okButton = keySettingControlPanel.getOkButton();
		JButton cancelButton = keySettingControlPanel.getCancelButton();
		JButton applyButton = keySettingControlPanel.getApplyButton();
		okButton.setBounds(keySettingFrame.getWidth() - 3 * 80 - 30, 5, 80, 28);
		cancelButton.setBounds(keySettingFrame.getWidth() - 2 * 80 - 22, 5, 80, 28);
		applyButton.setBounds(keySettingFrame.getWidth() - 1 * 80 - 14, 5, 80, 28);

		KeySettingKeyItemPanel keySettingKeyItemPanel = keySettingMainPanel.getKeySettingKeyItemPanel();
		keySettingKeyItemPanel.setSize(keySettingFrame.getWidth() - 25,
				keySettingFrame.getHeight() - keySettingControlPanel.getHeight() - 40);
		keySettingKeyItemPanel.setLocation(10, 10);

		KeySettingYoudaoPanel keySettingYoudaoPanel = keySettingKeyItemPanel.getKeySettingYoudaoPanel();
		keySettingYoudaoPanel.setSize(keySettingKeyItemPanel.getWidth() - 20, 90);
		keySettingYoudaoPanel.setLocation(10, 10);

		KeySettingBaiduPanel keySettingBaiduPanel = keySettingKeyItemPanel.getKeySettingBaiduPanel();
		keySettingBaiduPanel.setSize(keySettingYoudaoPanel.getSize());
		keySettingBaiduPanel.setLocation(keySettingYoudaoPanel.getX(), keySettingYoudaoPanel.getHeight() + 20);

		JLabel appKeyLabel = keySettingYoudaoPanel.getAppKeyLabel();
		appKeyLabel.setSize(80,20);
		appKeyLabel.setLocation(15,22);
		//appKeyLabel.setBorder(BorderFactory.createEtchedBorder());
		JTextField appKeyTextField = keySettingYoudaoPanel.getAppKeyTextField();
		appKeyTextField.setSize(keySettingKeyItemPanel.getWidth()-appKeyLabel.getX()-appKeyLabel.getWidth()-40, 21);
		appKeyTextField.setLocation(appKeyLabel.getWidth() + appKeyLabel.getX() + 5, appKeyLabel.getY());
		JLabel appSecretLabel = keySettingYoudaoPanel.getAppSecretLabel();
		appSecretLabel.setSize(appKeyLabel.getSize());
		appSecretLabel.setLocation(appKeyLabel.getX(), appKeyLabel.getY() + appKeyLabel.getHeight() + 5);
		JTextField appSecretTextField = keySettingYoudaoPanel.getAppSecretTextField();
		appSecretTextField.setSize(appKeyTextField.getSize());
		appSecretTextField.setLocation(appKeyTextField.getX(),
				appKeyTextField.getY() + appKeyTextField.getHeight() + 5);

		JLabel appIdLabel = keySettingBaiduPanel.getAppIdLabel();
		appIdLabel.setSize(appKeyLabel.getSize());
		appIdLabel.setLocation(appKeyLabel.getLocation());
		JTextField appIdTextField = keySettingBaiduPanel.getAppIdTextField();
		appIdTextField.setSize(appKeyTextField.getSize());
		appIdTextField.setLocation(appKeyTextField.getLocation());
		JLabel securityKeyLabel = keySettingBaiduPanel.getSecurityKeyLabel();
		securityKeyLabel.setSize(appKeyLabel.getSize());
		securityKeyLabel.setLocation(appSecretLabel.getLocation());
		JTextField securityKeyTextField = keySettingBaiduPanel.getSecurityKeyTextField();
		securityKeyTextField.setSize(appSecretTextField.getSize());
		securityKeyTextField.setLocation(appSecretTextField.getLocation());

	}

	@Override
	public void setLayouts(KeySettingFrame keySettingFrame) {

		KeySettingMainPanel keySettingMainPanel = keySettingFrame.getKeySettingMainPanel();
		keySettingMainPanel.setLayout(null);
		KeySettingControlPanel keySettingControlPanel = keySettingMainPanel.getKeySettingControlPanel();
		keySettingControlPanel.setLayout(null);
		KeySettingKeyItemPanel keySettingKeyItemPanel = keySettingMainPanel.getKeySettingKeyItemPanel();
		keySettingKeyItemPanel.setLayout(null);
		KeySettingYoudaoPanel keySettingYoudaoPanel = keySettingKeyItemPanel.getKeySettingYoudaoPanel();
		keySettingYoudaoPanel.setLayout(null);
		KeySettingBaiduPanel keySettingBaiduPanel = keySettingKeyItemPanel.getKeySettingBaiduPanel();
		keySettingBaiduPanel.setLayout(null);
	}

	@Override
	public void setBackgrounds(KeySettingFrame keySettingFrame) {
		KeySettingMainPanel keySettingMainPanel = keySettingFrame.getKeySettingMainPanel();
		KeySettingKeyItemPanel keySettingKeyItemPanel = keySettingMainPanel.getKeySettingKeyItemPanel();
		keySettingKeyItemPanel.setBackground(Color.white);
		KeySettingYoudaoPanel keySettingYoudaoPanel = keySettingKeyItemPanel.getKeySettingYoudaoPanel();
		keySettingYoudaoPanel.setBackground(keySettingKeyItemPanel.getBackground());
		KeySettingBaiduPanel keySettingBaiduPanel = keySettingKeyItemPanel.getKeySettingBaiduPanel();
		keySettingBaiduPanel.setBackground(keySettingKeyItemPanel.getBackground());
	}

	@Override
	public void setBorders(KeySettingFrame keySettingFrame) {
		KeySettingKeyItemPanel keySettingKeyItemPanel = keySettingFrame.getKeySettingMainPanel()
				.getKeySettingKeyItemPanel();
		keySettingKeyItemPanel.setBorder(BorderFactory.createLineBorder(new Color(0x898C95)));
		KeySettingYoudaoPanel keySettingYoudaoPanel = keySettingKeyItemPanel.getKeySettingYoudaoPanel();
		keySettingYoudaoPanel.setBorder(BorderFactory.createTitledBorder("有道翻译"));
		KeySettingBaiduPanel keySettingBaiduPanel = keySettingKeyItemPanel.getKeySettingBaiduPanel();
		keySettingBaiduPanel.setBorder(BorderFactory.createTitledBorder("百度翻译"));
	}

	@Override
	public void bindingListeners(KeySettingFrame keySettingFrame) {
		ListenerBinder keySettingFrameListenerBinder = Ez.getListenerBinder(new KeySettingFrameAction());
		keySettingFrameListenerBinder.windowClosing(keySettingFrame, "executingExit");

		KeySettingControlPanel keySettingControlPanel = keySettingFrame.getKeySettingMainPanel()
				.getKeySettingControlPanel();
		ListenerBinder keySettingControlPanelListenerBinder = Ez
				.getListenerBinder(new KeySettingControlPanelAction(keySettingControlPanel));
		JButton okButton = keySettingControlPanel.getOkButton();
		keySettingControlPanelListenerBinder.actionPerformed(okButton, "clickOk");
		JButton cancelButton = keySettingControlPanel.getCancelButton();
		keySettingControlPanelListenerBinder.actionPerformed(cancelButton, "clickCancel");
		JButton applyButton = keySettingControlPanel.getApplyButton();
		keySettingControlPanelListenerBinder.actionPerformed(applyButton, "clickApply");

		KeySettingKeyItemPanel keySettingKeyItemPanel = keySettingFrame.getKeySettingMainPanel()
				.getKeySettingKeyItemPanel();
		KeySettingBaiduPanel keySettingBaiduPanel = keySettingKeyItemPanel.getKeySettingBaiduPanel();
		final KeySettingBaiduPanelAction keySettingBaiduPanelAction = new KeySettingBaiduPanelAction(
				keySettingBaiduPanel);
		DocumentListener documentListener1 = new DocumentListener() {
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
		keySettingBaiduPanel.getAppIdTextField().getDocument().addDocumentListener(documentListener1);
		keySettingBaiduPanel.getSecurityKeyTextField().getDocument().addDocumentListener(documentListener1);

		KeySettingYoudaoPanel keySettingYoudaoPanel = keySettingKeyItemPanel.getKeySettingYoudaoPanel();
		final KeySettingYoudaoPanelAction keySettingYoudaoPanelAction = new KeySettingYoudaoPanelAction(
				keySettingYoudaoPanel);
		DocumentListener documentListener2 = new DocumentListener() {

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
		keySettingYoudaoPanel.getAppKeyTextField().getDocument().addDocumentListener(documentListener2);
		keySettingYoudaoPanel.getAppSecretTextField().getDocument().addDocumentListener(documentListener2);
	}

	@Override
	public void setFonts(KeySettingFrame keySettingFrame) {
		KeySettingKeyItemPanel keySettingKeyItemPanel = keySettingFrame.getKeySettingMainPanel()
				.getKeySettingKeyItemPanel();
		KeySettingYoudaoPanel keySettingYoudaoPanel = keySettingKeyItemPanel.getKeySettingYoudaoPanel();
		JLabel appKeyLabel = keySettingYoudaoPanel.getAppKeyLabel();
		int fontSize = appKeyLabel.getFont().getSize();
		int fontStyle = appKeyLabel.getFont().getStyle();
		Font labelFont = new Font("Arial", fontStyle, fontSize);
		
		appKeyLabel.setFont(labelFont);
		JLabel appSecretLabel = keySettingYoudaoPanel.getAppSecretLabel();
		appSecretLabel.setFont(labelFont);
		KeySettingBaiduPanel keySettingBaiduPanel = keySettingKeyItemPanel.getKeySettingBaiduPanel();
		JLabel appIdLabel = keySettingBaiduPanel.getAppIdLabel();
		appIdLabel.setFont(labelFont);
		JLabel securityKeyLabel = keySettingBaiduPanel.getSecurityKeyLabel();
		securityKeyLabel.setFont(labelFont);
	}
}
