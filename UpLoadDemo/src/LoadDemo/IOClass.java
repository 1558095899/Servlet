package LoadDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOClass {
	public static void main(String[] args){
		try {
			//直接写文件  如果没有ioclass.txt  自动创建
			File f=new File("D:\\Eclipse\\IO\\ioclass.txt");
			FileInputStream in=new FileInputStream("C:\\Users\\18877545427\\Desktop\\a.txt");
			FileOutputStream out=new FileOutputStream(f);
			int len=0;
			byte[] b=new byte[1024];
			while((len=in.read(b))>0){
				//System.out.println(new String(b,0,len));
				out.write(b,0,len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
