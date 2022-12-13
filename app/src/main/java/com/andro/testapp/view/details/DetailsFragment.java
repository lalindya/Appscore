package com.andro.testapp.view.details;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andro.testapp.R;
import com.andro.testapp.databinding.FragmentDetailsBinding;
import com.andro.testapp.model.Article;
import com.andro.testapp.view_model.ArticleViewModel;
import com.andro.testapp.view_model.DetailsViewModel;
import com.andro.testapp.view_model.SharedViewModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class DetailsFragment extends Fragment {
    private DetailsViewModel detailsViewModel;

    private FragmentDetailsBinding binding;
    SharedViewModel sharedViewModel;
    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        detailsViewModel = new DetailsViewModel(this.getActivity().getApplication(),sharedViewModel.getSelectedArticle().getValue().getId());


        getArticleList();
        return binding.getRoot();
    }

    private void getArticleList(){
        detailsViewModel.getArticleDetailsResponseLiveData().observe(getViewLifecycleOwner(),articleResponse -> {
            if(articleResponse != null ){
                Glide.with(getActivity())
                        .load(sharedViewModel.getSelectedArticle().getValue().getAgency().getImage_url())
                        .into(binding.imageView);
                binding.name.setText(articleResponse.getDate_of_birth());
                binding.nationality.setText(articleResponse.getNationality());
                binding.bio.setText(articleResponse.getBio());

            }
        });
    }
}