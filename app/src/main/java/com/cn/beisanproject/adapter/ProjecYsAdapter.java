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
import com.cn.beisanproject.activity.ProjectYsDetailActivity;
import com.cn.beisanproject.activity.ProjectYsListActivity;
import com.cn.beisanproject.modelbean.ProjectYsListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tzl
 * on 2020/11/11
 */
public class ProjecYsAdapter extends RecyclerView.Adapter<ProjecYsAdapter.MyViewHolder> {


    private Context mContext;
    private List<ProjectYsListBean.ResultBean.ResultlistBean> mList;
    private String mHight;

    public ProjecYsAdapter(ProjectYsListActivity context, List<ProjectYsListBean.ResultBean.ResultlistBean> resultlist, String s) {
        mContext = context;
        mList = resultlist;
        mHight = s;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.project_ys_list_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SpannableString highlightNum = HighLightUtils.highlight(mContext, "验收编号：" + mList.get(position).getUDPRYSNUM(), mHight, "#00ff00", 0, 0);
        holder.tvYsNo.setText(highlightNum);
        if (mList.get(position).getSTATUS().equals("已批准")) {
            holder.ivContractStatue.setVisibility(View.VISIBLE);
            holder.ivContractStatue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.permitted2));
            holder.tvStatues.setVisibility(View.GONE);
            holder.tvStatues.setBackgroundDrawable(null);

        }else  if (mList.get(position).getSTATUS().equals("驳回")){
            holder.ivContractStatue.setVisibility(View.VISIBLE);
            holder.ivContractStatue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.reject));
            holder.tvStatues.setVisibility(View.GONE);
            holder.tvStatues.setBackgroundDrawable(null);

        }else  if (mList.get(position).getSTATUS().equals("取消")||mList.get(position).getSTATUS().equals("已取消")){
            holder.ivContractStatue.setVisibility(View.VISIBLE);
            holder.ivContractStatue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.canceled));
            holder.tvStatues.setVisibility(View.GONE);
            holder.tvStatues.setBackgroundDrawable(null);

        }else  if (mList.get(position).getSTATUS().equals("完成")||mList.get(position).getSTATUS().equals("已完成")){
            holder.ivContractStatue.setVisibility(View.VISIBLE);
            holder.ivContractStatue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.finished));
            holder.tvStatues.setVisibility(View.GONE);
            holder.tvStatues.setBackgroundDrawable(null);
        }
        else {
            holder.ivContractStatue.setVisibility(View.GONE);
            holder.tvStatues.setVisibility(View.VISIBLE);
            holder.tvStatues.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.blue_shape_20));
            holder.tvStatues.setText(mList.get(position).getSTATUS());

        }
        SpannableString highlightDesc = HighLightUtils.highlight(mContext, "描述：" + mList.get(position).getDESCRIPTION(), mHight, "#00ff00", 0, 0);
        holder.tvDes.setText(highlightDesc);
        holder.tvConDes.setText("合同描述：" + mList.get(position).getCONTRACTDESC());
        holder.tvCost.setText("结算金额：" + mList.get(position).getCONTCOST());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ProjectYsDetailActivity.class);
                intent.putExtra("ResultlistBean", mList.get(position));
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<ProjectYsListBean.ResultBean.ResultlistBean> resultlist, String toString) {
        mList = resultlist;
        mHight = toString;
    }

    public void addAllList(List<ProjectYsListBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_ys_no)
        TextView tvYsNo;
        @BindView(R.id.tv_statues)
        TextView tvStatues;
        @BindView(R.id.tv_des)
        TextView tvDes;
        @BindView(R.id.tv_con_des)
        TextView tvConDes;
        @BindView(R.id.tv_cost)
        TextView tvCost;
        @BindView(R.id.iv_contract_statue)
        ImageView ivContractStatue;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
