package com.app.airmenu.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/app/airmenu/utils/AppState;", "", "()V", "errorCount", "", "getErrorCount", "()I", "setErrorCount", "(I)V", "shouldClearCache", "", "getShouldClearCache", "()Z", "setShouldClearCache", "(Z)V", "app_debug"})
public final class AppState {
    @org.jetbrains.annotations.NotNull()
    public static final com.app.airmenu.utils.AppState INSTANCE = null;
    private static int errorCount = 0;
    private static boolean shouldClearCache = true;
    
    private AppState() {
        super();
    }
    
    public final int getErrorCount() {
        return 0;
    }
    
    public final void setErrorCount(int p0) {
    }
    
    public final boolean getShouldClearCache() {
        return false;
    }
    
    public final void setShouldClearCache(boolean p0) {
    }
}