package danielfilho.ufc.br.com.predetect.intefaces;

import java.util.List;

import danielfilho.ufc.br.com.predetect.datas.WiFiData;

/**
 * Created by Daniel Filho on 6/12/16.
 */
public interface WiFiObserver extends NetworkListener {
    void onWiFiObservingEnds(int resultCode, List<WiFiData> list);
}
