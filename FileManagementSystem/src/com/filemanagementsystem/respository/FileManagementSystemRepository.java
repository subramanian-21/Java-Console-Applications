package com.filemanagementsystem.respository;

import utils.DirectoryNotFoundException;
import utils.NotADirectoryException;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileManagementSystemRepository {
    private List<String> pathList = new ArrayList<>();

    public static void main(String[] args) {
        FileManagementSystemRepository.getInstance().readFile("/hi/hello/my/name/hello.txt");

    }
    String absolutePath;
    private static FileManagementSystemRepository instance;
    private FileManagementSystemRepository(){
        absolutePath = Paths.get("").toAbsolutePath().toString()+"/FileManagementSystem/filesystem";
    }
    public static FileManagementSystemRepository getInstance(){
        if(instance == null){
            instance = new FileManagementSystemRepository();
        }
        return instance;
    }
    public boolean createDirectory(String directoryName){
        File file = new File(parsePath(directoryName));
        if(!file.exists()){
            file.mkdirs();
            return true;
        }
        return false;
    }
    public boolean openDirectory(String directoryName){
        if(addPath(directoryName)) {
            File file = new File(getFullPath());
            if (file.exists()) {
                return true;
            }
        }
        return false;
    }

    public boolean createFile(String fileName){
        File file = new File(parsePath(fileName));
        try {
            file.createNewFile();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean isValidDirectory(String str){
        try {
            File file = new File(str);
            if(file.isFile()){
                throw new NotADirectoryException(str);
            }
            if(!file.isDirectory()){
                throw new DirectoryNotFoundException(str);
            }
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public void readFile(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(getFullPath()+"/"+fileName));
            OutputStreamWriter osw = new OutputStreamWriter(System.out);
            System.out.println();
            System.out.println(fileName);
            String current = br.readLine();
            System.out.println("------------start of file---------------");
            while (br.ready()){
                osw.write(current+"\n");
                current = br.readLine();
            }
            osw.write(current);
            osw.close();
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            System.out.println("------------end of file---------------");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String parsePath(String command){
        List<String> pathSubList = new ArrayList<>();
        String[] str = command.split(" ");
        for (String s : str) {
            String[] parsedStr = s.split("/");
            pathSubList.addAll(pathList);
            pathSubList.addAll(Arrays.asList(parsedStr));
        }
        return getFullPath(pathSubList);
    }
    public String getCurrentPath(List<String> pathList) {
        if(pathList.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String path : pathList) {
            sb.append("/").append(path);
        }
        return sb.toString();
    }
    public String getFullPath(List<String> pathList) {
        return absolutePath+getCurrentPath(pathList);
    }
    public String getFullPath() {
        return absolutePath+getCurrentPath();
    }
    public String getCurrentPath() {
        if(pathList.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String path : pathList) {
            sb.append("/").append(path);
        }
        return sb.toString();
    }
    public boolean addPath(String path) {
        List<String> pathSubList = new ArrayList<>();
        String[] parsedStr = path.split("/");
        pathSubList.addAll(pathList);
        pathSubList.addAll(Arrays.asList(parsedStr));

        if (isValidDirectory(getFullPath(pathSubList))) {
            pathList = pathSubList;
            return true;
        } else {
            return false;
        }
    }
    public boolean listDirectory(){
        File file = new File(getFullPath());
        try {
            if(file.isDirectory()){
                String[] listFile = file.list();
                if(listFile!= null){
                    for (int i = 0; i < listFile.length; i++) {
                        String[] splitList = listFile[i].split("/");
                        System.out.println(" -"+splitList[splitList.length-1]);
                    }
                }
                return true;
            }else {
                throw new NotADirectoryException(getFullPath());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean listDirectory(String path){
        File file = new File(getFullPath()+"/"+path);
        try {
            if(file.isDirectory()){
                String[] listFile = file.list();
                if(listFile!= null){
                    for (int i = 0; i < listFile.length; i++) {
                        String[] splitList = listFile[i].split("/");
                        System.out.println(" -"+splitList[splitList.length-1]);
                    }
                }
                return true;
            }else {
                throw new NotADirectoryException(getFullPath());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String joinListString(List<String> paths){
        StringBuilder sb = new StringBuilder("");
        for(String path : paths){
            sb.append(path);
        }
        return sb.toString();
    }
}
