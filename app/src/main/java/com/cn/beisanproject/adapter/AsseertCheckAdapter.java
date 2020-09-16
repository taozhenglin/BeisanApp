package com.cn.beisanproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.HighLightUtils;
import com.cn.beisanproject.activity.AssertDetailActivity;
import com.cn.beisanproject.modelbean.AssertCheckListBean;

import java.util.List;

public class AsseertCheckAdapter extends RecyclerView.Adapter<AsseertCheckAdapter.MyViewholder> {
    private Context mContext;
    private List<AssertCheckListBean.ResultBean.ResultlistBean> mList;
    private String mHightlight;

    public AsseertCheckAdapter(Context context, List<AssertCheckListBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
        this.mContext = context;
        this.mList = resultlist;
        this.mHightlight = hightlight;

    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.assert_list_item, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, final int position) {
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "盘点单编号: " + mList.get(position).getFIXPDNUM(), mHightlight, "#00ff00", 0, 0);
        holder.tv_check_no.setText(highlightNo);
        SpannableString highlightDesc = HighLightUtils.highlight(mContext, "盘点备注: " + mList.get(position).getMEMO(), mHightlight, "#00ff00", 0, 0);
        holder.tv_check_desc.setText(highlightDesc);
        holder.tv_check_by.setText("盘点人: " + mList.get(position).getPDUSERDESC());
        holder.tv_check_starttime.setText("盘点开始时间: " + mList.get(position).getSTARTDATE());
        holder.tv_check_endtime.setText("盘点结束时间: " + mList.get(position).getENDDATE());
        holder.tv_created_by.setText("创建人: " + mList.get(position).getPDUSER());
        holder.tv_created_time.setText("创建时间: " + mList.get(position).getPDZTDATE());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击跳转至盘点详情
                Intent intent = new Intent(mContext, AssertDetailActivity.class);
                intent.putExtra("ResultlistBean", mList.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addAllList(List<AssertCheckListBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }

    public int getListSize() {
        return mList.size();
    }

    public void setData(List<AssertCheckListBean.ResultBean.ResultlistBean> list, String hightlight) {
        mList = list;
        mHightlight = hightlight;
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {
        private final TextView tv_check_no;
        private final TextView tv_check_desc;
        private final TextView tv_check_by;
        private final TextView tv_check_starttime;
        private final TextView tv_check_endtime;
        private final TextView tv_created_by;
        private final TextView tv_created_time;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            tv_check_no = itemView.findViewById(R.id.tv_check_no);
            tv_check_desc = itemView.findViewById(R.id.tv_check_desc);
            tv_check_by = itemView.findViewById(R.id.tv_check_by);
            tv_check_starttime = itemView.findViewById(R.id.tv_check_starttime);
            tv_check_endtime = itemView.findViewById(R.id.tv_check_endtime);
            tv_created_by = itemView.findViewById(R.id.tv_created_by);
            tv_created_time = itemView.findViewById(R.id.tv_created_time);
        }
    }
}
