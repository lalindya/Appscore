package com.andro.testapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.andro.testapp.R;
import com.andro.testapp.databinding.ItemViewBinding;
import com.andro.testapp.model.Article;
import com.andro.testapp.response.ArticleResponse;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private final Context context;
    ArrayList<Article.Results> articleList;
    private OnItemClickListner onItemClickListner;
    private ItemViewBinding binding;

    public ArticleAdapter(Context context, ArrayList<Article.Results> articleList) {
        this.context = context;
        this.articleList = articleList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_view, parent, false);

        return new ArticleAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article.Results article = articleList.get(position);
        holder.binding.name.setText(article.getName());
        holder.binding.nationality.setText(article.getNationality());

        Glide.with(context)
                .load(article.getAgency().getImage_url())
                .into(holder.binding.imageView);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ItemViewBinding binding;

        public ViewHolder(@NonNull ItemViewBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListner.onClick(view,getAdapterPosition());
        }
    }

    public interface OnItemClickListner{
        void onClick(View view, int position);
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public Article.Results getArticleAt(int position){
        return articleList.get(position);
    }
}
