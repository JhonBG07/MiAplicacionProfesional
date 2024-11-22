// DataLogin.java
package com.example.proyectofinalkotlin.model.login;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public final class DataLogin {
    @SerializedName("data")
    @Nullable
    private final Data data;
    @SerializedName("message")
    @Nullable
    private final String message;
    @SerializedName("status")
    @Nullable
    private final Boolean status;

    public DataLogin(@Nullable Data data, @Nullable String message, @Nullable Boolean status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    // $FF: synthetic method
    public DataLogin(Data var1, String var2, Boolean var3, int var4, DefaultConstructorMarker var5) {
        if ((var4 & 1) != 0) {
            var1 = null;
        }

        if ((var4 & 2) != 0) {
            var2 = null;
        }

        if ((var4 & 4) != 0) {
            var3 = null;
        }

        this(var1, var2, var3);
    }

    @Nullable
    public final Data getData() {
        return this.data;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Boolean getStatus() {
        return this.status;
    }

    @Nullable
    public final Data component1() {
        return this.data;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    @Nullable
    public final Boolean component3() {
        return this.status;
    }

    @NotNull
    public final DataLogin copy(@Nullable Data data, @Nullable String message, @Nullable Boolean status) {
        return new DataLogin(data, message, status);
    }

    // $FF: synthetic method
    public static DataLogin copy$default(DataLogin var0, Data var1, String var2, Boolean var3, int var4, Object var5) {
        if ((var4 & 1) != 0) {
            var1 = var0.data;
        }

        if ((var4 & 2) != 0) {
            var2 = var0.message;
        }

        if ((var4 & 4) != 0) {
            var3 = var0.status;
        }

        return var0.copy(var1, var2, var3);
    }

    @NotNull
    public String toString() {
        return "DataLogin(data=" + this.data + ", message=" + this.message + ", status=" + this.status + ')';
    }

    public int hashCode() {
        int result = this.data == null ? 0 : this.data.hashCode();
        result = result * 31 + (this.message == null ? 0 : this.message.hashCode());
        result = result * 31 + (this.status == null ? 0 : this.status.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        } else if (!(other instanceof DataLogin)) {
            return false;
        } else {
            DataLogin var2 = (DataLogin)other;
            if (!Intrinsics.areEqual(this.data, var2.data)) {
                return false;
            } else if (!Intrinsics.areEqual(this.message, var2.message)) {
                return false;
            } else {
                return Intrinsics.areEqual(this.status, var2.status);
            }
        }
    }

    public DataLogin() {
        this((Data)null, (String)null, (Boolean)null, 7, (DefaultConstructorMarker)null);
    }
}
// Data.java
package com.example.proyectofinalkotlin.model.login;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public final class Data {
    @SerializedName("nombre")
    @Nullable
    private final String usuName;
    @SerializedName("id_usuario")
    @Nullable
    private final String idUsu;
    @SerializedName("usu_nombre")
    @Nullable
    private final String username;

    public Data(@Nullable String usuName, @Nullable String idUsu, @Nullable String username) {
        this.usuName = usuName;
        this.idUsu = idUsu;
        this.username = username;
    }

    // $FF: synthetic method
    public Data(String var1, String var2, String var3, int var4, DefaultConstructorMarker var5) {
        if ((var4 & 1) != 0) {
            var1 = null;
        }

        if ((var4 & 2) != 0) {
            var2 = null;
        }

        if ((var4 & 4) != 0) {
            var3 = null;
        }

        this(var1, var2, var3);
    }

    @Nullable
    public final String getUsuName() {
        return this.usuName;
    }

    @Nullable
    public final String getIdUsu() {
        return this.idUsu;
    }

    @Nullable
    public final String getUsername() {
        return this.username;
    }

    @Nullable
    public final String component1() {
        return this.usuName;
    }

    @Nullable
    public final String component2() {
        return this.idUsu;
    }

    @Nullable
    public final String component3() {
        return this.username;
    }

    @NotNull
    public final Data copy(@Nullable String usuName, @Nullable String idUsu, @Nullable String username) {
        return new Data(usuName, idUsu, username);
    }

    // $FF: synthetic method
    public static Data copy$default(Data var0, String var1, String var2, String var3, int var4, Object var5) {
        if ((var4 & 1) != 0) {
            var1 = var0.usuName;
        }

        if ((var4 & 2) != 0) {
            var2 = var0.idUsu;
        }

        if ((var4 & 4) != 0) {
            var3 = var0.username;
        }

        return var0.copy(var1, var2, var3);
    }

    @NotNull
    public String toString() {
        return "Data(usuName=" + this.usuName + ", idUsu=" + this.idUsu + ", username=" + this.username + ')';
    }

    public int hashCode() {
        int result = this.usuName == null ? 0 : this.usuName.hashCode();
        result = result * 31 + (this.idUsu == null ? 0 : this.idUsu.hashCode());
        result = result * 31 + (this.username == null ? 0 : this.username.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        } else if (!(other instanceof Data)) {
            return false;
        } else {
            Data var2 = (Data)other;
            if (!Intrinsics.areEqual(this.usuName, var2.usuName)) {
                return false;
            } else if (!Intrinsics.areEqual(this.idUsu, var2.idUsu)) {
                return false;
            } else {
                return Intrinsics.areEqual(this.username, var2.username);
            }
        }
    }

    public Data() {
        this((String)null, (String)null, (String)null, 7, (DefaultConstructorMarker)null);
    }
}

