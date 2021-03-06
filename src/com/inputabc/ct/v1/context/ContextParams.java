package com.inputabc.ct.v1.context;

import java.awt.Color;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.SystemUtils;

import com.inputabc.ct.v1.ui.keysetting.KeySettingBuilder;
import com.inputabc.ct.v1.util.KeyIOUtils;
import com.inputabc.ct.v1.util.PFileUtils;

/**
 * 存放app的参数以及执行app的初始化任务
 * 
 * @author gaoweiyi
 *
 */
public class ContextParams {
	// 1.8.2
	public static final Map<Object, Object> contextParam = new HashMap<Object, Object>();
	////
	static {
		contextParam.put("uuid", UUID.randomUUID().toString().replace("-", ""));
		contextParam.put("xuuid",
				UUID.randomUUID().toString().replace("-", "") + UUID.randomUUID().toString().replace("-", ""));
		// 1.8.2
		String targetPathOfWin8 = PFileUtils.getTargetPath();
		Path path = null;
		if (SystemUtils.IS_OS_WINDOWS) {
			path = FileSystems.getDefault().getPath(targetPathOfWin8, "/AppData/Local/ctcatv1/index");
		} else {
			path = FileSystems.getDefault().getPath(targetPathOfWin8, "/ctcatv1/index");
		}
		////
		File file = path.toFile();
		if (file.exists() == false) {
			file.mkdirs();
		}
		contextParam.put("indexPath", path);
		LinkedHashMap<Integer, Color> bgColorMap = new LinkedHashMap<>();
		bgColorMap.put(0, Color.black);
		bgColorMap.put(1, Color.WHITE);
		bgColorMap.put(2, new Color(0xFF95CA));
		bgColorMap.put(3, new Color(0xFF2D2D));
		bgColorMap.put(4, new Color(0x2828FF));
		bgColorMap.put(5, new Color(0x0080FF));
		bgColorMap.put(6, new Color(0x00CACA));
		bgColorMap.put(7, new Color(0x00DB00));
		bgColorMap.put(8, new Color(0xFFAF60));
		contextParam.put("bgColorMap", bgColorMap);
		LinkedHashMap<Integer, Color> fgColorMap = new LinkedHashMap<>();
		fgColorMap.put(0, new Color(255 - 50, 255 - 50, 255 - 50));
		fgColorMap.put(1, new Color(50, 50, 50));
		fgColorMap.put(2, Color.white);
		fgColorMap.put(3, Color.black);
		fgColorMap.put(4, Color.white);
		fgColorMap.put(5, Color.white);
		fgColorMap.put(6, Color.white);
		fgColorMap.put(7, Color.white);
		fgColorMap.put(8, new Color(50, 50, 50));
		contextParam.put("fgColorMap", fgColorMap);
		//1.8.2
		if(SystemUtils.IS_OS_WINDOWS) {
			contextParam.put("colorMapPos", 0);// 默认颜色指针
		}else {
			contextParam.put("colorMapPos", 1);// 默认颜色指针
		}
		////
		contextParam.put("keySettingBuilder", new KeySettingBuilder());

		KeyIOUtils.load();
	}
}
