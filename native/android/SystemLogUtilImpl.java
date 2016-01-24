/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.gesher.cn1SysLogs;

import com.codename1.ui.Display;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import android.os.Process;

/**
 *
 * @author yaakov
 */
public class SystemLogUtilImpl implements SystemLogUtil{

    @Override
    public String getSysErrorLog() {
        //write log to file
        int pid = android.os.Process.myPid();
        StringBuilder result = new StringBuilder();
        
        try {
            String command = String.format("logcat -d -v threadtime *:*");        
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String currentLine = null;

            while ((currentLine = reader.readLine()) != null) {
                   if (currentLine != null && currentLine.contains(String.valueOf(pid))) {
                       result.append(currentLine);
                       result.append("\n");
                    }
            }
        } catch (IOException e) {
            result.append("Error getting logs");
        }
        
        //clear the log
        try {
            Runtime.getRuntime().exec("logcat -c");
        } catch (IOException e) {
            result.append("\nError clearing the log");
        }
        
        return result.toString();
    }

    /**
     * returns true if platform is supported.
     * currently we only support android
     * @return Boolean
     */
    @Override
    public boolean isSupported() {
        if(Display.getInstance().getPlatformName().equals("and")){
            return true;
        }
        return false;
    }
    
}
