package com.example.proyectofinalkotlin;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.example.proyectofinalkotlin.model.login.Data;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;


public final class SessionManager implements Serializable {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
    @NotNull
    private Context _context;
    @NotNull
    private SharedPreferences sharedPreferences;
    @NotNull
    private SharedPreferences.Editor editor;
    @NotNull
    private static final String IS_LOGGED_IN = "isLoggedIn";
    @NotNull
    private static final String USER_ID = "user_id";
    @NotNull
    private static final String USERNAME = "username";
    @NotNull
    private static final String NAME = "name";

    public SessionManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super();
        this._context = context;
        SharedPreferences var2 = PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkNotNullExpressionValue(var2, "getDefaultSharedPreferences(...)");
        this.sharedPreferences = var2;
        SharedPreferences.Editor var3 = this.sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(var3, "edit(...)");
        this.editor = var3;
    }

    public final void createLoginSession(@NotNull Data user) {
        Intrinsics.checkNotNullParameter(user, "user");
        this.editor.putBoolean(IS_LOGGED_IN, true);
        this.editor.putString(USER_ID, user.getIdUsu());
        this.editor.putString(USERNAME, user.getUsername());
        this.editor.putString(NAME, user.getUsuName());
        this.editor.commit();
    }

    @NotNull
    public final HashMap getUserDetail() {
        HashMap user = new HashMap();
        String var10001 = USER_ID;
        String var10002 = this.sharedPreferences.getString(USER_ID, (String)null);
        Intrinsics.checkNotNull(var10002);
        user.put(var10001, var10002);
        var10001 = USERNAME;
        var10002 = this.sharedPreferences.getString(USERNAME, (String)null);
        Intrinsics.checkNotNull(var10002);
        user.put(var10001, var10002);
        var10001 = NAME;
        var10002 = this.sharedPreferences.getString(NAME, (String)null);
        Intrinsics.checkNotNull(var10002);
        user.put(var10001, var10002);
        return user;
    }

    public final void logOutSession() {
        this.editor.clear();
        this.editor.commit();
    }

    public final boolean isLoggedIn() {
        return this.sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

    public static final class Companion {
        private Companion() {
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
