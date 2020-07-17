package com.inputabc.ct.v1.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import com.inputabc.ct.v1.context.ContextParams;
/**
 * 将翻译api的密钥信息加密读写
 * @author gaoweiyi
 *
 */
public class KeyIOUtils {
	private static final Map<Object, Object> contextParam = ContextParams.contextParam;
	private static String filePath = PFileUtils.getTargetPath() + "/AppData/Local/ctcatv1/";
	static {
		File dir = new File(filePath);
		if (dir.exists() == false) {
			dir.mkdirs();
			File file = new File(dir, "config");
			try {
				file.createNewFile();
				filePath = file.getAbsolutePath();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			if (dir.isFile()) {
				dir.delete();
				dir.mkdirs();
			} else {
				File file = new File(dir, "config");
				if (file.exists() == false) {
					try {
						file.createNewFile();
						filePath = file.getAbsolutePath();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					filePath = file.getAbsolutePath();
				}
			}
		}

	}

	public static void load() {
		Properties p = new Properties();
		try {
			p.load(new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8")));
			Set<Entry<Object, Object>> entrySet = p.entrySet();
			for (Entry<Object, Object> entry : entrySet) {
				String key = (String) entry.getKey();
				String value = (String) entry.getValue();
				Decoder decoder = Base64.getDecoder();
				byte[] decodedKey = decoder.decode(key);
				byte[] decodedValue = decoder.decode(value);
				contextParam.put(new String(decodedKey,"utf-8"),new String(decodedValue,"utf-8"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void store() {
		Properties p = new Properties();
		String youdaoAppKey = (String) contextParam.get("youdaoAppKey");
		String youdaoAppSecret = (String) contextParam.get("youdaoAppSecret");
		String baiduAppId = (String) contextParam.get("baiduAppId");
		String baiduSecurityKey = (String) contextParam.get("baiduSecurityKey");
		Encoder encoder = Base64.getEncoder();
		try {
			p.setProperty(new String(encoder.encode("youdaoAppKey".getBytes("utf-8")),"utf-8"), new String(encoder.encode(youdaoAppKey.getBytes("utf-8")),"utf-8"));
			p.setProperty(new String(encoder.encode("youdaoAppSecret".getBytes("utf-8")),"utf-8"), new String(encoder.encode(youdaoAppSecret.getBytes("utf-8")),"utf-8"));
			p.setProperty(new String(encoder.encode("baiduAppId".getBytes("utf-8")),"utf-8"), new String(encoder.encode(baiduAppId.getBytes("utf-8")),"utf-8"));
			p.setProperty(new String(encoder.encode("baiduSecurityKey".getBytes("utf-8")),"utf-8"), new String(encoder.encode(baiduSecurityKey.getBytes("utf-8")),"utf-8"));
			p.store(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "utf-8")), "\\");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
