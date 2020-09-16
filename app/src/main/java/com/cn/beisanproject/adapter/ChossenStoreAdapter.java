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
import com.cn.beisanproject.activity.ChossenStoreACctivity;
import com.cn.beisanproject.modelbean.ChossenProjectListBean;
import com.cn.beisanproject.modelbean.ChossenStoreListBean;

import java.util.List;

public class ChossenStoreAdapter extends RecyclerView.Adapter<ChossenStoreAdapter.MyViewHolder> {

    private  Context mContext;
    private  List<ChossenStoreListBean.ResultBean.ResultlistBean> mList;
    private  String mHight;
    private OnItemClickListener mLitsner;

    public ChossenStoreAdapter(Context context, List<ChossenStoreListBean.ResultBean.ResultlistBean> resultlist, String s) {
        mContext=context;
        mList=resultlist;
        mHight=s;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.assert_list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "库房:" + mList.get(position).getSITEID(), mHight, "#00ff00", 0, 0);
        holder.tv_check_no.setText(highlightNo);
        SpannableString highlightDesc = HighLightUtils.highlight(mContext, "描述:" + mList.get(position).getDESCRIPTION(), mHight, "#00ff00", 0, 0);
        holder.tv_check_desc.setText(highlightDesc);

        holder.tv_check_by.setText("类型:"+mList.get(position).getTYPE());
        holder.tv_check_starttime.setText("库房地点:" + mList.get(position).getLOCATION());
        holder.tv_check_endtime.setVisibility(View.GONE);
        holder.tv_created_by.setVisibility(View.GONE);
        holder.tv_created_time.setVisibility(View.GONE);

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

    public void setData(List<ChossenStoreListBean.ResultBean.ResultlistBean> resultlist, String toString) {
        mList=resultlist;
    }

    public void addAllList(List<ChossenStoreListBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView tv_check_no;
        private final TextView tv_check_desc;
        private final TextView tv_check_by;
        private final TextView tv_check_starttime;
        private final TextView tv_check_endtime;
        private final TextView tv_created_by;
        private final TextView tv_created_time;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_check_no = itemView.findViewById(R.id.tv_check_no);
            tv_check_desc = itemView.findViewById(R.id.tv_check_desc);
            tv_check_by = itemView.findViewById(R.id.tv_check_by);
            tv_check_starttime = itemView.findViewById(R.id.tv_check_starttime);
            tv_check_endtime = itemView.findViewById(R.id.tv_check_endtime);
            tv_created_by = itemView.findViewById(R.id.tv_created_by);
            tv_created_time = itemView.findViewById(R.id.tv_created_time);
        }
    }
    public interface OnItemClickListener{
        public void onItemClick(View view, int position, ChossenStoreListBean.ResultBean.ResultlistBean resultlistBean);
    }
    public void setOnclickListener(OnItemClickListener listener){
        this.mLitsner=listener;

    }
}
