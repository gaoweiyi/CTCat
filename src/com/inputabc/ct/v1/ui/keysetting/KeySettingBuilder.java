package com.inputabc.ct.v1.ui.keysetting;

import com.inputabc.EzGUIFramework.util.EzGUI;
import com.inputabc.ct.v1.service.KeySettingUIService;
import com.inputabc.ct.v1.service.impl.KeySettingUIServiceImpl;
import com.inputabc.ct.v1.ui.keysetting.component.KeySettingFrame;

public class KeySettingBuilder {
	private KeySettingFrame keySettingFrame;
	private KeySettingUIService keySettingUIService = new KeySettingUIServiceImpl();
	public void build() {
		try {
			KeySettingFrame keySettingFrame = new KeySettingFrame();
			keySettingUIService.setLayouts(keySettingFrame);
			keySettingUIService.setBackgrounds(keySettingFrame);
			keySettingUIService.setFonts(keySettingFrame);
			keySettingUIService.setBounds(keySettingFrame);
			keySettingUIService.setBorders(keySettingFrame);
			keySettingUIService.bindingListeners(keySettingFrame);
			keySettingFrame.setVisible(true);
			this.keySettingFrame = keySettingFrame;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void destory() {
		keySettingFrame = null;
	}
	public KeySettingFrame getKeySettingFrame() {
		return keySettingFrame;
	}

	public void setKeySettingFrame(KeySettingFrame keySettingFrame) {
		this.keySettingFrame = keySettingFrame;
	}
	
}
