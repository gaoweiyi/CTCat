package com.inputabc.ct.v1.ui.keysetting;

import java.awt.Color;
import java.awt.Point;

import javax.swing.Box;
import javax.swing.JFrame;

import com.inputabc.EzGUIFramework.util.alias.Ez;
import com.inputabc.ct.v1.context.Components;
import com.inputabc.ct.v1.context.ComponentsBuilder;
import com.inputabc.ct.v1.context.ComponentsContext;
import com.inputabc.ct.v1.ui.TextBox;

public class KeySettingFrame extends JFrame {
	private KeySettingMainPanel keySettingMainPanel;
	private Components textBoxComponents = ComponentsBuilder.getComponentsContext().get(TextBox.class);
	{
		setName(this.getClass().getName());
		keySettingMainPanel = new KeySettingMainPanel();
	}
	public KeySettingFrame() {
		JFrame textBoxFrame = (JFrame) textBoxComponents.get("textBoxFrame");
		Point locationOnScreen = textBoxFrame.getLocationOnScreen();
		setSize(360, 300);
		setLocationRelativeTo(textBoxFrame);
		setContentPane(keySettingMainPanel);
		
		KeySettingControlPanel keySettingControlPanel = keySettingMainPanel.getKeySettingControlPanel();
		Box controlBox = keySettingControlPanel.getControlBox();
		controlBox.add(Box.createHorizontalStrut(getWidth()-190),0);
		controlBox.validate();
		
		Ez.removeButtonDottedLine(this);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public KeySettingMainPanel getKeySettingMainPanel() {
		return keySettingMainPanel;
	}

	public void setKeySettingMainPanel(KeySettingMainPanel keySettingMainPanel) {
		this.keySettingMainPanel = keySettingMainPanel;
	}
	
}
