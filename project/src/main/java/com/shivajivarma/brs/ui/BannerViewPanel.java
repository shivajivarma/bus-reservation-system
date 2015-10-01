package com.shivajivarma.brs.ui;

import java.awt.BorderLayout;

import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.ResourcePaths;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
@SuppressWarnings("serial")
public class BannerViewPanel extends BaseView implements View{
	public BannerViewPanel(){
		this.setLayout(new BorderLayout());
		this.add(ViewComponentFactory.createJLabelImage(ResourcePaths.BANNER));
	}
}
