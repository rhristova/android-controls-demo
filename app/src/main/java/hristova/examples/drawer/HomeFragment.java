package hristova.examples.drawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(1);
    }


}
