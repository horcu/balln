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

package com.horcu.apps.balln.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.horcu.apps.balln.R;

import ca.barrenechea.widget.recyclerview.decoration.DoubleHeaderAdapter;

public class DoubleHeaderTestAdapter extends RecyclerView.Adapter<DoubleHeaderTestAdapter.ViewHolder> implements
        DoubleHeaderAdapter<DoubleHeaderTestAdapter.HeaderHolder, DoubleHeaderTestAdapter.SubHeaderHolder> {

    private LayoutInflater mInflater;

    public DoubleHeaderTestAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View view = mInflater.inflate(R.layout.item_test, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.item.setText("Item " + i);
    }

    @Override
    public int getItemCount()
    {
       return 16 //matchups per week excluding two more when bye weeks start
        + 5; //different time slots thursat730 sundayat1pm sundayat4pm sundayat8pm mondayat730pm

    }

    @Override
    public long getHeaderId(int position) {
        return position / 16;
    }

    @Override
    public long getSubHeaderId(int position) {
        return position / 7;
    }

    @Override
    public HeaderHolder onCreateHeaderHolder(ViewGroup parent) {
        try {
            final View view = mInflater.inflate(R.layout.super_header_test, parent, false);
            return new HeaderHolder(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SubHeaderHolder onCreateSubHeaderHolder(ViewGroup parent) {
        try {
            final View view = mInflater.inflate(R.layout.header_test, parent, false);
            return new SubHeaderHolder(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindHeaderHolder(HeaderHolder viewholder, int position) {
        viewholder.timeline.setText("Header " + getHeaderId(position));
    }

    @Override
    public void onBindSubHeaderHolder(SubHeaderHolder viewholder, int position) {
        viewholder.date.setText("Sub-header " + getSubHeaderId(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView item;

        public ViewHolder(View itemView) {
            super(itemView);

            item = (TextView) itemView;
        }
    }

    static class HeaderHolder extends RecyclerView.ViewHolder {
        public TextView timeline;

        public HeaderHolder(View itemView) {
            super(itemView);

            timeline = (TextView) itemView;
        }
    }

    static class SubHeaderHolder extends RecyclerView.ViewHolder {
        public TextView date;

        public SubHeaderHolder(View itemView) {
            super(itemView);

            date = (TextView) itemView;
        }
    }
}
