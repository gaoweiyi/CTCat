package com.inputabc.ct.v1.ui.keysetting;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.inputabc.EzGUIFramework.listener.ListenerBinder;
import com.inputabc.EzGUIFramework.util.alias.Ez;
import com.inputabc.ct.v1.ui.keysetting.action.KeySettingControlPanelAction;

public class KeySettingControlPanel extends JPanel {
	private JButton okButton;
	private JButton cancelButton;
	private JButton applyButton;
	private Box controlBox;
	{
		setName(this.getClass().getName());
		okButton = new JButton("确定");
		cancelButton = new JButton("取消");
		applyButton = new JButton("应用");
		controlBox = Box.createHorizontalBox();
	}

	public KeySettingControlPanel() {
		setName(this.getClass().getName());
		setBackground(new Color(0xf0f0f0));
		setLayout(new BorderLayout());
		add(controlBox);
		controlBox.add(okButton);
		controlBox.add(Box.createHorizontalStrut(5));
		controlBox.add(cancelButton);
		controlBox.add(Box.createHorizontalStrut(5));
		controlBox.add(applyButton);
		controlBox.add(Box.createHorizontalStrut(5));
		ListenerBinder lb = Ez.getListenerBinder(new KeySettingControlPanelAction(this));
		lb.actionPerformed(applyButton, "clickApply");
		lb.actionPerformed(cancelButton, "clickCancel");
		lb.actionPerformed(okButton, "clickOk");
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

	public Box getControlBox() {
		return controlBox;
	}

	public void setControlBox(Box controlBox) {
		this.controlBox = controlBox;
	}

}
