package br.ufc.predetect.ble.utils

import android.bluetooth.le.ScanSettings
import br.ufc.predetect.ble.properties.BLENetworkProperties.rssiAtOneMeter
import br.ufc.predetect.ble.properties.BLENetworkProperties.signalLoss
import br.ufc.quixada.predetect.common.utils.calculateDistance
import java.lang.Double.parseDouble
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols


/**
 * This formula is based in path loss model function
 *
 * @param rssi Received Signal Strength Intensity
 * @return distance based in rssi
 *
 */
fun rssiToDistance(rssi: Int): Double {

    val decimalFormat = DecimalFormat(".##")
    val dfs = DecimalFormatSymbols()
    dfs.decimalSeparator = '.'
    decimalFormat.decimalFormatSymbols = dfs

    val distance = calculateDistance(rssi.toDouble(), rssiAtOneMeter.toDouble(), signalLoss)
    return parseDouble(decimalFormat.format(distance))
}

fun scanSettings() : ScanSettings = ScanSettings.Builder()
        .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
        .setCallbackType(ScanSettings.CALLBACK_TYPE_ALL_MATCHES)
        .setReportDelay(TEN_MILLISECONDS)
        .build()

private const val TEN_MILLISECONDS = 10L