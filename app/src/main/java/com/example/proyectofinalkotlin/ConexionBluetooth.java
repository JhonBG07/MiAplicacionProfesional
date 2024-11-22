package com.example.proyectofinalkotlin;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public final class ConexionBluetooth extends AsyncTask {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
    private boolean connectSuccess;
    @NotNull
    private final Context context;

    public ConexionBluetooth(@NotNull Context c) {
        super();
        this.connectSuccess = true;
        this.context = c;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        ControlActivity.Companion var10000 = ControlActivity.Companion;
        ProgressDialog var1 = ProgressDialog.show(this.context, (CharSequence)"Conectando...", (CharSequence)"Espera");
        Intrinsics.checkNotNullExpressionValue(var1, "show(...)");
        var10000.setMyProgress(var1);
    }

    @Nullable
    protected String doInBackground(@NotNull Void... p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");

        try {
            if (ControlActivity.Companion.getMyBluetoothSocket() == null || !ControlActivity.Companion.isConnected()) {
                ControlActivity.Companion var10000 = ControlActivity.Companion;
                BluetoothAdapter var5 = BluetoothAdapter.getDefaultAdapter();
                var10000.setBAdapter(var5);
                BluetoothDevice var3 = ControlActivity.Companion.getBAdapter().getRemoteDevice(ControlActivity.Companion.getM_address());
                BluetoothDevice device = var3;
                ControlActivity.Companion.setMyBluetoothSocket(device.createInsecureRfcommSocketToServiceRecord(ControlActivity.Companion.getMyUUID()));
                BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                BluetoothSocket var7 = ControlActivity.Companion.getMyBluetoothSocket();
                Intrinsics.checkNotNull(var7);
                var7.connect();
                var10000 = ControlActivity.Companion;
                BluetoothSocket var10003 = ControlActivity.Companion.getMyBluetoothSocket();
                Intrinsics.checkNotNull(var10003);
                var10000.setComunicacion(new ComunicacionBluetooth(var10003));
            }
        } catch (IOException var4) {
            IOException e = var4;
            this.connectSuccess = false;
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(@Nullable String result) {
        super.onPostExecute(result);
        if (!this.connectSuccess) {
            Log.i("data", "no se pudo conectar");
        } else {
            ControlActivity.Companion.setConnected(true);
        }

        ControlActivity.Companion.getMyProgress().dismiss();
    }

    // $FF: synthetic method
    // $FF: bridge method
    public Object doInBackground(Object[] params) {
        return this.doInBackground((Void[])params);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void onPostExecute(Object result) {
        this.onPostExecute((String)result);
    }

    @Metadata(
            mv = {1, 9, 0},
            k = 1,
            xi = 48,
            d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"},
            d2 = {"Lcom/example/proyectofinalkotlin/ConexionBluetooth$Companion;", "", "()V", "disconnect", "", "activityCont", "Landroidx/appcompat/app/AppCompatActivity;", "app_debug"}
    )
    public static final class Companion {
        private Companion() {
        }

        public final void disconnect(@NotNull AppCompatActivity activityCont) {
            Intrinsics.checkNotNullParameter(activityCont, "activityCont");
            if (ControlActivity.Companion.getMyBluetoothSocket() != null) {
                try {
                    BluetoothSocket var10000 = ControlActivity.Companion.getMyBluetoothSocket();
                    Intrinsics.checkNotNull(var10000);
                    var10000.close();
                    ControlActivity.Companion.setMyBluetoothSocket((BluetoothSocket)null);
                    ControlActivity.Companion.setConnected(false);
                } catch (IOException var3) {
                    IOException e = var3;
                    e.printStackTrace();
                }
            }

            activityCont.finish();
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

