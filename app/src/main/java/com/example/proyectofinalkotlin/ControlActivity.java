package com.example.proyectofinalkotlin;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.proyectofinalkotlin.R.id;
import com.example.proyectofinalkotlin.R.layout;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public final class ControlActivity extends AppCompatActivity implements LoginInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
    @Nullable
    private Button ledOn;
    @Nullable
    private Button ledOff;
    @Nullable
    private Button logout;
    @Nullable
    private Button horario;
    @Nullable
    private Button barrer;
    @NotNull
    private static UUID myUUID;
    @Nullable
    private static BluetoothSocket myBluetoothSocket;
    public static ProgressDialog myProgress;
    public static BluetoothAdapter bAdapter;
    private static boolean isConnected;
    public static String m_address;
    private static Handler myHandler;
    public static ComunicacionBluetooth comunicacion;

    @Nullable
    public final Button getLedOn() {
        return this.ledOn;
    }

    public final void setLedOn(@Nullable Button var1) {
        this.ledOn = var1;
    }

    @Nullable
    public final Button getLedOff() {
        return this.ledOff;
    }

    public final void setLedOff(@Nullable Button var1) {
        this.ledOff = var1;
    }

    @Nullable
    public final Button getLogout() {
        return this.logout;
    }

    public final void setLogout(@Nullable Button var1) {
        this.logout = var1;
    }

    @Nullable
    public final Button getHorario() {
        return this.horario;
    }

    public final void setHorario(@Nullable Button var1) {
        this.horario = var1;
    }

    @Nullable
    public final Button getBarrer() {
        return this.barrer;
    }

    public final void setBarrer(@Nullable Button var1) {
        this.barrer = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.control_layout);
        this.ledOn = (Button)this.findViewById(id.control_led_on);
        this.ledOff = (Button)this.findViewById(id.control_led_off);
        this.logout = (Button)this.findViewById(id.btnLogout);
        this.horario = (Button)this.findViewById(id.btnHorario);
        this.barrer = (Button)this.findViewById(id.btnBarrer);
        Companion.setM_address(String.valueOf(this.getIntent().getStringExtra(EllawFacade.Companion.getEXTRA_ADDRESS())));
        Companion var10000 = Companion;
        myHandler = new Handler();
        (new ConexionBluetooth((Context)this)).execute(new Void[0]);
        Button var2 = this.ledOn;
        Intrinsics.checkNotNull(var2);
        var2.setOnClickListener(ControlActivity::onCreate$lambda$0);
        var2 = this.ledOff;
        Intrinsics.checkNotNull(var2);
        var2.setOnClickListener(ControlActivity::onCreate$lambda$1);
        var2 = this.logout;
        Intrinsics.checkNotNull(var2);
        var2.setOnClickListener(ControlActivity::onCreate$lambda$2);
        var2 = this.horario;
        Intrinsics.checkNotNull(var2);
        var2.setOnClickListener(ControlActivity::onCreate$lambda$3);
        var2 = this.barrer;
        Intrinsics.checkNotNull(var2);
        var2.setOnClickListener(ControlActivity::onCreate$lambda$4);
    }

    public void moveToLogin() {
        Intent intent = new Intent((Context)this, ModeloPrincipal.class);
        intent.setFlags(1073774592);
        this.startActivity(intent);
        this.finish();
    }

    private static final void onCreate$lambda$0(View it) {
        Companion.getComunicacion().sendCommand("on");
        Thread.sleep(1000L);
        Companion.getComunicacion().sendCommand("031459");
    }

    private static final void onCreate$lambda$1(View it) {
        Companion.getComunicacion().sendCommand("off");
    }

    private static final void onCreate$lambda$2(ControlActivity this$0, View it) {
        ConexionBluetooth.Companion.disconnect((AppCompatActivity)this$0);
        ModelDevice.Companion.getSessionManager().logOutSession();
        this$0.moveToLogin();
    }

    private static final void onCreate$lambda$3(ControlActivity this$0, View it) {
        Intent intent = new Intent((Context)this$0, ModeloHorario.class);
        this$0.startActivity(intent);
    }

    private static final void onCreate$lambda$4(ControlActivity this$0, View it) {
        Companion.getComunicacion().sendCommand("barrer");
        Toast.makeText((Context)this$0, (CharSequence)"Barriendo", 0).show();
    }

    static {
        UUID var0 = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
        Intrinsics.checkNotNullExpressionValue(var0, "fromString(...)");
        myUUID = var0;
    }


    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final UUID getMyUUID() {
            return ControlActivity.myUUID;
        }

        public final void setMyUUID(@NotNull UUID var1) {
            Intrinsics.checkNotNullParameter(var1, "<set-?>");
            ControlActivity.myUUID = var1;
        }

        @Nullable
        public final BluetoothSocket getMyBluetoothSocket() {
            return ControlActivity.myBluetoothSocket;
        }

        public final void setMyBluetoothSocket(@Nullable BluetoothSocket var1) {
            ControlActivity.myBluetoothSocket = var1;
        }

        @NotNull
        public final ProgressDialog getMyProgress() {
            ProgressDialog var1 = ControlActivity.myProgress;
            if (var1 != null) {
                return var1;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("myProgress");
                return null;
            }
        }

        public final void setMyProgress(@NotNull ProgressDialog var1) {
            Intrinsics.checkNotNullParameter(var1, "<set-?>");
            ControlActivity.myProgress = var1;
        }

        @NotNull
        public final BluetoothAdapter getBAdapter() {
            BluetoothAdapter var1 = ControlActivity.bAdapter;
            if (var1 != null) {
                return var1;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("bAdapter");
                return null;
            }
        }

        public final void setBAdapter(@NotNull BluetoothAdapter var1) {
            Intrinsics.checkNotNullParameter(var1, "<set-?>");
            ControlActivity.bAdapter = var1;
        }

        public final boolean isConnected() {
            return ControlActivity.isConnected;
        }

        public final void setConnected(boolean var1) {
            ControlActivity.isConnected = var1;
        }

        @NotNull
        public final String getM_address() {
            String var1 = ControlActivity.m_address;
            if (var1 != null) {
                return var1;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("m_address");
                return null;
            }
        }

        public final void setM_address(@NotNull String var1) {
            Intrinsics.checkNotNullParameter(var1, "<set-?>");
            ControlActivity.m_address = var1;
        }

        @NotNull
        public final ComunicacionBluetooth getComunicacion() {
            ComunicacionBluetooth var1 = ControlActivity.comunicacion;
            if (var1 != null) {
                return var1;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("comunicacion");
                return null;
            }
        }

        public final void setComunicacion(@NotNull ComunicacionBluetooth var1) {
            Intrinsics.checkNotNullParameter(var1, "<set-?>");
            ControlActivity.comunicacion = var1;
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

