package com.inputabc.ct.v1.handler;
/**
 * 
 * @author gaoweiyi
 *
 */
public interface ForcedTranslationHandler extends TranslateHandler{
	/**
	 * 判断文本内容是否符合指定格式
	 * @param format
	 * @param content
	 * @return
	 */
	public boolean judgeCompliance(String format,String content);
	/**
	 * 根据支持的格式将源内容转化为可翻译的内容，即每个单词用空格隔开
	 * @param sourceContent
	 * @return
	 */
	public String formatContent(String sourceContent);
}
