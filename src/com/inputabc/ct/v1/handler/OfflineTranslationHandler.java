package com.inputabc.ct.v1.handler;

import org.apache.lucene.store.Directory;
/**
 * 
 * @author gaoweiyi
 *
 */
public interface OfflineTranslationHandler extends TranslateHandler{
	/**
	 * 将翻译后的内容写入索引库中
	 * @param content
	 * @param translatedContent
	 * @param dir 索引库位置对象
	 */
	public void writeTranslatedContentToIndex(String content,String translatedContent,Directory dir);
	/**
	 * 从索引库中检索翻译后的内容（离线翻译）
	 * @param content
	 * @param dir
	 * @return
	 */
	public String getTranslatedContentFromIndex(String content,Directory dir);
}
