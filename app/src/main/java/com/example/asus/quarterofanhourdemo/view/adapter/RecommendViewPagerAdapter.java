package com.example.asus.quarterofanhourdemo.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;
/**
 * 类描述	ViewPager+Fragment 的适配器(推荐)
 */
public class RecommendViewPagerAdapter extends FragmentPagerAdapter {
	private List<Fragment> mlist;

	public RecommendViewPagerAdapter(FragmentManager fm, List<Fragment> mlist) {
		super(fm);
		this.mlist = mlist;
		notifyDataSetChanged();
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return mlist.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mlist==null?0:mlist.size();
	}

}
