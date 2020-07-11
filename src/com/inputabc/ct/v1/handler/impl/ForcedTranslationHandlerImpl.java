package com.inputabc.ct.v1.handler.impl;

import com.inputabc.ct.v1.handler.ForcedTranslationHandler;
/**
 * 将源内容强制进行翻译的处理器
 * @author gaoweiyi
 * @since v1
 *
 */
public class ForcedTranslationHandlerImpl implements ForcedTranslationHandler {
	@Override
	public boolean judgeCompliance(String format,String content){
		if("xx_xx".equals(format)){
			String[] words = content.split("_");
			for (String w : words) {
				for(int x = 0;x<w.length();x++){
					//判断拆分的每个单词是否包含非英文字符，如果包含，则返回false
					char charAt = w.charAt(x);
					if(charAt<'A' || (charAt>'Z'&&charAt<'a') || charAt>'z'){
						return false;
					}
				}
			}
			return true;//符合
		}
		return false;//不符合
		
	}
	@Override
	public String formatContent(String sourceContent){
		if(judgeCompliance("xx_xx",sourceContent)){
			StringBuilder sb = new StringBuilder();
			String[] words = sourceContent.split("_");
			for (String w : words) {
				sb.append(w).append(" ");
			}
			return sb.toString();
		}
		return sourceContent;//表示源内容不符合任何被支持的格式
	}
	
}
