package ood.fileSystem;

import java.util.*;

public class Directory extends Entry{
  private List<Entry> contents;

  public Directory(String n, Directory p) {
    super(n, p);
    contents = new ArrayList<Entry>();
  }

  protected List<Entry> getContents() {
    return contents;
  }

  public int size() {
    int size = 0;
    for (Entry e: contents) {
      size += e.size();
    }
    return size;
  }

  public int numberOfFiles() {
    int count = 0;
    for (Entry e: contents) {
      if (e instanceof Directory) {
        Directory d = (Directory)e;
        count += d.numberOfFiles();
      }
      count++;
    }
    return count;
  }

  public boolean deleteEntry(Entry entry) {
    return contents.remove(entry);
  }

  public void addEntry(Entry entry) {
    contents.add(entry);
  }
}
