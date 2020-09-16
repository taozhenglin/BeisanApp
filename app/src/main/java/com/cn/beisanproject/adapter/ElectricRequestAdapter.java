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
import com.cn.beisanproject.activity.ElectricRequestDetailActivity;
import com.cn.beisanproject.modelbean.ElectricRequestListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ElectricRequestAdapter extends RecyclerView.Adapter<ElectricRequestAdapter.MyViewHolder> {

    private Context mContext;
    private List<ElectricRequestListBean.ResultBean.ResultlistBean> mList;
    private String mHightLight;

    public ElectricRequestAdapter(Context context, List<ElectricRequestListBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
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
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "申请单号:" + mList.get(position).getJD_POSUDIAPPLYID(), mHightLight, "#00ff00", 0, 0);
        holder.tvRequestNo.setText(highlightNo);
        holder.tvRequestStatue.setText(mList.get(position).getSTATUS());
        SpannableString highlightEqNo = HighLightUtils.highlight(mContext, "系统编号:" + mList.get(position).getASSETNUM(), mHightLight, "#00ff00", 0, 0);
        holder.tvSystemNo.setText( highlightEqNo);
        holder.tvFacilityName.setText("设备名称:" + mList.get(position).getNAME());
        holder.tvBigType.setText("供配电大类:" + mList.get(position).getTYPEDL());
        holder.tvSmallType.setText("供配电小类:" + mList.get(position).getTYPEXL());
        holder.tvWriteBy.setText("创建人:" + mList.get(position).getENTERBYDESC());
        holder.tvWriteTime.setText("创建时间:" + mList.get(position).getENTERDATE());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ElectricRequestDetailActivity.class);
                intent.putExtra("ResultlistBean", mList.get(position));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<ElectricRequestListBean.ResultBean.ResultlistBean> resultlist, String toString) {
        mList = resultlist;
        mHightLight = toString;
    }

    public void addAllList(List<ElectricRequestListBean.ResultBean.ResultlistBean> resultlist) {
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
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
