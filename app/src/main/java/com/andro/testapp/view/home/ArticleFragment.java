package com.andro.testapp.view.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.andro.testapp.R;
import com.andro.testapp.adapter.ArticleAdapter;
import com.andro.testapp.databinding.FragmentHomeBinding;
import com.andro.testapp.model.Article;
import com.andro.testapp.response.ArticleResponse;
import com.andro.testapp.view.details.DetailsFragment;
import com.andro.testapp.view_model.ArticleViewModel;
import com.andro.testapp.view_model.SharedViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArticleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArticleFragment extends Fragment {

    private ArticleViewModel articleViewmodel;
    private ArticleAdapter articleAdapter;
    private LiveData<ArticleResponse> articleResponseLiveData;
    private ArrayList<Article.Results> articleArrayList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private DetailsFragment detailsFragment = new DetailsFragment();
    public static final String TAG = ArticleFragment.class.getSimpleName();
    private FragmentHomeBinding binding;

    public ArticleFragment() {
        // Required empty public constructor
    }

    public static ArticleFragment newInstance() {
        ArticleFragment fragment = new ArticleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        init();
        getArticleList();
        binding.setCallback(sortCallBack);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        articleAdapter.setOnItemClickListner((v,position)-> {
            viewModel.setSelectedArticle(articleAdapter.getArticleAt(position));
            getParentFragmentManager().beginTransaction().addToBackStack(ArticleFragment.TAG).replace(R.id.main_frame, new DetailsFragment()).commit();
        });
    }

    private void init() {
        articleViewmodel = new ArticleViewModel(this.getActivity().getApplication());

        linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.listView.setLayoutManager(linearLayoutManager);
        binding.listView.setHasFixedSize(true);

        articleAdapter = new ArticleAdapter(getActivity(),articleArrayList);
        binding.listView.setAdapter(articleAdapter);

        articleViewmodel = ViewModelProviders.of(this).get(ArticleViewModel.class);
    }

    private void getArticleList(){
        articleViewmodel.getArticleResponseLiveData().observe(getViewLifecycleOwner(),articleResponse -> {
            if(articleResponse != null ){
                binding.progressBarArticle.setVisibility(View.GONE);
                List<Article.Results> list = articleResponse.getResults();
                articleArrayList.addAll(list);
                articleAdapter.notifyDataSetChanged();
            }
        });
    }

    private SortCallBack sortCallBack = new SortCallBack() {
        @Override
        public void sortByName() {
            if(articleArrayList != null){

                articleViewmodel.sortByName(articleArrayList);
                articleAdapter.notifyDataSetChanged();
            }
        }
    };
}