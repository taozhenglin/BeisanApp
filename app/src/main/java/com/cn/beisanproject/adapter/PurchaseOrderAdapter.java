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
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.activity.PurchaseContractDetailActivity;
import com.cn.beisanproject.activity.PurchaseOrderDetailActivity;
import com.cn.beisanproject.activity.PurchaseOrderListActivity;
import com.cn.beisanproject.modelbean.PurchaseMonthPlanListBean;
import com.cn.beisanproject.modelbean.PurchaseOrderListBean;
import com.cn.beisanproject.modelbean.PurchseContractListBean;

import java.util.List;

public class PurchaseOrderAdapter extends RecyclerView.Adapter<PurchaseOrderAdapter.MyViewHolder>{
    private Context mContext;
    private List<PurchaseOrderListBean.ResultBean.ResultlistBean> mList;
    private String mHightlight;
    public PurchaseOrderAdapter(Context context, List<PurchaseOrderListBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
        mContext=context;
        mList=resultlist;
        mHightlight=hightlight;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LogUtils.d("onCreateViewHolder==");
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_purchase_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        LogUtils.d("onBindViewHolder==");
        SpannableString highlightno = HighLightUtils.highlight(mContext, "合同编号：" + mList.get(position).getCONTRACTNUM(), mHightlight, "#00ff00", 0, 0);

        holder.tv_contract_no.setText(highlightno);
        SpannableString highlightdes = HighLightUtils.highlight(mContext, "合同描述：" + mList.get(position).getDESCRIPTION(), mHightlight, "#00ff00", 0, 0);
        holder.tv_contract_desc.setText(highlightdes);


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
        holder.tv_contract_count.setText("合同金额："+mList.get(position).getTOTALCOST());
        holder.tv_contract_jia.setText("甲方："+mList.get(position).getHTJF());
        SpannableString highlightYi= HighLightUtils.highlight(mContext, "乙方：" + mList.get(position).getHTYF(), mHightlight, "#00ff00", 0, 0);
        holder.tv_contract_yi.setText(highlightYi);
        holder.tv_contract_starttime.setText("开始时间："+mList.get(position).getSTARTDATE());
        holder.tv_contract_endtime.setText("结束时间："+mList.get(position).getENDDATE());
        holder.tv_contract_by.setText("合同编制人："+mList.get(position).getENTERBY());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转至合同详情页
                Intent intent=new Intent(mContext, PurchaseOrderDetailActivity.class);
                intent.putExtra("ResultlistBean",mList.get(position));
                mContext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        LogUtils.d("getItemCount=="+mList.size());
        return mList.size();
    }

    public void addAllList(List<PurchaseOrderListBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);

    }

    public void setData(List<PurchaseOrderListBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
        mList=resultlist;
        mHightlight=hightlight;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_contract_no;//合同编号
        TextView tv_statues;//合同状态;
        ImageView iv_contract_statue;
        TextView tv_contract_count;//合同金额
        TextView tv_contract_desc;//合同描述
        TextView tv_contract_jia;//合同甲方
        TextView tv_contract_yi;//合同乙方
        TextView tv_contract_starttime;//合同开始时间
        TextView tv_contract_endtime;//合同结束时间
        TextView tv_contract_by;//合同编制人


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            LogUtils.d("MyViewHolder==");

            tv_contract_no=itemView.findViewById(R.id.tv_contract_no);
            tv_statues=itemView.findViewById(R.id.tv_contract_statue);
            iv_contract_statue=itemView.findViewById(R.id.iv_contract_statue);
            tv_contract_count=itemView.findViewById(R.id.tv_contract_count);
            tv_contract_desc=itemView.findViewById(R.id.tv_contract_desc);
            tv_contract_jia =itemView.findViewById(R.id.tv_contract_jia);
            tv_contract_yi =itemView.findViewById(R.id.tv_contract_yi);
            tv_contract_starttime=itemView.findViewById(R.id.tv_contract_starttime);
            tv_contract_endtime = itemView.findViewById(R.id.tv_contract_endtime);
            tv_contract_by=itemView.findViewById(R.id.tv_contract_by);


        }


    }
}
