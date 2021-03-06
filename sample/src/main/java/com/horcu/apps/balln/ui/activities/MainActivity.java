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

package com.horcu.apps.balln.ui.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.horcu.apps.balln.R;
import com.horcu.apps.balln.custom.ColorBarDrawable;
import com.horcu.apps.balln.ui.fragments.DoubleHeaderFragment;
import com.horcu.apps.balln.ui.fragments.PinnedHeaderFragment;
import com.horcu.apps.balln.ui.fragments.StickyHeaderFragment;
import com.horcu.apps.balln.utilities.decorUtil;


public class MainActivity extends BaseActivity {

    private String[] tabs = { "Pinned", "Week", "Live"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decorUtil.changeStatusBarColor(this, R.color.primary);
        try {
            HeaderPagerAdapter adapter = new HeaderPagerAdapter(this.getSupportFragmentManager());
            ViewPager pager = (ViewPager) this.findViewById(R.id.pager);
            pager.setAdapter(adapter);

            Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
            android.support.v7.app.ActionBar ab = getSupportActionBar();
            if (ab != null) {
                ab.setHomeButtonEnabled(true);
                ab.setDefaultDisplayHomeAsUpEnabled(true);
            }

            setSupportActionBar(toolbar);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void toast(final String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            this.getMenuInflater().inflate(R.menu.activity_main, menu);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            if (item.getItemId() == R.id.action_about) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/edubarr/header-decor"));
                this.startActivity(intent);
                return true;
            }

            return super.onOptionsItemSelected(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    class HeaderPagerAdapter extends FragmentPagerAdapter {

        public HeaderPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
          //  return new DoubleHeaderFragment();
            try {
                if (position == 0) {
                    return new PinnedHeaderFragment();
               } else if(position == 1) {
                    return new DoubleHeaderFragment();
                 }
                else
                {
                    return new StickyHeaderFragment();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            try {
                if (position == 0) {
                    return "TEAMS";
                } else if(position == 1) {
                    return "MATCHUPS";
                }
                else
                {
                    return "LIVE";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
