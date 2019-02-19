package com.fisrtproject.polybook.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fisrtproject.polybook.model.Category;
import com.fisrtproject.polybook.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    public Context context;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    public List<Category> categories;

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item, viewGroup, false);

        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder categoryHolder, int i) {
        categoryHolder.category = categories.get(i);
        categoryHolder.tvTenTheLoai.setText(categoryHolder.category.CATEGORY_TEN_THE_LOAI);
        categoryHolder.tvMaTheLoai.setText(categoryHolder.category.CATEGORY_MA_THE_LOAI);
    }

    @Override
    public int getItemCount() {
        if (categories == null) return 0;
        else
            return categories.size();
    }

    class CategoryHolder extends RecyclerView.ViewHolder {

        private Button btnDelCategory;
        private Category category;
        private TextView tvMaTheLoai;
        private TextView tvTenTheLoai;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            btnDelCategory = itemView.findViewById(R.id.btnDelCategory);
            tvMaTheLoai = itemView.findViewById(R.id.tvMaTheLoai);
            tvTenTheLoai = itemView.findViewById(R.id.tvTenTheLoai);
        }
    }
}
