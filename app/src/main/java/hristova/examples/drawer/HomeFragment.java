package hristova.examples.drawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import hristova.examples.drawer.pager.PagerAdapter;
import hristova.examples.drawer.pager.VerticalViewPager;
import hristova.examples.drawer.pager.ZoomOutPageTransformer;

/**
 * Created by radost on 1/23/15.
 */
public class HomeFragment extends Fragment {

    /**
     * The fragment argument representing the home
     * fragment.
     */

    private static final int NUM_PAGES = 5;
    private VerticalViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private ImageView arrowImageView;


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = (VerticalViewPager) rootView.findViewById(R.id.pager);
        pagerAdapter = new PagerAdapter(getFragmentManager(), NUM_PAGES);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        arrowImageView = (ImageView) rootView.findViewById(R.id.imageView);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        Animation floatAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.float_animation);
        floatAnimation.setRepeatCount(Animation.INFINITE);
        arrowImageView.startAnimation(floatAnimation);
    }


    @Override
    public void onStop() {
        super.onStop();
        arrowImageView.clearAnimation();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(1);
    }


}
