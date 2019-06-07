package com.example.a20190530_chandragudimetla_nycschools.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.a20190530_chandragudimetla_nycschools.R;
import com.example.a20190530_chandragudimetla_nycschools.SchoolViewModel;
import com.example.a20190530_chandragudimetla_nycschools.data.School;
import com.example.a20190530_chandragudimetla_nycschools.databinding.ActivityMainBinding;


//Developed the App icon using the following link: https://romannurik.github.io/AndroidAssetStudio/index.html
//Used colors from: https://uicolorpicker.com/
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding binding;
    private SchoolViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        loadListFragment();

        viewModel = ViewModelProviders.of(this).get(SchoolViewModel.class);
    }

    private void loadListFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (isNetworkAvailable()) {
            hideOfflineViews();
            if (fragmentManager.findFragmentById(R.id.fragment_container) == null) {
                ListFragment listFragment = ListFragment.newInstance();
                fragmentManager
                        .beginTransaction()
                        .add(R.id.fragment_container, listFragment, "listFragment")
                        .commit();
            }
        } else {
            showOfflineViews();
        }
    }

    // if no internet is available display these views
    private void showOfflineViews() {
        binding.noInternetTv.setVisibility(View.VISIBLE);
        binding.wifiLogo.setVisibility(View.VISIBLE);
    }

    // if internet is available hide these views
    private void hideOfflineViews() {
        binding.noInternetTv.setVisibility(View.GONE);
        binding.wifiLogo.setVisibility(View.GONE);
    }

    // checks for internet connection
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onItemClick(final int position) {
        viewModel.getSchools().observe(this, new Observer<List<School>>() {
            @Override
            public void onChanged(@Nullable List<School> schools) {
                Log.d(TAG, "onChanged: " + schools.get(position));
                viewModel.setSchool(schools.get(position));
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, DetailsFragment.getInstance())
                .addToBackStack(null)
                .commit();
    }
}

