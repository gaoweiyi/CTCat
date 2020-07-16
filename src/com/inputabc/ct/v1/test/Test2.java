package com.inputabc.ct.v1.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.regexp.RegexpMatcher;
import net.sf.json.regexp.RegexpUtils;

public class Test2 {

	public static void main(String[] args) {
		String re = "([a-zA-Z]+(\\!|\\@|\\#|\\$|\\%|\\^|\\&|\\*|\\_|\\-|\\=|\\+|\\/|\\*|\\~)[a-zA-Z]+)+";
		String s = "As#dsd/wd#wedwe/a#A/wdwewdw#efwef/dwedwefwe/Zs/AAAaAa";
		
		Pattern p = Pattern.compile("([a-zA-Z]+(\\!|\\@|\\#|\\$|\\%|\\^|\\&|\\*|\\_|\\-|\\=|\\+|\\/|\\*|\\~)[a-zA-Z]+)+");
		Matcher matcher = p.matcher("Asdsd/wdwedwe/wefwefe");
		RegexpMatcher regexpMatcher = RegexpUtils.getMatcher(re);
		String groupIfMatches = regexpMatcher.getGroupIfMatches(s,2);
		System.out.println(groupIfMatches);
//		while(matcher.find()) {
//			String group = matcher.group();
//			System.out.println(group);
//		}
	}

}
