package com.cn.beisanproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cn.beisanproject.R;
import com.cn.beisanproject.activity.StockListItemDetailActivity;
import com.cn.beisanproject.modelbean.StockingLineListBean;
import com.cn.beisanproject.modelbean.StockingTakeListBean;

import java.util.List;

public class StockTakeDetailAdapter extends RecyclerView.Adapter<StockTakeDetailAdapter.MyViewHolder> {
    private final String mTag;
    private Context mContext;
    private List<StockingLineListBean.ResultBean.ResultlistBean> mResultlist;
    StockingTakeListBean.ResultBean.ResultlistBean mResultlistBean;

    public StockTakeDetailAdapter(Context context, StockingTakeListBean.ResultBean.ResultlistBean resultlistBean,
                                  List<StockingLineListBean.ResultBean.ResultlistBean> resultlist, String tag) {
        this.mContext = context;
        this.mResultlistBean = resultlistBean;
        this.mResultlist = resultlist;
        this.mTag = tag;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(mContext).inflate(R.layout.stock_line_item, parent, false);
        return new MyViewHolder(inflate);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        holder.tv_line_no.setText("明细行序号:" + mResultlist.get(i).getLINENUM());
        holder.tv_product_location.setText("货位：：" + mResultlist.get(i).getBINNUM());
        holder.tv_line_batch.setText("批次：" + mResultlist.get(i).getLOTNUM());
        holder.tv_prodution_no.setText("物资编码：" + mResultlist.get(i).getITEMNUM());
        holder.tv_prodution_desc.setText("物资描述：" + mResultlist.get(i).getITEMNUMDESC());
        holder.tv_stock_count.setText("库存数量：" + mResultlist.get(i).getYPQUANTITY());
        holder.tv_actually_count.setText("实盘数量：" + mResultlist.get(i).getSPQUANTITY());
        if (mResultlist.get(i).getYPQUANTITY().equals(mResultlist.get(i).getSPQUANTITY())){

        }else {
            holder.tv_diff_count.setText("差异数量：" + mResultlist.get(i).getCYQUANTITY());

        }
        holder.tv_store.setText("仓库："+mResultlist.get(i).getLOCATION());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (! mTag.equals("diff")) {
                    mContext.startActivity(new Intent(mContext, StockListItemDetailActivity.class).putExtra("resultlistBean", mResultlistBean).putExtra("data", mResultlist.get(i)));
                }

            }
        });

    }


    @Override
    public int getItemCount() {
        return mResultlist.size();
    }


    public void setData(List<StockingLineListBean.ResultBean.ResultlistBean> resultlist) {
        mResultlist = resultlist;
    }

    public void addAllList(List<StockingLineListBean.ResultBean.ResultlistBean> resultlist) {
        mResultlist.addAll(resultlist);
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
