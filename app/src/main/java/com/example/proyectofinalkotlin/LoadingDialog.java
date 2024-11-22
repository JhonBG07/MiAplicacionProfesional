package com.example.proyectofinalkotlin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.proyectofinalkotlin.R.layout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;


public final class LoadingDialog {
    @NotNull
    private Activity activity;

    public LoadingDialog(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super();
        this.activity = activity;
    }

    @NotNull
    public final Activity getActivity() {
        return this.activity;
    }

    public final void setActivity(@NotNull Activity var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.activity = var1;
    }

    public final void iniciarDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)this.activity);
        LayoutInflater var3 = this.activity.getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(var3, "getLayoutInflater(...)");
        LayoutInflater inflater = var3;
        builder.setView(inflater.inflate(layout.dialog_loading, (ViewGroup)null));
    }
}
