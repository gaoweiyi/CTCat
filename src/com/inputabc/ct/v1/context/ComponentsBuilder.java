package com.inputabc.ct.v1.context;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.inputabc.EzGUIFramework.main.EzGUI;
import com.inputabc.ct.v1.ui.SettingColorDialog;
import com.inputabc.ct.v1.ui.TextBox;

/**
 * 组件加载器 用于在项目启动时就创建好项目中的所有组件
 * 
 * @author gaoweiyi
 *
 */
public class ComponentsBuilder {
	private static ComponentsContext cc;
	static {
		EzGUI.setTheme(EzGUI.THEME_OS_DEFAULT);

		cc = new ComponentsContext();
		/** 初始化主窗口的组件 */
		Components textBoxComs = new Components();

		JFrame jf = new JFrame();
		jf.setName("textBoxFrame");
		textBoxComs.put(jf.getName(), jf);

		JPanel jp = new JPanel();
		jp.setName("textBoxPanel");
		textBoxComs.put(jp.getName(), jp);

		JTextArea jta = new JTextArea();
		jta.setName("textBoxTextArea");
		textBoxComs.put(jta.getName(), jta);

		JScrollPane jsp = new JScrollPane();
		jsp.setName("textBoxScrollPane");
		textBoxComs.put(jsp.getName(), jsp);

		JPopupMenu jpm = new JPopupMenu();
		jpm.setName("textBoxPopupMenu");
		textBoxComs.put(jpm.getName(), jpm);

		JMenuItem jmi1 = new JMenuItem();
		jmi1.setName("textBoxCloseMenuItem");
		textBoxComs.put(jmi1.getName(), jmi1);

		JMenuItem jmi2 = new JMenuItem();
		jmi2.setName("textBoxSelectAllMenuItem");
		textBoxComs.put(jmi2.getName(), jmi2);

		JMenuItem jmi3 = new JMenuItem();
		jmi3.setName("textBoxSelectAllAndCopyMenuItem");
		textBoxComs.put(jmi3.getName(), jmi3);

		JMenuItem jmi4 = new JMenuItem();
		jmi4.setName("textBoxCopyMenuItem");
		textBoxComs.put(jmi4.getName(), jmi4);

		JMenuItem jmi5 = new JMenuItem();
		jmi5.setName("textBoxMoveMenuItem");
		textBoxComs.put(jmi5.getName(), jmi5);

		JMenu jm1 = new JMenu();
		jm1.setName("textBoxTranslationMenu");
		textBoxComs.put(jm1.getName(), jm1);

		JMenuItem jmi7 = new JMenuItem();
		jmi7.setName("textBoxTranslationMenuEN2CN");
		textBoxComs.put(jmi7.getName(), jmi7);

		JMenuItem jmi8 = new JMenuItem();
		jmi8.setName("textBoxTranslationMenuJA2CN");
		textBoxComs.put(jmi8.getName(), jmi8);

		JMenuItem jmi9 = new JMenuItem();
		jmi9.setName("textBoxTranslationMenuKR2CN");
		textBoxComs.put(jmi9.getName(), jmi9);

		JMenuItem jmi10 = new JMenuItem();
		jmi10.setName("textBoxTranslationMenuCN2EN");
		textBoxComs.put(jmi10.getName(), jmi10);

		JMenuItem jmi11 = new JMenuItem();
		jmi11.setName("textBoxTranslationMenuCN2JA");
		textBoxComs.put(jmi11.getName(), jmi11);

		JMenuItem jmi12 = new JMenuItem();
		jmi12.setName("textBoxTranslationMenuCN2KR");
		textBoxComs.put(jmi12.getName(), jmi12);

		JMenuItem jmi13 = new JMenuItem();
		jmi13.setName("textBoxRefreshMenu");
		textBoxComs.put(jmi13.getName(), jmi13);

		cc.put(TextBox.class, textBoxComs);

		/** 初始化颜色设置对话框的组件 */
		Components settingColorDialogComs = new Components();

		JDialog jd_1 = new JDialog();
		jd_1.setName("settingColorDialog");
		settingColorDialogComs.put(jd_1.getName(), jd_1);

		JPanel jp_1 = new JPanel();
		jp_1.setName("settingColorPanel");
		settingColorDialogComs.put(jp_1.getName(), jp_1);

		JButton jb_1 = new JButton();
		jb_1.setName("settingColorBackgroundColorButton");
		settingColorDialogComs.put(jb_1.getName(), jb_1);

		JButton jb_1_1 = new JButton();
		jb_1_1.setName("settingColorNormalTextcolorButton");
		settingColorDialogComs.put(jb_1_1.getName(), jb_1_1);

		JButton jb_1_2 = new JButton();
		jb_1_2.setName("settingColorErrorTextcolorButton");
		settingColorDialogComs.put(jb_1_2.getName(), jb_1_2);

		JPanel jp_1_1 = new JPanel();
		jp_1_1.setName("settingColorShowColorEffectPanel");
		settingColorDialogComs.put(jp_1_1.getName(), jp_1_1);

		JLabel jl_1 = new JLabel();
		jl_1.setName("settingColorShowNormalLabel");
		settingColorDialogComs.put(jl_1.getName(), jl_1);

		JLabel jl_1_1 = new JLabel();
		jl_1_1.setName("settingColorShowErrorLabel");
		settingColorDialogComs.put(jl_1_1.getName(), jl_1_1);

		JButton jb_1_3 = new JButton();
		jb_1_3.setName("settingColorRecDefaultButton");
		settingColorDialogComs.put(jb_1_3.getName(), jb_1_3);

		JButton jb_1_4 = new JButton();
		jb_1_4.setName("settingColorOkButton");
		settingColorDialogComs.put(jb_1_4.getName(), jb_1_4);

		JButton jb_1_5 = new JButton();
		jb_1_5.setName("settingColorCancelButton");
		settingColorDialogComs.put(jb_1_5.getName(), jb_1_5);

		cc.put(SettingColorDialog.class, settingColorDialogComs);

		JMenuItem jmi14 = new JMenuItem();
		jmi14.setName("textBoxTranslationMenuAUTO2CN");
		textBoxComs.put(jmi14.getName(), jmi14);
		
		JMenuItem jmi15 = new JMenuItem();
		jmi15.setName("textBoxTranslationMenuAUTO2EN");
		textBoxComs.put(jmi15.getName(), jmi15);
		
		JMenuItem jmi16 = new JMenuItem();
		jmi16.setName("textBoxTranslationMenuAUTO2JA");
		textBoxComs.put(jmi16.getName(), jmi16);
		
		JMenuItem jmi17 = new JMenuItem();
		jmi17.setName("textBoxTranslationMenuAUTO2KR");
		textBoxComs.put(jmi17.getName(), jmi17);
		
		JMenu jm2 = new JMenu();
		jm2.setName("textBoxTranslationEngineMenu");
		textBoxComs.put(jm2.getName(), jm2);
		
		JMenuItem jmi18 = new JMenuItem();
		jmi18.setName("textBoxTranslationEngineMenuYoudao");
		textBoxComs.put(jmi18.getName(), jmi18);
		
		JMenuItem jmi19 = new JMenuItem();
		jmi19.setName("textBoxTranslationEngineMenuBaidu");
		textBoxComs.put(jmi19.getName(), jmi19);
	}

	public static ComponentsContext getComponentsContext() {
		return cc;
	}
}
