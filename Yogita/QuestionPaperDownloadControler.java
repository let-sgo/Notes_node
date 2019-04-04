import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;

public class  QuestionPaperDownloadControler extends GenericServlet {
public  void service(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response) 
throws javax.servlet.ServletException, java.io.IOException{
	   int id=Integer.parseInt(request.getParameter("id"));
		String donwloadDir="E:\\ProjectImages\\";
	
		 Connection con = null;
		 PreparedStatement  pstmt  = null;
		 ResultSet rs  =null;
		 InputStream dbInputStream = null;
		 FileOutputStream fos = null;
		 try {
				
				con = DbConnectionUtil.getConnection();
				String sql="select * from quetionpaper "
						+ " where id=?";
				pstmt = con.prepareStatement(sql);				
				pstmt.setLong(1, id);
				rs  = pstmt.executeQuery();
				if(rs.next()) {
						dbInputStream  = rs.getBinaryStream("FILEDATA");
						String fileName=rs.getString("FILENAME");
						File file  = new File(donwloadDir+fileName);
						fos = new FileOutputStream(file);
						byte[]dataBuff  = new byte[1024];
						int readLength;
						while( (readLength = dbInputStream.read(dataBuff))!=-1) {
							fos.write(dataBuff, 0, readLength);
						}
						fos.close();
						//file must be close for permanent save
						System.out.println("file saved at "+ file.getAbsolutePath());
						dbInputStream.close();
					
				}else {
					System.out.println("no record found for doc id" +id);
				}
				
			}catch(SQLException e){
				System.out.println("db Error : " + e.getMessage());
				e.printStackTrace();
			}catch(Exception e){
				System.out.println("Error : " + e.getMessage());
				e.printStackTrace();
			}finally{
				
					try{
						DbConnectionUtil.closeConnection(con);
					}catch(SQLException e){
						System.out.println("db close error " + e.getMessage());
						e.printStackTrace();
					}
				
				
			 
			}//finally
			

	}

}
