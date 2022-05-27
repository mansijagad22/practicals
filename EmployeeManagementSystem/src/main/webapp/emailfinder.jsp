<%@ page import="java.sql.*" import ="config.DbConnection" import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  

<%  
String email=request.getParameter("email");  
if(email.contains("@")&&email.contains(".")){  
try{  
final Connection con = DbConnection.getConnection();
PreparedStatement ps=con.prepareStatement("select * from employee where email=?");  
ps.setString(1,email);  
ResultSet rs=ps.executeQuery();  
if(rs.next()){  
out.print("Unavailable! <img src='unchecked.gif'/>");  
}else{  
out.print("Available! <img src='checked.gif'/>");  
}  
}catch(Exception e){out.print(e);}  
}else{  
out.print("Invalid email!");  
}  
%>  