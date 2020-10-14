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
import com.cn.beisanproject.activity.CountEqmentRequestDetailActivity;
import com.cn.beisanproject.activity.ElectricRequestDetailActivity;
import com.cn.beisanproject.activity.EqumentRequestDetailActivity;
import com.cn.beisanproject.activity.FacilityRequestDetailActivity;
import com.cn.beisanproject.activity.InformationRequestDetailActivity;
import com.cn.beisanproject.activity.MaterialRequestDetailActivity;
import com.cn.beisanproject.activity.ProjectContractChangeActivity;
import com.cn.beisanproject.activity.ProjectContractDetailActivity;
import com.cn.beisanproject.activity.ProjectEnquiryDetailActivity;
import com.cn.beisanproject.activity.ProjectMonthColletDetailActivity;
import com.cn.beisanproject.activity.ProjectMonthDetailActivity;
import com.cn.beisanproject.activity.PurchaseContractDetailActivity;
import com.cn.beisanproject.activity.PurchaseEnquiryDetailActivity;
import com.cn.beisanproject.activity.PurchaseListDetailActivity;
import com.cn.beisanproject.activity.PurchaseMonthColletDetailActivity;
import com.cn.beisanproject.activity.PurchaseMonthPlanDetailActivity;
import com.cn.beisanproject.activity.PurchaseOrderDetailActivity;
import com.cn.beisanproject.activity.StockMoveDetailActivity;
import com.cn.beisanproject.activity.SupplierDetailActivity;
import com.cn.beisanproject.modelbean.WaitDoListBean;

import java.util.List;

public class WaitDoAdapter extends RecyclerView.Adapter<WaitDoAdapter.MyViewHolder> {
    private Context mContext;
    private List<WaitDoListBean.ResultBean.ResultlistBean> mResultList;

    public WaitDoAdapter(Context context, List<WaitDoListBean.ResultBean.ResultlistBean> resultlist) {
        this.mContext = context;
        this.mResultList = resultlist;
    }

    @NonNull
    @Override
    public WaitDoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.wait_do_listitem, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WaitDoAdapter.MyViewHolder holder, final int position) {
        switch (mResultList.get(position).getPROCESSNAME()) {
            case "PO":
                holder.tv_title.setText("入库单");
                break;
            case "RFQ":
                holder.tv_title.setText("采购询价单");
                break;
            case "CONTPURCH":
                holder.tv_title.setText("采购合同");
                break;
            case "PRSUM":
                holder.tv_title.setText( "采购计划月度汇总");
                break;
            case "PR":
                holder.tv_title.setText( "采购月度计划");
                break;
                case "GPDTZ":
                holder.tv_title.setText("供配电设备台账增减申请");
                break;
            case "VENAPPLY":
                  holder.tv_title.setText("供应商申请");
                break;
            case "JLTZ":
                holder.tv_title.setText( "计量设备台账增减申请");
                break;
            case "MATREQ":
                holder.tv_title.setText( "领料申请单");
                break;
            case "SBTZ":
                holder.tv_title.setText( "设备台账增减申请");
                break;
            case "SSTZ":
                holder.tv_title.setText( "设施台账增减申请");
                break;
            case "WZBMSQ":
                holder.tv_title.setText( "物资编码申请");
                break;
            case "XMHT":
                holder.tv_title.setText("项目合同");
                break;
            case "UDXMHTBG":
                holder.tv_title.setText( "项目合同变更");
                break;
            case "PRPROJ":
                holder.tv_title.setText( "项目立项/项目月度计划");
                break;
            case "XBJ":
                holder.tv_title.setText( "项目询价单");
                break;
            case "PROJSUM":
                holder.tv_title.setText("项目月度计划汇总");
                break;
            case "XXHTZ":
                holder.tv_title.setText("信息化台账增减申请");
                break;
            case "CONTRACTPO":
                holder.tv_title.setText("采购订单");
                break;
            case "INVUSEZY":
                holder.tv_title.setText("库存转移");
                break;

        }
        holder.tv_desc.setText(mResultList.get(position).getDESCRIPTION() + "");
        holder.tv_date.setText(mResultList.get(position).getSTARTDATE() + "");
        holder.tv_type.setText(mResultList.get(position).getASSIGNSTATUS() + "");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //代办事项详情
                Intent intent;
                switch (mResultList.get(position).getPROCESSNAME()) {
                    case "PO"://入库单
                        intent=new Intent(mContext, PurchaseListDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "RFQ":// 采购询价单
                        intent=new Intent(mContext, PurchaseEnquiryDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "CONTPURCH"://采购合同 CONTPURCH-3155-CONGYS
                        intent=new Intent(mContext, PurchaseContractDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "PRSUM"://采购计划月度汇总 PRSUM-29181-CHENYN
                        intent=new Intent(mContext, PurchaseMonthColletDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "PR"://采购月度计划 PR-WZ00527-XIAXF
                        intent=new Intent(mContext, PurchaseMonthPlanDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "GPDTZ"://供配电台账
                        intent=new Intent(mContext, ElectricRequestDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "VENAPPLY"://供应商
                        intent=new Intent(mContext, SupplierDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "JLTZ"://计量设备台账
                        intent=new Intent(mContext, CountEqmentRequestDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "MATREQ"://领料申请单
                        intent=new Intent(mContext, MaterialRequestDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "SBTZ"://设备台账增减申请
                        intent=new Intent(mContext, EqumentRequestDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "SSTZ"://设施台账增减申请 facility
                        intent=new Intent(mContext, FacilityRequestDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "XMHT"://项目合同
                        intent=new Intent(mContext, ProjectContractDetailActivity.class);
                        intent.putExtra("ResultlistBean", mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "UDXMHTBG"://项目合同变更
                        intent=new Intent(mContext, ProjectContractChangeActivity.class);
                        intent.putExtra("ResultlistBean", mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "PRPROJ"://项目立项/项目月度计划
                         intent=new Intent(mContext, ProjectMonthDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "XBJ":
                         intent=new Intent(mContext, ProjectEnquiryDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "PROJSUM"://项目月度计划汇总
                        intent=new Intent(mContext, ProjectMonthColletDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "XXHTZ"://信息化台账
                        intent=new Intent(mContext, InformationRequestDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "CONTRACTPO"://采购订单
                        intent=new Intent(mContext, PurchaseOrderDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;
                    case "INVUSEZY"://库存转移
                        intent=new Intent(mContext, StockMoveDetailActivity.class);
                        intent.putExtra("ResultlistBean",mResultList.get(position));
                        intent.putExtra("from","waitdolist");//从代办事项列表进入详情的还需要接口请求数据 列表数据不够用
                        mContext.startActivity(intent);
                        break;

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }


    public void addAllList(List<WaitDoListBean.ResultBean.ResultlistBean> resultlist) {
        mResultList.addAll(resultlist);
    }

    public void setData(List<WaitDoListBean.ResultBean.ResultlistBean> resultlist) {
        mResultList = resultlist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_desc;
        TextView tv_date;
        TextView tv_type;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_type = itemView.findViewById(R.id.tv_type);

        }
    }
}
