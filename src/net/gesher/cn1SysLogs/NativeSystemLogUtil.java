
package net.gesher.cn1SysLogs;

import com.codename1.system.NativeInterface;

public interface NativeSystemLogUtil extends NativeInterface {
    
    public String getSysErrorLog(int max);
}