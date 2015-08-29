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

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.horcu.apps.balln.R;
import com.horcu.apps.balln.adapters.GameDayAdapter;

import ca.barrenechea.widget.recyclerview.decoration.DoubleHeaderDecoration;

public class DoubleHeaderFragment extends BaseDecorationFragment {

    private DoubleHeaderDecoration decor;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void setAdapterAndDecor(RecyclerView list) {
        try {
            final GameDayAdapter adapter = new GameDayAdapter(getActivity().findViewById(R.id.empty),  this.getActivity());
            decor = new DoubleHeaderDecoration(adapter);
            setHasOptionsMenu(true);
            list.setAdapter(adapter);
            list.addItemDecoration(decor, 1);


        } catch (Exception e) {
            e.printStackTrace();
        }
        //this.presenter = ActivityMainPresenter.create(null, getActivity());
        //this.adapter = new ScheduleAdapter(this.getActivity().findViewById(R.id.empty),getActivity());
      //  this.presenter.getSchedule("1", true); // only week 1 for now
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            if (item.getItemId() == R.id.action_clear_cache) {
                decor.clearDoubleHeaderCache();
                return true;
            }

            return super.onOptionsItemSelected(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
