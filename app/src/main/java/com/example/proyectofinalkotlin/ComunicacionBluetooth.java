package com.example.proyectofinalkotlin;

import android.bluetooth.BluetoothSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;


public final class ComunicacionBluetooth {
    @NotNull
    private BluetoothSocket myBluetoothSocket;

    public ComunicacionBluetooth(@NotNull BluetoothSocket myBluetoothSocket) {
        super();
        this.myBluetoothSocket = myBluetoothSocket;
    }

    @NotNull
    public final BluetoothSocket getMyBluetoothSocket() {
        return this.myBluetoothSocket;
    }

    public final void setMyBluetoothSocket(@NotNull BluetoothSocket var1) {
        this.myBluetoothSocket = var1;
    }

    public final void sendCommand(@NotNull String input) {
        if (ControlActivity.Companion.getMyBluetoothSocket() != null) {
            try {
                BluetoothSocket var10000 = ControlActivity.Companion.getMyBluetoothSocket();
                Intrinsics.checkNotNull(var10000);
                OutputStream var5 = var10000.getOutputStream();
                Charset var3 = Charsets.UTF_8;
                byte[] var10001 = input.getBytes(var3);
                Intrinsics.checkNotNullExpressionValue(var10001, "getBytes(...)");
                var5.write(var10001);
            } catch (IOException var4) {
                IOException e = var4;
                e.printStackTrace();
            }
        }

    }

    @NotNull
    public final String read() {
        BluetoothSocket var10000 = ControlActivity.Companion.getMyBluetoothSocket();
        Intrinsics.checkNotNull(var10000);
        InputStream inputStream = var10000.getInputStream();
        byte[] arreglo = new byte[inputStream.available()];
        String mensaje = null;

        try {
            inputStream.read(arreglo);
            mensaje = new String(arreglo, Charsets.UTF_8);
            String var7 = "mi mensaje: " + mensaje;
            System.out.println(var7);
        } catch (IOException var5) {
            IOException e = var5;
            e.printStackTrace();
        }

        String var6;
        if (mensaje == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mensaje");
            var6 = null;
        } else {
            var6 = mensaje;
        }

        return var6;
    }
}

