package com.yourname.www.view;

import com.yourname.www.dao.Dao;
import com.yourname.www.po.Cou;
import com.yourname.www.po.Jibenxinxi;
import com.yourname.www.po.Stu;
import com.yourname.www.po.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/xuankeServlet")
public class xuankeServlet extends HttpServlet {
    /**
     * 特有id号
     */
    private static final long serialVersionUID = 1L;
    Dao dao = new Dao();
    /**
     * 方法选择
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if("login".equals(method)) {
            try {
                login(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("addtea".equals(method)) {
            try {
                addtea(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("addstu".equals(method)) {
            try {
                addstu(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("addcou".equals(method)) {
            try {
                addcou(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("updatetea".equals(method)) {
            try {
                updatetea(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("updatestu".equals(method)) {
            try {
                updatestu(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("liulankecheng".equals(method)) {
            try {
                liulankecheng(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("chakan".equals(method)) {
            try {
                chakan(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("xuanke".equals(method)) {
            try {
                xuanke(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("liulankecheng1".equals(method)) {
            try {
                liulankecheng1(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if("liulanstu".equals(method)) {
            try {
                liulanstu(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password=req.getParameter("password");
        int pid=dao.searchPid(username,password);
        System.out.println(pid);
        if(pid==1) {
            String teaname=dao.searchteaname(username);
            System.out.println(teaname);
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("teaname", teaname);
        }
        if(pid==2) {
            req.getSession().setAttribute("username1", username);
        }
        req.setAttribute("pid", pid);
        req.getRequestDispatcher("houtai.jsp").forward(req, resp);
    }
    private void addtea(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        req.setCharacterEncoding("utf-8");
        String tpid = req.getParameter("tpid");
        String teaname = req.getParameter("teaname");
        String sex = req.getParameter("sex");
        String txueyuan = req.getParameter("txueyuan");
        String zhicheng = req.getParameter("zhicheng");
        int pid=1;
        String password = "123456";
        Teacher teacher=new Teacher(tpid,teaname,sex,txueyuan,zhicheng);
        if(dao.addtea(teacher)&&dao.adduser(tpid,password,pid)) {
            req.setAttribute("teacher",teacher);
            req.setAttribute("message","添加成功" );
            req.getRequestDispatcher("addtea.jsp").forward(req, resp);
        }else {
            req.setAttribute("message","老师姓名重复，请重新输入" );
            req.getRequestDispatcher("addtea.jsp").forward(req, resp);
        }
    }

    private void addstu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        req.setCharacterEncoding("utf-8");
        String spid = req.getParameter("spid");
        String stuname = req.getParameter("stuname");
        String sex = req.getParameter("sex");
        String banji = req.getParameter("banji");
        String ye = req.getParameter("ye");
        Stu stu=new Stu(spid,stuname,sex,banji,ye);
        int pid=2;
        String password="123456";
        if(dao.addstu(stu)&&dao.adduser(spid, password, pid)) {
            req.setAttribute("stu",stu);
            req.setAttribute("message","添加成功" );
            req.getRequestDispatcher("addstu.jsp").forward(req, resp);
        }else {
            req.setAttribute("message","学生姓名重复，请重新输入" );
            req.getRequestDispatcher("addstu.jsp").forward(req, resp);
        }
    }

    private void addcou(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        req.setCharacterEncoding("utf-8");
        String jiaoshi=(String) req.getSession().getAttribute("teaname");
        String cpid = req.getParameter("cpid");
        String cname = req.getParameter("cname");
        int num = Integer.parseInt(req.getParameter("num"));
        int snum=0;
        System.out.println(jiaoshi);
        Cou cou=new Cou(cpid,cname,num,snum,jiaoshi);
        if(dao.addcou(cou)) {
            req.setAttribute("cou",cou);
            req.setAttribute("message","添加成功" );
            req.getRequestDispatcher("addcourse.jsp").forward(req, resp);
        }else {
            req.setAttribute("message","课程信息重复，请重新输入" );
            req.getRequestDispatcher("addcourse.jsp").forward(req, resp);
        }
    }
    private void updatetea(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        req.setCharacterEncoding("utf-8");
        String tpid=(String) req.getSession().getAttribute("username");
        String teaname = req.getParameter("teaname");
        String sex = req.getParameter("sex");
        String txueyuan = req.getParameter("txueyuan");
        String zhicheng = req.getParameter("zhicheng");
        Teacher teacher=new Teacher(tpid,teaname,sex,txueyuan,zhicheng);
        if(dao.updatetea(teacher)) {
            req.setAttribute("message","修改成功" );
            req.getRequestDispatcher("updatet.jsp").forward(req, resp);
        } else {
            req.setAttribute("message","修改失败" );
            req.getRequestDispatcher("updatet.jsp").forward(req, resp);
        }
    }

    private void updatestu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        req.setCharacterEncoding("utf-8");
        String spid =(String) req.getSession().getAttribute("username1");
        String stuname = req.getParameter("stuname");
        String sex = req.getParameter("sex");
        String banji = req.getParameter("banji");
        String ye = req.getParameter("ye");
        Stu stu=new Stu(spid,stuname,sex,banji,ye);
        if(dao.updatestu(stu)) {
            req.setAttribute("message","修改成功" );
            req.getRequestDispatcher("updates.jsp").forward(req, resp);
        } else {
            req.setAttribute("message","修改失败" );
            req.getRequestDispatcher("updates.jsp").forward(req, resp);
        }
    }


    private void liulankecheng(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        req.setCharacterEncoding("utf-8");
        List<Cou> cous = dao.liulankecheng();
        req.setAttribute("cous", cous);
        req.getRequestDispatcher("liulankecheng.jsp").forward(req, resp);

    }

    private void chakan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Cou cou=dao.searchByid(id);
        req.getSession().setAttribute("id", id);
        req.setAttribute("cou", cou);
        req.getRequestDispatcher("chakankecheng.jsp").forward(req, resp);
    }

    private void xuanke(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        req.setCharacterEncoding("utf-8");
        String spid =(String) req.getSession().getAttribute("username1");
        String cpid = req.getParameter("cpid");
        String stuname=req.getParameter("stuname");
        String sex=req.getParameter("sex");
        String banji=req.getParameter("banji");
        String ye=req.getParameter("ye");
        int snum = Integer.parseInt(req.getParameter("snum"))+1;
        String jiaoshi = req.getParameter("jiaoshi");
        int id =(int) req.getSession().getAttribute("id");
        String tpid=dao.searchtpid(jiaoshi);
        Stu stu = dao.searchstu(spid);
        System.out.println(id);
        if(dao.updatecou(id,snum)&&dao.addjiben(cpid,tpid,spid,stuname,sex,banji,ye)) {
            req.setAttribute("message","选课成功" );
            req.getRequestDispatcher("sucess.jsp").forward(req, resp);
        } else {
            req.setAttribute("message","选课失败" );
            req.getRequestDispatcher("sucess.jsp").forward(req, resp);
        }
    }

    private void liulankecheng1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        req.setCharacterEncoding("utf-8");
        List<Cou> cous = dao.liulankecheng1();
        req.setAttribute("cous", cous);
        req.getRequestDispatcher("liulankecheng1.jsp").forward(req, resp);

    }

    private void liulanstu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String tpid=(String) req.getSession().getAttribute("username");
        List<Jibenxinxi> jibens = dao.searchstuinfo(tpid);
        req.setAttribute("jibens",jibens);
        req.getRequestDispatcher("liulanstu.jsp").forward(req, resp);
    }

}

