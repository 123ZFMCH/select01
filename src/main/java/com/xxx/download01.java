package com.xxx;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/download01")
public class download01  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;Charset=utf-8");
        //获取要下载文件的name值
        String name=req.getParameter("fileName");
        //获取下载路径
        String path=getServletContext().getRealPath("/");
        //通过路径获取file对象
        File file=new File(path+name);
        if(file.exists()&&file.isFile()){
            //设置响应类型
            resp.setContentType("application/x-msdownload");
            resp.setHeader("Content-Disposition","attachment;filename="+name);
            //得到输入流
            InputStream is=new FileInputStream(file);
            ServletOutputStream os=resp.getOutputStream();
            byte[] car=new byte[1024];
            int len=0;
            while ((len=is.read(car))!=-1){
                os.write(car);

            }
            os.flush();
            os.close();
            is.close();
        }
        else
        {
            System.out.println("文件不存在,下载失败");
        }


    }
}
