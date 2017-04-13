package com.zijin.wifi_teacher.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zijin.wifi_teacher.R;
import com.zijin.wifi_teacher.common.Users;

import java.util.List;

/**
 * Created by yin on 2017/4/4.
 */
public class UsersAdapter extends BaseAdapter {

    private List<Users> mData; //定义数据
    private LayoutInflater mInflater; //定义Inflater加载自定义的布局

    /*
    定义构造器，在Activity创建对象Adapter的时候将数据data和Inflater传入自定义的Adapter中进行处理。
    */
    public UsersAdapter(LayoutInflater inflater, List<Users> data){
        mInflater = inflater;
        mData = data;
    }

    /**
     * 获取数据的数量
     * @return
     */
    @Override
    public int getCount() {
        return mData.size();
    }

    /**
     * 获得某一位置的数据
     */
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    /**
     * 获得唯一标识
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {
        //获得ListView中的view
        View viewUser = mInflater.inflate(R.layout.listview_item, null);
        //获得学生对象
        Users user = mData.get(position);
        //获得自定义布局中每一个控件的对象。
        ImageView imagePhoto = (ImageView) viewUser.findViewById(R.id.image_photo);
        TextView name = (TextView) viewUser.findViewById(R.id.tv_name);
        TextView number = (TextView) viewUser.findViewById(R.id.tv_number);
        TextView mac = (TextView) viewUser.findViewById(R.id.tv_ip);
        //将数据一一添加到自定义的布局中。
        imagePhoto.setImageResource(R.drawable.connected);
        name.setText(user.getName());
        number.setText(user.getNumber());
        mac.setText(user.getIp());
        return viewUser ;
    }
}
