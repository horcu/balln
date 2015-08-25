/*
 * Copyright 2014 Eduardo Barrenechea
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.horcu.apps.balln.ui.fragments;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.horcu.apps.balln.R;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.SimpleLineIconsIcons;

import ca.barrenechea.widget.recyclerview.decoration.DividerDecoration;

public abstract class BaseDecorationFragment extends Fragment {

    private RecyclerView mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            final View view = inflater.inflate(R.layout.fragment_recycler, container, false);

            mList = (RecyclerView) view.findViewById(R.id.games);

            return view;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mList;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        try {
            super.onActivityCreated(savedInstanceState);

            mList.setHasFixedSize(true);
            mList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
            mList.addItemDecoration(new DividerDecoration(this.getActivity()));

            setAdapterAndDecor(mList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void setAdapterAndDecor(RecyclerView list);
}
