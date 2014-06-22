package com.bandeira.interactiveviewpager.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bandeira.interactiveviewpager.R;


public class RootFragmentB  extends RootTab{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.root_tab_b, container, false);
		FragmentTransaction transaction = getActivity().getSupportFragmentManager()
				.beginTransaction();
		/*
		 * When this container fragment is created, we fill it with our first
		 * "real" fragment
		 */
		FragmentOne fragmentOne = FragmentOne.newInstance(this, R.id.tab_b_frame);
		transaction.replace(R.id.tab_b_frame, fragmentOne);

		transaction.commit();
		
		return view;
	}

}
