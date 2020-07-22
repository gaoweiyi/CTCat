package com.inputabc.ct.v1.ui;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class ShadowPanel extends JPanel {

	  /**
	 * 
	 */
	private static final long serialVersionUID = -8551136225490818545L;

	public ShadowPanel() {
	    setLayout(new BorderLayout());
	    setOpaque(false);
	    setBackground(Color.BLACK);
	    setBorder(new EmptyBorder(0, 0, 4, 4));
	  }

	 
	  @Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g.create();
	    g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
	    g2d.fillRect(10, 10, getWidth(), getHeight());
	    g2d.dispose();
	  }
}
