package com.example.proyectofinalkotlin;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;


public interface CrudDAO {
    void insertar(@NotNull String var1);

    void actualizar(@NotNull String var1);

    void eliminar(@NotNull String var1);

    @NotNull
    ArrayList mostrar();
}