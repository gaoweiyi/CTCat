package com.inputabc.ct.v1.service;

import com.inputabc.ct.v1.ui.keysetting.component.KeySettingFrame;

public interface KeySettingUIService {
	public void setBounds(KeySettingFrame keySettingFrame) ;
	public void setLayouts(KeySettingFrame keySettingFrame);
	public void setBackgrounds(KeySettingFrame keySettingFrame);
	public void setBorders(KeySettingFrame keySettingFrame);
	public void bindingListeners(KeySettingFrame keySettingFrame);
	void setFonts(KeySettingFrame keySettingFrame);
}
