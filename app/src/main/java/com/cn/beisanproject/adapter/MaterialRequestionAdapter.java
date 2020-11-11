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
import com.cn.beisanproject.activity.MaterialRequestDetailActivity;
import com.cn.beisanproject.modelbean.MaterialRequestListBean;

import java.util.List;

public class MaterialRequestionAdapter extends RecyclerView.Adapter<MaterialRequestionAdapter.MyViewHolder> {
    private Context mContext;
    private List<MaterialRequestListBean.ResultBean.ResultlistBean> mList;
    private String mHightlight;

    public MaterialRequestionAdapter(Context context, List<MaterialRequestListBean.ResultBean.ResultlistBean> resultlist, String hightlight) {
        this.mContext = context;
        this.mList = resultlist;
        this.mHightlight = hightlight;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.material_request_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        SpannableString hightLightNo = HighLightUtils.highlight(mContext, "领料单编号：" + mList.get(position).getWONUM(), mHightlight, "#00ff00", 0, 0);
        holder.tv_material_no.setText(hightLightNo);
        if (mList.get(position).getSTATUS().equals("已批准")) {
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.permitted2));
            holder.tv_material_statue.setVisibility(View.GONE);
            holder.tv_material_statue.setBackgroundDrawable(null);

        }else  if (mList.get(position).getSTATUS().equals("驳回")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.reject));
            holder.tv_material_statue.setVisibility(View.GONE);
            holder.tv_material_statue.setBackgroundDrawable(null);

        }else  if (mList.get(position).getSTATUS().equals("取消")||mList.get(position).getSTATUS().equals("已取消")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.canceled));
            holder.tv_material_statue.setVisibility(View.GONE);
            holder.tv_material_statue.setBackgroundDrawable(null);

        }
        else  if (mList.get(position).getSTATUS().equals("完成")||mList.get(position).getSTATUS().equals("已完成")){
            holder.iv_contract_statue.setVisibility(View.VISIBLE);
            holder.iv_contract_statue.setImageDrawable(mContext.getResources().getDrawable(R.drawable.finished));
            holder.tv_material_statue.setVisibility(View.GONE);
            holder.tv_material_statue.setBackgroundDrawable(null);
        }
        else {
            holder.iv_contract_statue.setVisibility(View.GONE);
            holder.tv_material_statue.setVisibility(View.VISIBLE);
            holder.tv_material_statue.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.blue_shape_20));
            holder.tv_material_statue.setText(mList.get(position).getSTATUS());

        }
        SpannableString hightLightDesc = HighLightUtils.highlight(mContext, "领料单描述：" + mList.get(position).getDESCRIPTION(), mHightlight, "#00ff00", 0, 0);
        holder.tv_material_desc.setText(hightLightDesc);
        holder.tv_function_dep.setText("职能部门：" + mList.get(position).getA_TODEPT());
        holder.tv_requset_dep.setText("申请部门:" + mList.get(position).getA_DEPT());
        holder.tv_material_team.setText("班组:" + mList.get(position).getBZ());
        holder.tv_material_sum.setText("总金额:" + mList.get(position).getESTMATCOST());
        holder.tv_write_by.setText("填报人:" + mList.get(position).getREPORTEDBY());
        holder.tv_write_time.setText("填报时间:" + mList.get(position).getREPORTDATE());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MaterialRequestDetailActivity.class);
                intent.putExtra("ResultlistBean",mList.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<MaterialRequestListBean.ResultBean.ResultlistBean> resultlist, String toString) {
        mList = resultlist;
        mHightlight = toString;
    }

    public void addAllList(List<MaterialRequestListBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_material_no;
        TextView tv_material_statue;
        ImageView iv_contract_statue;
        TextView tv_material_desc;
        TextView tv_function_dep;
        TextView tv_requset_dep;
        TextView tv_material_team;
        TextView tv_material_sum;
        TextView tv_write_by;
        TextView tv_write_time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_material_no = itemView.findViewById(R.id.tv_material_no);
            tv_material_statue = itemView.findViewById(R.id.tv_material_statue);
            iv_contract_statue= itemView.findViewById(R.id.iv_contract_statue);
            tv_material_desc = itemView.findViewById(R.id.tv_material_desc);
            tv_function_dep = itemView.findViewById(R.id.tv_function_dep);
            tv_requset_dep = itemView.findViewById(R.id.tv_requset_dep);
            tv_material_team = itemView.findViewById(R.id.tv_material_team);
            tv_material_sum = itemView.findViewById(R.id.tv_material_sum);
            tv_write_by = itemView.findViewById(R.id.tv_write_by);
            tv_write_time = itemView.findViewById(R.id.tv_write_time);


        }
    }
}
