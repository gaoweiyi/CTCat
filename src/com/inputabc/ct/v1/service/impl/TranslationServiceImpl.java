package com.inputabc.ct.v1.service.impl;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.Lock;
import org.apache.lucene.store.LockFactory;

import com.inputabc.ct.v1.context.ContextParams;
import com.inputabc.ct.v1.handler.ForcedTranslationHandler;
import com.inputabc.ct.v1.handler.OfflineTranslationHandler;
import com.inputabc.ct.v1.handler.impl.ForcedTranslationHandlerImpl;
import com.inputabc.ct.v1.handler.impl.OfflineTranslationHandlerImpl;
import com.inputabc.ct.v1.service.TranslationService;
import com.inputabc.ct.v1.util.BaiduUtils;
import com.inputabc.ct.v1.util.YoudaoUtils;

public class TranslationServiceImpl implements TranslationService {
	private Map<Object, Object> contextParam = ContextParams.contextParam;
	private ForcedTranslationHandler fth = new ForcedTranslationHandlerImpl();
	private OfflineTranslationHandler oth = new OfflineTranslationHandlerImpl();

	@Override
	public String translate(String content) throws Exception {
		String translated = null;
		/*
		 * 将被翻译的内容进行格式化，以便其一定能够翻译
		 * 因为我们很多时候像HELLO_WORLD或hello_world这样的句子是需要翻译的，但大部分在线翻译引擎无法将其翻译，所以将其转换为HELLO
		 * WORLD之后就一定可以翻译了
		 */
		content = fth.formatContent(content);// 格式化被翻译的内容

		FSDirectory fsdir = null;
		try {
			fsdir = FSDirectory.open((Path) contextParam.get("indexPath"));
			translated = oth.getTranslatedContentFromIndex(content, fsdir);// 从索引库中检索翻译后的内容（真正的离线翻译）
			if (translated == null) {
				// 进行在线翻译
				try {
					String translationEngine = (String) contextParam.get("translationEngine");
					if ("youdao".equals(translationEngine)) {
						translated = YoudaoUtils.translate(content, (String) contextParam.get("sourceLanguage"),
								(String) contextParam.get("targetLanguage"));
					} else if ("baidu".equals(translationEngine)) {
						translated = BaiduUtils.translate(content, (String) contextParam.get("sourceLanguage"),
								(String) contextParam.get("targetLanguage"));
					}
					oth.writeTranslatedContentToIndex(content, translated, fsdir);// 将翻译后的内容写入索引库
				} catch (Exception e) {
					if (e.toString().contains("java.net.")) {
						throw new RuntimeException("无法连接到在线翻译引擎");
					}
				}
			} else {
				return translated;// 将离线翻译的结果返回
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (e.toString().contains("org.apache.lucene.index.IndexNotFoundException")) {
				// 进行在线翻译
				String translationEngine = (String) contextParam.get("translationEngine");
				if ("youdao".equals(translationEngine)) {
					translated = YoudaoUtils.translate(content, (String) contextParam.get("sourceLanguage"),
							(String) contextParam.get("targetLanguage"));
				} else if ("baidu".equals(translationEngine)) {
					translated = BaiduUtils.translate(content, (String) contextParam.get("sourceLanguage"),
							(String) contextParam.get("targetLanguage"));
				}
			} else {
				throw e;
			}

		}

		return translated;// 将在线翻译的结果返回
	}

}
