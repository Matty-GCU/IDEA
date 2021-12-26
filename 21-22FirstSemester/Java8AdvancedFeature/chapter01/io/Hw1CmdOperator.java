package chapter01.io;

import java.io.File;

public class Hw1CmdOperator {
    File currentFile;

    Hw1CmdOperator() {
        currentFile = new File(".");
    }

    String[] getRootNames() {
        File[] roots = File.listRoots();
        String[] rootNames = new String[roots.length];
        for(int i = 0; i < roots.length; i++) {
            rootNames[i] = roots[i].getPath();
        }
        return rootNames;
    }

    File[] getChildFiles() {
        if(currentFile.isFile()) {
            System.out.println("当前文件不是目录，不包含子目录和文件");
            return null;
        }
        //File类的toString()实际是return getPath();
        return currentFile.listFiles();
    }

    boolean updateFile(String fileName) {
        File newFile;
        newFile = new File(currentFile.getPath() + "\\" + fileName);
        if(newFile.exists()) {
            currentFile = newFile;
            return true;
        }
        else {
            System.out.println("文件或目录不存在");
            return false;
        }
    }
}
