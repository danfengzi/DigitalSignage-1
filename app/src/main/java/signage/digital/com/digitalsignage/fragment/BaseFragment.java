package signage.digital.com.digitalsignage.fragment;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;

/**
 * Created by Alexandre on 07/10/2016.
 */

public class BaseFragment extends Fragment {
    public static final String TAG = "--->>>";

    private ProgressDialog mProgressDialog;

    protected void showDialog() {
        if (mProgressDialog == null) {
            setProgressDialog();
        }
        mProgressDialog.show();
    }

    protected void hideDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    private void setProgressDialog() {
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setTitle("Thinking...");
        mProgressDialog.setMessage("Doing the action...");
    }

}