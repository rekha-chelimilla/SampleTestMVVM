package com.test.sampletest.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.test.sampletest.R;
import com.test.sampletest.databinding.ActivityMainBinding;
import com.test.sampletest.utils.FragmentUtils;
import com.test.sampletest.view.base.BaseActivity;
import com.test.sampletest.view.fragment.ArticleListFragment;

import static com.test.sampletest.utils.FragmentUtils.TRANSITION_NONE;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentUtils.replaceFragment(this, ArticleListFragment.newInstance(), R.id.fragContainer, false, TRANSITION_NONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
