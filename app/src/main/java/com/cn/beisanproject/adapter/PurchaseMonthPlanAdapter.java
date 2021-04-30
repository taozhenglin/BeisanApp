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
import com.cn.beisanproject.activity.ProjectMonthDetailActivity;
import com.cn.beisanproject.activity.PurchaseMonthPlanDetailActivity;
import com.cn.beisanproject.modelbean.ProjectMonthListBean;
import com.cn.beisanproject.modelbean.PurchaseMonthPlanListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PurchaseMonthPlanAdapter extends RecyclerView.Adapter<PurchaseMonthPlanAdapter.MyViewHolder> {
    private Context mContext;
    private List<PurchaseMonthPlanListBean.ResultBean.ResultlistBean> mList;
    private String mHightlight;

    public PurchaseMonthPlanAdapter(Context context, List<PurchaseMonthPlanListBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
        this.mContext = context;
        this.mList = resultlist;
        this.mHightlight = hightlight;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.purchase_month_plan_list, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "项目申请：" + mList.get(position).getPRNUM(), mHightlight, "#00ff00", 0, 0);
        holder.tvProjectRequest.setText(highlightNo);
        holder.tvStatue.setText(mList.get(position).getSTATUS());
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
        SpannableString highlightDesc = HighLightUtils.highlight(mContext, "描述："+mList.get(position).getDESCRIPTION(), mHightlight, "#00ff00", 0, 0);
        holder.tvDesc.setText(highlightDesc);
        holder.tvHuizongStatue.setText("汇总状态"+mList.get(position).getR_PRSTATUS());
        holder.tvRequestType.setText("申请类型:"+mList.get(position).getA_PURTYPE());
        holder.tvHuizongDate.setText("汇总年月:"+mList.get(position).getA_PRKEY());
        holder.tvSumAmount.setText("总金额："+mList.get(position).getTOTALCOST());
        holder.tvDept.setText("主管部门："+mList.get(position).getA_DEPT());
        holder.tvRequsetDep.setText("申请部门："+mList.get(position).getA_DEPT());
        holder.tvCreatedBy.setText("创建人："+mList.get(position).getR_DEPTDESC());
        holder.tvCreatedTime.setText("创建时间："+mList.get(position).getISSUEDATE());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进入详情页面
                Intent intent=new Intent(mContext, PurchaseMonthPlanDetailActivity.class);
                intent.putExtra("ResultlistBean",mList.get(position));
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<PurchaseMonthPlanListBean.ResultBean.ResultlistBean> resultlist, String toString) {
        mList = resultlist;
        mHightlight = toString;
    }

    public void addAllList(List<PurchaseMonthPlanListBean.ResultBean.ResultlistBean> resultlist) {
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
        @BindView(R.id.tv_huizong_statue)
        TextView tvHuizongStatue;
        @BindView(R.id.tv_request_type)
        TextView tvRequestType;
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
