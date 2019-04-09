package LoadDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

public class FileUpLoadDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断是否可以上传文件 即  enctype="multipart/form-data"
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(!isMultipart){
			throw new RuntimeException("is not multipart/form-data");
		}
		//创建一个工厂类
		DiskFileItemFactory df = new DiskFileItemFactory();
		/*//指定临时文件目录位置
		df.setRepository(new File("D:\\"));*/
		
		//创建一个核心对象
		ServletFileUpload sfu = new ServletFileUpload(df);
		//决解上传表单项中文乱码问题
		sfu.setHeaderEncoding("utf-8");
		//限制上传文件大小   并抛出异常提示
		/*ServletFileUpload.setFileSizeMax(字节)
		总文件大小：（多文件上传）
		ServletFileUpload.setSizeMax(字节)*/		
		
		//解析request对象  返回一个list集合
		try {
			//限制单个文件大小：3M	
			sfu.setFileSizeMax(1024*1024*3);
			/*//限制总文件大小：6M
			sfu.setSizeMax(1024*1024*6);*/
			
			List<FileItem> parseRequest = sfu.parseRequest(request);
			//遍历集合元素
			for (FileItem fileItem : parseRequest) {
				if(fileItem.isFormField()){
					//如果是普通表单项   创建一个方法
					processFormField(fileItem);
				}else{
					//上传表单项  创建一个方法
					//processUpLoadField(fileItem);
					processUpLoadField2(fileItem);
				}
			}
		}catch(FileUploadBase.FileSizeLimitExceededException e){
			//提示异常
			System.out.println("上传文件不能超过3M");
		} 
		catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//上传表单项
	private void processUpLoadField(FileItem fileItem) {
		//获取上传表单名
		String filename = fileItem.getName();
		/*
		 * 有些浏览器上传文件时通过 fileItem.getName()可能会获得盘符和父目录为文件名  即
			C:\Users\18877545427\Desktop\a.txt这样的文件名  导致出错
			决解方法如下：
		*/
		//File.separator  得到路径分割符\
		//处理文件名
		//filename = filename.substring(filename.lastIndexOf(File.separator+1));//File.separator文件目录分割符
		if(filename!=null){
			filename = FilenameUtils.getName(filename);
		}
		/*//获取上传文件的格式(扩展名)   jsp  exe   txt等 并过滤
		String extension = FilenameUtils.getExtension(filename);
		if((!"jsp".equals(extension))||(!"exe".equals(extension))){
			
		}*/
		
		/*//解决文件同名问题
		filename=UUID.randomUUID()+"_"+filename;
		*/
		
		
		
		//创建存放目录  在tomcat服务器目录下创建一个load文件目录
		String realPath = this.getServletContext().getRealPath("/load");
		File f=new File(realPath);
		//判断是否存在目录   不存在则创建
		if(!f.exists()){
			f.mkdirs();
		}
		try {
			//创建目录  并以获取到的filename命名
			File file=new File(f,filename);
			//fileItem获取上传的字节流文件
			InputStream in = fileItem.getInputStream();
			//创建输出流
			FileOutputStream out=new FileOutputStream(file);
			
			int len=0;
			byte[] b=new byte[1024];
			while((len=in.read(b))>0){
				out.write(b, 0, len);
			}
			in.close();
			out.close();
			//删除临时文件
			fileItem.delete();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//上传表单项另一种保存方式
	private void processUpLoadField2(FileItem fileItem) {
		//获取上传表单名
		String filename = fileItem.getName();
		//处理文件名
		//File.separator  得到路径分割符\
		//filename = filename.substring(filename.lastIndexOf(File.separator+1));//File.separator文件目录分割符
		if(filename!=null){
			filename = FilenameUtils.getName(filename);
		}
		//创建存放目录  在tomcat服务器目录下创建一个load文件目录
		String realPath = this.getServletContext().getRealPath("/load");
		File f=new File(realPath);
		//判断是否存在目录   不存在则创建
		if(!f.exists()){
			f.mkdirs();
		}
		String DateDirectory=dateDirectory(f);
		try {
			//fileItem获取上传的字节流文件
			fileItem.getInputStream();
			//fileItem自带的输出流
			fileItem.write(new File(f,DateDirectory+File.separator+filename));
			//删除临时文件
			fileItem.delete();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private String dateDirectory(File f) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String format = df.format(new Date());//转成字符串
		File file = new File(f,format);
		if(!file.exists()){
			file.mkdir();
		}
		
		return format;
	}
	//普通表单项
	private void processFormField(FileItem fileItem) {
		// TODO Auto-generated method stub
		//获取表单名    标签里的name
		String fieldName = fileItem.getFieldName();
		//获取表单值
		try {
			//决解普通表单项乱码问题   文本框里的值value
			String string = fileItem.getString("utf-8");
			System.out.println(fieldName+"="+string);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
