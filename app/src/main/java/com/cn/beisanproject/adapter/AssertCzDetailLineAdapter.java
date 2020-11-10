package com.cn.beisanproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cn.beisanproject.R;
import com.cn.beisanproject.modelbean.AssertCzDetailLineBean;
import com.cn.beisanproject.modelbean.AssertJsDetailLineBean;

import java.util.List;

/**
 * Created by tzl
 * on 2020/11/6
 */
public class AssertCzDetailLineAdapter extends RecyclerView.Adapter<AssertCzDetailLineAdapter.MyViewHolder> {
    private Context mContext;
    private List<AssertCzDetailLineBean.ResultBean.ResultlistBean> mList;

    public AssertCzDetailLineAdapter(Context context, List<AssertCzDetailLineBean.ResultBean.ResultlistBean> resultlist) {
        this.mContext = context;
        this.mList = resultlist;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.stock_line_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.tv_line_no.setText("资产编码:" + mList.get(i).getCWBM());
        holder.tv_product_location.setText("存放位置：" + mList.get(i).getLOCATION());
        holder.tv_line_batch.setText("描述：" + mList.get(i).getDESCRIPTION());
        holder.tv_prodution_no.setText("规格型号：" + mList.get(i).getPRODUCTMODEL());
        holder.tv_prodution_desc.setText("购买日期：" + mList.get(i).getDATEOFPURCHASE());
        holder.tv_stock_count.setText("使用部门：" + mList.get(i).getDEPARTMENT());
        holder.tv_actually_count.setText("所属公司：" + mList.get(i).getUDCOMPANY());
        holder.tv_diff_count.setText("原值："+mList.get(i).getCOST());
        holder.tv_store.setText("处置方式："+mList.get(i).getSCRAPYPE());
    }



    @Override
    public int getItemCount() {
        return mList.size();
    }
    public void addAllList(List<AssertCzDetailLineBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }


    public void setData(List<AssertCzDetailLineBean.ResultBean.ResultlistBean> list) {
        mList = list;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_line_no;
        TextView tv_product_location;
        TextView tv_line_batch;
        TextView tv_prodution_no;
        TextView tv_prodution_desc;
        TextView tv_stock_count;
        TextView tv_actually_count;
        TextView tv_diff_count;
        TextView tv_store;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_line_no = itemView.findViewById(R.id.tv_line_no);
            tv_product_location = itemView.findViewById(R.id.tv_product_location);
            tv_line_batch = itemView.findViewById(R.id.tv_line_batch);
            tv_prodution_no = itemView.findViewById(R.id.tv_prodution_no);
            tv_prodution_desc = itemView.findViewById(R.id.tv_prodution_desc);
            tv_stock_count = itemView.findViewById(R.id.tv_stock_count);
            tv_actually_count = itemView.findViewById(R.id.tv_actually_count);
            tv_diff_count = itemView.findViewById(R.id.tv_diff_count);
            tv_store= itemView.findViewById(R.id.tv_store);
        }
    }
}
