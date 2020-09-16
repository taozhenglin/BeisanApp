package com.cn.beisanproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.HighLightUtils;
import com.cn.beisanproject.activity.StockTakeDetailActivity;
import com.cn.beisanproject.modelbean.StockingTakeListBean;

import java.util.List;

public class StockingTakeAdapter extends RecyclerView.Adapter<StockingTakeAdapter.MyViewHolder> {
    private  Context mContext;
    private  List<StockingTakeListBean.ResultBean.ResultlistBean> mList;
    private  String mHightlight;

    public StockingTakeAdapter(Context context, List<StockingTakeListBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
        mContext=context;
        mList=resultlist;
        mHightlight=hightlight;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.assert_list_item, parent, false);
        return new MyViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "盘点单编号: " + mList.get(position).getSTOCKNUM(), mHightlight, "#00ff00", 0, 0);
        holder.tv_check_no.setText(highlightNo);
        SpannableString highlightDesc = HighLightUtils.highlight(mContext, "盘点描述: " + mList.get(position).getDESCRIPTION(), mHightlight, "#00ff00", 0, 0);
        holder.tv_check_desc.setText(highlightDesc);

        holder.tv_check_by.setVisibility(View.GONE);
        holder.tv_check_starttime.setText("盘点日期: " + mList.get(position).getPDDATE());
        holder.tv_check_endtime.setText("仓库: " + mList.get(position).getLOCATION());
        holder.tv_created_by.setText("创建人: " + mList.get(position).getCREATENAME());
        holder.tv_created_time.setText("创建时间: " + mList.get(position).getCREATEDATE());
//        if (mList.get(position).getHaschecked().equals("yes")){
//            holder.iv_haschecked.setVisibility(View.VISIBLE);
//        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击跳转至盘点详情
                Intent intent = new Intent(mContext, StockTakeDetailActivity.class);
                intent.putExtra("ResultlistBean", mList.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<StockingTakeListBean.ResultBean.ResultlistBean> resultlist, String toString) {
        mList=resultlist;
        mHightlight=toString;
    }
    public List<StockingTakeListBean.ResultBean.ResultlistBean>  getData() {
        return mList;
    }

    public void addAllList(List<StockingTakeListBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView tv_check_no;
        private final TextView tv_check_desc;
        private final TextView tv_check_by;
        private final TextView tv_check_starttime;
        private final TextView tv_check_endtime;
        private final TextView tv_created_by;
        private final TextView tv_created_time;
        private ImageView iv_haschecked;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_check_no = itemView.findViewById(R.id.tv_check_no);
            tv_check_desc = itemView.findViewById(R.id.tv_check_desc);
            tv_check_by = itemView.findViewById(R.id.tv_check_by);
            tv_check_starttime = itemView.findViewById(R.id.tv_check_starttime);
            tv_check_endtime = itemView.findViewById(R.id.tv_check_endtime);
            tv_created_by = itemView.findViewById(R.id.tv_created_by);
            tv_created_time = itemView.findViewById(R.id.tv_created_time);
            iv_haschecked = itemView.findViewById(R.id.iv_haschecked);
        }
    }
}
