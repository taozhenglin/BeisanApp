package com.cn.beisanproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cn.beisanproject.R;
import com.cn.beisanproject.Utils.HighLightUtils;
import com.cn.beisanproject.modelbean.PurchseAttachBean;

import java.util.List;

/**
 * Created by tzl
 * on 2020/11/18
 */
public class AttachListAdapter extends RecyclerView.Adapter<AttachListAdapter.MyViewHolder> {
    private  Context mContext;
    private List<PurchseAttachBean.ResultBean.ResultlistBean> mList;
    private OnclickListsner mListener;

    public AttachListAdapter(Context context, List<PurchseAttachBean.ResultBean.ResultlistBean> resultlist) {
        mContext=context;
        mList = resultlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.contract_detail_attach, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_attach_no.setText("附件编号:" + mList.get(position).getDOCLINKSID());
        holder. tv_attach_desc.setText(HighLightUtils.highlight(mContext, "附件描述:" + mList.get(position).getDOCDESC(), mList.get(position).getDOCDESC(), "#1B88EE", 0, 0));
        holder.tv_upload_time.setText("上传日期:" + mList.get(position).getCREATEDATE());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onclick( mList.get(position).getDOCUMENT());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<PurchseAttachBean.ResultBean.ResultlistBean> resultlist) {
        mList = resultlist;
    }

    public void addAllList(List<PurchseAttachBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_attach_no;
        TextView tv_attach_desc;
        TextView tv_upload_time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_attach_no = itemView.findViewById(R.id.tv_attach_no);
            tv_attach_desc = itemView.findViewById(R.id.tv_attach_desc);
            tv_upload_time = itemView.findViewById(R.id.tv_upload_time);
        }
    }
    public void setListener(OnclickListsner listener){
        this.mListener=listener;

    }
    public interface OnclickListsner{
       void onclick(String document);
    }
}
