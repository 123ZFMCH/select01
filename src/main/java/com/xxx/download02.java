package com.xxx;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/download02")
@MultipartConfig
public class download02  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
//
//        String realPath = req.getServletContext().getRealPath("/");
//        Part part = req.getPart("myFile");
//        String submittedFileName = part.getSubmittedFileName();
//        part.write(realPath+submittedFileName);


        String realPath = req.getServletContext().getRealPath("/");
        Part myFile = req.getPart("myFile");
        String submittedFileName = myFile.getSubmittedFileName();
        myFile.write(realPath+submittedFileName);


    }
}
