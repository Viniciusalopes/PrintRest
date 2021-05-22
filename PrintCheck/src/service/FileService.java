/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import static util.UtilSo.getBar;
import static util.UtilSo.getCurrentDir;

/**
 *
 * @author vinicius
 */
public class FileService {

    private static String serviceName = "";
    private static String extension = "";
    private static String fileDir = "";
    private static String fileName = "";
    private static String fullPath = "";

    private static boolean alreadyExists(String pServiceName, String pFileName, String pExtension) throws Exception {
        serviceName = pServiceName;
        fileName = pFileName;
        extension = pExtension;
        fileDir = getCurrentDir() + getBar() + serviceName;
        File dir = new File(fileDir);
        if (!dir.exists()) {
            return false;
        }

        fullPath = fileDir + getBar() + fileName + "." + extension;

        File file = new File(fullPath);
        return file.exists();
    }

    private static void grant() throws Exception {

        fileDir = getCurrentDir() + getBar() + serviceName;
        fullPath = fileDir + getBar() + fileName + "." + extension;

        if (!alreadyExists(serviceName, fileName, extension)) {
            File dir = new File(fileDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(fullPath);
            file.createNewFile();
        }
    }

    private static void delete() throws Exception {

        fileDir = getCurrentDir() + getBar() + serviceName;

        if (alreadyExists(serviceName, fileName, extension)) {
            fullPath = fileDir + getBar() + fileName + "." + extension;
            File file = new File(fullPath);
            file.delete();
        }
    }

    public static void record(String pServiceName, String pFileName, String pExtension, String text) throws Exception {
        serviceName = pServiceName;
        fileName = pFileName;
        extension = pExtension;
        delete();
        grant();

        FileWriter fw = new FileWriter(fullPath, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(text);
        bw.close();
    }

    public static String load(String pServiceName, String pFileName, String pExtension) throws Exception {
        String ret = "";
        if (!alreadyExists(pServiceName, pFileName, pExtension)) {
            return ret;
        }

        serviceName = pServiceName;
        fileName = pFileName;
        extension = pExtension;

        BufferedReader br = new BufferedReader(new FileReader(fullPath));
        String line = "";
        while (true) {
            if (line != null) {
                if (line.trim().length() > 0) {
                    ret += line;
                }
            } else {
                break;
            }
            line = br.readLine();
        }
        br.close();
        return ret;
    }
}
