package danielfilho.ufc.br.com.predetect.receivers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

import danielfilho.ufc.br.com.predetect.intefaces.INetworkReceiver;
import danielfilho.ufc.br.com.predetect.managers.NetworkManager;

/**
 * Created by Daniel Filho on 6/2/16.
 */
public class NetworkReceiver extends WakefulBroadcastReceiver {

    private INetworkReceiver networkManager;

    public NetworkReceiver() {
        networkManager = NetworkManager.getInstance();
    }

    @Override
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    public void onReceive(Context context, Intent intent) {
        networkManager.onNetworkReceive(context, intent);
    }
}
