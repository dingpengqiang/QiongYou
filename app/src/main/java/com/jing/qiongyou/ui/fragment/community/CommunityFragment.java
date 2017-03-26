package com.jing.qiongyou.ui.fragment.community;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jing.qiongyou.R;
import com.jing.qiongyou.base.BaseFragment;

/**
 * Created by Ding.pengqiang
 * on 2017/3/27.
 *
 * 社区
 */

public class CommunityFragment extends BaseFragment {

    public static final String TAG = CommunityFragment.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_community,container,false);
        return layout;
    }
}
