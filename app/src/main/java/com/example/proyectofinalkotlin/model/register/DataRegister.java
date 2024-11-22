// DataRegister.java
package com.example.proyectofinalkotlin.model.register;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public final class DataRegister {
    @SerializedName("data")
    @Nullable
    private final Data data;
    @SerializedName("message")
    @Nullable
    private final String message;
    @SerializedName("status")
    @Nullable
    private final Boolean status;

    public DataRegister(@Nullable Data data, @Nullable String message, @Nullable Boolean status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    // $FF: synthetic method
    public DataRegister(Data var1, String var2, Boolean var3, int var4, DefaultConstructorMarker var5) {
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
    public final DataRegister copy(@Nullable Data data, @Nullable String message, @Nullable Boolean status) {
        return new DataRegister(data, message, status);
    }

    // $FF: synthetic method
    public static DataRegister copy$default(DataRegister var0, Data var1, String var2, Boolean var3, int var4, Object var5) {
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
        return "DataRegister(data=" + this.data + ", message=" + this.message + ", status=" + this.status + ')';
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
        } else if (!(other instanceof DataRegister)) {
            return false;
        } else {
            DataRegister var2 = (DataRegister)other;
            if (!Intrinsics.areEqual(this.data, var2.data)) {
                return false;
            } else if (!Intrinsics.areEqual(this.message, var2.message)) {
                return false;
            } else {
                return Intrinsics.areEqual(this.status, var2.status);
            }
        }
    }

    public DataRegister() {
        this((Data)null, (String)null, (Boolean)null, 7, (DefaultConstructorMarker)null);
    }
}
// Data.java
package com.example.proyectofinalkotlin.model.register;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Data {
    @SerializedName("usu_name")
    @Nullable
    private final String usuName;
    @SerializedName("username")
    @Nullable
    private final String username;

    public Data(@Nullable String usuName, @Nullable String username) {
        this.usuName = usuName;
        this.username = username;
    }

    // $FF: synthetic method
    public Data(String var1, String var2, int var3, DefaultConstructorMarker var4) {
        if ((var3 & 1) != 0) {
            var1 = null;
        }

        if ((var3 & 2) != 0) {
            var2 = null;
        }

        this(var1, var2);
    }

    @Nullable
    public final String getUsuName() {
        return this.usuName;
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
        return this.username;
    }

    @NotNull
    public final Data copy(@Nullable String usuName, @Nullable String username) {
        return new Data(usuName, username);
    }

    // $FF: synthetic method
    public static Data copy$default(Data var0, String var1, String var2, int var3, Object var4) {
        if ((var3 & 1) != 0) {
            var1 = var0.usuName;
        }

        if ((var3 & 2) != 0) {
            var2 = var0.username;
        }

        return var0.copy(var1, var2);
    }

    @NotNull
    public String toString() {
        return "Data(usuName=" + this.usuName + ", username=" + this.username + ')';
    }

    public int hashCode() {
        int result = this.usuName == null ? 0 : this.usuName.hashCode();
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
            } else {
                return Intrinsics.areEqual(this.username, var2.username);
            }
        }
    }

    public Data() {
        this((String)null, (String)null, 3, (DefaultConstructorMarker)null);
    }
}
