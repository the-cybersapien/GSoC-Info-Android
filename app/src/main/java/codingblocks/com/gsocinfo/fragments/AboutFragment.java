package codingblocks.com.gsocinfo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import codingblocks.com.gsocinfo.R;
import codingblocks.com.gsocinfo.adapters.TimelineAdapter;

/**
 * Created by harshit on 25/08/17.
 */

public class AboutFragment extends Fragment {


    SliderLayout sliderLayout;
    public static AboutFragment newInstance() {

        Bundle args = new Bundle();

        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_timeline);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        sliderLayout = view.findViewById(R.id.sliderView);

        DefaultSliderView apply  = new DefaultSliderView(getContext());

        apply.image(R.drawable.apply);
        DefaultSliderView code = new DefaultSliderView(getContext());
        code.image(R.drawable.code);
        DefaultSliderView share = new DefaultSliderView(getContext());
        share.image(R.drawable.share);

        sliderLayout.addSlider(apply);
        sliderLayout.addSlider(code);
        sliderLayout.addSlider(share);
        sliderLayout.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);
        sliderLayout.startAutoCycle();

        TimelineAdapter timelineAdapter = new TimelineAdapter();


        recyclerView.setAdapter(timelineAdapter);
        return view;
    }

    @Override
    public void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }
}