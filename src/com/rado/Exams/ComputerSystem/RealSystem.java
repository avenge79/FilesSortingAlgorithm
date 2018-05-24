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
        final String path = "C:\\Windows\\Temp";

        List<RealSystem> al = new ArrayList<RealSystem>();

        File dir;
        //File[] paths;
        //ArrayList<String> al = new ArrayList<>();

        try {
            dir = new File(path);
            //paths = dir.listFiles();

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
                            //System.out.println("  " + file.getName() + ", Size: "
                                   // + (double) file.length() / 1024 + " KB");
                            folderLength += file.length();
                            filesInDirCount++;
                            al.add(fileData);

                        }
                    }
                    Collections.sort(al, Collections.reverseOrder());
                    System.out.println("--> Files: " + filesInDirCount + ", Size: "
                            + (double) folderLength / 1024 + " KB");
                    System.out.println(al);
                } //else System.out.println("Not a directory: " + ch);
                al = new ArrayList<>();
            }
        } catch (Exception e) {
            System.out.println("Error! " + e);
        }
    }

    public static void listFilesRecursive(java.io.File root) {
        File[] listOfFilesAndDirectory = root.listFiles();

        if (listOfFilesAndDirectory != null) {
            for (File file : listOfFilesAndDirectory) {
                if (file.isDirectory()) {
                    listFilesRecursive(file);
                } else {
                    System.out.println(file);
                }
            }
        }
    }

    private static void printFiles(java.io.File dir) {
        Stack<File> stack = new Stack<>();
        stack.push(dir);

        while (!stack.isEmpty()) {
            java.io.File child = stack.pop();
            if (child.isDirectory()) {
                for (java.io.File f : child.listFiles()) stack.push(f);
                //System.out.println("Directory: " + child);
            } else if (child.isFile()) {
                System.out.println(child.getPath());
            }
        }
    }
}
















    /*    String rootDirectory = new Scanner(System.in).nextLine();

        java.io.CustomFile rootDirInfo = new java.io.CustomFile(rootDirectory);
        Directory rootDir = new Directory(rootDir.listFiles());
        Device fileSystem = new Device("CustomFile System", rootDir);
        FileSystemTraversal(rootDirInfo, rootDir);

        System.out.println(fileSystem);
    }

    private static void FileSystemTraversal(CustomFile currentDirectoryInfo, Directory currentDirectory) {
//C# TO JAVA CONVERTER TODO TASK: There is no equivalent to implicit typing in Java unless the Java 10 inferred typing option is selected:
        for (CustomFile file : Directory.listFiles()) {
            currentDirectory.AddFile(new BinaryCustomFile(file.Name, file.CreationTime, file.LastWriteTime, null));
        }

//C# TO JAVA CONVERTER TODO TASK: There is no equivalent to implicit typing in Java unless the Java 10 inferred typing option is selected:
        for (Directory di : currentDirectory.listFiles()) {
            FileSystem.Directory dir = new FileSystem.Directory(di.Name, di.LastWriteTime);
            currentDirectory.AddDirectory(dir);
            FileSystemTraversal(di, dir);
        }


    }
}
*/