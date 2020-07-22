package com.inputabc.ct.v1.ui.keysetting.component;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.inputabc.EzGUIFramework.listener.ListenerBinder;
import com.inputabc.EzGUIFramework.util.alias.Ez;
import com.inputabc.ct.v1.ui.keysetting.action.KeySettingControlPanelAction;
/**
 * 
 * @author gaoweiyi
 *
 */
public class KeySettingControlPanel extends JPanel {
	private JButton okButton;
	private JButton cancelButton;
	private JButton applyButton;
	{
		setName(this.getClass().getName());
		okButton = new JButton("确定");
		cancelButton = new JButton("取消");
		applyButton = new JButton("应用");
	}

	public KeySettingControlPanel() {
		this.add(okButton);
		this.add(cancelButton);
		this.add(applyButton);
		
		applyButton.setEnabled(false);
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JButton getApplyButton() {
		return applyButton;
	}

	public void setApplyButton(JButton applyButton) {
		this.applyButton = applyButton;
	}

}
