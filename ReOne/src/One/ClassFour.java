package One;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ClassFour {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		File file=new File("D:\\11");
		System.out.println(file.getName());
		File createTempFile = File.createTempFile("bbb", ".txt", file);
		createTempFile.deleteOnExit();
		String[] list = file.list();
		for (String string : list) {
			System.out.println(string);
			
		}
		File[] listRoots = File.listRoots();
		for (File file2 : listRoots) {
			System.out.println(file2);
		}
		System.out.println("-----------------------------");
		String[] list2 = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".txt");
			}
			
		});
		for (String s : list2) {
			System.out.println(s);
			
		}
		
		System.out.println("--------------------------------");
		FileInputStream in=new FileInputStream("D:\\11\\file.txt");
		FileOutputStream fs=new FileOutputStream("out.txt");
		byte[] b=new byte[1024];
		int len=0;
		while((len=in.read(b))>0){
			fs.write(b,0,len);
		}
		in.close();
		fs.close();
		FileReader fr=new FileReader("D:\\11\\file.txt");
		char[] bb=new char[1024];
		int length=0;
		while((length=fr.read(bb))>0){
			System.out.println(new String(bb,0,length));
			
		}
		FileWriter fw=new FileWriter("write.txt");
		fw.write("filewrite \r\n");
		fw.write("file");
		fr.close();
		fw.close();
		
		FileOutputStream ff=new FileOutputStream("fileoutput.txt");
		PrintStream ps=new PrintStream(ff);
		ps.println("fileoutputstream");
		ps.print("printstream");
		System.out.println("*************************************");
		RandomAccessFile raf=new RandomAccessFile("D:\\11\\file.txt","r");
		raf.seek(1);
		byte[] by=new byte[1024];
		int haslen=0;
		while((haslen=raf.read(by))>0){
			System.out.println(new String(by,0,haslen));
		}
		
		FileInputStream fi=new FileInputStream(createTempFile);
		FileOutputStream fo=new FileOutputStream(createTempFile);
		RandomAccessFile ra=new RandomAccessFile("D:\\11\\file.txt","rw");
		ra.seek(1);
		byte[] byt=new byte[1024];
		int le=0;
		while((le=ra.read(byt))>0){
			System.out.println(new String(byt,0,le));
		}
		/*ra.seek(1);
		ra.write("写入的文字，".getBytes());
		while((le=fi.read(byt))>0){
			System.out.println(new String(byt,0,le));
		}*/
		
		System.out.println("************************************");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			ps.println("请输入内容："+sc.next());
		}
		/*while(sc.hasNext()){
			System.out.println(sc.next());
		}*/
		
	}
}
