package com.inputabc.ct.v1.ui.keysetting.component;

import java.awt.Point;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.inputabc.EzGUIFramework.listener.ListenerBinder;
import com.inputabc.EzGUIFramework.util.alias.Ez;
import com.inputabc.ct.v1.context.Components;
import com.inputabc.ct.v1.context.ComponentsBuilder;
import com.inputabc.ct.v1.ui.TextBox;
import com.inputabc.ct.v1.ui.keysetting.action.KeySettingFrameAction;
/**
 * 
 * @author gaoweiyi
 *
 */
public class KeySettingFrame extends JFrame {
	private KeySettingMainPanel keySettingMainPanel;
	private Components textBoxComponents = ComponentsBuilder.getComponentsContext().get(TextBox.class);
	{
		setName(this.getClass().getName());
		keySettingMainPanel = new KeySettingMainPanel();
	}
	public KeySettingFrame() {
		super("设置API密钥");
		setContentPane(keySettingMainPanel);

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
