package com.example.proyectofinalkotlin;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.example.proyectofinalkotlin.R.id;
import com.example.proyectofinalkotlin.R.layout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ModelDevice extends AppCompatActivity implements Serializable, LoginInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
    @NotNull
    private EllawFacade facade = new EllawFacade();
    @Nullable
    private Button refreshDevice;
    @Nullable
    private ListView deviceList;
    private final int REQUEST_PERMISSION_CODE = 1;
    public static SessionManager sessionManager;

    @NotNull
    public final EllawFacade getFacade() {
        return this.facade;
    }

    public final void setFacade(@NotNull EllawFacade var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.facade = var1;
    }

    @Nullable
    public final Button getRefreshDevice() {
        return this.refreshDevice;
    }

    public final void setRefreshDevice(@Nullable Button var1) {
        this.refreshDevice = var1;
    }

    @Nullable
    public final ListView getDeviceList() {
        return this.deviceList;
    }

    public final void setDeviceList(@Nullable ListView var1) {
        this.deviceList = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.select_list_device);
        Companion.setSessionManager(new SessionManager((Context)this));
        this.refreshDevice = (Button)this.findViewById(id.select_device_refresh);
        this.deviceList = (ListView)this.findViewById(id.select_device_list);
        if (!Companion.getSessionManager().isLoggedIn()) {
            this.moveToLogin();
        } else {
            if (this.facade.getAdapter() == null) {
                Toast.makeText((Context)this, (CharSequence)"No soporta Bluetooth", 0).show();
                return;
            }

            BluetoothAdapter var10000 = this.facade.getAdapter();
            Intrinsics.checkNotNull(var10000);
            if (!var10000.isEnabled()) {
                Intent enableBluetoothIntent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
                if (ContextCompat.checkSelfPermission((Context)this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                    try {
                        this.startActivityForResult(enableBluetoothIntent, EllawFacade.Companion.getREQUEST_ENABLE_BLUETOOTH());
                    } catch (SecurityException var4) {
                        Toast.makeText((Context)this, (CharSequence)"Se necesita el permiso de Bluetooth", 0).show();
                    }
                } else {
                    Activity var5 = (Activity)this;
                    String[] var3 = new String[]{"android.permission.BLUETOOTH_CONNECT"};
                    ActivityCompat.requestPermissions(var5, var3, this.REQUEST_PERMISSION_CODE);
                }
            }

            Button var6 = this.refreshDevice;
            Intrinsics.checkNotNull(var6);
            var6.setOnClickListener(ModelDevice::onCreate$lambda$0);
        }

    }

    private final void pairedDeviceList() {
        ArrayList list = new ArrayList();
        if (!this.facade.getEmparejados().isEmpty()) {
            Iterator var2 = this.facade.getEmparejados().iterator();

            while(var2.hasNext()) {
                BluetoothDevice device = (BluetoothDevice)var2.next();
                list.add(device);
            }
        } else {
            Toast.makeText((Context)this, (CharSequence)"No se encontraron dispositivos bluetooth", 0).show();
        }

        ArrayAdapter adapter = new ArrayAdapter((Context)this, 17367043, (List)list);
        ListView var10000 = this.deviceList;
        Intrinsics.checkNotNull(var10000);
        var10000.setAdapter((ListAdapter)adapter);
        var10000 = this.deviceList;
        Intrinsics.checkNotNull(var10000);
        var10000.setOnItemClickListener(ModelDevice::pairedDeviceList$lambda$1);
    }

    public void moveToLogin() {
        Intent intent = new Intent((Context)this, ModeloPrincipal.class);
        intent.setFlags(1073774592);
        this.startActivity(intent);
        this.finish();
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EllawFacade.Companion.getREQUEST_ENABLE_BLUETOOTH()) {
            if (resultCode == -1) {
                Toast.makeText((Context)this, (CharSequence)"Bluetooth habilitado", 0).show();
            } else {
                Toast.makeText((Context)this, (CharSequence)"El usuario no habilitó el Bluetooth", 0).show();
            }
        }

    }

    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == this.REQUEST_PERMISSION_CODE) {
            if (grantResults.length != 0 && grantResults[0] == 0) {
                Intent enableBluetoothIntent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");

                try {
                    this.startActivityForResult(enableBluetoothIntent, EllawFacade.Companion.getREQUEST_ENABLE_BLUETOOTH());
                } catch (SecurityException var6) {
                    Toast.makeText((Context)this, (CharSequence)"Se necesita el permiso de Bluetooth", 0).show();
                }
            } else {
                Toast.makeText((Context)this, (CharSequence)"Se necesita el permiso de Bluetooth para continuar", 0).show();
            }
        }

    }

    private static final void onCreate$lambda$0(ModelDevice this$0, View it) {
        this$0.pairedDeviceList();
    }

    private static final void pairedDeviceList$lambda$1(ArrayList $list, ModelDevice this$0, AdapterView var2, View var3, int position, long var5) {
        Object var8 = $list.get(position);
        Intrinsics.checkNotNullExpressionValue(var8, "get(...)");
        BluetoothDevice device = (BluetoothDevice)var8;
        String var9 = device.getAddress();
        Intrinsics.checkNotNullExpressionValue(var9, "getAddress(...)");
        String address = var9;
        Intent intent = new Intent((Context)this$0, ControlActivity.class);
        intent.putExtra(EllawFacade.Companion.getEXTRA_ADDRESS(), address);
        this$0.startActivity(intent);
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SessionManager getSessionManager() {
            SessionManager var1 = ModelDevice.sessionManager;
            if (var1 != null) {
                return var1;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
                return null;
            }
        }

        public final void setSessionManager(@NotNull SessionManager var1) {
            Intrinsics.checkNotNullParameter(var1, "<set-?>");
            ModelDevice.sessionManager = var1;
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

