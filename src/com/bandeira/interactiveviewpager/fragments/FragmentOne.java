package com.bandeira.interactiveviewpager.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.bandeira.interactiveviewpager.MainActivity;
import com.bandeira.interactiveviewpager.R;

public class FragmentOne extends Fragment implements UpdatableFragment {
	RootTab tab;
	int resourceId;

	public static FragmentOne newInstance(RootTab tab, int resourceId) {
		FragmentOne fragment = new FragmentOne();
		Bundle bundle = new Bundle();
		bundle.putParcelable(RootTab.TAB_KEY, tab);
		bundle.putInt(RootTab.RESOURCE_KEY, resourceId);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_one, container, false);
		Bundle bundle = getArguments();
		if(bundle != null){
			if(bundle.containsKey(RootTab.TAB_KEY)){
				tab = bundle.getParcelable(RootTab.TAB_KEY);
			}
			if(bundle.containsKey(RootTab.RESOURCE_KEY)){
				resourceId = bundle.getInt(RootTab.RESOURCE_KEY);
			}
		}
		view.findViewById(R.id.button).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				FragmentTransaction transaction = getActivity().getSupportFragmentManager()
						.beginTransaction();
				FragmentTwo fragmentTwo = FragmentTwo.newInstance(tab, resourceId);
				transaction.replace(resourceId, fragmentTwo);
				transaction.addToBackStack(MainActivity.getTagToBackStack(resourceId));
				transaction.commit();
			}
		});
		return view;
	}

	@Override
	public void updateFragment() {
		// TODO Update some list or something you wish to update after coming
		// here (Sometimes you need to update some list wich was changed in the
		// other tab)

	}

}
