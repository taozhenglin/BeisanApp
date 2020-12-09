package com.cn.beisanproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cn.beisanproject.R;
import com.cn.beisanproject.activity.PurchaseMonthPlanDetailActivity;
import com.cn.beisanproject.modelbean.PurchaseMonthPlanLineBean;

import java.util.List;

/**
 * Created by tzl
 * on 2020/12/2
 */
public class PurchaseMonthPlanLineAdapter extends RecyclerView.Adapter<PurchaseMonthPlanLineAdapter.MyViewHolder> {
    private  List<PurchaseMonthPlanLineBean.ResultBean.ResultlistBean> mList;
    private Context mContext;

    public PurchaseMonthPlanLineAdapter(Context context, List<PurchaseMonthPlanLineBean.ResultBean.ResultlistBean> list) {
        this.mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.purchase_month_plan_line_item, parent,false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_line_no.setText("计划行：" + mList.get(position).getPRLINENUM());
        holder.tv_wuzi_no.setText("物资编码：" + mList.get(position).getITEMNUM());
        holder.tv_line_desc.setText("物资描述：" + mList.get(position).getDESCRIPTION());
        holder.tv_model.setText("规格型号：" + mList.get(position).getA_MODEL());
        holder.tv_unit.setText("订购单位：" + mList.get(position).getORDERUNIT());
        holder.tv_count.setText("数量：" + mList.get(position).getORDERQTY());
        holder.tv_note.setText("备注：" + mList.get(position).getREMARK());
        holder.tv_unit_cost.setText("单位成本：" + mList.get(position).getUNITCOST());
        holder.tv_line_cost.setText("行成本：" + mList.get(position).getLINECOST());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<PurchaseMonthPlanLineBean.ResultBean.ResultlistBean> resultlist) {
        mList=resultlist;
    }

    public void addAllList(List<PurchaseMonthPlanLineBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_line_no;
        TextView tv_wuzi_no;
        TextView tv_line_desc;
        TextView tv_model;
        TextView tv_unit;
        TextView tv_count;
        TextView tv_note;
        TextView tv_unit_cost;
        TextView tv_line_cost;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
             tv_line_no = itemView.findViewById(R.id.tv_line_no);
             tv_wuzi_no = itemView.findViewById(R.id.tv_wuzi_no);
             tv_line_desc = itemView.findViewById(R.id.tv_line_desc);
             tv_model = itemView.findViewById(R.id.tv_model);
             tv_unit = itemView.findViewById(R.id.tv_unit);
             tv_count = itemView.findViewById(R.id.tv_count);
             tv_note = itemView.findViewById(R.id.tv_note);
             tv_unit_cost = itemView.findViewById(R.id.tv_unit_cost);
             tv_line_cost = itemView.findViewById(R.id.tv_line_cost);
        }
    }
}
