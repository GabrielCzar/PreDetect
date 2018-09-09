package danielfilho.ufc.br.com.predetect.datas;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Filho on 6/6/16.
 */
public class WiFiBundle implements Parcelable{
    private List<String> wifiData;
    private int observeTime;
    private double distanceRange;

    public WiFiBundle(List<String> wifiData, int observeTime, double distanceRange) {
        this.wifiData = wifiData;
        this.observeTime = observeTime;
        this.distanceRange = distanceRange;
    }

    @SuppressWarnings("unchecked")
    protected WiFiBundle(Parcel in) {
        wifiData = in.readArrayList(String.class.getClassLoader());
        observeTime = in.readInt();
        distanceRange = in.readDouble();
    }

    public static final Creator<WiFiBundle> CREATOR = new Creator<WiFiBundle>() {
        @Override
        public WiFiBundle createFromParcel(Parcel in) {
            return new WiFiBundle(in);
        }

        @Override
        public WiFiBundle[] newArray(int size) {
            return new WiFiBundle[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(wifiData);
        dest.writeInt(observeTime);
        dest.writeDouble(distanceRange);
    }

    public List<String> getWifiData() {
        return wifiData;
    }

    public void setWifiData(List<String> wifiData) {
        this.wifiData = wifiData;
    }

    public int getObserveTime() {
        return observeTime;
    }

    public void setObserveTime(int observeTime) {
        this.observeTime = observeTime;
    }

    public double getDistanceRange() {
        return distanceRange;
    }

    public void setDistanceRange(double distanceRange) {
        this.distanceRange = distanceRange;
    }

}
