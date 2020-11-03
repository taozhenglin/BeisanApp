package com.cn.beisanproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cn.beisanproject.R;
import com.cn.beisanproject.activity.AssertCheckJsListActivity;
import com.cn.beisanproject.activity.AssertCheckListActivity;
import com.cn.beisanproject.activity.AssertCheckCzListActivity;
import com.cn.beisanproject.activity.CountEqmentRequestListActivity;
import com.cn.beisanproject.activity.ElectricRequestListActivity;
import com.cn.beisanproject.activity.EqumentRequestListkActivity;
import com.cn.beisanproject.activity.FacilityRequestListActivity;
import com.cn.beisanproject.activity.InformationRequestListActivity;
import com.cn.beisanproject.activity.MaterialRequestListActivity;
import com.cn.beisanproject.activity.ProjectContractListActivity;
import com.cn.beisanproject.activity.ProjectContractChangeListActivity;
import com.cn.beisanproject.activity.ProjectEnquiryListActivity;
import com.cn.beisanproject.activity.ProjectMonthColletListActivity;
import com.cn.beisanproject.activity.PurchaseEnquiryListActivity;
import com.cn.beisanproject.activity.ProjectMonthListActivity;
import com.cn.beisanproject.activity.PurchaseListActivity;
import com.cn.beisanproject.activity.PurchaseMonthPlanListActivity;
import com.cn.beisanproject.activity.PurchaseOrderListActivity;
import com.cn.beisanproject.activity.PurchasePlanMonthCollectListActivity;
import com.cn.beisanproject.activity.PurchseContractListActivity;
import com.cn.beisanproject.activity.StockMoveListActivity;
import com.cn.beisanproject.activity.StockTakeListActivity;
import com.cn.beisanproject.activity.SupplierListActivity;

public class FunCtionFragment extends Fragment implements View.OnClickListener {

    private final Context mContext;
    private LinearLayout ll_purchase_contract;
    private LinearLayout ll_project_contract;
    private LinearLayout ll_stock_taking;
    private LinearLayout ll_material_requisition;
    private LinearLayout ll_asssert_check;
    private LinearLayout ll_asssert_js;
    private LinearLayout ll_asssert_cz;

    private LinearLayout ll_equment_1;
    private LinearLayout ll_equment_2;
    private LinearLayout ll_equment_3;
    private LinearLayout ll_equment_4;
    private LinearLayout ll_equment_5;
    private LinearLayout ll_project_1;
    private LinearLayout ll_project_2;
    private LinearLayout ll_project_3;
    private LinearLayout ll_project_4;
    private LinearLayout ll_purchase1;
    private LinearLayout ll_purchase2;
    private LinearLayout ll_purchase3;
    private LinearLayout ll_purchase4;
    private LinearLayout ll_supplier_management;
    private LinearLayout ll_purchase5;
    private LinearLayout ll_stock_move;


    public FunCtionFragment(Context context) {
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.function_fragment, container, false);
        ll_purchase_contract = view.findViewById(R.id.ll_purchase_contract);//采购合同
        ll_project_contract = view.findViewById(R.id.ll_project_contract);//项目合同
        ll_stock_taking = view.findViewById(R.id.ll_stock_taking);//库存盘点
        ll_material_requisition = view.findViewById(R.id.ll_material_requisition);//领料单
        ll_stock_move= view.findViewById(R.id.ll_stock_move);//库存转移

        ll_asssert_check = view.findViewById(R.id.ll_asssert_check);//固定资产盘点
        ll_asssert_js = view.findViewById(R.id.ll_asssert_js);//固定资产接收
        ll_asssert_cz = view.findViewById(R.id.ll_asssert_cz);//固定资产处置

        ll_equment_1 = view.findViewById(R.id.ll_equment_1);//设备1
        ll_equment_2 = view.findViewById(R.id.ll_equment_2);
        ll_equment_3 = view.findViewById(R.id.ll_equment_3);
        ll_equment_4 = view.findViewById(R.id.ll_equment_4);
        ll_equment_5 = view.findViewById(R.id.ll_equment_5);

        ll_project_1 = view.findViewById(R.id.ll_project_1);//项目1
        ll_project_2 = view.findViewById(R.id.ll_project_2);
        ll_project_3 = view.findViewById(R.id.ll_project_3);
        ll_project_4 = view.findViewById(R.id.ll_project_4);

        ll_purchase1 = view.findViewById(R.id.ll_purchase1);//采购
        ll_purchase2 = view.findViewById(R.id.ll_purchase2);
        ll_purchase3 = view.findViewById(R.id.ll_purchase3);
        ll_purchase4 = view.findViewById(R.id.ll_purchase4);
        ll_purchase5 = view.findViewById(R.id.ll_purchase5);

        ll_supplier_management = view.findViewById(R.id.ll_supplier_management);//供应商

        initListener();
        return view;
    }

    private void initListener() {
        ll_purchase_contract.setOnClickListener(this);
        ll_project_contract.setOnClickListener(this);
        ll_stock_taking.setOnClickListener(this);
        ll_material_requisition.setOnClickListener(this);
        ll_asssert_check.setOnClickListener(this);
        ll_asssert_js.setOnClickListener(this);
        ll_asssert_cz.setOnClickListener(this);

        ll_equment_1.setOnClickListener(this);
        ll_equment_2.setOnClickListener(this);
        ll_equment_3.setOnClickListener(this);
        ll_equment_4.setOnClickListener(this);
        ll_equment_5.setOnClickListener(this);
        ll_project_1.setOnClickListener(this);
        ll_project_2.setOnClickListener(this);
        ll_project_3.setOnClickListener(this);
        ll_project_4.setOnClickListener(this);
        ll_purchase1.setOnClickListener(this);
        ll_purchase2.setOnClickListener(this);
        ll_purchase3.setOnClickListener(this);
        ll_purchase4.setOnClickListener(this);
        ll_purchase5.setOnClickListener(this);
        ll_stock_move.setOnClickListener(this);
        ll_supplier_management.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_purchase_contract://采购合同
                startActivity(new Intent(mContext, PurchseContractListActivity.class));
                break;
            case R.id.ll_project_contract://项目合同
                startActivity(new Intent(mContext, ProjectContractListActivity.class));
                break;
            case R.id.ll_stock_taking://库存盘点
                startActivity(new Intent(mContext, StockTakeListActivity.class));
                break;
            case R.id.ll_material_requisition://领料单
                startActivity(new Intent(mContext, MaterialRequestListActivity.class));
                break;
            case R.id.ll_stock_move://库存转移
                startActivity(new Intent(mContext, StockMoveListActivity.class));
                break;
            case R.id.ll_asssert_check://固定资产盘点
                startActivity(new Intent(mContext, AssertCheckListActivity.class));
                break;
            case R.id.ll_asssert_js://固定资产接收
                startActivity(new Intent(mContext, AssertCheckJsListActivity.class));
                break;
            case R.id.ll_asssert_cz://固定资产处置
                startActivity(new Intent(mContext, AssertCheckCzListActivity.class));
                break;
            case R.id.ll_equment_1://设备台账增减申请
                startActivity(new Intent(mContext, EqumentRequestListkActivity.class));
                break;
            case R.id.ll_equment_2://设施台账增减申请
                startActivity(new Intent(mContext, FacilityRequestListActivity.class));
                break;
            case R.id.ll_equment_3://信息化台账增减申请
                startActivity(new Intent(mContext, InformationRequestListActivity.class));
                break;
            case R.id.ll_equment_4://计量设备增减申请
                startActivity(new Intent(mContext, CountEqmentRequestListActivity.class));
                break;
            case R.id.ll_equment_5://设供配电台账增减申请
                startActivity(new Intent(mContext, ElectricRequestListActivity.class));
                break;
            case R.id.ll_project_1://项目立项/项目月度计划
                startActivity(new Intent(mContext, ProjectMonthListActivity.class));
                break;
            case R.id.ll_project_2://项目月度计划汇总
                startActivity(new Intent(mContext, ProjectMonthColletListActivity.class));
                break;
            case R.id.ll_project_3://项目询价单
                startActivity(new Intent(mContext, ProjectEnquiryListActivity.class));
                break;
            case R.id.ll_project_4://项目合同变更
                startActivity(new Intent(mContext, ProjectContractChangeListActivity.class));
                break;
            case R.id.ll_purchase1://采购月度计划
                startActivity(new Intent(mContext, PurchaseMonthPlanListActivity.class));
                break;
            case R.id.ll_purchase2://采购计划月度汇总
                startActivity(new Intent(mContext, PurchasePlanMonthCollectListActivity.class));
                break;
            case R.id.ll_purchase3://采购询价单
                startActivity(new Intent(mContext, PurchaseEnquiryListActivity.class));
                break;
            case R.id.ll_purchase4://入库单
                startActivity(new Intent(mContext, PurchaseListActivity.class));
                break;
            case R.id.ll_purchase5://采购订单
                startActivity(new Intent(mContext, PurchaseOrderListActivity.class));
                break;
            case R.id.ll_supplier_management://供应商
                startActivity(new Intent(mContext, SupplierListActivity.class));
                break;
        }
    }
}
