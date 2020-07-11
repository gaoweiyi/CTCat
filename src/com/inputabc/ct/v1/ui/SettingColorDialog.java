package com.inputabc.ct.v1.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.inputabc.ct.v1.context.Components;
import com.inputabc.ct.v1.context.ComponentsBuilder;

public class SettingColorDialog {
	private Components settingColorDialogComponents = ComponentsBuilder.getComponentsContext()
			.get(SettingColorDialog.class);
	
	private JDialog jd = (JDialog) settingColorDialogComponents.get("settingColorDialog");
	private JPanel jp = (JPanel) settingColorDialogComponents.get("settingColorPanel");
	private JButton jb1 = (JButton) settingColorDialogComponents.get("settingColorBackgroundColorButton");// 按钮：背景色
	private JButton jb2 = (JButton) settingColorDialogComponents.get("settingColorNormalTextcolorButton");// 按钮：普通文本色
	private JButton jb3 = (JButton) settingColorDialogComponents.get("settingColorErrorTextcolorButton");// 按钮：错误文本色
	private JPanel jp1 = (JPanel) settingColorDialogComponents.get("settingColorShowColorEffectPanel");// 展示颜色设置的效果的框
	private JLabel jl1 = (JLabel) settingColorDialogComponents.get("settingColorShowNormalLabel");// 展示普通文本色的效果文字
	private JLabel jl2 = (JLabel) settingColorDialogComponents.get("settingColorShowErrorLabel");// 展示错误文本色的效果文字
	private JButton jb4 = (JButton) settingColorDialogComponents.get("settingColorRecDefaultButton");// 按钮：恢复默认
	private JButton jb5 = (JButton) settingColorDialogComponents.get("settingColorOkButton");// 按钮：确定
	private JButton jb6 = (JButton) settingColorDialogComponents.get("settingColorCancelButton");// 按钮：取消

	private Components textBoxComponents = ComponentsBuilder.getComponentsContext().get(TextBox.class);
	private JFrame textBoxJf = (JFrame) textBoxComponents.get("textBoxFrame");
	public SettingColorDialog() {
		init();
	}

	private void init() {
		jp.setLayout(null);
		
		
		jd.setLayout(new BorderLayout());
		jd.setContentPane(jp);
		jd.setResizable(false);
		jd.setModal(true);
		jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jd.setSize(400, 500);
		jd.setLocationRelativeTo(textBoxJf);
		jd.setVisible(true);
	}
}
