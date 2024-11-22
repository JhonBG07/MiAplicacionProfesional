package com.example.proyectofinalkotlin;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinalkotlin.R.id;
import com.example.proyectofinalkotlin.R.layout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public final class ModeloHorario extends AppCompatActivity {
    @NotNull
    public static final com.example.proyectofinalkotlin.ModeloHorario.Companion Companion = new com.example.proyectofinalkotlin.ModeloHorario.Companion((DefaultConstructorMarker)null);
    @Nullable
    private ListView horarios;
    @Nullable
    private Spinner spinnerDia;
    @Nullable
    private Spinner spinnerHora;
    @Nullable
    private Spinner spinnerMinutos;
    @Nullable
    private TextView tvDiaSemana;
    @Nullable
    private TextView tvHoras;
    @Nullable
    private TextView tvMinutos;
    @Nullable
    private Button dialogAceptar;
    @Nullable
    private Button dialogCancelar;
    @Nullable
    private Button btnConfirmar;
    @Nullable
    private Button btnAgregar;
    @Nullable
    private EditText dialogFecha;
    @NotNull
    private List fechas = (List)(new ArrayList());
    @NotNull
    private ComunicacionBluetooth comunicacion;
    @NotNull
    private FechaDAOImpl fechaDAO;
    @NotNull
    private ArrayList dias;
    @NotNull
    private ArrayList horas;
    @NotNull
    private ArrayList minutos;
    @NotNull
    private static String horario = "";

    public ModeloHorario() {
        BluetoothSocket var10003 = ControlActivity.Companion.getMyBluetoothSocket();
        Intrinsics.checkNotNull(var10003);
        this.comunicacion = new ComunicacionBluetooth(var10003);
        this.fechaDAO = new FechaDAOImpl(this.comunicacion);
        this.dias = this.fechaDAO.valoresDias();
        this.horas = this.fechaDAO.valoresHoras();
        this.minutos = this.fechaDAO.valoresMinutos();
    }

    @Nullable
    public final ListView getHorarios() {
        return this.horarios;
    }

    public final void setHorarios(@Nullable ListView var1) {
        this.horarios = var1;
    }

    @Nullable
    public final Spinner getSpinnerDia() {
        return this.spinnerDia;
    }

    public final void setSpinnerDia(@Nullable Spinner var1) {
        this.spinnerDia = var1;
    }

    @Nullable
    public final Spinner getSpinnerHora() {
        return this.spinnerHora;
    }

    public final void setSpinnerHora(@Nullable Spinner var1) {
        this.spinnerHora = var1;
    }

    @Nullable
    public final Spinner getSpinnerMinutos() {
        return this.spinnerMinutos;
    }

    public final void setSpinnerMinutos(@Nullable Spinner var1) {
        this.spinnerMinutos = var1;
    }

    @Nullable
    public final TextView getTvDiaSemana() {
        return this.tvDiaSemana;
    }

    public final void setTvDiaSemana(@Nullable TextView var1) {
        this.tvDiaSemana = var1;
    }

    @Nullable
    public final TextView getTvHoras() {
        return this.tvHoras;
    }

    public final void setTvHoras(@Nullable TextView var1) {
        this.tvHoras = var1;
    }

    @Nullable
    public final TextView getTvMinutos() {
        return this.tvMinutos;
    }

    public final void setTvMinutos(@Nullable TextView var1) {
        this.tvMinutos = var1;
    }

    @Nullable
    public final Button getDialogAceptar() {
        return this.dialogAceptar;
    }

    public final void setDialogAceptar(@Nullable Button var1) {
        this.dialogAceptar = var1;
    }

    @Nullable
    public final Button getDialogCancelar() {
        return this.dialogCancelar;
    }

    public final void setDialogCancelar(@Nullable Button var1) {
        this.dialogCancelar = var1;
    }

    @Nullable
    public final Button getBtnConfirmar() {
        return this.btnConfirmar;
    }

    public final void setBtnConfirmar(@Nullable Button var1) {
        this.btnConfirmar = var1;
    }

    @Nullable
    public final Button getBtnAgregar() {
        return this.btnAgregar;
    }

    public final void setBtnAgregar(@Nullable Button var1) {
        this.btnAgregar = var1;
    }

    @Nullable
    public final EditText getDialogFecha() {
        return this.dialogFecha;
    }

    public final void setDialogFecha(@Nullable EditText var1) {
        this.dialogFecha = var1;
    }

    @NotNull
    public final List getFechas() {
        return this.fechas;
    }

    public final void setFechas(@NotNull List var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.fechas = var1;
    }

    @NotNull
    public final ComunicacionBluetooth getComunicacion() {
        return this.comunicacion;
    }

    public final void setComunicacion(@NotNull ComunicacionBluetooth var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.comunicacion = var1;
    }

    @NotNull
    public final FechaDAOImpl getFechaDAO() {
        return this.fechaDAO;
    }

    public final void setFechaDAO(@NotNull FechaDAOImpl var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.fechaDAO = var1;
    }

    @NotNull
    public final ArrayList getDias() {
        return this.dias;
    }

    public final void setDias(@NotNull ArrayList var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.dias = var1;
    }

    @NotNull
    public final ArrayList getHoras() {
        return this.horas;
    }

    public final void setHoras(@NotNull ArrayList var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.horas = var1;
    }

    @NotNull
    public final ArrayList getMinutos() {
        return this.minutos;
    }

    public final void setMinutos(@NotNull ArrayList var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.minutos = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_vista_horario);
        com.example.proyectofinalkotlin.ModeloHorario.Companion var10000 = Companion;
        horario = "";
        this.horarios = (ListView)this.findViewById(id.listaHorarios);
        this.btnAgregar = (Button)this.findViewById(id.btnAgregar);

        String var2;
        while(horario.length() < 6) {
            this.comunicacion.sendCommand("mostrar");
            Thread.sleep(1000L);
            var10000 = Companion;
            horario = this.comunicacion.read();
            Thread.sleep(1000L);
            var2 = "Mi mensaje" + horario;
            System.out.println(var2);
        }

        var2 = "Esto es lo que recibió";
        System.out.println(var2);
        var2 = horario;
        System.out.println(var2);
        if (horario.length() <= 8) {
            this.fechas.add(this.fechaDAO.formatoFecha(horario));
        } else {
            this.fechas.addAll((Collection)this.fechaDAO.mostrar());
        }

        this.listaHorarios();
        ListView var3 = this.horarios;
        Intrinsics.checkNotNull(var3);
        var3.setOnItemClickListener(com.example.proyectofinalkotlin.ModeloHorario::onCreate$lambda$5);
        Button var4 = this.btnAgregar;
        Intrinsics.checkNotNull(var4);
        var4.setOnClickListener(com.example.proyectofinalkotlin.ModeloHorario::onCreate$lambda$8);
    }

    public final void listaHorarios() {
        ArrayAdapter adapter = new ArrayAdapter((Context)this, 17367043, (List)this.fechaDAO.alistarVista(this.fechas));
        ListView var10000 = this.horarios;
        Intrinsics.checkNotNull(var10000);
        var10000.setAdapter((ListAdapter)adapter);
    }

    private static final void onCreate$lambda$5$lambda$2$lambda$0(com.example.proyectofinalkotlin.ModeloHorario this$0, Ref.ObjectRef $fechaEntrega, int $position, Ref.ObjectRef $modificar, AlertDialog $myAlertDialog, View it) {
        TextView var10000 = this$0.tvDiaSemana;
        Intrinsics.checkNotNull(var10000);
        if (var10000.getText() != null) {
            var10000 = this$0.tvHoras;
            Intrinsics.checkNotNull(var10000);
            if (var10000.getText() != null) {
                var10000 = this$0.tvMinutos;
                Intrinsics.checkNotNull(var10000);
                if (var10000.getText() != null) {
                    TextView var10003 = this$0.tvDiaSemana;
                    Intrinsics.checkNotNull(var10003);
                    String var9 = var10003.getText().toString();
                    TextView var10004 = this$0.tvHoras;
                    Intrinsics.checkNotNull(var10004);
                    String var10 = var10004.getText().toString();
                    TextView var10005 = this$0.tvMinutos;
                    Intrinsics.checkNotNull(var10005);
                    $fechaEntrega.element = new FechaDTO(var9, var10, var10005.getText().toString());
                    this$0.fechas.remove($position);
                    this$0.fechas.add($position, $fechaEntrega.element);
                    int i = 0;

                    for(int var7 = this$0.fechas.size(); i < var7; ++i) {
                        $modificar.element = (String)$modificar.element + this$0.fechaDAO.desformatoFecha((FechaDTO)this$0.fechas.get(i));
                    }

                    Object var8 = $modificar.element;
                    System.out.println(var8);
                    this$0.fechaDAO.actualizar((String)$modificar.element);
                    $myAlertDialog.dismiss();
                    this$0.listaHorarios();
                }
            }
        }

    }

    private static final void onCreate$lambda$5$lambda$2$lambda$1(AlertDialog $myAlertDialog, View it) {
        $myAlertDialog.dismiss();
    }

    private static final void onCreate$lambda$5$lambda$2(com.example.proyectofinalkotlin.ModeloHorario this$0, int $position, DialogInterface dialog, int which) {
        final View dialogView = LayoutInflater.from((Context)this$0).inflate(layout.agregar_horario, (ViewGroup)null);
        AlertDialog.Builder myBuilder = (new AlertDialog.Builder((Context)this$0)).setView(dialogView).setTitle((CharSequence)("Modificar Horario\n" + ((FechaDTO)this$0.fechas.get($position)).getDia() + ' ' + ((FechaDTO)this$0.fechas.get($position)).getHora() + ' ' + ((FechaDTO)this$0.fechas.get($position)).getMinuto()));
        AlertDialog myAlertDialog = myBuilder.show();
        Ref.ObjectRef fechaEntrega = new Ref.ObjectRef();
        final Ref.ObjectRef diaSemana = new Ref.ObjectRef();
        diaSemana.element = this$0.dias;
        final Ref.ObjectRef hours = new Ref.ObjectRef();
        hours.element = this$0.horas;
        final Ref.ObjectRef mins = new Ref.ObjectRef();
        mins.element = this$0.minutos;
        Ref.ObjectRef modificar = new Ref.ObjectRef();
        modificar.element = "";
        this$0.spinnerDia = (Spinner)dialogView.findViewById(id.spinnerDia);
        this$0.spinnerHora = (Spinner)dialogView.findViewById(id.spinnerHora);
        this$0.spinnerMinutos = (Spinner)dialogView.findViewById(id.spinnerMinutos);
        this$0.tvDiaSemana = (TextView)dialogView.findViewById(id.tvDiaSemana);
        this$0.tvHoras = (TextView)dialogView.findViewById(id.tvHoras);
        this$0.tvMinutos = (TextView)dialogView.findViewById(id.tvMinutos);
        this$0.dialogAceptar = (Button)dialogView.findViewById(id.dialogAceptar);
        this$0.dialogCancelar = (Button)dialogView.findViewById(id.dialogCancelar);
        Spinner var10000 = this$0.spinnerDia;
        Intrinsics.checkNotNull(var10000);
        var10000.setAdapter((SpinnerAdapter)(new ArrayAdapter((Context)this$0, 17367043, (List)diaSemana.element)));
        var10000 = this$0.spinnerHora;
        Intrinsics.checkNotNull(var10000);
        var10000.setAdapter((SpinnerAdapter)(new ArrayAdapter((Context)this$0, 17367043, (List)hours.element)));
        var10000 = this$0.spinnerMinutos;
        Intrinsics.checkNotNull(var10000);
        var10000.setAdapter((SpinnerAdapter)(new ArrayAdapter((Context)this$0, 17367043, (List)mins.element)));
        var10000 = this$0.spinnerDia;
        Intrinsics.checkNotNull(var10000);
        var10000.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView parent) {
                ((TextView)dialogView.findViewById(id.tvDiaSemana)).setText((CharSequence)"Seleccione una opcion");
            }

            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                ((TextView)dialogView.findViewById(id.tvDiaSemana)).setText((CharSequence)((ArrayList)diaSemana.element).get(position));
            }
        }));
        var10000 = this$0.spinnerHora;
        Intrinsics.checkNotNull(var10000);
        var10000.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView parent) {
                ((TextView)dialogView.findViewById(id.tvHoras)).setText((CharSequence)"Seleccione una opcion");
            }

            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                ((TextView)dialogView.findViewById(id.tvHoras)).setText((CharSequence)((ArrayList)hours.element).get(position));
            }
        }));
        var10000 = this$0.spinnerMinutos;
        Intrinsics.checkNotNull(var10000);
        var10000.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView parent) {
                ((TextView)dialogView.findViewById(id.tvMinutos)).setText((CharSequence)"Seleccione una opcion");
            }

            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                ((TextView)dialogView.findViewById(id.tvMinutos)).setText((CharSequence)((ArrayList)mins.element).get(position));
            }
        }));
        ((Button)dialogView.findViewById(id.dialogAceptar)).setOnClickListener(com.example.proyectofinalkotlin.ModeloHorario::onCreate$lambda$5$lambda$2$lambda$0);
        Button var12 = this$0.dialogCancelar;
        Intrinsics.checkNotNull(var12);
        var12.setOnClickListener(com.example.proyectofinalkotlin.ModeloHorario::onCreate$lambda$5$lambda$2$lambda$1);
    }

    private static final void onCreate$lambda$5$lambda$4$lambda$3(com.example.proyectofinalkotlin.ModeloHorario this$0, int $position, Ref.ObjectRef $eliminar, AlertDialog $mAlertDialog, View it) {
        EditText var10000 = this$0.dialogFecha;
        Intrinsics.checkNotNull(var10000);
        if (Intrinsics.areEqual(var10000.getText().toString(), "si")) {
            this$0.fechas.remove($position);
            int i = 0;

            for(int var6 = this$0.fechas.size(); i < var6; ++i) {
                $eliminar.element = (String)$eliminar.element + this$0.fechaDAO.desformatoFecha((FechaDTO)this$0.fechas.get(i));
            }

            Object var7 = $eliminar.element;
            System.out.println(var7);
            this$0.fechaDAO.eliminar((String)$eliminar.element);
        }

        $mAlertDialog.dismiss();
        this$0.listaHorarios();
    }

    private static final void onCreate$lambda$5$lambda$4(com.example.proyectofinalkotlin.ModeloHorario this$0, int $position, DialogInterface dialog, int which) {
        View mDialogView = LayoutInflater.from((Context)this$0).inflate(layout.modificar_horario, (ViewGroup)null);
        AlertDialog.Builder mBuilder = (new AlertDialog.Builder((Context)this$0)).setView(mDialogView).setTitle((CharSequence)("Eliminar Fecha\n" + ((FechaDTO)this$0.fechas.get($position)).getDia() + ' ' + ((FechaDTO)this$0.fechas.get($position)).getHora() + ' ' + ((FechaDTO)this$0.fechas.get($position)).getMinuto()));
        this$0.btnConfirmar = (Button)mDialogView.findViewById(id.btnConfirmar);
        this$0.dialogFecha = (EditText)mDialogView.findViewById(id.dialogFecha);
        AlertDialog mAlertDialog = mBuilder.show();
        Ref.ObjectRef eliminar = new Ref.ObjectRef();
        eliminar.element = "";
        Button var10000 = this$0.btnConfirmar;
        Intrinsics.checkNotNull(var10000);
        var10000.setOnClickListener(com.example.proyectofinalkotlin.ModeloHorario::onCreate$lambda$5$lambda$4$lambda$3);
    }

    private static final void onCreate$lambda$5(com.example.proyectofinalkotlin.ModeloHorario this$0, AdapterView parent, View view, int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)this$0);
        builder.setTitle((CharSequence)"Menú Horarios");
        builder.setMessage((CharSequence)(((FechaDTO)this$0.fechas.get(position)).getDia() + ' ' + ((FechaDTO)this$0.fechas.get(position)).getHora() + ' ' + ((FechaDTO)this$0.fechas.get(position)).getMinuto())).setPositiveButton((CharSequence)"Modificar", com.example.proyectofinalkotlin.ModeloHorario::onCreate$lambda$5$lambda$2).setNegativeButton((CharSequence)"Eliminar", com.example.proyectofinalkotlin.ModeloHorario::onCreate$lambda$5$lambda$4).show();
    }

    private static final void onCreate$lambda$8$lambda$6(com.example.proyectofinalkotlin.ModeloHorario this$0, AlertDialog $myAlertDialog, View it) {
        TextView var10000 = this$0.tvDiaSemana;
        Intrinsics.checkNotNull(var10000);
        if (var10000.getText() != null) {
            var10000 = this$0.tvHoras;
            Intrinsics.checkNotNull(var10000);
            if (var10000.getText() != null) {
                var10000 = this$0.tvMinutos;
                Intrinsics.checkNotNull(var10000);
                if (var10000.getText() != null) {
                    TextView var10002 = this$0.tvDiaSemana;
                    Intrinsics.checkNotNull(var10002);
                    String var5 = var10002.getText().toString();
                    TextView var10003 = this$0.tvHoras;
                    Intrinsics.checkNotNull(var10003);
                    String var6 = var10003.getText().toString();
                    TextView var10004 = this$0.tvMinutos;
                    Intrinsics.checkNotNull(var10004);
                    FechaDTO fechaEntrega = new FechaDTO(var5, var6, var10004.getText().toString());
                    this$0.fechas.add(fechaEntrega);
                    String fechaFinal = this$0.fechaDAO.desformatoFecha(fechaEntrega);
                    this$0.fechaDAO.insertar(fechaFinal);
                    $myAlertDialog.dismiss();
                    this$0.listaHorarios();
                }
            }
        }

    }

    private static final void onCreate$lambda$8$lambda$7(AlertDialog $myAlertDialog, View it) {
        $myAlertDialog.dismiss();
    }

    private static final void onCreate$lambda$8(final com.example.proyectofinalkotlin.ModeloHorario this$0, View it) {
        View dialogView = LayoutInflater.from((Context)this$0).inflate(layout.agregar_horario, (ViewGroup)null);
        AlertDialog.Builder myBuilder = (new AlertDialog.Builder((Context)this$0)).setView(dialogView).setTitle((CharSequence)"Agregar Nuevo Horario");
        AlertDialog myAlertDialog = myBuilder.show();
        final Ref.ObjectRef diaSemana = new Ref.ObjectRef();
        diaSemana.element = this$0.dias;
        final Ref.ObjectRef hours = new Ref.ObjectRef();
        hours.element = this$0.horas;
        final Ref.ObjectRef mins = new Ref.ObjectRef();
        mins.element = this$0.minutos;
        Spinner var10000 = this$0.spinnerDia;
        Intrinsics.checkNotNull(var10000);
        var10000.setAdapter((SpinnerAdapter)(new ArrayAdapter((Context)this$0, 17367043, (List)diaSemana.element)));
        var10000 = this$0.spinnerHora;
        Intrinsics.checkNotNull(var10000);
        var10000.setAdapter((SpinnerAdapter)(new ArrayAdapter((Context)this$0, 17367043, (List)hours.element)));
        var10000 = this$0.spinnerMinutos;
        Intrinsics.checkNotNull(var10000);
        var10000.setAdapter((SpinnerAdapter)(new ArrayAdapter((Context)this$0, 17367043, (List)mins.element)));
        var10000 = this$0.spinnerDia;
        Intrinsics.checkNotNull(var10000);
        var10000.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView parent) {
                TextView var10000 = this$0.getTvDiaSemana();
                Intrinsics.checkNotNull(var10000);
                var10000.setText((CharSequence)"Seleccione una opcion");
            }

            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                TextView var10000 = this$0.getTvDiaSemana();
                Intrinsics.checkNotNull(var10000);
                var10000.setText((CharSequence)((ArrayList)diaSemana.element).get(position));
            }
        }));
        var10000 = this$0.spinnerHora;
        Intrinsics.checkNotNull(var10000);
        var10000.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView parent) {
                TextView var10000 = this$0.getTvHoras();
                Intrinsics.checkNotNull(var10000);
                var10000.setText((CharSequence)"Seleccione una opcion");
            }

            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                TextView var10000 = this$0.getTvHoras();
                Intrinsics.checkNotNull(var10000);
                var10000.setText((CharSequence)((ArrayList)hours.element).get(position));
            }
        }));
        var10000 = this$0.spinnerMinutos;
        Intrinsics.checkNotNull(var10000);
        var10000.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView parent) {
                TextView var10000 = this$0.getTvMinutos();
                Intrinsics.checkNotNull(var10000);
                var10000.setText((CharSequence)"Seleccione una opcion");
            }

            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                TextView var10000 = this$0.getTvMinutos();
                Intrinsics.checkNotNull(var10000);
                var10000.setText((CharSequence)((ArrayList)mins.element).get(position));
            }
        }));
        Button var8 = this$0.dialogAceptar;
        Intrinsics.checkNotNull(var8);
        var8.setOnClickListener(com.example.proyectofinalkotlin.ModeloHorario::onCreate$lambda$8$lambda$6);
        var8 = this$0.dialogCancelar;
        Intrinsics.checkNotNull(var8);
        var8.setOnClickListener(com.example.proyectofinalkotlin.ModeloHorario::onCreate$lambda$8$lambda$7);
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getHorario() {
            return com.example.proyectofinalkotlin.ModeloHorario.horario;
        }

        public final void setHorario(@NotNull String var1) {
            Intrinsics.checkNotNullParameter(var1, "<set-?>");
            com.example.proyectofinalkotlin.ModeloHorario.horario = var1;
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

