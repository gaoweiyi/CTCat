package com.inputabc.ct.v1.controller;

import com.inputabc.ct.v1.context.ContextParams;
import com.inputabc.ct.v1.service.TranslationService;
import com.inputabc.ct.v1.service.impl.TranslationServiceImpl;
/**
 * 
 * @author gaoweiyi
 *
 */
public class TextContentController {
	private TranslationService ts = new TranslationServiceImpl();

	public String getTranslatedContent(String content) throws Exception {
		String engine = (String) ContextParams.contextParam.get("translationEngine");
		if ("youdao".equals(engine)) {
			if (content.length() > 200) {
				throw new RuntimeException("文本长度过长");
			}
		}
		return ts.translate(content);
	}
}
