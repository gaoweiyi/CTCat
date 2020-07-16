package com.inputabc.ct.v1.ui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Hashtable;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.inputabc.EzGUIFramework.main.EzGUI;
import com.inputabc.ct.v1.context.Components;
import com.inputabc.ct.v1.context.ComponentsBuilder;
import com.inputabc.ct.v1.context.ContextParams;
import com.inputabc.ct.v1.ui.listener.TextBoxPopupMeunListenerHandler;

public class TextBox {
	private Components textBoxComponents = ComponentsBuilder.getComponentsContext().get(TextBox.class);
	private JFrame jf = (JFrame) textBoxComponents.get("textBoxFrame");
	private JPanel jp = (JPanel) textBoxComponents.get("textBoxPanel");
	private JTextArea ta = (JTextArea) textBoxComponents.get("textBoxTextArea");
	private JScrollPane jsp = (JScrollPane) textBoxComponents.get("textBoxScrollPane");
	private JPopupMenu jpm = (JPopupMenu) textBoxComponents.get("textBoxPopupMenu");
	private JMenuItem closeMi = (JMenuItem) textBoxComponents.get("textBoxCloseMenuItem");
	private JMenuItem selectAllMi = (JMenuItem) textBoxComponents.get("textBoxSelectAllMenuItem");
	private JMenuItem selectAllAndCopyMi = (JMenuItem) textBoxComponents.get("textBoxSelectAllAndCopyMenuItem");
	private JMenuItem copyMi = (JMenuItem) textBoxComponents.get("textBoxCopyMenuItem");
	private JMenuItem moveMi = (JMenuItem) textBoxComponents.get("textBoxMoveMenuItem");
	private JMenu textBoxTranslationMenu = (JMenu) textBoxComponents.get("textBoxTranslationMenu");
	private JMenuItem textBoxTranslationMenuEN2CN = (JMenuItem) textBoxComponents.get("textBoxTranslationMenuEN2CN");
	private JMenuItem textBoxTranslationMenuJA2CN = (JMenuItem) textBoxComponents.get("textBoxTranslationMenuJA2CN");
	private JMenuItem textBoxTranslationMenuKR2CN = (JMenuItem) textBoxComponents.get("textBoxTranslationMenuKR2CN");
	private JMenuItem textBoxTranslationMenuCN2EN = (JMenuItem) textBoxComponents.get("textBoxTranslationMenuCN2EN");
	private JMenuItem textBoxTranslationMenuCN2JA = (JMenuItem) textBoxComponents.get("textBoxTranslationMenuCN2JA");
	private JMenuItem textBoxTranslationMenuCN2KR = (JMenuItem) textBoxComponents.get("textBoxTranslationMenuCN2KR");
	private JMenuItem textBoxTranslationMenuAUTO2CN = (JMenuItem) textBoxComponents
			.get("textBoxTranslationMenuAUTO2CN");
	private JMenuItem textBoxTranslationMenuAUTO2EN = (JMenuItem) textBoxComponents
			.get("textBoxTranslationMenuAUTO2EN");
	private JMenuItem textBoxTranslationMenuAUTO2JA = (JMenuItem) textBoxComponents
			.get("textBoxTranslationMenuAUTO2JA");
	private JMenuItem textBoxTranslationMenuAUTO2KR = (JMenuItem) textBoxComponents
			.get("textBoxTranslationMenuAUTO2KR");
	private JMenuItem textBoxRefreshMenu = (JMenuItem) textBoxComponents.get("textBoxRefreshMenu");
	private JMenu textBoxTranslationEngineMenu = (JMenu) textBoxComponents.get("textBoxTranslationEngineMenu");
	private JMenuItem textBoxTranslationEngineMenuYoudao = (JMenuItem) textBoxComponents
			.get("textBoxTranslationEngineMenuYoudao");
	private JMenuItem textBoxTranslationEngineMenuBaidu = (JMenuItem) textBoxComponents
			.get("textBoxTranslationEngineMenuBaidu");
	boolean left, right, up, down, add, subtract;
	private Robot robot;

	public TextBox() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		jsp.setViewportView(ta);
		init();
	}

	private void init() {
		jf.setSize(320, 110);
		EzGUI.center(jf, true);
		jf.setLocation(jf.getX(), jf.getY() + 400);
		jf.setContentPane(jp);
		jp.setLayout(new BorderLayout());
		jp.add(jsp);

		jsp.setAutoscrolls(true);
		jsp.getViewport().setBackground(Color.BLACK);
		ta.setForeground(new Color(255 - 50, 255 - 50, 255 - 50));
		String os = System.getProperty("os.name");
		if (os.toLowerCase().startsWith("win")) {
			ta.setFont(new Font("幼圆", Font.BOLD, 16));
		} else {
			ta.setFont(new Font("宋体", Font.BOLD, 16));
		}
		ta.setText("按住Ctrl键拖拽我~");
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		ta.setEditable(false);
		ta.setOpaque(false);
		ta.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		textBoxTranslationMenu.setText("互译");
		jpm.add(textBoxTranslationMenu);
		textBoxTranslationEngineMenu.setText("翻译引擎");
		jpm.add(textBoxTranslationEngineMenu);
		copyMi.setText("复制");
		jpm.add(copyMi);
		selectAllMi.setText("全选");
		jpm.add(selectAllMi);
		selectAllAndCopyMi.setText("全选并复制");
		jpm.add(selectAllAndCopyMi);
		moveMi.setText("移动");
		// jpm.add(moveMi);
		textBoxRefreshMenu.setText("刷新");
		jpm.add(textBoxRefreshMenu);
		closeMi.setText("关闭");
		jpm.add(closeMi);

		textBoxTranslationMenuEN2CN.setText("英->中");
		textBoxTranslationMenu.add(textBoxTranslationMenuEN2CN);
		textBoxTranslationMenuJA2CN.setText("日->中");
		textBoxTranslationMenu.add(textBoxTranslationMenuJA2CN);
		textBoxTranslationMenuKR2CN.setText("韩->中");
		textBoxTranslationMenu.add(textBoxTranslationMenuKR2CN);
		textBoxTranslationMenu.addSeparator();
		textBoxTranslationMenuCN2EN.setText("中->英");
		textBoxTranslationMenu.add(textBoxTranslationMenuCN2EN);
		textBoxTranslationMenuCN2JA.setText("中->日");
		textBoxTranslationMenu.add(textBoxTranslationMenuCN2JA);
		textBoxTranslationMenuCN2KR.setText("中->韩");
		textBoxTranslationMenu.add(textBoxTranslationMenuCN2KR);
		textBoxTranslationMenu.addSeparator();
		textBoxTranslationMenuAUTO2CN.setText("自动检测->中");
		textBoxTranslationMenu.add(textBoxTranslationMenuAUTO2CN);
		textBoxTranslationMenuAUTO2EN.setText("自动检测->英");
		textBoxTranslationMenu.add(textBoxTranslationMenuAUTO2EN);
		textBoxTranslationMenuAUTO2JA.setText("自动检测->日");
		textBoxTranslationMenu.add(textBoxTranslationMenuAUTO2JA);
		textBoxTranslationMenuAUTO2KR.setText("自动检测->韩");
		textBoxTranslationMenu.add(textBoxTranslationMenuAUTO2KR);
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				String translationEngine = (String) ContextParams.contextParam.get("translationEngine");
				// System.out.println(translationEngine);
				textBoxTranslationMenuAUTO2CN.setEnabled("baidu".equals(translationEngine));
				textBoxTranslationMenuAUTO2EN.setEnabled("baidu".equals(translationEngine));
				textBoxTranslationMenuAUTO2JA.setEnabled("baidu".equals(translationEngine));
				textBoxTranslationMenuAUTO2KR.setEnabled("baidu".equals(translationEngine));
			}
		}, 0, 10);

		textBoxTranslationEngineMenuYoudao.setText("有道");
		textBoxTranslationEngineMenu.add(textBoxTranslationEngineMenuYoudao);
		textBoxTranslationEngineMenuBaidu.setText("百度");
		textBoxTranslationEngineMenu.add(textBoxTranslationEngineMenuBaidu);

		EzGUI.setJPopupMenuForSwing(ta, jpm);

		jf.setAlwaysOnTop(true);
		jf.setUndecorated(true);
		jf.setOpacity(0.8f);
		event();// 批量注册事件监听器
		EzGUI.removeButtonDottedLine(jf);
		jf.setVisible(true);

	}

	/**
	 * 批量注册事件监听器
	 */
	private void event() {
		// 使窗口可拖动
		bindDragListener(ta, jf);
		// 给右键菜单绑定事件
		new TextBoxPopupMeunListenerHandler(jpm).bindMenuItemListener();
		ta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int i = e.getKeyCode();
				switch (i) {
				case KeyEvent.VK_LEFT:
					left = false;
					break;
				case KeyEvent.VK_UP:
					up = false;
					break;
				case KeyEvent.VK_DOWN:
					down = false;
					break;
				case KeyEvent.VK_RIGHT:
					right = false;
					break;
				case 61:
					add = false;
					break;
				case 107:
					add = false;
					break;
				case 45:
					subtract = false;
					break;
				case 109:
					subtract = false;
					break;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int i = e.getKeyCode();
				switch (i) {
				case KeyEvent.VK_LEFT:
					left = true;
					break;
				case KeyEvent.VK_UP:
					up = true;
					break;
				case KeyEvent.VK_DOWN:
					down = true;
					break;
				case KeyEvent.VK_RIGHT:
					right = true;
					break;
				case 61:
					add = true;
					break;
				case 107:
					add = true;
					break;
				case 45:
					subtract = true;
					break;
				case 109:
					subtract = true;
					break;
				}
				// System.out.println(e.getKeyCode());
				if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
					ta.setText(ContextParams.contextParam.get("previousText").toString());
				} else if ((e.isAltDown() && add && subtract == false)) {
					jf.setSize(jf.getWidth() + 20, jf.getHeight() + 20);
					jf.setLocation(jf.getX() - 10, jf.getY() - 20);
				} else if ((e.isAltDown() && subtract && add == false && left == false && right == false && up == false
						&& down == false)) {
					jf.setSize(jf.getWidth() - 20, jf.getHeight() - 20);
					jf.setLocation(jf.getX() + 10, jf.getY() + 20);
				} else if ((e.isControlDown() && add && subtract == false)) {
					Font font = ta.getFont();
					ta.setFont(new Font(font.getFontName(), font.getStyle(), font.getSize() + 4));

				} else if ((e.isControlDown() && subtract && add == false)) {
					Font font = ta.getFont();
					ta.setFont(new Font(font.getFontName(), font.getStyle(), font.getSize() - 4));
				} else if (e.isAltDown() && up && subtract == false) {
					jf.setSize(jf.getWidth(), jf.getHeight() + 20);
					jf.setLocation(jf.getX(), jf.getY() - 20);
				} else if (e.isAltDown() && down && subtract == false) {
					jf.setSize(jf.getWidth(), jf.getHeight() + 20);
				} else if (e.isAltDown() && left && subtract == false) {
					jf.setSize(jf.getWidth() + 20, jf.getHeight());
					jf.setLocation(jf.getX() - 20, jf.getY());
				} else if (e.isAltDown() && right && subtract == false) {
					jf.setSize(jf.getWidth() + 20, jf.getHeight());
					jf.setLocation(jf.getX(), jf.getY());
				} else if (e.isControlDown() && up && left == false && right == false && down == false) {
					up();
				} else if (e.isControlDown() && down && left == false && right == false && up == false) {
					down();
				} else if (e.isControlDown() && left && up == false && down == false && right == false) {
					left();
				} else if (e.isControlDown() && right && up == false && down == false && left == false) {
					right();
				} else if (e.getKeyCode() == KeyEvent.VK_F2) {
					Map<Integer, Color> bgColorMap = (Map<Integer, Color>) ContextParams.contextParam.get("bgColorMap");
					Map<Integer, Color> fgColorMap = (Map<Integer, Color>) ContextParams.contextParam.get("fgColorMap");
					int pos = (int) ContextParams.contextParam.get("colorMapPos");
					pos = ++pos == 9 ? 0 : pos;
					ContextParams.contextParam.put("colorMapPos", pos);
					jsp.getViewport().setBackground(bgColorMap.get(pos));
					ta.setForeground(fgColorMap.get(pos));
				} else if (e.isControlDown() && up && left && right == false && down == false) {
					left_up();
				} else if (e.isControlDown() && up && right && left == false && down == false) {
					right_up();
				} else if (e.isControlDown() && down && left && up == false && right == false) {
					left_down();
				} else if (e.isControlDown() && down && right && up == false && left == false) {
					right_down();
				} else if (e.isAltDown() && subtract && add == false && left && right == false && up == false
						&& down == false) {
					// 从左边缩小窗口
					jf.setSize(jf.getWidth() - 20, jf.getHeight());
					jf.setLocation(jf.getX() + 20, jf.getY());
				} else if (e.isAltDown() && subtract && add == false && left == false && right && up == false
						&& down == false) {
					// 从右边缩小窗口
					jf.setSize(jf.getWidth() - 20, jf.getHeight());
					jf.setLocation(jf.getX(), jf.getY());
				} else if (e.isAltDown() && subtract && add == false && left == false && right == false && up
						&& down == false) {
					// 从上边缩小窗口
					jf.setSize(jf.getWidth(), jf.getHeight() - 20);
					jf.setLocation(jf.getX(), jf.getY() + 20);
				} else if (e.isAltDown() && subtract && add == false && left == false && right == false && up == false
						&& down) {
					// 从下边缩小窗口
					jf.setSize(jf.getWidth(), jf.getHeight() - 20);
					jf.setLocation(jf.getX(), jf.getY());
				}
			}
		});
	}

	/**
	 * 绑定拖动事件到组建
	 * 
	 * @param eventSource 事件源
	 * @param dragged     被拖动的组件
	 */
	private void bindDragListener(final Component eventSource, final Component dragged) {
		final Point origin = new Point();
		final Map<String, Boolean> flag = new Hashtable<String, Boolean>();
		eventSource.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if ((e.getButton() == MouseEvent.BUTTON1 && e.isControlDown())||e.getButton()==MouseEvent.BUTTON2) {
					if(e.getButton()==MouseEvent.BUTTON2) {
						flag.put("clikedButton2", true);
					}
					flag.put("dragable", true);
					origin.x = e.getX();
					origin.y = e.getY();
				} 
				else {
					flag.put("dragable", false);
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON2) {
					flag.put("clikedButton2", false);
				}
			}
		});
		eventSource.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				
				if (flag.get("dragable") == true && (e.isControlDown()||flag.get("clikedButton2"))) {
					Point p = dragged.getLocation();
					dragged.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
				}
			}
		});
	}

	private void up() {
		jf.setLocation(jf.getX(), jf.getY() - 10);
	}

	private void down() {
		jf.setLocation(jf.getX(), jf.getY() + 10);
	}

	private void left() {
		jf.setLocation(jf.getX() - 10, jf.getY());
	}

	private void right() {
		jf.setLocation(jf.getX() + 10, jf.getY());
	}

	private void left_up() {
		jf.setLocation(jf.getX() - 10, jf.getY() - 10);
	}

	private void right_up() {
		jf.setLocation(jf.getX() + 10, jf.getY() - 10);
	}

	private void left_down() {
		jf.setLocation(jf.getX() - 10, jf.getY() + 10);
	}

	private void right_down() {
		jf.setLocation(jf.getX() + 10, jf.getY() + 10);
	}
}
