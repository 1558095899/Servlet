package LoadDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class TestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean mul = ServletFileUpload.isMultipartContent(request);
		if(!mul){
			System.out.println("is not multipart/form-data");
		}
		DiskFileItemFactory dif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dif);
		sfu.setHeaderEncoding("utf-8");
		try {
			sfu.setSizeMax(1024*1024*3);
			List<FileItem> file = sfu.parseRequest(request);
			for (FileItem fileItem : file) {
				if(fileItem.isFormField()){
					formFieldmethod(fileItem);
				}else{
					notformFieldMethod(fileItem);
					//UploadFile(fileItem);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	/*private void UploadFile(FileItem fileItem) {
		String filename = fileItem.getName();
		if(filename!=null){
			filename=FilenameUtils.getName(filename);
		}
		String realPath = this.getServletContext().getRealPath("/doload");
		File file = new File(realPath);
		if(!file.exists()){
			file.mkdir();
		}
		try {
			File f=new File(file,filename);
			InputStream in = fileItem.getInputStream();
			FileOutputStream out=new FileOutputStream(f);
			byte[] b=new byte[1024];
			int len=1;
			while((len=in.read(b))>0){
				out.write(b,0,len);
			}
			
			out.close();
			in.close();
			fileItem.delete();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
*/


	private void notformFieldMethod(FileItem fileItem) {
		String filename = fileItem.getName();
		if(filename!=null){
			filename = FilenameUtils.getName(filename);
		}
		String realPath = this.getServletContext().getRealPath("/download");
		File file = new File(realPath);
		if(!file.exists()){
			file.mkdir();
		}			
			try {
				fileItem.getInputStream();
				fileItem.write(new File(file,filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		fileItem.delete();
	}

	private void formFieldmethod(FileItem fileItem) {
		String fieldName = fileItem.getFieldName();
		try {
			String string = fileItem.getString("utf-8");
			System.out.println(fieldName+"="+string);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
