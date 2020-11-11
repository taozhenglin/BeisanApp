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
import com.cn.beisanproject.activity.CountEqmentRequestDetailActivity;
import com.cn.beisanproject.modelbean.CountEqmentRequestListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountEqmentRequestAdapter extends RecyclerView.Adapter<CountEqmentRequestAdapter.MyViewHolder> {

    private Context mContext;
    private List<CountEqmentRequestListBean.ResultBean.ResultlistBean> mList;
    private String mHightLight;

    public CountEqmentRequestAdapter(Context context, List<CountEqmentRequestListBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
        mContext = context;
        mList = resultlist;
        mHightLight = hightlight;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.facility_request_list_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "申请单号:" + mList.get(position).getJD_MEASUREMENTID(), mHightLight, "#00ff00", 0, 0);
        holder.tvRequestNo.setText(highlightNo);
        if (mList.get(position).getSTATUS().equals("已批准")) {
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.permitted2));
            holder.tvRequestStatue.setVisibility(View.GONE);
            holder.tvRequestStatue.setBackgroundDrawable(null);

        }else  if (mList.get(position).getSTATUS().equals("驳回")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.reject));
            holder.tvRequestStatue.setVisibility(View.GONE);
            holder.tvRequestStatue.setBackgroundDrawable(null);

        }else  if (mList.get(position).getSTATUS().equals("取消")||mList.get(position).getSTATUS().equals("已取消")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.canceled));
            holder.tvRequestStatue.setVisibility(View.GONE);
            holder.tvRequestStatue.setBackgroundDrawable(null);

        }
        else  if (mList.get(position).getSTATUS().equals("完成")||mList.get(position).getSTATUS().equals("已完成")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.finished));
            holder.tvRequestStatue.setVisibility(View.GONE);
            holder.tvRequestStatue.setBackgroundDrawable(null);
        }
        else {
            holder.iv_contract_statue.setVisibility(View.GONE);
            holder.tvRequestStatue.setVisibility(View.VISIBLE);
            holder.tvRequestStatue.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.blue_shape_20));
            holder.tvRequestStatue.setText(mList.get(position).getSTATUS());

        }
//        SpannableString highlightEqNo = HighLightUtils.highlight(mContext, "系统编号:" + mList.get(position).getASSETNUM(), mHightLight, "#00ff00", 0, 0);
        holder.tvSystemNo.setText("系统编号:" + mList.get(position).getASSETNUM());
        holder.tvFacilityName.setText("设备名称:" + mList.get(position).getNAME());
        holder.tvBigType.setText("型号规格:" + mList.get(position).getXH());
        holder.tvSmallType.setText("设备状态:" + mList.get(position).getASSETSTATUS());
        holder.tvWriteBy.setText("创建人:" + mList.get(position).getENTERBYDESC());
        holder.tvWriteTime.setText("创建时间:" + mList.get(position).getENTERDATE());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CountEqmentRequestDetailActivity.class);
                intent.putExtra("ResultlistBean", mList.get(position));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<CountEqmentRequestListBean.ResultBean.ResultlistBean> resultlist, String toString) {
        mList = resultlist;
        mHightLight = toString;
    }

    public void addAllList(List<CountEqmentRequestListBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_request_no)
        TextView tvRequestNo;
        @BindView(R.id.tv_request_statue)
        TextView tvRequestStatue;
        @BindView(R.id.tv_system_no)
        TextView tvSystemNo;
        @BindView(R.id.tv_facility_name)
        TextView tvFacilityName;
        @BindView(R.id.tv_big_type)
        TextView tvBigType;
        @BindView(R.id.tv_small_type)
        TextView tvSmallType;
        @BindView(R.id.tv_write_by)
        TextView tvWriteBy;
        @BindView(R.id.tv_write_time)
        TextView tvWriteTime;
        @BindView(R.id.iv_contract_statue)
        ImageView iv_contract_statue;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
