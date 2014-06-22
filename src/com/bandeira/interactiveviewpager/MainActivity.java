package com.bandeira.interactiveviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.ViewGroup;

import com.bandeira.interactiveviewpager.fragments.RootFragmentA;
import com.bandeira.interactiveviewpager.fragments.RootFragmentB;
import com.bandeira.interactiveviewpager.fragments.RootTab;

public class MainActivity extends ActionBarActivity implements
		ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SlidePagerAdapter mSlidePagerAdapter;
	FragmentManager fm;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar.
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		fm = getSupportFragmentManager();
		mSlidePagerAdapter = new SlidePagerAdapter(fm);

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSlidePagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager.setOnPageChangeListener(mSlidePagerAdapter);
		actionBar.removeAllTabs();
		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSlidePagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSlidePagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}

	@Override
	public void onBackPressed() {
		if (fm.getBackStackEntryCount() > 0) {
			super.onBackPressed();
		} else {
			if (!mSlidePagerAdapter.isFirstScreen()) {
				mViewPager.setCurrentItem(0);
			} else {
				super.onBackPressed();
			}
		}
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.

		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		fm.popBackStack(getTagToBackStackByTab(tab.getPosition()),
				FragmentManager.POP_BACK_STACK_INCLUSIVE);
		mSlidePagerAdapter.updateContent();
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	/* PagerAdapter class */
	public class SlidePagerAdapter extends FragmentPagerAdapter implements
			OnPageChangeListener {
		int lastTab = 0;
		String lastTabTag = "";
		RootTab fragment;

		@Override
		public void setPrimaryItem(ViewGroup container, int position,
				Object object) {
			if (fragment != object) {
				fragment = (RootTab) object;
				updateContent();
			}
			super.setPrimaryItem(container, position, object);
		}

		public RootTab getRootFragment() {
			return fragment;
		}

		public SlidePagerAdapter(FragmentManager fm) {
			super(fm);
			lastTabTag = getTagToBackStackByTab(lastTab);
		}

		public boolean isFirstScreen() {
			return lastTab == 0 && fm.getBackStackEntryCount() == 0;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return new RootFragmentA();
			case 1:
				return new RootFragmentB();
			default:
				return new RootFragmentA();
			}
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return getTagToBackStackByTab(position);
		}

		@Override
		public int getCount() {
			return 2;
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int tab) {
			ActionBar actionBar = getSupportActionBar();
			actionBar.setSelectedNavigationItem(tab);
			fm.popBackStack(lastTabTag,
					FragmentManager.POP_BACK_STACK_INCLUSIVE);
			lastTab = tab;
			lastTabTag = getTagToBackStackByTab(tab);
		}

		public void updateContent() {
			fragment.updateFragmentContent();
		}
	}

	public static String getTagToBackStack(int id) {
		switch (id) {
		case R.id.tab_a_frame:
			return "Home";
		case R.id.tab_b_frame:
			return "Tab B";
		default:
			return "";
		}
	}

	public static String getTagToBackStackByTab(int id) {
		switch (id) {
		case 0:
			return "Home";
		case 1:
			return "Tab B";
		default:
			return "";
		}
	}

}
