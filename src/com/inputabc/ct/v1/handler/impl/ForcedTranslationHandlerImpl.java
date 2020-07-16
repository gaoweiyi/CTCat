package com.inputabc.ct.v1.handler.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.inputabc.ct.v1.handler.ForcedTranslationHandler;

import net.sf.json.regexp.RegexpMatcher;
import net.sf.json.regexp.RegexpUtils;

/**
 * 将源内容强制进行翻译的处理器
 * 
 * @author gaoweiyi
 * @since v1
 * @date 2020-07-13
 */
public class ForcedTranslationHandlerImpl implements ForcedTranslationHandler {
	@Override
	public boolean judgeCompliance(String format, String content) {
		if ("xx@xx".equals(format)) {
			return content.matches("([a-zA-Z]+(\\!|\\@|\\#|\\$|\\%|\\^|\\&|\\*|\\_|\\-|\\=|\\+|\\/|\\*|\\~)[a-zA-Z]+)+");
		} else if ("XxXx".equals(format)) {
			return content.matches("([A-Z][a-z]+){2,}");
		}
		return false;// 不符合

	}

	@Override
	public String formatContent(String sourceContent) {
		if (judgeCompliance("xx@xx", sourceContent)) {
			RegexpMatcher regexpMatcher = RegexpUtils.getMatcher("([a-zA-Z]+(\\!|\\@|\\#|\\$|\\%|\\^|\\&|\\*|\\_|\\-|\\=|\\+|\\/|\\*|\\~)[a-zA-Z]+)+");
			String sep = regexpMatcher.getGroupIfMatches(sourceContent,2);
			String[] words = sourceContent.split(sep);
			return StringUtils.join(words, " ");
		}else if(judgeCompliance("XxXx",sourceContent)) {
			List<String> words = new ArrayList<>();
			Pattern pattern = Pattern.compile("[A-Z][a-z]+");
			Matcher matcher = pattern.matcher(sourceContent);
			while(matcher.find()) {
				String group = matcher.group();
				System.out.println(group);
				words.add(group);
			}
			return StringUtils.join(words, " ").toLowerCase();
		}
		return sourceContent;// 表示源内容不符合任何被支持的格式
	}

}
