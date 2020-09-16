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
import com.cn.beisanproject.activity.SupplierDetailActivity;
import com.cn.beisanproject.activity.SupplierListActivity;
import com.cn.beisanproject.modelbean.PurchseContractListBean;
import com.cn.beisanproject.modelbean.SupplierListBean;

import java.util.List;

public class SupplierAdapter extends RecyclerView.Adapter<SupplierAdapter.MyViewHolder> {

    private  String mHightLight;
    private Context mContext;
    private List<SupplierListBean.ResultBean.ResultlistBean> mResultlist;

    public SupplierAdapter(Context context, List<SupplierListBean.ResultBean.ResultlistBean> resultlist,String hightlight) {
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
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "申请编号：" + mResultlist.get(position).getVENDORSAPPLYID(), mHightLight, "#00ff00", 0, 0);
        holder.tv_contract_no.setText(highlightNo);
        SpannableString highlightdes = HighLightUtils.highlight(mContext, "供应商编码：" + mResultlist.get(position).getVENDORSCODE(), mHightLight, "#00ff00", 0, 0);
        holder.tv_contract_desc.setText(highlightdes);
        holder.tv_contract_statue.setText(mResultlist.get(position).getSTATUS());
        SpannableString highlightName = HighLightUtils.highlight(mContext, "供应商名称：" + mResultlist.get(position).getNAME(), mHightLight, "#00ff00", 0, 0);
        holder.tv_contract_count.setText(highlightName);
        holder.tv_contract_jia.setVisibility(View.GONE);
        holder.tv_contract_yi.setVisibility(View.GONE);
        holder.tv_contract_starttime.setText("申请人员："+mResultlist.get(position).getAPPLICANT());
        holder.tv_contract_endtime.setText("是否发送管控平台："+mResultlist.get(position).getSENDFLAG());
        holder.tv_contract_by.setText("申请时间："+mResultlist.get(position).getAPPLYDATE());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转至合同详情页
                Intent intent=new Intent(mContext, SupplierDetailActivity.class);
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

    public void addAllList(List<SupplierListBean.ResultBean.ResultlistBean> resultlist) {
        mResultlist.addAll(resultlist);

    }

    public void setData(List<SupplierListBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
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
