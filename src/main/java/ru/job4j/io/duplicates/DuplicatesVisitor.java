package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    HashMap<FileProperty, List<Path>> map = new HashMap<>();
    List<Path> listDuplicate = new ArrayList<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        if (map.containsKey(fileProperty)) {
            listDuplicate.add(file);
            map.put(fileProperty, listDuplicate);
        } else {
            List<Path> firstIn = new ArrayList<>();
            firstIn.add(file);
            map.put(fileProperty, firstIn);
        }
        return super.visitFile(file, attrs);
    }
    public List<Path> searchSizeMoreOne() {
        List<Path> list = new ArrayList<>();
        for (Map.Entry<FileProperty, List<Path>> collect : map.entrySet()) {
            if (map.size() > 1) {
                list.addAll(collect.getValue());
            }
        }
        return list;
    }
}
