package com.shivajivarma.brs.ui;

import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.ResourcePaths;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
@SuppressWarnings("serial")
public class BannerViewPanel extends BaseView implements View{
	public BannerViewPanel(){
		this.add(ViewComponentFactory.createJPanelImage(ResourcePaths.BANNER));
	}
}
