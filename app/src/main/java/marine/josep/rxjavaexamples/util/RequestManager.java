package marine.josep.rxjavaexamples.util;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;

import java.io.File;

/**
 * Created by T15804 on 05/09/2018.
 */

public class RequestManager {

  private RequestQueue requestQueue;
  private Cache cache;
  private Network network;

  public RequestManager() {
    cache = new DiskBasedCache(new File("/"), 1024 * 1024);
    network = new BasicNetwork(new HurlStack());
    requestQueue = new RequestQueue(cache, network);
    requestQueue.start();
  }

  public void add(StringRequest stringRequest){
    requestQueue.add(stringRequest);
  }

}
