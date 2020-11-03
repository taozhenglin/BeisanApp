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
import com.cn.beisanproject.activity.ProjectEnquiryDetailActivity;
import com.cn.beisanproject.activity.PurchaseEnquiryDetailActivity;
import com.cn.beisanproject.activity.PurchaseListDetailActivity;
import com.cn.beisanproject.modelbean.PurchaseListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PurchaseAdapter extends RecyclerView.Adapter<PurchaseAdapter.MyViewHolder>{
    private final String mFrom;
    private  Context mContext;
    private  List<PurchaseListBean.ResultBean.ResultlistBean> mList;
    private  String mHightLight;

    public PurchaseAdapter(Context context, List<PurchaseListBean.ResultBean.ResultlistBean> resultlist, String hightlight,String from) {
        mContext=context;
        mList=resultlist;
        mHightLight=hightlight;
        mFrom=from;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(mContext).inflate(R.layout.project_month_list,parent,false);
        return new MyViewHolder(inflate);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "入库单：" + mList.get(position).getPONUM(), mHightLight, "#00ff00", 0, 0);
        holder.tvProjectRequest.setText(highlightNo);
        SpannableString highlightDesc = HighLightUtils.highlight(mContext, "描述：" + mList.get(position).getDESCRIPTION(), mHightLight, "#00ff00", 0, 0);
        if (mList.get(position).getSTATUS().equals("已批准")) {
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.permitted2));
            holder.tvStatue.setVisibility(View.GONE);
            holder.tvStatue.setBackgroundDrawable(null);

        }else  if (mList.get(position).getSTATUS().equals("驳回")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.reject));
            holder.tvStatue.setVisibility(View.GONE);
            holder.tvStatue.setBackgroundDrawable(null);

        }else  if (mList.get(position).getSTATUS().equals("取消")||mList.get(position).getSTATUS().equals("已取消")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.canceled));
            holder.tvStatue.setVisibility(View.GONE);
            holder.tvStatue.setBackgroundDrawable(null);

        }else  if (mList.get(position).getSTATUS().equals("完成")||mList.get(position).getSTATUS().equals("已完成")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.finished));
            holder.tvStatue.setVisibility(View.GONE);
            holder.tvStatue.setBackgroundDrawable(null);
        }
        else {
            holder.iv_contract_statue.setVisibility(View.GONE);
            holder.tvStatue.setVisibility(View.VISIBLE);
            holder.tvStatue.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.blue_shape_20));
            holder.tvStatue.setText(mList.get(position).getSTATUS());

        }
        holder.tvDesc.setText(highlightDesc);
        holder.tvHuizongDate.setText("采购员："+mList.get(position).getSHIPTOATTN());
        holder.tvSumAmount.setVisibility(View.GONE);
        holder.tvDept.setText("供应商："+mList.get(position).getVENDORDESC());
        holder.tvRequsetDep.setVisibility(View.GONE);
        holder.tvCreatedBy.setVisibility(View.GONE);
        holder.tvCreatedTime.setVisibility(View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFrom.equals("PurchaseEnquiryListActivity")){//来自采购询价list  跳转至采购询价详情
                    Intent intent=new Intent(mContext, PurchaseListDetailActivity.class);
                    intent.putExtra("ResultlistBean",mList.get(position));
                    mContext.startActivity(intent);
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<PurchaseListBean.ResultBean.ResultlistBean> resultlist, String toString) {
        mList=resultlist;
        mHightLight=toString;
    }

    public void addAllList(List<PurchaseListBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_project_request)
        TextView tvProjectRequest;
        @BindView(R.id.tv_statue)
        TextView tvStatue;
        @BindView(R.id.iv_contract_statue)
        ImageView iv_contract_statue;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.tv_huizong_date)
        TextView tvHuizongDate;
        @BindView(R.id.tv_sum_amount)
        TextView tvSumAmount;
        @BindView(R.id.tv_dept)
        TextView tvDept;
        @BindView(R.id.tv_requset_dep)
        TextView tvRequsetDep;
        @BindView(R.id.tv_created_by)
        TextView tvCreatedBy;
        @BindView(R.id.tv_created_time)
        TextView tvCreatedTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
