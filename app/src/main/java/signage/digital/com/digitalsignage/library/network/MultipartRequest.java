package signage.digital.com.digitalsignage.library.network;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

/**
 * @author
 */
public class MultipartRequest extends Request<String> {
    public MultipartRequest(String url, Response.ErrorListener listener) {
        super(url, listener);
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override
    protected void deliverResponse(String response) {

    }
}