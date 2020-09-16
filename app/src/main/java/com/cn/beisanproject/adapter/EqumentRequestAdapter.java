package com.cn.beisanproject.adapter;

import android.content.ContentProviderClient;
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
import com.cn.beisanproject.activity.EqumentRequestDetailActivity;
import com.cn.beisanproject.activity.MaterialRequestDetailActivity;
import com.cn.beisanproject.modelbean.EqumentRequestListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EqumentRequestAdapter extends RecyclerView.Adapter<EqumentRequestAdapter.MyViewHolder> {


    private Context mContext;
    private List<EqumentRequestListBean.ResultBean.ResultlistBean> mList;
    private String mHightLight;

    public EqumentRequestAdapter(Context context, List<EqumentRequestListBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
        mContext = context;
        mList = resultlist;
        mHightLight = hightlight;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.equment_request_list_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "申请单号:" + mList.get(position).getJD_SBTZID(), mHightLight, "#00ff00", 0, 0);
        holder.tvRequestNo.setText(highlightNo);
        holder.tvRequestStatue.setText(mList.get(position).getSTATUS());
        SpannableString highlightEqNo = HighLightUtils.highlight(mContext, "设备编号:" + mList.get(position).getASSETNUM(), mHightLight, "#00ff00", 0, 0);
        holder.tvEqNo.setText(highlightEqNo);
        holder.tvIsImporment.setText("是否重点设备:"+mList.get(position).getISZDSB());
        holder.tvBigType.setText("设备大类:"+mList.get(position).getSBDL());
        holder.tvMiddleType.setText("设备中类:"+mList.get(position).getSBZL());
        holder.tvSmallType.setText("设备小类:"+mList.get(position).getSBXL());
        holder.tvOriginValue.setText("原值:"+mList.get(position).getYZ());
        holder.tvWriteBy.setText("创建人:"+mList.get(position).getCREATEBYDESC());
        holder.tvWriteTime.setText("创建时间:"+mList.get(position).getCREATETIME());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, EqumentRequestDetailActivity.class);
                intent.putExtra("ResultlistBean",mList.get(position));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<EqumentRequestListBean.ResultBean.ResultlistBean> resultlist, String toString) {
        mList = resultlist;
        mHightLight = toString;
    }

    public void addAllList(List<EqumentRequestListBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_request_no)
        TextView tvRequestNo;
        @BindView(R.id.tv_request_statue)
        TextView tvRequestStatue;
        @BindView(R.id.tv_eq_no)
        TextView tvEqNo;
        @BindView(R.id.tv_is_imporment)
        TextView tvIsImporment;
        @BindView(R.id.tv_big_type)
        TextView tvBigType;
        @BindView(R.id.tv_middle_type)
        TextView tvMiddleType;
        @BindView(R.id.tv_small_type)
        TextView tvSmallType;
        @BindView(R.id.tv_origin_value)
        TextView tvOriginValue;
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
