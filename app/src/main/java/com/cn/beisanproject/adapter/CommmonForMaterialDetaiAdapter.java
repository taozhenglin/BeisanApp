package com.cn.beisanproject.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.HighLightUtils;
import com.cn.beisanproject.modelbean.CommmonForMaterialDetailBean;
import com.cn.beisanproject.modelbean.YuSuanListBean;

import java.util.List;

public class CommmonForMaterialDetaiAdapter extends RecyclerView.Adapter<CommmonForMaterialDetaiAdapter.MyViewHolder>{
    private OnItemClickListener mLitsner;
    Context mContext;
    List<CommmonForMaterialDetailBean.ResultBean.ResultlistBean> mList;
    String mHightlight;

    public CommmonForMaterialDetaiAdapter(Context context, List<CommmonForMaterialDetailBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
        mContext=context;
        mList=resultlist;
        mHightlight=hightlight;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.yusan_list_item, parent, false);
        return new MyViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "值: " + mList.get(position).getVALUE(), mHightlight, "#00ff00", 0, 0);
        holder.tv_project.setText(highlightNo);
        SpannableString highlightDesc = HighLightUtils.highlight(mContext, "描述: " + mList.get(position).getDESCRIPTION(), mHightlight, "#00ff00", 0, 0);
        holder.tv_desc.setText(highlightDesc);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLitsner.onItemClick(view,position,mList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<CommmonForMaterialDetailBean.ResultBean.ResultlistBean> resultlist, String toString) {
        mList=resultlist;
        mHightlight=toString;
    }

    public void addAllList(List<CommmonForMaterialDetailBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView tv_project;
        private final TextView tv_desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_project = itemView.findViewById(R.id.tv_project);
            tv_desc = itemView.findViewById(R.id.tv_desc);

        }
    }
    public interface OnItemClickListener{
        public void onItemClick(View view,int position,CommmonForMaterialDetailBean.ResultBean.ResultlistBean resultlistBean);
    }
    public void setOnclickListener(OnItemClickListener listener){
        this.mLitsner=listener;

    }
}
