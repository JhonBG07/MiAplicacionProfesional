package com.example.proyectofinalkotlin;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;


public enum DiasSemana {
    Lunes,
    Martes,
    Miercoles,
    Jueves,
    Viernes,
    Sabado,
    Domingo;

    // $FF: synthetic field
    private static final EnumEntries $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);

    @NotNull
    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    // $FF: synthetic method
    private static final DiasSemana[] $values() {
        DiasSemana[] var0 = new DiasSemana[]{Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo};
        return var0;
    }
}
