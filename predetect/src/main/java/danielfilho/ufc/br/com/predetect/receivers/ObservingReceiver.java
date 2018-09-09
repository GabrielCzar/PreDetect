package danielfilho.ufc.br.com.predetect.receivers;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;
import com.elvishew.xlog.printer.file.FilePrinter;

import danielfilho.ufc.br.com.predetect.services.NetworkObserverService;

import static danielfilho.ufc.br.com.predetect.constants.PreDetectConstants.ACTION_SERVICE_WAKEFUL_BROADCAST;
import static danielfilho.ufc.br.com.predetect.constants.PreDetectConstants.LOG_PATH;
import static danielfilho.ufc.br.com.predetect.constants.PreDetectConstants.LOG_TAG;
import static danielfilho.ufc.br.com.predetect.constants.PreDetectConstants.WIFI_BUNDLE;

/**
 * Created by Daniel Filho on 11/17/16.
 */

public class ObservingReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == null)
            return;

        if (intent.getAction().equals(ACTION_SERVICE_WAKEFUL_BROADCAST)) {
            XLog.init(LogLevel.ALL, new FilePrinter.Builder(LOG_PATH).build());

            if (intent.getByteArrayExtra(WIFI_BUNDLE) != null) {
                XLog.d(System.currentTimeMillis() + "|  -------------- PRE DETECT : ON BROADCAST  -----------");
                Log.d(LOG_TAG, "-------------- PRE DETECT : ON BROADCAST  -----------");
                Intent observingIntent = new Intent(context, NetworkObserverService.class);
                observingIntent.putExtra(WIFI_BUNDLE, intent.getByteArrayExtra(WIFI_BUNDLE));
                startWakefulService(context, observingIntent);
            } else {
                Log.e(LOG_TAG, "-------------- THE BUNDLE ON WIFI OBSERVING IS NULL -----------");
                XLog.e(System.currentTimeMillis() + "|  -------------- THE BUNDLE ON WIFI OBSERVING IS NULL -----------");
            }
        }

    }
}
