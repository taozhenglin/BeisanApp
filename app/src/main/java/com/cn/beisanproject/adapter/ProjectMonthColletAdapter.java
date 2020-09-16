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
import com.cn.beisanproject.activity.ProjectMonthColletDetailActivity;
import com.cn.beisanproject.activity.ProjectMonthColletListActivity;
import com.cn.beisanproject.activity.PurchaseMonthColletDetailActivity;
import com.cn.beisanproject.modelbean.ProjectContractChangeBean;
import com.cn.beisanproject.modelbean.ProjectMonthCollectBean;

import java.util.List;

public class ProjectMonthColletAdapter extends RecyclerView.Adapter<ProjectMonthColletAdapter.MyViewHolder> {
    private final String mTag;
    private Context mContext;
    private List<ProjectMonthCollectBean.ResultBean.ResultlistBean> mList;
    private String mHightlight;

    public ProjectMonthColletAdapter(Context context, List<ProjectMonthCollectBean.ResultBean.ResultlistBean> resultlist, String hightlight,String tag) {
        mContext = context;
        mList = resultlist;
        mHightlight = hightlight;
        mTag=tag;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.assert_list_item, parent, false);
        return new MyViewHolder(inflate);
    }

    public void setData(List<ProjectMonthCollectBean.ResultBean.ResultlistBean> resultlist, String toString) {
        mList = resultlist;
        mHightlight = toString;
    }

    public void addAllList(List<ProjectMonthCollectBean.ResultBean.ResultlistBean> resultlist) {
        mList.addAll(resultlist);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SpannableString highlightNo = HighLightUtils.highlight(mContext, "项目汇总：" + mList.get(position).getPRNUM(), mHightlight, "#00ff00", 0, 0);
        holder.tv_check_no.setText(highlightNo);
        holder.tv_statues.setVisibility(View.VISIBLE);
        holder.tv_statues.setText(mList.get(position).getSTATUS());
        SpannableString highlightDesc = HighLightUtils.highlight(mContext, "描述：" + mList.get(position).getDESCRIPTION(), mHightlight, "#00ff00", 0, 0);
        holder.tv_check_desc.setText(highlightDesc);
        holder.tv_check_by.setText("项汇总年月：" + mList.get(position).getA_PRKEY());
        holder.tv_check_starttime.setText("汇总时间：" + mList.get(position).getISSUEDATE());
        holder.tv_check_endtime.setVisibility(View.GONE);
        holder.tv_created_by.setVisibility(View.GONE);
        holder.tv_created_time.setVisibility(View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTag.equals("ProjectMonthColletListActivity")){
                    // 跳转至项目月度汇总
                    Intent intent=new Intent(mContext, ProjectMonthColletDetailActivity.class);
                    intent.putExtra("ResultlistBean",mList.get(position));
                    mContext.startActivity(intent);
                }else {
                    // 跳转至采购月度汇总
                    Intent intent=new Intent(mContext, PurchaseMonthColletDetailActivity.class);
                    intent.putExtra("ResultlistBean",mList.get(position));
                    mContext.startActivity(intent);

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_check_no;
        private final TextView tv_check_desc;
        private final TextView tv_statues;
        private final TextView tv_check_by;
        private final TextView tv_check_starttime;
        private final TextView tv_check_endtime;
        private final TextView tv_created_by;
        private final TextView tv_created_time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_check_no = itemView.findViewById(R.id.tv_check_no);
            tv_statues = itemView.findViewById(R.id.tv_statues);
            tv_check_desc = itemView.findViewById(R.id.tv_check_desc);
            tv_check_by = itemView.findViewById(R.id.tv_check_by);
            tv_check_starttime = itemView.findViewById(R.id.tv_check_starttime);
            tv_check_endtime = itemView.findViewById(R.id.tv_check_endtime);
            tv_created_by = itemView.findViewById(R.id.tv_created_by);
            tv_created_time = itemView.findViewById(R.id.tv_created_time);
        }
    }
}
