package com.shivajivarma.brs.ui;

import java.awt.BorderLayout;

import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.ResourcePaths;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
@SuppressWarnings("serial")
public class BannerViewPanel extends BaseView implements View{
	public BannerViewPanel(){
		this.setLayout(new BorderLayout());
		this.add(ViewComponentFactory.createJLabelImage(ResourcePaths.BANNER));
	}
}
