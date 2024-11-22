package com.example.proyectofinalkotlin;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


@RequiresApi(31)
public final class EllawFacade extends AppCompatActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
    @Nullable
    private BluetoothAdapter bAdapter = BluetoothAdapter.getDefaultAdapter();
    private Set DispoEmparejados;
    @NotNull
    private static final String EXTRA_ADDRESS = "Device_address";
    private static final int REQUEST_ENABLE_BLUETOOTH = 1;
    private static final int REQUEST_PERMISSION_CODE = 2;

    public EllawFacade() {
        if (this.bAdapter != null) {
            if (ContextCompat.checkSelfPermission((Context)this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                BluetoothAdapter var10001 = this.bAdapter;
                Intrinsics.checkNotNull(var10001);
                Set var1 = var10001.getBondedDevices();
                Intrinsics.checkNotNullExpressionValue(var1, "getBondedDevices(...)");
                this.DispoEmparejados = var1;
            } else {
                Activity var10000 = (Activity)this;
                String[] var2 = new String[]{"android.permission.BLUETOOTH_CONNECT"};
                ActivityCompat.requestPermissions(var10000, var2, REQUEST_PERMISSION_CODE);
                this.DispoEmparejados = SetsKt.emptySet();
            }
        } else {
            this.DispoEmparejados = SetsKt.emptySet();
        }

    }

    public final void setAdapter(@NotNull BluetoothAdapter b) {
        Intrinsics.checkNotNullParameter(b, "b");
        this.bAdapter = b;
    }

    @Nullable
    public final BluetoothAdapter getAdapter() {
        return this.bAdapter;
    }

    public final void setEmparejados(@NotNull Set d) {
        Intrinsics.checkNotNullParameter(d, "d");
        this.DispoEmparejados = d;
    }

    @NotNull
    public final Set getEmparejados() {
        Set var1 = this.DispoEmparejados;
        Set var10000;
        if (var1 != null) {
            var10000 = var1;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("DispoEmparejados");
            var10000 = null;
        }

        return var10000;
    }

    private final void updateBondedDevices() {
        if (this.bAdapter != null) {
            if (ContextCompat.checkSelfPermission((Context)this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                BluetoothAdapter var10001 = this.bAdapter;
                Intrinsics.checkNotNull(var10001);
                Set var1 = var10001.getBondedDevices();
                Intrinsics.checkNotNullExpressionValue(var1, "getBondedDevices(...)");
                this.DispoEmparejados = var1;
            } else {
                Activity var10000 = (Activity)this;
                String[] var2 = new String[]{"android.permission.BLUETOOTH_CONNECT"};
                ActivityCompat.requestPermissions(var10000, var2, REQUEST_PERMISSION_CODE);
                this.DispoEmparejados = SetsKt.emptySet();
            }
        }

    }

    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (grantResults.length != 0 && grantResults[0] == 0) {
                this.updateBondedDevices();
            } else {
                this.DispoEmparejados = SetsKt.emptySet();
            }
        }

    }

    @Metadata(
            mv = {1, 9, 0},
            k = 1,
            xi = 48,
            d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"},
            d2 = {"Lcom/example/proyectofinalkotlin/EllawFacade$Companion;", "", "()V", "EXTRA_ADDRESS", "", "getEXTRA_ADDRESS", "()Ljava/lang/String;", "REQUEST_ENABLE_BLUETOOTH", "", "getREQUEST_ENABLE_BLUETOOTH", "()I", "REQUEST_PERMISSION_CODE", "getREQUEST_PERMISSION_CODE", "app_debug"}
    )
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getEXTRA_ADDRESS() {
            return EllawFacade.EXTRA_ADDRESS;
        }

        public final int getREQUEST_ENABLE_BLUETOOTH() {
            return EllawFacade.REQUEST_ENABLE_BLUETOOTH;
        }

        public final int getREQUEST_PERMISSION_CODE() {
            return EllawFacade.REQUEST_PERMISSION_CODE;
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

