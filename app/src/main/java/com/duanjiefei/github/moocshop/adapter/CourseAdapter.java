package com.duanjiefei.github.moocshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duanjiefei.github.moocshop.R;
import com.duanjiefei.github.moocshop.bean.home.DataList;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CourseAdapter extends BaseAdapter {
    private static final int CARD_TYPE_COUNT = 4;

    private static final int CARD_VIDEO_TYPE = 0;
    private static final int CARD_TYPE_ONE = 1;
    private static final int CARD_TYPE_TWO = 2;
    private static final int CARD_TYPE_THREE = 3;

    /**
     * Data
     */
    private ArrayList<DataList> list;
    private Context context;
    private LayoutInflater inflater;
    private ViewHolder viewHolder;


    public CourseAdapter(ArrayList<DataList> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public DataList getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        int type = getItem(position).type;
        return type;
    }

    @Override
    public int getViewTypeCount() {
        return CARD_TYPE_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        DataList data = getItem(position);
        if (convertView == null) {
            switch (type){
                    case CARD_TYPE_ONE:
                            viewHolder = new ViewHolder();
                            convertView = inflater.inflate(R.layout.item_home_request_one_layout,parent,false);
                            viewHolder.circleImageView = convertView.findViewById(R.id.item_logo_view);
                            viewHolder.itemFootView = convertView.findViewById(R.id.item_footer_view);
                            viewHolder.itemFromView = convertView.findViewById(R.id.item_from_view);
                            viewHolder.itemZanView = convertView.findViewById(R.id.item_zan_view);
                            viewHolder.productLayout = convertView.findViewById(R.id.item_product_layout);
                            viewHolder.productPhotoLayout = convertView.findViewById(R.id.product_photo_layout);
                        break;

                }
                convertView.setTag(viewHolder);
        }else {
                viewHolder = (ViewHolder) convertView.getTag();
        }

        switch (type){
            case CARD_TYPE_ONE:
                viewHolder.itemFromView.setText(data.from);
                viewHolder.itemZanView.setText(data.zan);
                break;
        }
        return convertView;
    }

    /**
     * 静态内部类的作用
     * 1 因为内部类一般只被该内部类的外部类所调用，所以直接写为内部类，而没必要写单独的java文件
     * 2 静态：可以直接使用 类名+变量名进行赋值
     * 3 用ViewHolder 可以减少view的创建，因为getView 方法会被调用很多次，如果每次都新建View会造成界面卡顿
     */
    public static class ViewHolder{

        private CircleImageView circleImageView;
        private TextView itemTitleView;
        private TextView itemPriceView;
        private TextView itemInfoView;
        private HorizontalScrollView productLayout;
        private LinearLayout productPhotoLayout;
        private TextView itemFootView;
        private TextView itemFromView;
        private TextView itemZanView;
    }

    public void setDatas(ArrayList<DataList> list){
        this.list = list;
    }
}
