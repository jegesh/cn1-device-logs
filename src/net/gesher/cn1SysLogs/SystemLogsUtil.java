/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.gesher.cn1SysLogs;

import com.codename1.system.NativeLookup;

/**
 *
 * @author yaakov
 */
public class SystemLogsUtil {
    private static Object contextValue;
    private static NativeSystemLogUtil util;
    
    public static String getSysErrorLogs(int count) throws RuntimeException {
        util = (NativeSystemLogUtil)NativeLookup.create(NativeSystemLogUtil.class);
        if ( util == null ) {
            throw new RuntimeException("Toast is not implemented yet in this platform.");
        }

        if ( !util.isSupported() ){
            throw new RuntimeException("Toast is not supported in this platform.");
        }
        
        return util.getSysErrorLog(count);
    }
    
    public static String getSysErrorLogs() throws RuntimeException{
        return getSysErrorLogs(150);
    }
    
}
