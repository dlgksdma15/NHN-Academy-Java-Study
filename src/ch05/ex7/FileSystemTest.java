package ch05.ex7;

import java.util.*;

// 파일 시스템 항목
interface FileSystemItem {
    String getName();
    long getSize();
    Date getCreatedDate();
    Date getModifiedDate();
    String getPath();
}

// 읽기 가능
interface FileReadable {
    byte[] read();
    String readAsString();
}

// 쓰기 가능
interface Writable {
    void write(byte[] data);
    void writeString(String content);
    void append(byte[] data);
}

// 파일 인터페이스
interface File extends FileSystemItem, FileReadable, Writable {
    String getExtension();
    String getMimeType();
}

// 디렉토리 인터페이스
interface Directory extends FileSystemItem {
    List<FileSystemItem> listItems();
    void addItem(FileSystemItem item);
    void removeItem(String name);
    FileSystemItem findItem(String name);
}

// 텍스트 파일 구현
class TextFile implements File {
    private String name;
    private String content;
    private Date createdDate;
    private Date modifiedDate;
    private String path;

    public TextFile(String name, String path) {
        // TODO 88
        this.name = name;
        this.path = path;
        this.content = "";
        this.createdDate = new Date();
        this.modifiedDate = new Date();
    }

    @Override
    public String getName() {
        // TODO 89
        return name;
    }

    @Override
    public long getSize() {
        // TODO 90
        return content.getBytes().length;
    }

    @Override
    public Date getCreatedDate() {
        // TODO 91
        return createdDate;
    }

    @Override
    public Date getModifiedDate() {
        // TODO 92
        return modifiedDate;
    }

    @Override
    public String getPath() {
        // TODO 93
        return path;
    }

    @Override
    public String getExtension() {
        // TODO 94
        int dotIndex = name.lastIndexOf('.');
        if (dotIndex == -1) {
            return "";
        }
        return name.substring(dotIndex + 1);
    }

    @Override
    public String getMimeType() {
        // TODO 95
        return "text/plain";
    }

    @Override
    public byte[] read() {
        // TODO 96
        return content.getBytes();
    }

    @Override
    public String readAsString() {
        // TODO 97
        return content;
    }

    @Override
    public void write(byte[] data) {
        // TODO 98
        this.content = new String(data);
        this.modifiedDate = new Date();
    }

    @Override
    public void writeString(String content) {
        // TODO 99
        this.content = content;
        this.modifiedDate = new Date();
    }

    @Override
    public void append(byte[] data) {
        // TODO 100
        this.content += new String(data);
        this.modifiedDate = new Date();
    }
}

// 간단한 디렉토리 구현
class SimpleDirectory implements Directory {
    private String name;
    private String path;
    private Date createdDate;
    private Date modifiedDate;
    private List<FileSystemItem> items;

    public SimpleDirectory(String name, String path) {
        // TODO 101
        this.name = name;
        this.path = path;
        this.createdDate = new Date();
        this.modifiedDate = new Date();
        this.items = new ArrayList<>();
    }

    @Override
    public String getName() {
        // TODO 102
        return name;
    }

    @Override
    public long getSize() {
        // TODO 103
        long totalSize = 0;
        for (FileSystemItem item : items) {
            totalSize += item.getSize();
        }
        return totalSize;
    }

    @Override
    public Date getCreatedDate() {
        // TODO 104
        return createdDate;
    }

    @Override
    public Date getModifiedDate() {
        // TODO 105
        return modifiedDate;
    }

    @Override
    public String getPath() {
        // TODO 106
        return path;
    }

    @Override
    public List<FileSystemItem> listItems() {
        // TODO 107
        return new ArrayList<>(items);
    }

    @Override
    public void addItem(FileSystemItem item) {
        // TODO 108
        items.add(item);
        this.modifiedDate = new Date();
    }

    @Override
    public void removeItem(String name) {
        // TODO 109
        items.removeIf(item -> item.getName().equals(name));
        this.modifiedDate = new Date();
    }

    @Override
    public FileSystemItem findItem(String name) {
        // TODO 110
        for (FileSystemItem item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}

// 파일 시스템 테스트
public class FileSystemTest {
    public static void main(String[] args) {
        // TODO 111
        SimpleDirectory root = new SimpleDirectory("root", "/");
        TextFile readme = new TextFile("README.txt", "/README.txt");
        readme.writeString("이것은 읽어보기 파일입니다.");

        // TODO 112
        root.addItem(readme);

        // TODO 113
        System.out.println("=== 파일 시스템 내용 ===");
        System.out.println("디렉토리: " + root.getName() + ", 크기: " + root.getSize() + " bytes");

        FileSystemItem found = root.findItem("README.txt");
        if (found instanceof TextFile) {
            TextFile tf = (TextFile) found;
            System.out.println("파일: " + tf.getName() + ", 크기: " + tf.getSize() + " bytes");
            System.out.println("내용: " + tf.readAsString());
        }
    }
}
