package com.inputabc.ct.v1.ui.keysetting.action;

import com.inputabc.ct.v1.context.ContextParams;
import com.inputabc.ct.v1.ui.keysetting.KeySettingBuilder;
/**
 * 
 * @author gaoweiyi
 *
 */
public class KeySettingFrameAction{
	public void executingExit() {
		KeySettingBuilder keySettingBuilder = (KeySettingBuilder) ContextParams.contextParam.get("keySettingBuilder");
		keySettingBuilder.destory();
	}
}
