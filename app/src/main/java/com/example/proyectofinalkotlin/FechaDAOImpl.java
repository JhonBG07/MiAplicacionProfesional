package com.example.proyectofinalkotlin;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;


public final class FechaDAOImpl implements CrudDAO {
    public FechaDTO fecha;
    @NotNull
    private ComunicacionBluetooth comunicacion;

    public FechaDAOImpl(@NotNull ComunicacionBluetooth comunicacionBluetooth) {
        Intrinsics.checkNotNullParameter(comunicacionBluetooth, "comunicacionBluetooth");
        super();
        this.comunicacion = comunicacionBluetooth;
    }

    @NotNull
    public final FechaDTO getFecha() {
        FechaDTO var1 = this.fecha;
        if (var1 != null) {
            return var1;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("fecha");
            return null;
        }
    }

    public final void setFecha(@NotNull FechaDTO var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.fecha = var1;
    }

    @NotNull
    public final ComunicacionBluetooth getComunicacion() {
        return this.comunicacion;
    }

    public final void setComunicacion(@NotNull ComunicacionBluetooth var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.comunicacion = var1;
    }

    public void insertar(@NotNull String p) {
        Intrinsics.checkNotNullParameter(p, "p");
        this.comunicacion.sendCommand("ingresar");
        Thread.sleep(1000L);
        this.comunicacion.sendCommand(p.toString());
    }

    public void actualizar(@NotNull String fechaNueva) {
        Intrinsics.checkNotNullParameter(fechaNueva, "fechaNueva");
        this.comunicacion.sendCommand("modificar");
        Thread.sleep(1000L);
        this.comunicacion.sendCommand(fechaNueva);
    }

    public void eliminar(@NotNull String fecha) {
        Intrinsics.checkNotNullParameter(fecha, "fecha");
        this.comunicacion.sendCommand("eliminar");
        Thread.sleep(1000L);
        this.comunicacion.sendCommand(fecha);
    }

    @NotNull
    public ArrayList mostrar() {
        String dia = "";
        ArrayList lista = new ArrayList();
        String var3 = "Longitud horario " + ModeloHorario.Companion.getHorario().length();
        System.out.println(var3);
        IntProgression var8 = RangesKt.step((IntProgression)RangesKt.until(0, ModeloHorario.Companion.getHorario().length() - 2), 6);
        int l = var8.getFirst();
        int var5 = var8.getLast();
        int var6 = var8.getStep();
        if (var6 > 0 && l <= var5 || var6 < 0 && var5 <= l) {
            while(true) {
                String var10002 = ModeloHorario.Companion.getHorario().substring(l, l + 6);
                Intrinsics.checkNotNullExpressionValue(var10002, "substring(...)");
                lista.add(this.formatoFecha(var10002));
                StringBuilder var10000 = (new StringBuilder()).append("Dia 1: ");
                String var10001 = ModeloHorario.Companion.getHorario().substring(l, l + 6);
                Intrinsics.checkNotNullExpressionValue(var10001, "substring(...)");
                String var7 = var10000.append(var10001).toString();
                System.out.println(var7);
                if (l == var5) {
                    break;
                }

                l += var6;
            }
        }

        this.alistarVista((List)lista);
        return lista;
    }

    @NotNull
    public final FechaDTO formatoFecha(@NotNull String temporal) {
        Intrinsics.checkNotNullParameter(temporal, "temporal");
        String dia = "";
        String var10000 = temporal.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(var10000, "substring(...)");
        switch (var3) {
            case "00":
                dia = DiasSemana.Domingo.toString();
                break;
            case "01":
                dia = DiasSemana.Lunes.toString();
                break;
            case "02":
                dia = DiasSemana.Martes.toString();
                break;
            case "03":
                dia = DiasSemana.Miercoles.toString();
                break;
            case "04":
                dia = DiasSemana.Jueves.toString();
                break;
            case "05":
                dia = DiasSemana.Viernes.toString();
                break;
            case "06":
                dia = DiasSemana.Sabado.toString();
        }

        String var10004 = temporal.substring(2, 4);
        Intrinsics.checkNotNullExpressionValue(var10004, "substring(...)");
        String var10005 = temporal.substring(4, 6);
        Intrinsics.checkNotNullExpressionValue(var10005, "substring(...)");
        this.setFecha(new FechaDTO(dia, var10004, var10005));
        return this.getFecha();
    }

    @NotNull
    public final ArrayList alistarVista(@NotNull List fechas) {
        Intrinsics.checkNotNullParameter(fechas, "fechas");
        ArrayList fechasString = new ArrayList();
        fechasString.clear();
        int i = 0;

        for(int var4 = fechas.size(); i < var4; ++i) {
            fechasString.add(((FechaDTO)fechas.get(i)).getDia() + ' ' + ((FechaDTO)fechas.get(i)).getHora() + " : " + ((FechaDTO)fechas.get(i)).getMinuto());
        }

        return fechasString;
    }

    @NotNull
    public final String desformatoFecha(@NotNull FechaDTO fecha) {
        Intrinsics.checkNotNullParameter(fecha, "fecha");
        String fechaEnviar = "";
        System.out.println(var3);
        var3 = fecha.getDia();
        switch (var3) {
            case "Jueves":
                fechaEnviar = "04";
                break;
            case "Martes":
                fechaEnviar = "02";
                break;
            case "Sabado":
                fechaEnviar = "06";
                break;
            case "Domingo":
                fechaEnviar = "00";
                break;
            case "Miercoles":
                fechaEnviar = "03";
                break;
            case "Lunes":
                fechaEnviar = "01";
                break;
            case "Viernes":
                fechaEnviar = "05";
        }

        return fechaEnviar + fecha.getHora() + fecha.getMinuto();
    }

    @NotNull
    public final ArrayList valoresDias() {
        ArrayList dias = new ArrayList();
        dias.add(DiasSemana.Lunes.toString());
        dias.add(DiasSemana.Martes.toString());
        dias.add(DiasSemana.Miercoles.toString());
        dias.add(DiasSemana.Jueves.toString());
        dias.add(DiasSemana.Viernes.toString());
        dias.add(DiasSemana.Sabado.toString());
        dias.add(DiasSemana.Domingo.toString());
        return dias;
    }

    @NotNull
    public final ArrayList valoresHoras() {
        ArrayList horas = new ArrayList();

        for(int i = 0; i < 24; ++i) {
            if (i < 10) {
                horas.add("" + '0' + i);
            } else {
                horas.add(String.valueOf(i));
            }
        }

        return horas;
    }

    @NotNull
    public final ArrayList valoresMinutos() {
        ArrayList minutos = new ArrayList();

        for(int i = 0; i < 60; ++i) {
            if (i < 10) {
                minutos.add("" + '0' + i);
            } else {
                minutos.add(String.valueOf(i));
            }
        }

        return minutos;
    }
}

