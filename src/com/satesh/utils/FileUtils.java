/*
 * FileUtils.java
 * Created on : 2/17/14 10:14 PM
 * Author 	   : satesh @ javaj2ee.com
 * License    : Copyright 2014 Its OpenSource.
 *            : Please feel free to Share!
 *            : If you like it fork me @ http://github.com/sanumala
 */

package com.satesh.utils;

import java.io.File;
import java.io.FileFilter;
import java.net.URI;
import java.net.URL;
import java.util.*;

/**
 * Credit goes to original developer.
 * Created by satesh on 2/17/14.
 */
public class FileUtils {
    public Collection<File> lookupClasspathFiles(String name) {
        Enumeration<URL> resources;
        List<File> files = new ArrayList<File>();

        try {
            resources = FileUtils.class.getClassLoader().getResources(name);

            while (resources.hasMoreElements()) {
                URI uri = resources.nextElement().toURI();
                File file = new File(uri);
                files.add(file);
            }

        } catch (Exception e) {
            throw new RuntimeException("could not lookup files with name: "+name, e);
        }

        return files;
    }

    public static class FileFileFilter implements FileFilter {
        @Override
        public boolean accept(File pathname) {
            return pathname.isFile();
        }
    }


    public static class DirectoryFileFilter implements FileFilter {
        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }
    }


    public static final class RecursiveFileIterator implements Iterator<File> {
        private final List<File> recursiveListing;
        private final int size;
        private int nextIndex = -1;

        public RecursiveFileIterator(File root,
                                     boolean includeDirs,
                                     boolean includeFiles) {
            List<File> l = new ArrayList<File>();
            traverse(root, includeDirs, includeFiles, l);
            recursiveListing = Collections.unmodifiableList(l);
            size = recursiveListing.size();

            if (size > 0) {
                nextIndex = 0;
            }
        }

        private List<File> traverse(File startDir,
                                    final boolean includeDirs,
                                    final boolean includeFiles,
                                    List<File> toAdd) {
            validateDirectory(startDir);
            File[] filesAndDirs = startDir.listFiles();
            Arrays.sort(filesAndDirs);
            File tmp = null;
            boolean isDir, isFile;

            for (int i = 0; i < filesAndDirs.length; i++) {
                tmp = filesAndDirs[i];
                isDir = tmp.isDirectory();
                isFile = tmp.isFile();

                if (isDir) {
                    if (includeDirs)
                        toAdd.add(tmp);

                    traverse(tmp, includeDirs, includeFiles, toAdd);

                } else if (isFile) {
                    if (includeFiles)
                        toAdd.add(tmp);
                }
            }

            return toAdd;
        }

        @Override
        public File next() {
            File next = recursiveListing.get(nextIndex);
            nextIndex++;
            return next;
        }

        @Override
        public boolean hasNext() {
            if (size < 0) {
                return false; // empty list
            }
            if (nextIndex >= size) {
                return false; // last element reached
            }

            return true;
        }

        @Override
        public void remove() {
            throw new RuntimeException("not supported yet");
        }

        /**
         * Directory is valid if it exists, does not represent a file, and can
         * be read.
         */
        private static void validateDirectory(File d) {
            if (d == null) {
                throw new IllegalArgumentException("Directory should not be null.");
            }
            if (!d.exists()) {
                throw new IllegalArgumentException("Directory does not exist: "
                        + d);
            }
            if (!d.isDirectory()) {
                throw new IllegalArgumentException("Is not a directory: " + d);
            }
            if (!d.canRead()) {
                throw new IllegalArgumentException("Directory cannot be read: "
                        + d);
            }
        }
    }

    private FileUtils() {
    }

    public static void deleteRecursively(File f) {
        if (!f.exists()) {
            return;
        }

        if (f.isDirectory()) {
            File[] children = f.listFiles();
            if (children != null) {
                for (int i = 0; i < children.length; i++) {
                    deleteRecursively(children[i]);
                }
            }
        }
        f.delete();
    }
}