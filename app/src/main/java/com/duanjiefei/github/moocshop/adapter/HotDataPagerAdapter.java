package com.duanjiefei.github.moocshop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duanjiefei.github.moocshop.R;
import com.duanjiefei.github.moocshop.bean.home.DataList;
import com.duanjiefei.github.moocshop.utils.GlideImageUtils;

import java.util.ArrayList;

public class HotDataPagerAdapter extends PagerAdapter {
    private ArrayList<DataList> dataLists;
    private LayoutInflater inflater;
    private GlideImageUtils imageUtils;
    private Context context;

    public HotDataPagerAdapter(ArrayList<DataList> dataLists, Context context) {
        this.dataLists = dataLists;
        this.context = context;
        inflater = LayoutInflater.from(context);
        imageUtils = GlideImageUtils.getInstance();
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        DataList data = dataLists.get(position%dataLists.size());
        View root = inflater.inflate(R.layout.item_hot_product_pager_layout,null);
        TextView hot_tittle_view= root.findViewById(R.id.title_view);
        TextView hot_info_view= root.findViewById(R.id.info_view);
        TextView hot_gonggao_view_view= root.findViewById(R.id.gonggao_view);
        ImageView[] imageViews = new ImageView[3];
        imageViews[0] = root.findViewById(R.id.image_one);
        imageViews[1] = root.findViewById(R.id.image_two);
        imageViews[2] = root.findViewById(R.id.image_three);

        TextView sale_num_view = root.findViewById(R.id.sale_num_view);

        hot_tittle_view.setText(data.title);
        hot_info_view.setText(data.price);
        hot_gonggao_view_view.setText(data.info);
        sale_num_view.setText(data.text);
        for (int i=0;i<imageViews.length;i++){
            imageUtils.showImageView(context,R.drawable.default_user_avatar,data.url.get(i),imageViews[i]);
        }
        container.addView(root,0);
        return root;
    }
}
