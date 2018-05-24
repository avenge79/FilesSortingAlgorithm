package com.rado.Exams.ComputerSystem;

import java.io.File;
import java.util.*;

public class RealSystem implements Comparable<RealSystem> {
    private final String fileName;
    private final long fileSize;

    public RealSystem(final String fileName, final long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return (fileName == null ? "" : "\n" + fileName) + " - " + (double) fileSize / 1024 + " KB";
    }

    @Override
    public int compareTo(RealSystem other) {
        return Long.compare(fileSize, other.fileSize);
    }

    public static void main(String[] args) {
        final String PATH = "C:\\Windows\\Temp";

        List<RealSystem> al = new ArrayList<RealSystem>();

        File dir;

        try {
            dir = new File(path);

            Stack<File> st = new Stack<>();
            st.push(dir);

            while (!st.isEmpty()) {
                File ch = st.pop();

                if (ch.isDirectory()) {
                    if (ch.listFiles() == null) {
                        System.out.println("Error reading " + ch.getPath());
                        continue;
                    }

                    for (File f : ch.listFiles()) st.push(f);
                    int folderLength = 0;
                    int filesInDirCount = 0;
                    System.out.println("\n++Files in " + ch.getPath() + ":");
                    for (File file : ch.listFiles()) {
                        if (file.isFile()) {
                            final RealSystem fileData = new RealSystem(file.getName(), file.length());
                            folderLength += file.length();
                            filesInDirCount++;
                            al.add(fileData);
                        }
                    }
                    
                    Collections.sort(al, Collections.reverseOrder());
                    System.out.println("--> Files: " + filesInDirCount + ", Size: "
                            + (double) folderLength / 1024 + " KB");
                    System.out.println(al);
                }
                
                al = new ArrayList<>();
            }
        } catch (Exception e) {
            System.out.println("Error! " + e);
        }
    }
}
