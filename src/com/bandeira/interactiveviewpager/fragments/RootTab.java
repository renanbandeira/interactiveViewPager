package com.bandeira.interactiveviewpager.fragments;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;

public abstract class RootTab extends Fragment implements Parcelable{
	public static final String TAB_KEY = "tab";
	public static final String RESOURCE_KEY = "resourceId";
	UpdatableFragment fragment;
	
	/**
	 * Calls the updateFragment method to update the view.
	 */
	public void updateFragmentContent(){
		if(fragment != null){
			fragment.updateFragment();
		}
	}
	
	/**
	 * @param fragment
	 * Update the Fragment reference
	 */
	public void updateFragment(UpdatableFragment fragment){
		this.fragment = fragment;
	}
	
	public UpdatableFragment getFragment(){
		return fragment;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	}

	
	

}
