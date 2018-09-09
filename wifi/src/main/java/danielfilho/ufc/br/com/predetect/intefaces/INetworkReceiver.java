package danielfilho.ufc.br.com.predetect.intefaces;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Daniel Filho on 6/12/16.
 */
public interface INetworkReceiver {
    void onNetworkReceive(Context context, Intent intent);
}
