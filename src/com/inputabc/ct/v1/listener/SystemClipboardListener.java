package com.inputabc.ct.v1.listener;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import com.inputabc.ct.v1.context.Components;
import com.inputabc.ct.v1.context.ComponentsBuilder;
import com.inputabc.ct.v1.context.ContextParams;
import com.inputabc.ct.v1.controller.TextContentController;
import com.inputabc.ct.v1.ui.TextBox;

/**
 * 剪贴板监控器 负责对剪贴板文本的监控和操作 由于监控需要一个对象作为ClipboardOwner，故不能用静态类
 * 
 * @author gaoweiyi
 */
public class SystemClipboardListener implements ClipboardOwner {
	private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	private Components textBoxComponents = ComponentsBuilder.getComponentsContext().get(TextBox.class);
	private JTextArea jta = (JTextArea) textBoxComponents.get("textBoxTextArea");
	private JScrollPane jsp = (JScrollPane) textBoxComponents.get("textBoxScrollPane");
	private JFrame jf = (JFrame) textBoxComponents.get("textBoxFrame");
	private TextContentController tcc = new TextContentController();
	private Map<Object, Object> contextParam = ContextParams.contextParam;
	public SystemClipboardListener() {
		// 如果剪贴板中有文本，则将它的ClipboardOwner设为自己
		clipboard.setContents(clipboard.getContents(null), this);
	}

	/*****************************************		*****
	 * 如果剪贴板的内容改变，则系统自动调用此方法 *
	 **********************************************
	 */
	@Override
	public void lostOwnership(final Clipboard clipboard, Transferable contents) {
		//1.8.2
		final ClipboardOwner _this = this;
		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (_this) {
					// 如果不暂停一下，经常会抛出IllegalStateException
					// 猜测是操作系统正在使用系统剪切板，故暂时无法访问
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 取出文本并进行一次文本处理
					String text = null;
					if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
						try {
							text = (String) clipboard.getData(DataFlavor.stringFlavor);
						} catch (UnsupportedFlavorException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (StringUtils.isNotBlank(text)) {
						String content = null;
						try {
							contextParam.put("sourceContent", text);
							content = tcc.getTranslatedContent(text);// 调用控制器获取翻译后的文本内容
							contextParam.put("translatedContent", content);
							if (content == null) {
								content = "";
							}
							Map<Integer, Color> fgColorMap = (Map<Integer, Color>) ContextParams.contextParam
									.get("fgColorMap");
							int pos = (int) ContextParams.contextParam.get("colorMapPos");
							jta.setForeground(fgColorMap.get(pos));
							jta.setText(content);
						} catch (Exception e) {
							e.printStackTrace();
							if (jsp.getViewport().getBackground().getRGB() == -53971) {
								jta.setForeground(Color.BLUE);
							} else {
								jta.setForeground(Color.RED);
							}
							jta.setText("出错了！" + System.lineSeparator() + e.getMessage());
							
							return;
						} finally {
							// 存入剪贴板，并注册自己为所有者
							// 用以监控下一次剪贴板内容变化
							StringSelection tmp = new StringSelection(text);
							clipboard.setContents(tmp, _this);
						}
					} else {
						clipboard.setContents(clipboard.getContents(null), _this);
					}
				}

			}
		}).start();
		////
	}
}
