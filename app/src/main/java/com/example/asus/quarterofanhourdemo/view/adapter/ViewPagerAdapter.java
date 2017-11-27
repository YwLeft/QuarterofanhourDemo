package com.example.asus.quarterofanhourdemo.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;
/**
 * 创建时间  2017/11/23 20:00
 * 创建人    gaozhijie
 * 类描述	ViewPager+Fragment 的适配器
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
	private List<Fragment> mlist;

	public ViewPagerAdapter(FragmentManager fm,List<Fragment> mlist) {
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
