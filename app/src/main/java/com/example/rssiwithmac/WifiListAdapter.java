package com.example.rssiwithmac;

import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WifiListAdapter extends RecyclerView.Adapter<WifiListAdapter.ViewHolder> {

    private List<ScanResult> wifiList;

    public WifiListAdapter(List<ScanResult> wifiList) {
        this.wifiList = wifiList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wifi_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ScanResult wifi = wifiList.get(position);

        holder.ssidTextView.setText(wifi.SSID);
        holder.bssidTextView.setText(wifi.BSSID);
        holder.rssiTextView.setText(String.valueOf(wifi.level));
    }

    @Override
    public int getItemCount() {
        return wifiList.size();
    }

    public void updateWifiList(List<ScanResult> newWifiList) {
        wifiList.clear();
        wifiList.addAll(newWifiList);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView ssidTextView;
        public TextView bssidTextView;
        public TextView rssiTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ssidTextView = itemView.findViewById(R.id.wifi_ssid);
            bssidTextView = itemView.findViewById(R.id.wifi_bssid);
            rssiTextView = itemView.findViewById(R.id.wifi_rssi);
        }
    }
}
