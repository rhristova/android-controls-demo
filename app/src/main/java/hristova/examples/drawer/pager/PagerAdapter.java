package hristova.examples.drawer.pager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by radost on 1/24/15.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    private int count = 0;

    public PagerAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("number", (i + 1));
        Fragment fr = new PageFragment();
        fr.setArguments(bundle);

        return fr;
    }

    @Override
    public int getCount() {
        return count;
    }
}