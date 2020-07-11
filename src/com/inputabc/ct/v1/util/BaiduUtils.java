package com.inputabc.ct.v1.util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baidu.translate.demo.TransApi;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONObject;

public class BaiduUtils {
	private static final String APP_ID = "";
	private static final String SECURITY_KEY = "";
	private static TransApi api;
	public static final String CHINESE = "zh";
	public static final String ENGLISH = "en";
	public static final String JPANESE = "jp";
	public static final String KOREAN = "kor";
	public static final String AUTO = "auto";
	static {
		api = new TransApi(APP_ID, SECURITY_KEY);
	}
	public static String translate(String src,String srcLang,String targetLang) {
		String transResult = api.getTransResult(src,srcLang,targetLang);
		JSONObject fromObject = JSONObject.fromObject(transResult);
		Map<String, Object> map = (Map<String, Object>) JSONObject.toBean(fromObject, HashMap.class);
		String value;
		try {
			List<MorphDynaBean> list = (List) map.get("trans_result");
			MorphDynaBean bean = list.get(0);
			value = (String) bean.get("dst");
		} catch (Exception e) {
			e.printStackTrace();
			return transResult;
		}
		return value;
	}
}
