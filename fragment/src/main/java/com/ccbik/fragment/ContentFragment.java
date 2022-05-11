package com.ccbik.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ContentFragment extends Fragment {
    private View view;
    TextView tvcontent;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @deprecated
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentcontent, container, false);
        if (view != null) {
            tvcontent = view.findViewById(R.id.content);
        }
        tvcontent.setText("第一个菜");
        return view;
    }
}
