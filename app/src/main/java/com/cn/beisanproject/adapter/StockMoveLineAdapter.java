package com.cn.beisanproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cn.beisanproject.R;
import com.cn.beisanproject.activity.StockMoveDetailActivity;
import com.cn.beisanproject.modelbean.StockMoveLineBean;

import java.util.List;

/**
 * Created by tzl
 * on 2020/12/9
 */
public class StockMoveLineAdapter extends RecyclerView.Adapter<StockMoveLineAdapter.MyViewHolder> {
    private Context mContext;
    private List<StockMoveLineBean.ResultBean.ResultlistBean> mList;

    public StockMoveLineAdapter(Context context, List<StockMoveLineBean.ResultBean.ResultlistBean> resultlist) {
        mContext = context;
        mList = resultlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.stock_move_line_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.tv_no.setText("物资编码：" + mList.get(i).getITEMNUM());
        holder.tv_use_statue.setText("使用情况类型：" + mList.get(i).getUSETYPE());
        holder.tv_line_type.setText("行类型：" + mList.get(i).getLINETYPE());
        holder.tv_count.setText("数量：" + mList.get(i).getQUANTITY());
        holder.tv_desc.setText("物资描述：" + mList.get(i).getDESCRIPTION());
        holder.tv_ori_store.setText("原货柜：" + mList.get(i).getFROMBIN());
        holder.tv_ori_num.setText("原批次：" + mList.get(i).getFROMLOT());
        holder.tv_target_store.setText("目标库房：" + mList.get(i).getTOSTORELOC());
        holder.tv_target_draw.setText("目标货柜：" + mList.get(i).getTOBIN());
        holder.tv_target_num.setText("目标批次：" + mList.get(i).getTOLOT());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<StockMoveLineBean.ResultBean.ResultlistBean> resultlist) {
        mList = resultlist;
    }

    public void addAllList(List<StockMoveLineBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_no;
        TextView tv_use_statue;
        TextView tv_line_type;
        TextView tv_count;
        TextView tv_desc;
        TextView tv_ori_store;
        TextView tv_ori_num;
        TextView tv_target_store;
        TextView tv_target_draw;
        TextView tv_target_num;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_no=itemView.findViewById(R.id.tv_no);
            tv_use_statue = itemView.findViewById(R.id.tv_use_statue);
            tv_line_type=itemView.findViewById(R.id.tv_line_type);
            tv_count=itemView.findViewById(R.id.tv_count);
            tv_desc=itemView.findViewById(R.id.tv_desc);
            tv_ori_store=itemView.findViewById(R.id.tv_ori_store);
            tv_ori_num=itemView.findViewById(R.id.tv_ori_num);
            tv_target_store=itemView.findViewById(R.id.tv_target_store);
            tv_target_draw=itemView.findViewById(R.id.tv_target_draw);
            tv_target_num= itemView.findViewById(R.id.tv_target_num);
        }
    }
}
