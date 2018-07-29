package com.example.module_demo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.module_demo.R;
import com.example.module_demo.di.component.DaggerPictureListComponent;
import com.example.module_demo.di.module.PictureListModule;
import com.example.module_demo.mvp.contract.PictureListContract;
import com.example.module_demo.mvp.model.entity.PictureResp;
import com.example.module_demo.mvp.presenter.PictureListPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.glide.GlideImageLoaderStrategy;
import com.jess.arms.utils.ArmsUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.jessyan.armscomponent.commonsdk.imgaEngine.config.CommonImageConfigImpl;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class PictureListActivity extends BaseActivity<PictureListPresenter> implements PictureListContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smartRefreshLayout;

    private int page = 1;
    private int page_count = 20;
    private BaseQuickAdapter<PictureResp.DataBean, BaseViewHolder> adapter;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerPictureListComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .pictureListModule(new PictureListModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.demo_activity_picture_list; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initRecyclerView();
        mPresenter.getPictureList(page,page_count);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BaseQuickAdapter<PictureResp.DataBean, BaseViewHolder>(R.layout.demo_item_picture) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, PictureResp.DataBean data) {
                baseViewHolder.setText(R.id.tv_title, data.getTitle());
                CommonImageConfigImpl config = CommonImageConfigImpl.builder()
                        .imageView(baseViewHolder.getView(R.id.photo_view))
                        .url(data.getUrl())
                        .build();
                ArmsUtils.obtainAppComponentFromContext(PictureListActivity.this)
                        .imageLoader()
                        .loadImage(PictureListActivity.this, config);

            }
        };
        recyclerView.setAdapter(adapter);
        smartRefreshLayout.autoRefresh();
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                mPresenter.getPictureList(page,page_count);

            }
        });
        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                mPresenter.getPictureList(page,page_count);
            }
        });
    }

    @Override
    public void queryPictureSuccess(List<PictureResp.DataBean> datas) {

        smartRefreshLayout.finishLoadmore();
        smartRefreshLayout.finishRefresh();
        if (page == 1){
            adapter.replaceData(datas);
        }else {
            adapter.addData(datas);
        }

    }

    @Override
    public void queryPictureError(String err) {

    }
}
