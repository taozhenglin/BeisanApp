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
import com.cn.beisanproject.Utils.LogUtils;
import com.cn.beisanproject.activity.PurchaseContractDetailActivity;
import com.cn.beisanproject.modelbean.PurchseContractListBean;

import java.util.List;

public class PurchseContractAdapter extends RecyclerView.Adapter<PurchseContractAdapter.MyViewHolder> {
    private  String mHightLight;
    private Context mContext;
    private List<PurchseContractListBean.ResultBean.ResultlistBean> mResultlist;

    public PurchseContractAdapter(Context context, List<PurchseContractListBean.ResultBean.ResultlistBean> resultlist,String hightlight) {
        LogUtils.d("PurchseContractAdapter=="+PurchseContractAdapter.class);
        this.mContext = context;
        this.mResultlist = resultlist;
        this.mHightLight=hightlight;
        LogUtils.d("mResultlist =="+mResultlist.size());

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
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "合同编号：" + mResultlist.get(position).getCONTRACTNUM(), mHightLight, "#00ff00", 0, 0);
        holder.tv_contract_no.setText(highlightNo);
        SpannableString highlightdes = HighLightUtils.highlight(mContext, "合同描述：" + mResultlist.get(position).getDESCRIPTION(), mHightLight, "#00ff00", 0, 0);
        holder.tv_contract_desc.setText(highlightdes);

        holder.tv_contract_statue.setText(mResultlist.get(position).getSTATUS());
        holder.tv_contract_count.setText("合同金额："+mResultlist.get(position).getTOTALCOST());
        holder.tv_contract_jia.setText("甲方："+mResultlist.get(position).getHTJF());
        SpannableString highlighty = HighLightUtils.highlight(mContext, "乙方：" + mResultlist.get(position).getHTYF(), mHightLight, "#00ff00", 0, 0);

        holder.tv_contract_yi.setText(highlighty);
        holder.tv_contract_starttime.setText("开始时间："+mResultlist.get(position).getSTARTDATE());
        holder.tv_contract_endtime.setText("结束时间："+mResultlist.get(position).getENDDATE());
        holder.tv_contract_by.setText("合同编制人："+mResultlist.get(position).getENTERBY());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转至合同详情页
                Intent intent=new Intent(mContext, PurchaseContractDetailActivity.class);
                intent.putExtra("ResultlistBean",mResultlist.get(position));
                mContext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        LogUtils.d("getItemCount=="+mResultlist.size());
        return mResultlist.size();
    }

    public void addAllList(List<PurchseContractListBean.ResultBean.ResultlistBean> resultlist) {
        mResultlist.addAll(resultlist);

    }

    public void setData(List<PurchseContractListBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
        mResultlist=resultlist;
        mHightLight=hightlight;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_contract_no;//合同编号
        TextView tv_contract_statue;//合同状态;
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
            tv_contract_statue=itemView.findViewById(R.id.tv_contract_statue);
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
