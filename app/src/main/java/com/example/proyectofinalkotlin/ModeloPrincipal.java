package com.example.proyectofinalkotlin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.proyectofinalkotlin.R.id;
import com.example.proyectofinalkotlin.R.layout;
import com.example.proyectofinalkotlin.api.ApiClient;
import com.example.proyectofinalkotlin.api.ApiInterface;
import com.example.proyectofinalkotlin.model.login.Data;
import com.example.proyectofinalkotlin.model.login.DataLogin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class ModeloPrincipal extends AppCompatActivity {
    public ApiInterface apiInterface;
    public SessionManager sessionManager;
    @Nullable
    private Button login;
    @Nullable
    private EditText user;
    @Nullable
    private EditText password;

    @NotNull
    public final ApiInterface getApiInterface() {
        ApiInterface var1 = this.apiInterface;
        if (var1 != null) {
            return var1;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("apiInterface");
            return null;
        }
    }

    public final void setApiInterface(@NotNull ApiInterface var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.apiInterface = var1;
    }

    @NotNull
    public final SessionManager getSessionManager() {
        SessionManager var1 = this.sessionManager;
        if (var1 != null) {
            return var1;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            return null;
        }
    }

    public final void setSessionManager(@NotNull SessionManager var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.sessionManager = var1;
    }

    @Nullable
    public final Button getLogin() {
        return this.login;
    }

    public final void setLogin(@Nullable Button var1) {
        this.login = var1;
    }

    @Nullable
    public final EditText getUser() {
        return this.user;
    }

    public final void setUser(@Nullable EditText var1) {
        this.user = var1;
    }

    @Nullable
    public final EditText getPassword() {
        return this.password;
    }

    public final void setPassword(@Nullable EditText var1) {
        this.password = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.login_activity);
        this.login = (Button)this.findViewById(id.btnLogin);
        this.user = (EditText)this.findViewById(id.etUsr);
        this.password = (EditText)this.findViewById(id.etPassword);
        Button var10000 = this.login;
        Intrinsics.checkNotNull(var10000);
        var10000.setOnClickListener(ModeloPrincipal::onCreate$lambda$0);
    }

    public final void login(@NotNull String user, @NotNull String password) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(password, "password");
        Object var3 = ApiClient.Companion.getClient().create(ApiInterface.class);
        Intrinsics.checkNotNullExpressionValue(var3, "create(...)");
        this.setApiInterface((ApiInterface)var3);
        Call loginCall = this.getApiInterface().loginResponse(user, password);
        loginCall.enqueue((Callback)(new Callback() {
            public void onResponse(Call call, Response response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Context var5;
                if (response.body() != null && response.isSuccessful()) {
                    Object var10000 = response.body();
                    Intrinsics.checkNotNull(var10000);
                    Boolean var4 = ((DataLogin)var10000).getStatus();
                    Intrinsics.checkNotNull(var4);
                    if (var4) {
                        ModeloPrincipal.this.setSessionManager(new SessionManager((Context)ModeloPrincipal.this));
                        var10000 = response.body();
                        Intrinsics.checkNotNull(var10000);
                        Data var7 = ((DataLogin)var10000).getData();
                        Intrinsics.checkNotNull(var7);
                        Data dataLogin = var7;
                        ModeloPrincipal.this.getSessionManager().createLoginSession(dataLogin);
                        var5 = ModeloPrincipal.this.getApplicationContext();
                        StringBuilder var8 = (new StringBuilder()).append("Bienvenido ");
                        Object var10002 = response.body();
                        Intrinsics.checkNotNull(var10002);
                        Data var9 = ((DataLogin)var10002).getData();
                        Intrinsics.checkNotNull(var9);
                        String var10 = var9.getUsername();
                        Intrinsics.checkNotNull(var10);
                        Toast.makeText(var5, (CharSequence)var8.append(var10).toString(), 0).show();
                        return;
                    }
                }

                var5 = ModeloPrincipal.this.getApplicationContext();
                Object var10001 = response.body();
                Intrinsics.checkNotNull(var10001);
                String var6 = ((DataLogin)var10001).getMessage();
                Intrinsics.checkNotNull(var6);
                Toast.makeText(var5, (CharSequence)var6, 0).show();
            }

            public void onFailure(Call call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Toast.makeText(ModeloPrincipal.this.getApplicationContext(), (CharSequence)t.getLocalizedMessage(), 0).show();
                t.printStackTrace();
            }
        }));
    }

    public final void switchScreen() {
        Intent intent = new Intent((Context)this, ModelDevice.class);
        this.startActivity(intent);
        this.finish();
    }

    private static final void onCreate$lambda$0(ModeloPrincipal this$0, View it) {
        EditText var10000 = this$0.user;
        Intrinsics.checkNotNull(var10000);
        String user = var10000.getText().toString();
        HashContrasena.Companion var4 = HashContrasena.Companion;
        EditText var10001 = this$0.password;
        Intrinsics.checkNotNull(var10001);
        String password = var4.hash(var10001.getText().toString());
        this$0.login(user, password);
    }
}
