package com.example.proyectofinalkotlin;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;


public final class HashContrasena {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker)null);


    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String hash(@NotNull String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            String hashFin = "";

            try {
                MessageDigest var4 = MessageDigest.getInstance("SHA-256");
                Intrinsics.checkNotNullExpressionValue(var4, "getInstance(...)");
                MessageDigest crp = var4;
                crp.digest();
                Charset var5 = Charsets.UTF_8;
                byte[] var10001 = password.getBytes(var5);
                Intrinsics.checkNotNullExpressionValue(var10001, "getBytes(...)");
                crp.update(var10001);
                StringCompanionObject var9 = StringCompanionObject.INSTANCE;
                String var10 = "%064x";
                Object[] var6 = new Object[]{new BigInteger(1, crp.digest())};
                String var10000 = String.format(var10, Arrays.copyOf(var6, var6.length));
                Intrinsics.checkNotNullExpressionValue(var10000, "format(...)");
                hashFin = var10000;
            } catch (IOException var7) {
                IOException e = var7;
                e.printStackTrace();
            }

            return hashFin;
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

