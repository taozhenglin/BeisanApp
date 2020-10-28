package com.cn.beisanproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cn.beisanproject.R;
import com.cn.beisanproject.activity.AssertListItemDetailActivity;
import com.cn.beisanproject.modelbean.AssertCheckListBean;
import com.cn.beisanproject.modelbean.AssertDetailLineBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssertDetailLineAdapter extends RecyclerView.Adapter<AssertDetailLineAdapter.MyViewHolder> {

    private final String mTag;
    private Context mContext;
    private List<AssertDetailLineBean.ResultBean.ResultlistBean> mList;
    private  AssertCheckListBean.ResultBean.ResultlistBean mResultlistBean;

    public AssertDetailLineAdapter(Context context, List<AssertDetailLineBean.ResultBean.ResultlistBean> resultlist, String tag, AssertCheckListBean.ResultBean.ResultlistBean resultlistBean) {
        this.mContext = context;
        this.mList = resultlist;
        this.mTag = tag;
        this.mResultlistBean=resultlistBean;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.asseert_line_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvAssertName.setText("固定资产名称:" + mList.get(position).getDESCRIPTION());
        holder.tvAssertAdmin.setText("资产管理员:" + mList.get(position).getADMINISTRATOR());
        holder.tvDepartment.setText("使用部门:" + mList.get(position).getDEPARTMENT());
        holder.tvShiyongStatue.setText("使用情况:" + mList.get(position).getSYQK());
        holder.tvShiyongPeople.setText("使用人:" + mList.get(position).getDISPLAYNAME());
        holder.tvShigongDeparment.setText("施工单位:" + mList.get(position).getSGCOM());
        holder.tvProjectDeparment.setText("项目主办方:" + mList.get(position).getMANAGEMENT());
        holder.tvOwnerCompanny.setText("所属公司:" + mList.get(position).getOWNERSITE());
        holder.tvAssertType.setText("固定资产类别:" + mList.get(position).getASSETTYPE());
        holder.tvXinghao.setText("固定资产型号:" + mList.get(position).getPRODUCTMODEL());
        holder.tvCountDate.setText("财务入账时间:" + mList.get(position).getFIXASSETDATE());
        holder.tvBuyTime.setText("购买时间:" + mList.get(position).getDATEOFPURCHASE());
        holder.tvStartTime.setText("启用时间:" + mList.get(position).getDATEPLACEDINSERVICE());
        holder.tvStoreAddress.setText("存放地点:" + mList.get(position).getCFDD());
        holder.tvZhejiu.setText("折旧年限:" + mList.get(position).getDEPRECIATIONPERIOD());
        holder.tvOriginValue.setText("资产原值:" + mList.get(position).getCOST());
        holder.tvHasChecked.setText("是否已盘点:" + mList.get(position).getYPD());
        holder.tvPdhcfdd.setText("盘点后存放地点:"+mList.get(position).getPDJGCFWZ());
        holder.tvPdhsybm.setText("盘点后使用部门:"+mList.get(position).getPDHSYBM());

        if (!mTag.equals("diff")) {
            holder.ivModify.setVisibility(View.VISIBLE);
            if (mList.get(position).getYPD().equals("Y")) {
                holder.ivHaschecked.setVisibility(View.VISIBLE);
            } else {
                holder.ivHaschecked.setVisibility(View.GONE);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mTag.equals("diff")) {
                    mContext.startActivity(new Intent(mContext, AssertListItemDetailActivity.class).putExtra("resultlistBean", mResultlistBean).putExtra("data", mList.get(position)).putExtra("from","AssertDetailLineAdapter"));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<AssertDetailLineBean.ResultBean.ResultlistBean> resultlist) {
        mList = resultlist;
    }

    public void addAllList(List<AssertDetailLineBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_assert_name)
        TextView tvAssertName;
        @BindView(R.id.tv_assert_admin)
        TextView tvAssertAdmin;
        @BindView(R.id.tv_department)
        TextView tvDepartment;
        @BindView(R.id.tv_shiyong_statue)
        TextView tvShiyongStatue;
        @BindView(R.id.tv_shiyong_people)
        TextView tvShiyongPeople;
        @BindView(R.id.tv_shigong_deparment)
        TextView tvShigongDeparment;
        @BindView(R.id.tv_project_deparment)
        TextView tvProjectDeparment;
        @BindView(R.id.tv_owner_companny)
        TextView tvOwnerCompanny;
        @BindView(R.id.tv_assert_type)
        TextView tvAssertType;
        @BindView(R.id.tv_xinghao)
        TextView tvXinghao;
        @BindView(R.id.tv_count_date)
        TextView tvCountDate;
        @BindView(R.id.tv_buy_time)
        TextView tvBuyTime;
        @BindView(R.id.tv_start_time)
        TextView tvStartTime;
        @BindView(R.id.tv_store_address)
        TextView tvStoreAddress;
        @BindView(R.id.tv_zhejiu)
        TextView tvZhejiu;
        @BindView(R.id.tv_origin_value)
        TextView tvOriginValue;
        @BindView(R.id.tv_has_checked)
        TextView tvHasChecked;
        @BindView(R.id.iv_haschecked)
        ImageView ivHaschecked;
        @BindView(R.id.tv_pdhcfdd)
        TextView tvPdhcfdd;
        @BindView(R.id.tv_pdhsybm)
        TextView tvPdhsybm;
        @BindView(R.id.iv_modify)
        ImageView ivModify;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
