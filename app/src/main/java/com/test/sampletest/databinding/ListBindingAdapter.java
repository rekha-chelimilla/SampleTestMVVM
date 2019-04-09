package com.test.sampletest.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.test.sampletest.data.remote.Resource;
import com.test.sampletest.view.base.BaseAdapter;

import java.util.List;

final class ListBindingAdapter{

    private ListBindingAdapter(){
        // Private Constructor to hide the implicit one
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter == null)
            return;

        if(resource == null || resource.data == null)
            return;

        if(adapter instanceof BaseAdapter){
            ((BaseAdapter)adapter).setData((List) resource.data);
        }
    }

}
