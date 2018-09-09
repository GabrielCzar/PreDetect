package danielfilho.ufc.br.com.predetect.intefaces;

import java.util.List;

import danielfilho.ufc.br.com.predetect.datas.WiFiData;

/**
 * Created by Daniel Filho on 5/28/16.
 */
public interface WiFiListener extends NetworkListener{
    void onWiFiChange(List<WiFiData> list);
}
