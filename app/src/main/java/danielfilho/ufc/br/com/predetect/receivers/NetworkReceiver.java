package danielfilho.ufc.br.com.predetect.receivers;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import danielfilho.ufc.br.com.predetect.managers.NetworkManager;
import danielfilho.ufc.br.com.predetect.intefaces.INetworkReceiver;

/**
 * Created by Daniel Filho on 6/2/16.
 */
public class NetworkReceiver extends BroadcastReceiver {

    private INetworkReceiver networkManager;

    public NetworkReceiver() {
        networkManager = NetworkManager.getInstance();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        networkManager.onNetworkReceive(context, intent);
    }
}
