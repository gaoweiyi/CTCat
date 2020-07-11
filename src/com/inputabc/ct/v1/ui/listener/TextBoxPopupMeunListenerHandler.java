package com.inputabc.ct.v1.ui.listener;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

import com.inputabc.EzGUIFramework.main.EzGUI;
import com.inputabc.ct.v1.context.Components;
import com.inputabc.ct.v1.context.ComponentsBuilder;
import com.inputabc.ct.v1.context.ContextParams;
import com.inputabc.ct.v1.ui.TextBox;
import com.inputabc.ct.v1.util.BaiduUtils;
import com.inputabc.ct.v1.util.YoudaoUtils;

public class TextBoxPopupMeunListenerHandler {
	private JPopupMenu jpm;
	private Components textBoxComponents = ComponentsBuilder.getComponentsContext().get(TextBox.class);
	private JFrame jf = (JFrame) textBoxComponents.get("textBoxFrame");
	private JTextArea jta = (JTextArea) textBoxComponents.get("textBoxTextArea");
	private Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
	private Map<Object, Object> contextParam = ContextParams.contextParam;
	private FSDirectory fsdir;

	public TextBoxPopupMeunListenerHandler() {
		try {
			fsdir = FSDirectory.open((Path) contextParam.get("indexPath"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public TextBoxPopupMeunListenerHandler(JPopupMenu jpm) {
		this();
		this.jpm = jpm;
	}

	public void bindMenuItemListener() {
		Component[] components = jpm.getComponents();
		for (Component c : components) {
			if (c instanceof JMenuItem) {

				if ("textBoxCloseMenuItem".equals(c.getName())) {
					((JMenuItem) c).addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							EzGUI.fadeOut(jf, EzGUI.FADE_NORMAL);
							System.exit(0);
						}
					});
				}
				if ("textBoxSelectAllMenuItem".equals(c.getName())) {
					((JMenuItem) c).addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							jta.select(0, jta.getText().length());
						}
					});
				}
				if ("textBoxCopyMenuItem".equals(c.getName())) {
					((JMenuItem) c).addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							String selectedText = jta.getSelectedText();
							contextParam.put("previousText", jta.getText());
							StringSelection stringSelection = new StringSelection(selectedText);
							clip.setContents(stringSelection, null);

						}
					});
				}

				if ("textBoxSelectAllAndCopyMenuItem".equals(c.getName())) {
					((JMenuItem) c).addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							jta.select(0, jta.getText().length());
							String selectedText = jta.getSelectedText();
							contextParam.put("previousText", jta.getText());
							StringSelection stringSelection = new StringSelection(selectedText);
							clip.setContents(stringSelection, null);

						}
					});
				}
				if ("textBoxMoveMenuItem".equals(c.getName())) {
					((JMenuItem) c).addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							jta.setCursor(new Cursor(Cursor.MOVE_CURSOR));

						}
					});
				}

				if ("textBoxRefreshMenu".equals(c.getName())) {
					((JMenuItem) c).addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							JFrame jf = (JFrame) textBoxComponents.get("textBoxFrame");
							jf.setVisible(false);
							jf.setVisible(true);
							JTextArea jta = (JTextArea) textBoxComponents.get("textBoxTextArea");
							JPanel jp = (JPanel) textBoxComponents.get("textBoxPanel");
							String text = jta.getText();
							jta.setText("");
							jp.updateUI();
							jta.setText(text);
						}
					});
				}
				if ("textBoxTranslationMenu".equals(c.getName())) {
					JMenu translateMenu = (JMenu) c;
					Component[] components2 = translateMenu.getMenuComponents();
					for (Component c2 : components2) {
						if ("textBoxTranslationMenuEN2CN".equals(c2.getName())) {
							((JMenuItem) c2).addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									JMenuItem s = (JMenuItem) e.getSource();
									String engine = (String) contextParam.get("translationEngine");
									if ("youdao".equals(engine)) {
										contextParam.put("sourceLanguage", YoudaoUtils.ENGLISH);
										contextParam.put("targetLanguage", YoudaoUtils.CHINESE);
									} else if ("baidu".equals(engine)) {
										contextParam.put("sourceLanguage", BaiduUtils.ENGLISH);
										contextParam.put("targetLanguage", BaiduUtils.CHINESE);
									}
									deleteIndexAll();

								}
							});
						}
						else if ("textBoxTranslationMenuJA2CN".equals(c2.getName())) {
							((JMenuItem) c2).addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									JMenuItem s = (JMenuItem) e.getSource();
									String engine = (String) contextParam.get("translationEngine");
									if ("youdao".equals(engine)) {
										contextParam.put("sourceLanguage", YoudaoUtils.JPANESE);
										contextParam.put("targetLanguage", YoudaoUtils.CHINESE);
									} else if ("baidu".equals(engine)) {
										contextParam.put("sourceLanguage", BaiduUtils.JPANESE);
										contextParam.put("targetLanguage", BaiduUtils.CHINESE);
									}
									deleteIndexAll();
								}
							});
						}
						else if ("textBoxTranslationMenuKR2CN".equals(c2.getName())) {
							((JMenuItem) c2).addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									JMenuItem s = (JMenuItem) e.getSource();
									String engine = (String) contextParam.get("translationEngine");
									if ("youdao".equals(engine)) {
										contextParam.put("sourceLanguage", YoudaoUtils.KOREAN);
										contextParam.put("targetLanguage", YoudaoUtils.CHINESE);
									} else if ("baidu".equals(engine)) {
										contextParam.put("sourceLanguage", BaiduUtils.KOREAN);
										contextParam.put("targetLanguage", BaiduUtils.CHINESE);
									}
									deleteIndexAll();
								}
							});
						}
						else if ("textBoxTranslationMenuCN2EN".equals(c2.getName())) {
							((JMenuItem) c2).addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									JMenuItem s = (JMenuItem) e.getSource();
									String engine = (String) contextParam.get("translationEngine");
									if ("youdao".equals(engine)) {
										contextParam.put("sourceLanguage", YoudaoUtils.CHINESE);
										contextParam.put("targetLanguage", YoudaoUtils.ENGLISH);
									} else if ("baidu".equals(engine)) {
										contextParam.put("sourceLanguage", BaiduUtils.CHINESE);
										contextParam.put("targetLanguage", BaiduUtils.ENGLISH);
									}
									deleteIndexAll();
									System.out.println(2);
								}
							});
						}
						else if ("textBoxTranslationMenuCN2JA".equals(c2.getName())) {
							((JMenuItem) c2).addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									JMenuItem s = (JMenuItem) e.getSource();
									String engine = (String) contextParam.get("translationEngine");
									if ("youdao".equals(engine)) {
										contextParam.put("sourceLanguage", YoudaoUtils.CHINESE);
										contextParam.put("targetLanguage", YoudaoUtils.JPANESE);
									} else if ("baidu".equals(engine)) {
										contextParam.put("sourceLanguage", BaiduUtils.CHINESE);
										contextParam.put("targetLanguage", BaiduUtils.JPANESE);
									}
									deleteIndexAll();
								}
							});
						}
						else if ("textBoxTranslationMenuCN2KR".equals(c2.getName())) {
							((JMenuItem) c2).addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									JMenuItem s = (JMenuItem) e.getSource();
									String engine = (String) contextParam.get("translationEngine");
									if ("youdao".equals(engine)) {
										contextParam.put("sourceLanguage", YoudaoUtils.CHINESE);
										contextParam.put("targetLanguage", YoudaoUtils.KOREAN);
									} else if ("baidu".equals(engine)) {
										contextParam.put("sourceLanguage", BaiduUtils.CHINESE);
										contextParam.put("targetLanguage", BaiduUtils.KOREAN);
									}
									deleteIndexAll();

								}
							});
						}
						else if ("textBoxTranslationMenuAUTO2CN".equals(c2.getName())) {
							((JMenuItem) c2).addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									JMenuItem s = (JMenuItem) e.getSource();
									contextParam.put("sourceLanguage", BaiduUtils.AUTO);
									contextParam.put("targetLanguage", BaiduUtils.CHINESE);
									deleteIndexAll();
								}
							});
						}
						else if ("textBoxTranslationMenuAUTO2EN".equals(c2.getName())) {
							((JMenuItem) c2).addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									JMenuItem s = (JMenuItem) e.getSource();
									contextParam.put("sourceLanguage", BaiduUtils.AUTO);
									contextParam.put("targetLanguage", BaiduUtils.ENGLISH);
									deleteIndexAll();
								}
							});
						}
						else if ("textBoxTranslationMenuAUTO2JA".equals(c2.getName())) {
							((JMenuItem) c2).addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									JMenuItem s = (JMenuItem) e.getSource();
									contextParam.put("sourceLanguage", BaiduUtils.AUTO);
									contextParam.put("targetLanguage", BaiduUtils.JPANESE);
									deleteIndexAll();
								}
							});
						}
						else if ("textBoxTranslationMenuAUTO2KR".equals(c2.getName())) {
							((JMenuItem) c2).addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									JMenuItem s = (JMenuItem) e.getSource();
									contextParam.put("sourceLanguage", BaiduUtils.AUTO);
									contextParam.put("targetLanguage", BaiduUtils.KOREAN);
									deleteIndexAll();
								}
							});
						}
					}
				}
				if("textBoxTranslationEngineMenu".equals(c.getName())) {
					JMenu translateMenu = (JMenu) c;
					Component[] components2 = translateMenu.getMenuComponents();
					for (Component c2 : components2) {
						if("textBoxTranslationEngineMenuYoudao".equals(c2.getName())) {
							((JMenuItem) c2).addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									contextParam.put("translationEngine", "youdao");
									deleteIndexAll();
								}
							});
						}
						else if("textBoxTranslationEngineMenuBaidu".equals(c2.getName())) {
							((JMenuItem) c2).addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									contextParam.put("translationEngine", "baidu");
									deleteIndexAll();
								}
							});
						}
					}
				}

			}
		}
	}

	// 删除索引库内容
	private void deleteIndexAll() {
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new StandardAnalyzer());
		try {
			IndexWriter indexWriter = new IndexWriter(fsdir, indexWriterConfig);
			indexWriter.deleteAll();
			indexWriter.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void setJPopupMenu(JPopupMenu jpm) {
		this.jpm = jpm;
	}

}
