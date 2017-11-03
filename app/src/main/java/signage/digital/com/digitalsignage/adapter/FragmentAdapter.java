package signage.digital.com.digitalsignage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by everest on 03/11/2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> list = new ArrayList<Fragment>();

    public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

    public void add(Fragment fragment) {
            list.add(fragment);
        }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
}
