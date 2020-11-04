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
import com.cn.beisanproject.activity.AssertDetailActivity;
import com.cn.beisanproject.activity.ProjectContractChangeActivity;
import com.cn.beisanproject.activity.ProjectContractChangeListActivity;
import com.cn.beisanproject.modelbean.ProjectContractChangeBean;

import java.util.List;

public class ProjectContractChangeAdapter extends RecyclerView.Adapter<ProjectContractChangeAdapter.MyViewHolder> {
    private  Context mContext;
    private  List<ProjectContractChangeBean.ResultBean.ResultlistBean> mList;
    private  String mHightlight;

    public ProjectContractChangeAdapter(Context context, List<ProjectContractChangeBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
        mContext=context;
        mList=resultlist;
        mHightlight=hightlight;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(mContext).inflate(R.layout.assert_list_item,parent,false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "合同变更号: " + mList.get(position).getUDBGNUM(), mHightlight, "#00ff00", 0, 0);
        holder.tv_check_no.setText(highlightNo);
        if (mList.get(position).getSTATUS().equals("已批准")) {
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.permitted2));
            holder.tv_statues.setVisibility(View.GONE);
            holder.tv_statues.setBackgroundDrawable(null);

        }else  if (mList.get(position).getSTATUS().equals("驳回")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.reject));
            holder.tv_statues.setVisibility(View.GONE);
            holder.tv_statues.setBackgroundDrawable(null);

        }else  if (mList.get(position).getSTATUS().equals("取消")||mList.get(position).getSTATUS().equals("已取消")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.canceled));
            holder.tv_statues.setVisibility(View.GONE);
            holder.tv_statues.setBackgroundDrawable(null);

        }else  if (mList.get(position).getSTATUS().equals("完成")||mList.get(position).getSTATUS().equals("已完成")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.finished));
            holder.tv_statues.setVisibility(View.GONE);
            holder.tv_statues.setBackgroundDrawable(null);
        }
        else {
            holder.iv_contract_statue.setVisibility(View.GONE);
            holder.tv_statues.setVisibility(View.VISIBLE);
            holder.tv_statues.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.blue_shape_20));
            holder.tv_statues.setText(mList.get(position).getSTATUS());

        }
        SpannableString highlightDesc = HighLightUtils.highlight(mContext, "描述: " + mList.get(position).getDESCRIPTION(), mHightlight, "#00ff00", 0, 0);
        holder.tv_check_desc.setText(highlightDesc);
        holder.tv_check_by.setText("合同编号: " + mList.get(position).getCONTRACTNUM());
        holder.tv_check_starttime.setText("合同描述: " + mList.get(position).getCONTRACTDESC());
        holder.tv_check_endtime.setVisibility(View.GONE);
        holder.tv_created_by.setText("创建人: " + mList.get(position).getCREATEBYDESC());
        holder.tv_created_time.setText("创建时间: " + mList.get(position).getCREATEDATE());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击跳转至盘点详情
                Intent intent = new Intent(mContext, ProjectContractChangeActivity.class);
                intent.putExtra("ResultlistBean", mList.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<ProjectContractChangeBean.ResultBean.ResultlistBean> resultlist, String toString) {
        mList=resultlist;
        mHightlight=toString;
    }

    public void addAllList(List<ProjectContractChangeBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_check_no;
        private final TextView tv_check_desc;
        private final TextView tv_statues;
        ImageView iv_contract_statue;
        private final TextView tv_check_by;
        private final TextView tv_check_starttime;
        private final TextView tv_check_endtime;
        private final TextView tv_created_by;
        private final TextView tv_created_time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_check_no = itemView.findViewById(R.id.tv_check_no);
            tv_statues = itemView.findViewById(R.id.tv_statues);
            iv_contract_statue=itemView.findViewById(R.id.iv_contract_statue);
            tv_check_desc = itemView.findViewById(R.id.tv_check_desc);
            tv_check_by = itemView.findViewById(R.id.tv_check_by);
            tv_check_starttime = itemView.findViewById(R.id.tv_check_starttime);
            tv_check_endtime = itemView.findViewById(R.id.tv_check_endtime);
            tv_created_by = itemView.findViewById(R.id.tv_created_by);
            tv_created_time = itemView.findViewById(R.id.tv_created_time);
        }
    }
}
