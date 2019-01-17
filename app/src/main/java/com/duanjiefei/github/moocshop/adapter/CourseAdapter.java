package com.duanjiefei.github.moocshop.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duanjiefei.github.moocshop.R;
import com.duanjiefei.github.moocshop.bean.home.DataList;
import com.duanjiefei.github.moocshop.utils.GlideImageUtils;
import com.duanjiefei.github.moocshop.utils.Utils;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;



public class CourseAdapter extends BaseAdapter {
    private static final String TAG = "CourseAdapter";
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

    private GlideImageUtils imageUtils;


    public CourseAdapter(ArrayList<DataList> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        imageUtils = GlideImageUtils.getInstance();
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
        Log.d(TAG, "getView: type  == "+type);

        DataList data = getItem(position);
        //无tag时  要保证为每个type的类型的view 都装载布局文件，否则会出现空指针异常
        if (convertView == null) {
            switch (type) {
                case CARD_VIDEO_TYPE:
                    //显示video卡片
                    viewHolder = new ViewHolder();
                    convertView = inflater.inflate(R.layout.item_video_layout, parent, false);
                    break;
                case CARD_TYPE_ONE:
                    viewHolder = new ViewHolder();
                    convertView = inflater.inflate(R.layout.item_home_request_one_layout,parent,false);
                    viewHolder.itemInfoView  = convertView.findViewById(R.id.item_info_view);
                    viewHolder.itemPriceView = convertView.findViewById(R.id.item_price_view);
                    viewHolder.itemTitleView = convertView.findViewById(R.id.item_title_view);
                    viewHolder.circleImageView = convertView.findViewById(R.id.item_logo_view);
                    viewHolder.itemFootView = convertView.findViewById(R.id.item_footer_view);
                    viewHolder.itemFromView = convertView.findViewById(R.id.item_from_view);
                    viewHolder.itemZanView = convertView.findViewById(R.id.item_zan_view);
                    viewHolder.productLayout = convertView.findViewById(R.id.item_product_layout);
                    viewHolder.productPhotoLayout = convertView.findViewById(R.id.product_photo_layout);

                    break;
                case CARD_TYPE_TWO:
                    viewHolder = new ViewHolder();
                    convertView = inflater.inflate(R.layout.item_home_request_two_layout, parent, false);
                    break;
                case CARD_TYPE_THREE:
                    viewHolder = new ViewHolder();
                    convertView = inflater.inflate(R.layout.item_home_request_three_layout, null, false);
                    break;
            }
            convertView.setTag(viewHolder);
        }//有tag时
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Log.d(TAG, "convertView: getId  == "+convertView.getId());
        Log.d(TAG, "convertView: getId  == "+convertView);
        //填充item的数据
        switch (type) {
            case CARD_VIDEO_TYPE:
                break;
            case CARD_TYPE_ONE:
                imageUtils.showImageView(context,R.drawable.default_user_avatar,data.logo,viewHolder.circleImageView);
                viewHolder.itemTitleView.setText(data.title);
                viewHolder.itemPriceView.setText(data.price);
                viewHolder.itemInfoView.setText(data.info);
                viewHolder.itemFootView.setText(data.text);
                viewHolder.itemFromView.setText(data.from);
                viewHolder.itemZanView.setText(data.zan);
                viewHolder.productPhotoLayout.removeAllViews();//先清除所有的子View
                for (String url: data.url){
                    viewHolder.productPhotoLayout.addView(addImageView(url));
                }
                break;
            case CARD_TYPE_TWO:
                break;
            case CARD_TYPE_THREE:
                break;
        }
        return convertView;
    }

    private ImageView addImageView(String url) {
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    Utils.dip2px(context, 100),
                    LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.leftMargin = Utils.dip2px(context, 5);
        imageView.setLayoutParams(layoutParams);
        imageUtils.showImageView(context,R.drawable.default_user_avatar,url,imageView);
        return imageView;
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
