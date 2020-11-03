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
import com.cn.beisanproject.activity.AssertCzDetailActivity;
import com.cn.beisanproject.modelbean.AssertCheckCzListBean;

import java.util.List;

/**
 * Created by tzl
 * on 2020/11/2
 */
public class AsseertCheckCzAdapter extends RecyclerView.Adapter<AsseertCheckCzAdapter.MyViewholder> {
    private Context mContext;
    private List<AssertCheckCzListBean.ResultBean.ResultlistBean> mList;
    private String mHightlight;
    public AsseertCheckCzAdapter(Context context, List<AssertCheckCzListBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
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
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "申请单号: " + mList.get(position).getFIXEASSETRETNUM(), mHightlight, "#00ff00", 0, 0);
        holder.tv_check_no.setText(highlightNo);
        holder.tv_statues.setVisibility(View.VISIBLE);
        holder.tv_statues.setText(mList.get(position).getSTATUS());
        SpannableString highlightDesc = HighLightUtils.highlight(mContext, "描述: " + mList.get(position).getDESCRIPTION(), mHightlight, "#00ff00", 0, 0);
        holder.tv_check_desc.setText(highlightDesc);
        holder.tv_check_by.setText("创建人: " + mList.get(position).getENTERBY());
        holder.tv_check_starttime.setText("申请日期: " + mList.get(position).getENTERDATE());
        holder.tv_check_endtime.setText("申请事由: " + mList.get(position).getREASON());
        holder.tv_created_by.setText("管理部门: " + mList.get(position).getMANAGEMENT());
        holder.tv_created_time.setVisibility(View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击跳转至盘点详情
                Intent intent = new Intent(mContext, AssertCzDetailActivity.class);
                intent.putExtra("ResultlistBean", mList.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public void addAllList(List<AssertCheckCzListBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }


    public void setData(List<AssertCheckCzListBean.ResultBean.ResultlistBean> list, String hightlight) {
        mList = list;
        mHightlight = hightlight;
    }
    public static class MyViewholder extends RecyclerView.ViewHolder {
        private final TextView tv_check_no;
        TextView tv_statues;
        private final TextView tv_check_desc;
        private final TextView tv_check_by;
        private final TextView tv_check_starttime;
        private final TextView tv_check_endtime;
        private final TextView tv_created_by;
        private final TextView tv_created_time;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            tv_check_no = itemView.findViewById(R.id.tv_check_no);
            tv_statues=itemView.findViewById(R.id.tv_statues);
            tv_check_desc = itemView.findViewById(R.id.tv_check_desc);
            tv_check_by = itemView.findViewById(R.id.tv_check_by);
            tv_check_starttime = itemView.findViewById(R.id.tv_check_starttime);
            tv_check_endtime = itemView.findViewById(R.id.tv_check_endtime);
            tv_created_by = itemView.findViewById(R.id.tv_created_by);
            tv_created_time = itemView.findViewById(R.id.tv_created_time);
        }
    }
}
