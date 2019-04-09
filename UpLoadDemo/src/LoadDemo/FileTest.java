package LoadDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		String s="D:\\11\\load";
		File file=new File(s);
		if(!file.exists()){
			file.mkdirs();
		}
		try {
			File f=new File(file,"si.jpg");
			FileInputStream in = new FileInputStream("C:\\Users\\18877545427\\Pictures\\Saved Pictures\\oo\\1.jpg");
			FileOutputStream out = new FileOutputStream(f);
			int len=0;
			byte[] b=new byte[1024];
			while((len=in.read(b))>0){
				out.write(b, 0, len);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
