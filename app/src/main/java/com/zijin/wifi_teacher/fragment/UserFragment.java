package com.zijin.wifi_teacher.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zijin.wifi_teacher.R;
import com.zijin.wifi_teacher.dao.UsersDao;

import java.util.ArrayList;

/**
 * Created by yin on 2017/4/10.
 */
public class UserFragment extends Fragment {
    private Context mContext;
    private ListView mlistView;
    UsersDao usersDao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user,container,false);
        mlistView = (ListView) view.findViewById(R.id.lv_user);

        return view;
    }


}