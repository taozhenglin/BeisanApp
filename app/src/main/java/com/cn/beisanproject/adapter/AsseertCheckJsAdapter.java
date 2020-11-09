package com.cn.beisanproject.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.cn.beisanproject.activity.AssertJsDetailActivity;
import com.cn.beisanproject.modelbean.AssertCheckJsListBean;

import java.util.List;

/**
 * Created by tzl
 * on 2020/11/2
 */
public class AsseertCheckJsAdapter extends RecyclerView.Adapter<AsseertCheckJsAdapter.MyViewholder> {
    private Context mContext;
    private List<AssertCheckJsListBean.ResultBean.ResultlistBean> mList;
    private String mHightlight;

    public AsseertCheckJsAdapter(Context context, List<AssertCheckJsListBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
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
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "接收单号: " + mList.get(position).getFIXEDASSETJSNUM(), mHightlight, "#00ff00", 0, 0);
        holder.tv_check_no.setText(highlightNo);
        SpannableString highlightDesc = HighLightUtils.highlight(mContext, "接收描述: " + mList.get(position).getDESCRIPTION(), mHightlight, "#00ff00", 0, 0);
        holder.tv_check_desc.setText(highlightDesc);
        if (mList.get(position).getStatus().equals("已批准")) {
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.permitted2));
            holder.tv_statues.setVisibility(View.GONE);
            holder.tv_statues.setBackgroundDrawable(null);

        }else  if (mList.get(position).getStatus().equals("驳回")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.reject));
            holder.tv_statues.setVisibility(View.GONE);
            holder.tv_statues.setBackgroundDrawable(null);

        }else  if (mList.get(position).getStatus().equals("取消")||mList.get(position).getStatus().equals("已取消")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.canceled));
            holder.tv_statues.setVisibility(View.GONE);
            holder.tv_statues.setBackgroundDrawable(null);

        }else  if (mList.get(position).getStatus().equals("完成")||mList.get(position).getStatus().equals("已完成")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.finished));
            holder.tv_statues.setVisibility(View.GONE);
            holder.tv_statues.setBackgroundDrawable(null);
        }
        else {
            holder.iv_contract_statue.setVisibility(View.GONE);
            holder.tv_statues.setVisibility(View.VISIBLE);
            holder.tv_statues.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.blue_shape_20));
            holder.tv_statues.setText(mList.get(position).getStatus());

        }
        holder.tv_check_by.setText("创建人: " + mList.get(position).getENTERBY());
        holder.tv_check_starttime.setText("创建时间: " + mList.get(position).getENTERDATE());
        holder.tv_check_endtime.setText("接收类型: " + mList.get(position).getTYPE());
        holder.tv_created_by.setText("项目主管部门: " + mList.get(position).getDEPT());
        holder.tv_created_time.setVisibility(View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击跳转至盘点详情
                Intent intent = new Intent(mContext, AssertJsDetailActivity.class);
                intent.putExtra("ResultlistBean", mList.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addAllList(List<AssertCheckJsListBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }


    public void setData(List<AssertCheckJsListBean.ResultBean.ResultlistBean> list, String hightlight) {
        mList = list;
        mHightlight = hightlight;
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {
        private final TextView tv_check_no;
        private final TextView tv_check_desc;
        TextView tv_statues;
        ImageView iv_contract_statue;
        private final TextView tv_check_by;
        private final TextView tv_check_starttime;
        private final TextView tv_check_endtime;
        private final TextView tv_created_by;
        private final TextView tv_created_time;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            tv_check_no = itemView.findViewById(R.id.tv_check_no);
            tv_check_desc = itemView.findViewById(R.id.tv_check_desc);
            tv_statues = itemView.findViewById(R.id.tv_statues);
            iv_contract_statue= itemView.findViewById(R.id.iv_contract_statue);
            tv_check_by = itemView.findViewById(R.id.tv_check_by);
            tv_check_starttime = itemView.findViewById(R.id.tv_check_starttime);
            tv_check_endtime = itemView.findViewById(R.id.tv_check_endtime);
            tv_created_by = itemView.findViewById(R.id.tv_created_by);
            tv_created_time = itemView.findViewById(R.id.tv_created_time);
        }
    }
}
