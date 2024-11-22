package com.example.proyectofinalkotlin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class FechaDTO {
    @NotNull
    private final String dia;
    @NotNull
    private final String hora;
    @NotNull
    private final String minuto;

    public FechaDTO(@NotNull String day, @NotNull String hour, @NotNull String minute) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(hour, "hour");
        Intrinsics.checkNotNullParameter(minute, "minute");
        super();
        this.dia = day;
        this.hora = hour;
        this.minuto = minute;
    }

    @NotNull
    public final String getDia() {
        return this.dia;
    }

    @NotNull
    public final String getHora() {
        return this.hora;
    }

    @NotNull
    public final String getMinuto() {
        return this.minuto;
    }
}

