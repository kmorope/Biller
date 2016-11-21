package com.biller.appe;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ingenian on 21/11/2016.
 */

public class CatFragment extends BaseFragment {

    private List<Category> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CategoriesAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.catList);

        mAdapter = new CategoriesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Agregar Categoria", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        prepareMovieData();
        return view;
    }

    private void prepareMovieData() {

        Category category = new Category("Transporte","20/05/2016","$240.000", ResourcesCompat.getDrawable(getResources(), R.drawable.ic_bus_black_36dp, null));
        movieList.add(category);
        category = new Category("Alimentacion","20/07/2016", ResourcesCompat.getDrawable(getResources(), R.drawable.ic_food_black_36dp, null));
        movieList.add(category);
        category = new Category("Tarjetas","20/06/2016", ResourcesCompat.getDrawable(getResources(), R.drawable.ic_credit_card_black_36dp, null));
        movieList.add(category);

        mAdapter.notifyDataSetChanged();
    }

    public static CatFragment  newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        CatFragment fragment = new CatFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
